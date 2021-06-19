import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.Connection;
//import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;


public class deposit1 extends JFrame {

	private JPanel contentPane;
	private JPasswordField p6;
	private JTextField t6;
	private JButton btnBack;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					deposit1 frame = new deposit1();
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
	public deposit1() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 330);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblPin = new JLabel("pin");
		lblPin.setBounds(77, 52, 56, 16);
		contentPane.add(lblPin);
		
		p6 = new JPasswordField();
		p6.setBounds(246, 49, 69, 22);
		contentPane.add(p6);
		
		JLabel lblEnterAmountTo = new JLabel("enter amount to deposit");
		lblEnterAmountTo.setBounds(77, 118, 146, 16);
		contentPane.add(lblEnterAmountTo);
		
		t6 = new JTextField();
		t6.setBounds(246, 115, 116, 22);
		contentPane.add(t6);
		t6.setColumns(10);
		
		JButton l2 = new JButton("Submit");
		l2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) 
			{
		    try
		    {
			int amount=Integer.parseInt(t6.getText());
			String date=new SimpleDateFormat("dd/MM/yyyy",Locale.FRANCE).format(new Date());
			
			// if(t6.getText().equals(""));
			//  {
			// JOptionPane.showMessageDialog(null,"please enter the amount you want to deposit");
			// }
			 // else
			// {
			  
				  Class.forName("com.mysql.jdbc.Driver");
					
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/banking","root","");
					
					int pin=Integer.parseInt(p6.getText());
			        String q="Select * from login where pin = '"+pin+"'";
				    Statement stmt=con.createStatement();
					ResultSet rs=stmt.executeQuery(q);
					if(ae.getSource()==l2)
					{
						if(rs.next())
						{
							
							String query="insert into bank(pin,date,mode,amount)"+ "values(?,?,?,?)";
							PreparedStatement ps= con.prepareStatement(query);
				            
							ps.setInt(1,pin);
							ps.setString(2,date);
							ps.setString(3, "Deposit");
							ps.setInt(4,amount);
							
							ps.executeUpdate();
							JOptionPane.showMessageDialog(null,"Rs."+amount+" Deposited successfully");

						}
						else
						{
							JOptionPane.showMessageDialog(null,"Incorrect pin");
						}
					}con.close();

					
					
			  }
			 
			//}
			catch(Exception e)
			{
				System.out.println("cannot process "+e.getMessage());
			}
		}
			
		});
		l2.setBounds(256, 177, 97, 25);
		contentPane.add(l2);
		
		btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				transaction tobj=new transaction();
				tobj.setVisible(true);

			}
		});
		btnBack.setBounds(79, 245, 82, 25);
		contentPane.add(btnBack);
	}

}
