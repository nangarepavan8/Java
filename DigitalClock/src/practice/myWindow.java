package practice;

import javax.swing.plaf.FontUIResource;
import javax.swing.plaf.basic.BasicOptionPaneUI.ButtonActionListener;
import javax.swing.text.StyledEditorKit.BoldAction;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.*;

public class myWindow extends JFrame {

	private JLabel heading;

	private JLabel clockLable;

	// awt package imort
	private Font font = new FontUIResource("", Font.BOLD, 35);

	public myWindow() {

		super.setTitle("my digital clock");
		super.setSize(550, 550);
		super.setLocation(300, 50);

		this.createGUI();
		this.startClock();

		super.setVisible(true);
	}

	public void createGUI() {
		// for GUI
		heading = new JLabel("My Digital Clock");

		clockLable = new JLabel("Clock");

		heading.setFont(font);

		clockLable.setFont(font);

		this.setLayout(new GridLayout(2, 1));

		this.add(heading);
		this.add(clockLable);

	}

	public void startClock() {

/*		
		Timer timer = new Timer(1000,  new ActionListener()
		{
		

			@Override
			public void actionPerformed(ActionEvent e) {
					
//	1) method->			String dateTime = new Date().toString();
				
//  2) method->			String dateTime = new Date().toLocaleString();
				
				
				Date d = new Date();
				
				SimpleDateFormat sdf= new SimpleDateFormat();
				
				String dateTime=sdf.format(d);
				
				
				clockLable.setText(dateTime);
				
			}

		});
		
		timer.start(); 
*/		
		
		
		Thread t = new Thread() {
			
			public void run()
			{
				
				try {
					
					while(true)
					{
						Date d = new Date();
						
						SimpleDateFormat sdf= new SimpleDateFormat();
						
						String dateTime=sdf.format(d);
						
						clockLable.setText(dateTime);       // print on console
						
//						Thread.sleep(1000);
						Thread.currentThread().sleep(1000);
						
					}
					
				} catch (InterruptedException e) { // waiting for thread sleep
				
					e.printStackTrace();
					
				}
			}
			
		};
		t.start();
		
		
		
		
		
		
	}
}
