import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JPasswordField;


public class login extends JFrame {

	private JPanel contentPane;
	private JTextField t5;
	private JPasswordField p3;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					login frame = new login();
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
	public login() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 457, 310);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblLoginpage = new JLabel("LOGIN  PAGE\r\n");
		lblLoginpage.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblLoginpage.setBounds(157, 23, 115, 42);
		contentPane.add(lblLoginpage);
		
		JLabel lblName = new JLabel("Cardno");
		lblName.setBounds(120, 94, 68, 22);
		contentPane.add(lblName);
		
		t5 = new JTextField();
		t5.setBounds(211, 94, 141, 22);
		contentPane.add(t5);
		t5.setColumns(10);
		
		JLabel lblPassword = new JLabel("Pin");
		lblPassword.setBounds(120, 153, 68, 19);
		contentPane.add(lblPassword);
		
		JButton l1 = new JButton("Login");
		l1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae)
			{
				
				
								
			
			try
				{
					Class.forName("com.mysql.jdbc.Driver");    //load the drivers
					
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/banking","root","");
													//connect to data base
					String cardno=t5.getText();
					int pin=Integer.parseInt(p3.getText());
	                String q="Select * from login where cardno='"+cardno+"' and pin = '"+pin+"'";
                    
	                
					Statement stmt=con.createStatement();
					
	                
					ResultSet rs=stmt.executeQuery(q);
					
			       
					if(ae.getSource()==l1)
					{
						if(rs.next())
						{
							transaction tobj=new transaction();
							tobj.setVisible(true);
						}
						else
						{
							JOptionPane.showMessageDialog(null,"Incorrect login details");
						}
					}con.close();
					  
					//while(rs.next())
				    // {
				   // System.out.println(rs.getString(1)+" "+rs.getInt(2)+" "+rs.getInt(3)+" "+rs.getString(4)+" "+rs.getInt(5));
					//  transaction tobj=new transaction();
					//    tobj.setVisible(true);
	               //}
					//con.close();
					
				  }
			 
			
					catch(Exception e)
				{
					System.out.println("cannot process "+e.getMessage());
				}
			
			

			
		
			}});
		l1.setBounds(227, 208, 97, 25);
		contentPane.add(l1);
		
		p3 = new JPasswordField();
		p3.setBounds(211, 151, 141, 22);
		contentPane.add(p3);
		}}

