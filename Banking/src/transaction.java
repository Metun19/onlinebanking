import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class transaction extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					transaction frame = new transaction();
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
	public transaction() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 498, 343);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnWithdraw = new JButton("Withdraw");
		btnWithdraw.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				withdraw wobj=new withdraw();
				wobj.setVisible(true);
			}
		});
		btnWithdraw.setBounds(174, 67, 126, 25);
		contentPane.add(btnWithdraw);
		
		JButton btnDeposit = new JButton("Deposit");
		btnDeposit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0)
			{
				deposit1 dobj=new deposit1();
				dobj.setVisible(true);
			}
		});
		btnDeposit.setBounds(174, 133, 126, 25);
		contentPane.add(btnDeposit);
		
		JButton btnSsatement = new JButton("Mini Statement");
		btnSsatement.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0)
			{
				ministatement mobj=new ministatement(toString());
				mobj.setVisible(true);
			}
		});
		btnSsatement.setBounds(174, 196, 126, 25);
		contentPane.add(btnSsatement);
		
		JButton btnExit = new JButton("Exit");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				System.exit(0);
			}
		});
		btnExit.setBounds(360, 258, 97, 25);
		contentPane.add(btnExit);
	}
}
