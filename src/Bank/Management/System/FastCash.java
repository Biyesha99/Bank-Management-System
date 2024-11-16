package Bank.Management.System;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class FastCash extends JFrame implements ActionListener{
	
	JButton deposit, withdrew, fastcash, ministatement, pinchange, balance, exit;
	String pinnumber; 
	
	FastCash(String pinnumber) {
		this.pinnumber = pinnumber;
		setLayout(null);
		
		ImageIcon i1 = new ImageIcon("C://Users//Biyesha//Desktop//Bank Management System//src//icons/atm.jpg");
		Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		JLabel image = new JLabel(i3);
		image.setBounds(0, 0, 750, 750);
		add(image);
		
		JLabel text = new JLabel("SELECT WITHDRAWAL AMOUNT");
		text.setBounds(150, 230, 700, 35);
		text.setForeground(Color.WHITE);
		text.setFont(new Font("System", Font.BOLD, 16));
		image.add(text);
		
		deposit = new JButton("Rs. 100");
		deposit.setBounds(100, 340, 150, 30);
		deposit.addActionListener(this);
		image.add(deposit);
		
		withdrew = new JButton("Rs. 500");
		withdrew.setBounds(100, 375, 150, 30);
		withdrew.addActionListener(this);
		image.add(withdrew);
		
		fastcash = new JButton("Rs. 1000");
		fastcash.setBounds(100, 410, 150, 30);
		fastcash.addActionListener(this);
		image.add(fastcash);
		
		ministatement = new JButton("Rs. 2000");
		ministatement.setBounds(280, 340, 150, 30);
		ministatement.addActionListener(this);
		image.add(ministatement);
		
		pinchange = new JButton("Rs. 5000");
		pinchange.setBounds(280, 375, 150, 30);
		pinchange.addActionListener(this);
		image.add(pinchange);
		
		balance = new JButton("Rs. 10000");
		balance.setBounds(280, 410, 150, 30);
		balance.addActionListener(this);
		image.add(balance);
		
		exit = new JButton("Back");
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
			setVisible(false);
			new Transactions(pinnumber).setVisible(true);
		} else {
			String amount = ((JButton)ae.getSource()).getText().substring(3);
			Conn c = new Conn();
			
			try {
				ResultSet rs = c.s.executeQuery("select * from bank where pin = '"+pinnumber+"'");
				int balance = 0;
				while(rs.next()) {
					if(rs.getString("type").equals("Deposit")) {
						balance += Integer.parseInt(rs.getString("amount"));
					} else {
						balance -= Integer.parseInt(rs.getString(amount));
					}
				}
				
				if(ae.getSource() != exit && balance < Integer.parseInt(amount)) {
					JOptionPane.showMessageDialog(null, "INSUFFICIENT BALANCE");
					return;
				}
				
				setVisible(false);
				new Transactions(pinnumber).setVisible(true);
			} catch(Exception e) {
				System.out.print(e);
			}
		}
	}

	public static void main(String[] args) {
       new FastCash("");
	}

}
