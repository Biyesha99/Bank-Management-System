package Bank.Management.System;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Withdraw extends JFrame implements ActionListener{
	
	JTextField amount;
	JButton withdraw, back;
	String pinnumber;
	
	Withdraw(String pinnumber) {
		
		this.pinnumber = pinnumber;
		
		setLayout(null);
		
		ImageIcon i1 = new ImageIcon("C://Users//Biyesha//Desktop//Bank Management System//src//icons/atm.jpg");
		Image i2 = i1.getImage().getScaledInstance(750, 750, Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		JLabel image = new JLabel(i3);
		image.setBounds(0, 0, 750, 750);
		add(image);
		
		JLabel text = new JLabel("Enter the Amount");
		text.setForeground(Color.WHITE);
		text.setFont(new Font("System", Font.BOLD, 16));
		text.setBounds(150, 250, 400, 20);
		image.add(text);
		
		amount = new JTextField();
		amount.setFont(new Font("System", Font.BOLD, 22));
		amount.setBounds(140, 280, 280, 25);
		image.add(amount);
		
		withdraw = new JButton("Withdraw");
		withdraw.setBounds(275, 405, 150, 25);
		withdraw.addActionListener(this);
		image.add(withdraw);
		
		back = new JButton("Back");
		back.setBounds(275, 433, 150, 25);
		back.addActionListener(this);
		image.add(back);
		
		setSize(750, 750);
		setLocation(300, 0);
		//setUndecorated(true);
		setVisible(true);
		
	}
	
	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource() == withdraw) {
			String number = amount.getText();
			//String date = date.getText();
			if(number.equals("")) {
				JOptionPane.showMessageDialog(null, "Please Enter the Amount to Withdraw");
			} else {
				try {
				   Conn conn = new Conn();
				   String query = "insert into bank values('"+pinnumber+"', '"+withdraw+"', '"+number+"')";
				   conn.s.executeUpdate(query);
				   JOptionPane.showMessageDialog(null, "Success");
				   setVisible(false);
				   new Transactions(pinnumber).setVisible(true);
				} catch(Exception e) {
					System.out.print(e);
				}
			}
		} else if(ae.getSource() == back) {
			setVisible(false);
			new Transactions(pinnumber).setVisible(true);;
		}
	}

	public static void main(String[] args) {
        new Withdraw("");
	}

}
