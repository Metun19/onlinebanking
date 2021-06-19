import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.Window.Type;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.*;

public class cracc extends JFrame {

	private JPanel contentPane;
	private JTextField t1;
	private JTextField t2;
	private JTextField t3;
	private JTextField t4;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					cracc frame = new cracc();
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
	public cracc() {
		setTitle("Welcome to banking");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 755, 412);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblEnterYourName = new JLabel("Enter your name");
		lblEnterYourName.setBounds(182, 56, 146, 32);
		contentPane.add(lblEnterYourName);
		
		t1 = new JTextField();
		t1.setBounds(340, 61, 157, 22);
		contentPane.add(t1);
		t1.setColumns(10);
		
		JLabel lblEnterYourAge = new JLabel("Enter your age");
		lblEnterYourAge.setBounds(182, 113, 125, 32);
		contentPane.add(lblEnterYourAge);
		
		t2 = new JTextField();
		t2.setBounds(340, 118, 157, 22);
		contentPane.add(t2);
		t2.setColumns(10);
		
		JLabel lblEnterYourPhone = new JLabel("Enter your phone no.");
		lblEnterYourPhone.setBounds(182, 176, 146, 32);
		contentPane.add(lblEnterYourPhone);
		
		t3 = new JTextField();
		t3.setBounds(340, 181, 157, 22);
		contentPane.add(t3);
		t3.setColumns(10);
		
		JLabel lblEnterYourAddress = new JLabel("Enter your address");
		lblEnterYourAddress.setBounds(182, 238, 125, 22);
		contentPane.add(lblEnterYourAddress);
		
		t4 = new JTextField();
		t4.setBounds(340, 238, 157, 22);
		contentPane.add(t4);
		t4.setColumns(10);
		
		JButton btnSubmit = new JButton("Submit");
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0)
			{
				String name=t1.getText();
				int age=Integer.parseInt(t2.getText());
				long phonenumber=Long.parseLong(t3.getText());
				String address=t4.getText();
				
			
				Random ran=new Random();
				long first7=(ran.nextLong() & 90000000L) +5040936000000000L;
				long first8=Math.abs(first7);
				long cardno=first8;
			
				long first3=(ran.nextLong() & 9000L) +1000L;
				long first4=Math.abs(first3);
                long pin=first4;
				
				
				
		
				
			    try
				{
				 Class.forName("com.mysql.jdbc.Driver");    
					
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/banking","root","");
					
					String query="insert into cinfo(name,age,phonenumber,address,cardno,pin)"+ "values(?,?,?,?,?,?)";
					String query1="insert into login(cardno,pin)"+ "values(?,?)";
					
					PreparedStatement ps=con.prepareStatement(query);
					PreparedStatement ps1=con.prepareStatement(query1);
					
				
					
					//String q1="insert into cinfo values('"+first8+"','"+first4+"')";
					//String q2="insert into login values('"+first8+"','"+first4+"')";
					
			       // PreparedStatement ps2= con.prepareStatement(q1);
			     //   PreparedStatement ps1= con.prepareStatement(q2);
	               
			       




					JOptionPane.showMessageDialog(null,"Card Number: "+first8+"\n Pin:"+first4);
					
					
					ps.setString(1,name);
					ps.setInt(2,age);
					ps.setLong(3,phonenumber);
					ps.setString(4,address);
					ps.setLong(5,cardno);
					ps.setLong(6,pin);
				    ps.execute();
				    
				    ps1.setLong(1,cardno);
					ps1.setLong(2,pin);
				    ps1.execute();
					
					JOptionPane.showMessageDialog(null, "Data Submitted");
					
					con.close();
					
					login lobj=new login();
					lobj.setVisible(true);
			
									
					
				}
			   
                catch(Exception e)
				{
				System.out.println("cannot process"+e.getMessage());
				}
				}
		 
			
		});

		btnSubmit.setBounds(373, 301, 97, 25);
		contentPane.add(btnSubmit);
	}
}
