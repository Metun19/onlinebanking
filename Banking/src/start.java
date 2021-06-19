import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class start extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					start frame = new start();
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
	public start() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 542, 297);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblWelcomeToBanking = new JLabel("WELCOME TO BANKING");
		lblWelcomeToBanking.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblWelcomeToBanking.setForeground(Color.DARK_GRAY);
		lblWelcomeToBanking.setBounds(161, 13, 180, 48);
		contentPane.add(lblWelcomeToBanking);
		
		JButton btnCreateNewAccount = new JButton("Create new account");
		btnCreateNewAccount.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				JOptionPane.showMessageDialog(null, " DO u wanna continue");
				cracc cobj=new cracc();
				cobj.setVisible(true);
			}
		});
		btnCreateNewAccount.setBounds(161, 94, 180, 25);
		contentPane.add(btnCreateNewAccount);
		
		JButton btnLoginToExisting = new JButton("Login to existing account");
		btnLoginToExisting.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0)
			{
				JOptionPane.showMessageDialog(null, " DO u wanna continue");
				login lobj=new login();
				lobj.setVisible(true);
			}
		});
		btnLoginToExisting.setBounds(161, 166, 180, 25);
		contentPane.add(btnLoginToExisting);
	}
}
