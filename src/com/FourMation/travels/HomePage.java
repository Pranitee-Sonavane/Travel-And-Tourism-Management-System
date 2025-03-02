package com.FourMation.travels;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

public class HomePage extends JFrame implements ActionListener
{
	JMenuItem mi1;
	JMenuItem mi2;
	JMenuItem mi3;
	JMenuItem mi4;
	JMenuItem mi5;
	JMenuItem mi6;
	JMenuItem mi7;
	JMenuItem mi8;
	JMenuItem mi9;
	JMenuItem mi10;
	JMenuItem mi11;
	JMenuItem mi12;
	private String username;
	public static void main(String[] args)
	{
		new HomePage("").setVisible(true);
	}
	public HomePage(String username)
	{
		super("Travel and Tourism Management System");
		this.username=username;
		setForeground(Color.CYAN);
		setLayout(null);

		
		  ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("Icons/Homepage.jpg")); 
		  Image i2 =i1.getImage().getScaledInstance(1990, 1000, Image.SCALE_DEFAULT); 
		  ImageIcon i3 = new ImageIcon(i2); 
		  JLabel NewLabel = new JLabel(i3);
		  NewLabel.setBounds(0, 0, 1950, 1000); 
		  add(NewLabel);
		 
		
		JLabel l1 = new JLabel("Travel and Tourism Management System");
		l1.setForeground(Color.BLACK);
		l1.setFont(new Font("Gabriola", Font.BOLD, 80));
		l1.setBounds(220, 100, 2000, 200);
		NewLabel.add(l1);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		//Customer
		JMenu m1 = new JMenu("CUSTOMER");
		m1.setForeground(Color.BLACK);
		menuBar.add(m1);

		mi1 = new JMenuItem("Add Customer");
		m1.add(mi1);
		mi1.addActionListener(this);

		mi2 = new JMenuItem("Update Customer Details");
		m1.add(mi2);
		mi2.addActionListener(this);

		mi3 = new JMenuItem("View Cutomer Details");
		m1.add(mi3);
		mi3.addActionListener(this);

		mi4 = new JMenuItem("Delete Customer Details");
		m1.add(mi4);
		mi4.addActionListener(this);

		//packages
		JMenu m2 = new JMenu("PACKAGES");
		m2.setForeground(Color.BLACK);
		menuBar.add(m2);
		
		mi5 = new JMenuItem("Check Packages");
		m2.add(mi5);
		mi5.addActionListener(this);

		mi6 = new JMenuItem("View Packages");
		m2.add(mi6);
		mi6.addActionListener(this);

		mi7 = new JMenuItem("Book Packages");
		m2.add(mi7);
		mi7.addActionListener(this);
		
		//Hotels
		JMenu m3 = new JMenu("HOTELS");
		m3.setForeground(Color.BLACK);
		menuBar.add(m3);
		
		mi8 = new JMenuItem("Book Hotels");
		m3.add(mi8);
		mi8.addActionListener(this);

		mi9 = new JMenuItem("View Hotels");
		m3.add(mi9);
		mi9.addActionListener(this);

		mi10 = new JMenuItem("View Booked Hotels");
		m3.add(mi10);
		mi10.addActionListener(this);
		
		//Payment
		JMenu m4= new JMenu("PAYMENTS");
		m4.setForeground(Color.BLACK);
		menuBar.add(m4);
		
		mi11 = new JMenuItem("Make Payments");
		m4.add(mi11);
		mi11.addActionListener(this);
		
		//About
		JMenu m5= new JMenu("ABOUT");
		m5.setForeground(Color.BLACK);
		menuBar.add(m5);
		
		mi12 = new JMenuItem("View About");
		m5.add(mi12);
		mi12.addActionListener(this);
		
		
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		setVisible(true);
		getContentPane().setBackground(Color.BLACK);	
	}
	
	@Override
	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource()==mi12)
		{
			new AboutPage().setVisible(true);
		}
		else if(e.getSource()==mi11)
		{
			new PaymentPage().setVisible(true);
		}
		else if(e.getSource()==mi1)
		{
			new AddCustomer(username).setVisible(true);
		}
		else if(e.getSource()==mi3)
		{
			new ViewCustomer().setVisible(true);
		}
		else if(e.getActionCommand()=="Delete Customer Details")
		{	
			new DeleteCustomer1(username).setVisible(true);
		}
		else if(e.getSource()==mi5)
		{
			new CheckPackage().setVisible(true);
		}
		else if(e.getSource()==mi7)
		{
			new BookPackage(username).setVisible(true);
		}
		else if(e.getSource()==mi6)
		{
			new ViewPackage(username).setVisible(true);
		}
		else if(e.getSource()==mi8)
		{
			new BookHotel(username).setVisible(true);
		}
		else if(e.getSource()==mi9)
		{
			new ViewHotel().setVisible(true);
		}
		else if(e.getSource()==mi10)
		{
			new ViewBookedHotel(username).setVisible(true);
		}
		else if(e.getSource()==mi2)
		{
			new UpdateCustomer(username).setVisible(true);
		}
		
	}
	
}
	
