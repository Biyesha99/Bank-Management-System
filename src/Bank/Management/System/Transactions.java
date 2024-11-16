package Bank.Management.System;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Transactions extends JFrame implements ActionListener{
	
	JButton deposit, withdrew, fastcash, ministatement, pinchange, balance, exit;
	String pinnumber; 
	
	Transactions(String pinnumber) {
		this.pinnumber = pinnumber;
		setLayout(null);
		
		ImageIcon i1 = new ImageIcon("C://Users//Biyesha//Desktop//Bank Management System//src//icons/atm.jpg");
		Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		JLabel image = new JLabel(i3);
		image.setBounds(0, 0, 750, 750);
		add(image);
		
		JLabel text = new JLabel("Please select your Transaction");
		text.setBounds(150, 230, 700, 35);
		text.setForeground(Color.WHITE);
		text.setFont(new Font("System", Font.BOLD, 16));
		image.add(text);
		
		deposit = new JButton("Deposit");
		deposit.setBounds(100, 340, 150, 30);
		deposit.addActionListener(this);
		image.add(deposit);
		
		withdrew = new JButton("Withdrew");
		withdrew.setBounds(100, 375, 150, 30);
		withdrew.addActionListener(this);
		image.add(withdrew);
		
		fastcash = new JButton("Fast cash");
		fastcash.setBounds(100, 410, 150, 30);
		fastcash.addActionListener(this);
		image.add(fastcash);
		
		ministatement = new JButton("Mini-Statement");
		ministatement.setBounds(280, 340, 150, 30);
		ministatement.addActionListener(this);
		image.add(ministatement);
		
		pinchange = new JButton("Pin Change");
		pinchange.setBounds(280, 375, 150, 30);
		pinchange.addActionListener(this);
		image.add(pinchange);
		
		balance = new JButton("Balance");
		balance.setBounds(280, 410, 150, 30);
		balance.addActionListener(this);
		image.add(balance);
		
		exit = new JButton("Exit");
		exit.setBounds(280, 445, 150, 30);
		exit.addActionListener(this);
		image.add(exit);
		
		setSize(750, 750);
		setLocation(300, 0);
		setUndecorated(true);
		setVisible(true);
	}
	
	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource() == exit) {
			System.exit(0);
		} else if(ae.getSource() == deposit) {
			setVisible(false);
			new Deposit(pinnumber).setVisible(true);
		} else if(ae.getSource() == withdrew) {
			setVisible(false);
			new Withdraw(pinnumber).setVisible(true);
		} else if(ae.getSource() == fastcash) {
			setVisible(false);
			new FastCash(pinnumber).setVisible(true);
		} else if(ae.getSource() == pinchange) {
			setVisible(false);
			new FastCash(pinnumber).setVisible(true);
		} else if(ae.getSource() == balance) {
			setVisible(false);
			new FastCash(pinnumber).setVisible(true);
		} else if(ae.getSource() == ministatement) {
			new FastCash(pinnumber).setVisible(true);
		}
	}

	public static void main(String[] args) {
       new Transactions("");
	}

}
