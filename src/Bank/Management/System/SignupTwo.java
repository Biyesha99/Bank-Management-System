package Bank.Management.System;

import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.awt.event.*;

public class SignupTwo extends JFrame implements ActionListener{

	JButton next;
	JRadioButton yes, no, existing, neww;
	JComboBox religion, category, income, education, occupation;
	String formno;
	
	SignupTwo(String formno) {
		this.formno = formno;
		setLayout(null);
		
		setTitle("NEW ACCOUNT APPLICATION FORM - PAGE 02");
		
		JLabel additinoldetails = new JLabel("Page 02: Additional Details");
		additinoldetails.setFont(new Font("Railway", Font.BOLD, 22));
		additinoldetails.setBounds(290, 80, 400, 30);
		add(additinoldetails);
		
		JLabel name = new JLabel("Religion:");
		name.setFont(new Font("Railway", Font.BOLD, 20));
		name.setBounds(100, 140, 100, 30);
		add(name);
		
		String  rel[] = {"Buddhist", "Christian", "Islamic", "Hindu", "Other"};
		religion = new JComboBox(rel);
		religion.setBounds(300, 140, 400, 30);
		religion.setBackground(Color.WHITE);
		add(religion);
		
		String  cat[] = {"General", "Other"};
		category = new JComboBox(cat);
		category.setBounds(300, 190, 400, 30);
		category.setBackground(Color.WHITE);
		add(category);
		
		JLabel fname = new JLabel("Category:");
		fname.setFont(new Font("Railway", Font.BOLD, 20));
		fname.setBounds(100, 190, 200, 30);
		add(fname);
		
		JLabel dob = new JLabel("Income:");
		dob.setFont(new Font("Railway", Font.BOLD, 20));
		dob.setBounds(100, 240, 200, 30);
		add(dob);
		
		String  inc[] = {"More than Rs.500000", "In between Rs.500000 - Rs.250000", "Less that Rs.250000"};
		income = new JComboBox(inc);
		income.setBounds(300, 240, 400, 30);
		income.setBackground(Color.WHITE);
		add(income);
		
		JLabel gender = new JLabel("Educational");
		gender.setFont(new Font("Railway", Font.BOLD, 20));
		gender.setBounds(100, 290, 200, 30);
		add(gender);
		
		JLabel email = new JLabel("Qualification:");
		email.setFont(new Font("Railway", Font.BOLD, 20));
		email.setBounds(100, 318, 200, 30);
		add(email);
		
		String  values[] = {"Non-Graduate", "Graduate", "Post-Graduate", "Doctrate", "Other"};
		education = new JComboBox(values);
		education.setBounds(300, 318, 400, 30);
		education.setBackground(Color.WHITE);
		add(education);
		
		JLabel status = new JLabel("Occupation:");
		status.setFont(new Font("Railway", Font.BOLD, 20));
		status.setBounds(100, 390, 200, 30);
		add(status);
		
		String  occu[] = {"Salaried", "Self-Employed", "Business", "Student", "Retired", "Other"};
		occupation = new JComboBox(occu);
		occupation.setBounds(300, 390, 400, 30);
		occupation.setBackground(Color.WHITE);
		add(occupation);
		
		JLabel city = new JLabel("Senior Citizen:");
		city.setFont(new Font("Railway", Font.BOLD, 20));
		city.setBounds(100, 490, 200, 30);
		add(city);
		
		yes = new JRadioButton("Yes");
		yes.setBounds(300, 490, 60, 30);
		yes.setBackground(Color.WHITE);
		add(yes);
		
		no = new JRadioButton("No");
		no.setBounds(450, 490, 120, 30);
		no.setBackground(Color.WHITE);
		add(no);
		
		ButtonGroup gendergroup = new ButtonGroup();
		gendergroup.add(yes);
		gendergroup.add(no);
		
		JLabel state = new JLabel("Exisitng Account:");
		state.setFont(new Font("Railway", Font.BOLD, 20));
		state.setBounds(100, 540, 200, 30);
		add(state);
		
		existing = new JRadioButton("Yes");
		existing.setBounds(300, 540, 60, 30);
		existing.setBackground(Color.WHITE);
		add(existing);
		
		neww = new JRadioButton("No");
		neww.setBounds(450, 540, 120, 30);
		neww.setBackground(Color.WHITE);
		add(neww);
		
		ButtonGroup accountgroup = new ButtonGroup();
		gendergroup.add(existing);
		gendergroup.add(neww);
		
		next = new JButton("Next");
		next.setBackground(Color.BLACK);
		next.setForeground(Color.WHITE);
		next.setFont(new Font("Railway", Font.BOLD, 14));
		next.setBounds(620, 660, 80, 30);
		next.addActionListener(this);
		add(next);
		
		getContentPane().setBackground(Color.WHITE);
		
		setSize(850, 80);
		setLocation(350, 10);
		setVisible(true);
	}
	
	public void actionPerformed(ActionEvent ae) {
		String sreligion = (String) religion.getSelectedItem();
		String scategory = (String) category.getSelectedItem();
		String sincome = (String) income.getSelectedItem();
		String seducation = (String) education.getSelectedItem();
		String soccupation = (String) occupation.getSelectedItem();
		
		String sseniorCitizen = null;
		if(yes.isSelected()) {
			sseniorCitizen = "Yes";
		} else if(no.isSelected()) {
			sseniorCitizen = "No";
		}
		
		String saccount = null;
		if(existing.isSelected()) {
			saccount = "Yes";
		} else if(neww.isSelected()) {
			saccount = "No";
		}
		
		try {
		    Conn c = new Conn();
			String query = "insert into signuptwo values('"+formno+"', '"+sreligion+"', '"+scategory+"', '"+sincome+"', '"+seducation+"', '"+soccupation+"', '"+sseniorCitizen+"', '"+saccount+"')";
			c.s.executeUpdate(query);
			
			//SignupThree Object
			setVisible(false);
			new SignupThree(formno).setVisible(true);
		} catch(Exception e) {
			System.out.print(e);
		}
	}

	public static void main(String[] args) {
        new SignupTwo("");
	}

}
