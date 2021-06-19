import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.JPasswordField;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;


public class withdraw extends JFrame {

	private JPanel contentPane;
	private JPasswordField p4;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					withdraw frame = new withdraw();
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
	public withdraw() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 339);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblEnterAmountTo = new JLabel("Enter amount to withdraw");
		lblEnterAmountTo.setBounds(59, 125, 149, 31);
		contentPane.add(lblEnterAmountTo);
		
		JTextArea t7 = new JTextArea();
		t7.setBounds(258, 129, 99, 22);
		contentPane.add(t7);
		
		JButton c1 = new JButton("confirm");
		c1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) 
			{
				 try
				    {
					int amount=Integer.parseInt(t7.getText());
					String date=new SimpleDateFormat("dd/MM/yyyy",Locale.FRANCE).format(new Date());
				
					  
						  Class.forName("com.mysql.jdbc.Driver");
							
							Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/banking","root","");
							
							int pin=Integer.parseInt(p4.getText());
					        String q="Select * from login where pin = '"+pin+"'";
						    Statement stmt=con.createStatement();
							ResultSet rs=stmt.executeQuery(q);
			if(ae.getSource()==c1)
				{
							
				int balance=16500;		
						if(rs.next())
							{
							
							
							//String query="Select * from bank where amount = '"+balance+"'";
						   // Statement ps=con.createStatement();
							
							// ps.execute(query); 
								
								while(rs.next())
								{
									String query="Select * from bank where pin='"+pin+"' and   '"+balance+"'=amount";
								    Statement ps=con.createStatement();
									
									 ps.execute(query); 
										
									if(rs.getString("mode").equals("Deposit"))
									{
										balance+=Integer.parseInt(rs.getString("amount"));
									}
									else
									{
										balance-=Integer.parseInt(rs.getString("amount"));
                                    }
								}	
								if(balance < Integer.parseInt(t7.getText()))
								{
								 JOptionPane.showMessageDialog(null,"Insufficient balance");
								 return;
								 }
								else{
								String query1="insert into bank(pin,date,mode,amount)"+ "values(?,?,?,?)";
								PreparedStatement ps1= con.prepareStatement(query1);
					            
								ps1.setInt(1,pin);
								ps1.setString(2,date);
								ps1.setString(3, "Withdraw");
								ps1.setInt(4,amount);
								
								ps1.executeUpdate();
								JOptionPane.showMessageDialog(null,"Rs."+amount+" Debited successfully");
								}	
							    }//con.close();

                           
									
							
							
							else
							{
								JOptionPane.showMessageDialog(null,"Incorrect pin");
							}
							
				       }		
				    }
				 
					 
					//}
					catch(Exception e)
					{
						System.out.println("cannot process "+e.getMessage());
					}
			}
		});
		c1.setBounds(260, 189, 97, 25);
		contentPane.add(c1);
		
		JLabel lblPin = new JLabel("pin");
		lblPin.setBounds(59, 72, 56, 16);
		contentPane.add(lblPin);
		
		p4 = new JPasswordField();
		p4.setBounds(258, 69, 99, 22);
		contentPane.add(p4);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0)
			{
				transaction tobj=new transaction();
				tobj.setVisible(true);
			}
		});
		btnBack.setBounds(59, 254, 97, 25);
		contentPane.add(btnBack);
	}
}
