
import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;


class MyWindow extends JFrame
{
    private JLabel heading;
    Font font  = new Font("", Font.BOLD, 30);
    
    private JPanel mainPanel;
    private JLabel nameLable, passwordLable;
    private JTextField nameTextField;
    private JPasswordField passwordFiled;
    private JButton button1,button2;
    
    
    
    
    
    // constructor
    public MyWindow()
    {
        super.setTitle("my First From..");
        super.setSize(500,500);
        super.setLocation(100, 100);
//        super.setVisible(true);  // bydefalut invisible.

        super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        this.CreateGUI();

        setVisible(true);
        System.out.println("This is contructor........");
    }
    
    
    // this method create GUI
    public void CreateGUI()
    {
        this.setLayout(new BorderLayout());
        
        heading = new JLabel("My First Form...");
        heading.setFont(font);
        
        heading.setHorizontalAlignment(JLabel.CENTER);
                
        this.add(heading, BorderLayout.NORTH);
        
        ///////////////////// working with JPanel     ///////////////
        
        mainPanel = new JPanel();
        
        // setting layout of  main panel..
        mainPanel.setLayout(new GridLayout(3,2));
        
        nameLable = new JLabel("Enter Name : ");
        nameLable.setFont(font);
        
        passwordLable = new JLabel("Enter Password :");
        passwordLable.setFont(font);
    
        nameTextField = new JTextField();
        nameTextField.setFont(font);
        
        
        passwordFiled = new JPasswordField();
        passwordFiled.setFont(font);
        
        button1 = new JButton("Submit");
        
        button1.setFont(font);
        
        button2 = new JButton("Reset");
        button2.setFont(font);
        
        
        mainPanel.add(nameLable);
        
        mainPanel.add(nameTextField);
        
        mainPanel.add(passwordLable);
        
        mainPanel.add(passwordFiled);
        
        mainPanel.add(button1);
        mainPanel.add(button2);
        
        
        this.add(mainPanel, BorderLayout.CENTER);
        
        
                
        
        
                
        
    }
    
    
}
