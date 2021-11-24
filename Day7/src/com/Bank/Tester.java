package com.Bank;

import static com.Bank.AccountValidationRule.ParseNValiadteAccountType;
import static com.Bank.AccountValidationRule.validatebal;
import static com.Bank.AccountValidationRule.ParseNValiadteAccountType;
import static com.Bank.AccountValidationRule.ValidateAccountNo;
import static com.Bank.AccountValidationRule.NameValidate;
import static com.Bank.AccountValidationRule.*;

import java.text.SimpleDateFormat;
import java.util.Scanner;

public class Tester {
	public static void main(String[] args) {
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		try (Scanner sc = new Scanner(System.in)) {
			System.out.println("how may account u want to store");
			BankAccount[] accounts = new BankAccount[sc.nextInt()];

			boolean exit = false;
			int counter = 0;
			while (!exit) {
				try {
					System.out.println("Menu 1: Create new A/C , 2: Diaplay, 3: KYC Details 4:Withdraw5:Exit");
					System.out.println("Choose option");
					switch (sc.nextInt()) {
					case 1:
						if (counter < accounts.length) {
							System.out.println("Enter A/C details: acctNum custNmae acctType balance dateofCreation ");
							BankAccount a = new BankAccount(sc.nextInt(), NameValidate(sc.next()),
									ParseNValiadteAccountType(sc.next().toUpperCase()), validatebal(sc.nextDouble()),
									DateValidate(sc.next()));
							accounts[counter++] = a;
							System.out.println("A/C created successfully!!! ");
						} else
							throw new AccountHandlingException("Max accont reached!!");
						break;
					case 2:
//				if(counter !=0)

						for (BankAccount b : accounts) {
							if (b != null)
								System.out.println(b.toString());
						}

						break;
					case 3:
						System.out.println("Link KYC to Bank Account");
						System.out.println("enter account NO");
						int accNum = sc.nextInt();
						// write a method to validate bank account number
						// failure .-> throw exception
						// found: rets validate bank acct ref.
						// check if acct exit

						BankAccount bankAccount = ValidateAccountNo(accNum, accounts);

						System.out.println("Enter KYC details; Email ID, Adress , Phone No");

						bankAccount.linkKYC(sc.next(), sc.next(), sc.next());
						System.out.println("KYC Linked Successfully..!!");
						break;

					case 4: // withdraw
						// i/p account No, withdraw Amount
						System.out.println("Enter A/c no amount to withdraw");
						accNum = sc.nextInt();
						double amount = sc.nextDouble();

						bankAccount = ValidateAccountNo(accNum, accounts);
						// accts no exists
						// if its linked to KYC: allown tx -- o w throw exc

						bankAccount.withdraw(amount);

						System.out.println("Hello " + bankAccount.getCustname() + " withdraw successfully");

						break;
					case 5:
						exit = true;
						break;
					}
				} catch (Exception e) {
					System.out.println("Error" + e);
					System.out.println("Plz retry");
				}
				// to clear off pending tokens from buffer of scanner
				sc.nextLine();
			}

		}
	}
}
