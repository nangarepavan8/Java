package com.Bank;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.text.*;
import java.util.Date;


//import com.sun.org.apache.xerces.internal.impl.xpath.regex.ParseException;
public class AccountValidationRule {
	
	 
 public static final double MIN_BAL;
 public static final int MAX_LENGTH;	
 public static final int MIN_LENGTH;
 public static Date beginDate;
 public static Date endDate;
 public static SimpleDateFormat sdf;
 
 static {
	 MIN_BAL=1000;
	 MIN_LENGTH=4;
	 MAX_LENGTH=10;
	
	       sdf = new SimpleDateFormat("dd-MM-yyyy");
		try {
			beginDate=sdf.parse("01-04-2020");
			endDate=sdf.parse("31-03-2021");
		}
		catch(ParseException e){
			System.out.println("Error Static initionliser Block "+ e);
		}
 }
 
 public static double validatebal(double bal ) throws AccountHandlingException
 {
	 if(bal< MIN_BAL)
		throw new AccountHandlingException("A/C having insufficiet funds!! ");
	 	return bal;
 }
 
 public static AccountType ParseNValiadteAccountType(String acctType)
 {
	 return AccountType.valueOf(acctType);  //parsing and validation
 }
 
 public static String NameValidate(String Custname) throws AccountHandlingException
 {
	 if(Custname.length()>MAX_LENGTH || Custname.length()<MIN_LENGTH)
	 {
		 throw new AccountHandlingException("Name length must be in Between 4 To 10");
	 }
	return Custname;
	 
 }
 
 public static Date DateValidate(String Date) throws  ParseException, AccountHandlingException
 {
	 Date creationDate=sdf.parse(Date);
	 if(creationDate.before(beginDate) || creationDate.after(endDate))
	 {
		 throw new AccountHandlingException("A/C creation date must be in finacial years");
		 
	 }
	 return creationDate;
	 
 }

 public static BankAccount ValidateAccountNo(int accNum,  BankAccount[] accounts) throws AccountHandlingException
 {
	 for(BankAccount a: accounts)
		 if(a!= null && a.getAccNum()== accNum )
	       return a;
		
	       throw new AccountHandlingException("A/C no invalid!!");
 }
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
}
