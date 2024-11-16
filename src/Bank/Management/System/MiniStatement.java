package Bank.Management.System;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;

public class MiniStatement extends JFrame implements ActionListener{
	
	String pinnumber;
	JTextField pin, repin;
	JButton back;
	
	MiniStatement(String pinnumber) {
		
		setTitle("Mini-Statement");
		this.pinnumber = pinnumber;
		setLayout(null);
		
		ImageIcon i1 = new ImageIcon("C://Users//Biyesha//Desktop//Bank Management System//src//icons/atm.jpg");
		Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		JLabel image = new JLabel(i3);
		image.setBounds(0, 0, 750, 750);
		add(image);
		
		JLabel mini = new JLabel();
		add(mini);
		
		JLabel bank = new JLabel("Horizon Bank");
		bank.setBounds(150, 20, 100, 20);
		add(bank);
		
		JLabel card = new JLabel();
		card.setBounds(20, 80, 300, 20);
		add(card);
		
		JLabel balance = new JLabel();
		balance.setBounds(20, 400, 300, 20);
		add(balance);
		
		try {
			Conn c = new Conn();
			ResultSet rs = c.s.executeQuery("elect * from login where pin = '"+pinnumber+"'");
			while(rs.next()) {
				card.setText("Card Number: " + rs.getString("cardnumber").substring(0, 4) + "XXXXXXXX" + rs.getString("cardnumber").substring(12));
			}
		}catch(Exception e) {
			System.out.print(e);
		}
		
		try {
			Conn c = new Conn();
			int bal = 0;
			ResultSet rs = c.s.executeQuery("elect * from login where pin = '"+pinnumber+"'");
			while(rs.next()) {
				mini.setText(mini.getText() + "<html>" + rs.getString("date") + "&nbsp&nbsp&nbsp&nbsp&nbsp" + rs.getString("type") + "&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp" + rs.getString("amount") + "<br><br></html>");
				if(rs.getString("type").equals("Deposit")) {
					bal += Integer.parseInt(rs.getString("amount"));
				   } else {
					   bal -= Integer.parseInt(rs.getString("amount"));
				   }
			}
			
			balance.setText("Your current account balance is Rs. " + bal);
		}catch(Exception e) {
			System.out.print(e);
		}
		
		mini.setBounds(20, 140, 400, 200);
		
		setSize(400, 600);
		setLocation(20, 20);
		setUndecorated(true);
		setVisible(true);
	}

	public void actionPerformed(ActionEvent ae) {
		
	}
	
	public static void main(String[] args) {
		new MiniStatement("").setVisible(true);
	}

}
