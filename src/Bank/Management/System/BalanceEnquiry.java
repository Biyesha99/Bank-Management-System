package Bank.Management.System;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;

public class BalanceEnquiry extends JFrame implements ActionListener{
	
	String pinnumber;
	JTextField pin, repin;
	JButton back;
	
	BalanceEnquiry(String pinnumber) {
		this.pinnumber = pinnumber;
		setLayout(null);
		
		ImageIcon i1 = new ImageIcon("C://Users//Biyesha//Desktop//Bank Management System//src//icons/atm.jpg");
		Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		JLabel image = new JLabel(i3);
		image.setBounds(0, 0, 750, 750);
		add(image);
		
		back = new JButton("BACK");
		back.setBounds(280, 435, 150, 30);
		back.addActionListener(this);
		image.add(back);
		
		Conn c = new Conn();
		int balance = 0;
		try {
			ResultSet rs = c.s.executeQuery("select * from bank where pin = '"+pinnumber+"'");
			while(rs.next()) {
				if(rs.getString("type").equals("Deposit")) {
				balance += Integer.parseInt(rs.getString("amount"));
			   } else {
				   balance -= Integer.parseInt(rs.getString("amount"));
			   }
		    }
		} catch(Exception e) {
			System.out.print(e);
		}
		
		JLabel text = new JLabel("Your Current Account Balance is Rs. " + balance);
		text.setForeground(Color.WHITE);
		text.setBounds(170, 300, 400, 30);
		image.add(text);
		
		setSize(750, 750);
		setLocation(300, 0);
		setUndecorated(true);
		setVisible(true);
	}

	public void actionPerformed(ActionEvent ae) {
		
	}
	
	public static void main(String[] args) {
		new BalanceEnquiry("").setVisible(true);
	}

}
