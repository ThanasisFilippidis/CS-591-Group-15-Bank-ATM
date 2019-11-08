package bank.View;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

import bank.Controller.LoanController;
import bank.Controller.LoanControllerManager;
import bank.Controller.LoginController;

public class ManagerSideView extends JPanel {

	private static final long serialVersionUID = 1L;
	private JButton loginButton;
	private JButton managerLoginButton;
	private JButton profileButton;
	private JButton custListButton;
	private JButton loanListButton;
	private JButton transactionButton;
	private JPanel parentPanel;
	private JButton logOutButton;
	
	public ManagerSideView()
	{
		custListButton = new JButton("Customer List");
		loanListButton = new JButton("Loan List to Approve");
		transactionButton = new JButton("Transaction List");
		logOutButton = new JButton("Log out");
		
		this.setLayout(new GridBagLayout());
	    GridBagConstraints gbc = new GridBagConstraints();
	    gbc.gridwidth = GridBagConstraints.REMAINDER;
        gbc.fill = GridBagConstraints.HORIZONTAL;
	    		
        this.add(custListButton, gbc);
		this.add(loanListButton, gbc);
		this.add(transactionButton, gbc);
		this.add(logOutButton, gbc);
		
		initialize();
	}
	
	private void initialize()
	{
		loanListButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LoanControllerManager loanControllerManager = new LoanControllerManager();
	    	
				//LoanController loanController = new LoanController();
		     
			}
		});
		custListButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {	    	
				//ProfileController proController = new ProfileController();
				//proController.ShowProfileList();		     
			}
		});
		
		transactionButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
	    	
				//TransactionController transController = new TransactionController();
				//transController.transactionList();
		     
			}
		});
		logOutButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {    	
				LoginController loginController = new LoginController();
			}
		});
	}
}
