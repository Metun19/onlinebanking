import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;

import java.awt.Font;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class ministatement extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ministatement frame = new ministatement(toString());
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public ministatement(String pin) 
	{
		pin="1544";
		//pin="1256";
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 440, 503);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel l2 = new JLabel("KARNATAKA BANK");
		l2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		l2.setBounds(136, 13, 155, 46);
		contentPane.add(l2);
		
		
		
		
		JLabel l1=new JLabel();
		l1.setBounds(20,80,480,20);
		getContentPane().add(l1);
		
		JLabel l3=new JLabel();
		l3.setBounds(20,100,480,200);
		getContentPane().add(l3);
		
		JLabel l4=new JLabel();
		l4.setBounds(20,265,480,200);
		getContentPane().add(l4);
        
		
		try
		{
			Class.forName("com.mysql.jdbc.Driver");    //load the drivers
		
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/banking","root","");
			String q="Select * from login where pin = '"+pin+"'";
            Statement stmt=con.createStatement();
			ResultSet rs=stmt.executeQuery(q);
            
			while(rs.next()){
				l1.setText("Card Number:   "+rs.getString("cardno").substring(0, 4) + "XXXXXXXX" +rs.getString("cardno").substring(12));
			}con.close();
		}
		catch(Exception e)
		{
			
		}
		int balance=0;
		try
		{
			Class.forName("com.mysql.jdbc.Driver");    
			
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/banking","root","");
			String q1="Select * from bank where pin = '"+pin+"'";
            Statement stmt=con.createStatement();
			ResultSet rs=stmt.executeQuery(q1);
            
			while(rs.next()){
				l3.setText(l3.getText() + "<html>" + rs.getString("date") + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" +rs.getString("mode") + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" +rs.getString("amount") + "<br><br><html>");
				if(rs.getString("mode").equals("Deposit"))
				{
					balance+=Integer.parseInt(rs.getString("amount"));
				}
				else
				{
					balance-=Integer.parseInt(rs.getString("amount"));
                }
			}con.close();
		}
		catch(Exception e)
		{
			
		}
		l4.setText("Your current account balance is Rs "+balance);
		
		JButton btnExit = new JButton("Exit");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0)
			{
				System.exit(0);
			}
		});
		btnExit.setBounds(313, 418, 78, 25);
		contentPane.add(btnExit);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0)
			{
				transaction tobj=new transaction();
				tobj.setVisible(true);

			}
		});
		btnBack.setBounds(20, 418, 71, 25);
		contentPane.add(btnBack);
		
		
		
		
	}
}
