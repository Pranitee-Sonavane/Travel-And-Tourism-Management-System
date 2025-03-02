package com.FourMation.travels;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;

import java.sql.*;
import java.awt.event.*;

public class ForgotPassword extends JFrame implements ActionListener{
	private JPanel contentPane;
	private JTextField t1, t2, t3, t4, t5;
	private JButton b1, b2, b3;

	public static void main(String[] args) 
	{
		new ForgotPassword().setVisible(true);
	}
	public ForgotPassword() {

		setBounds(500, 200, 850, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setBackground(Color.WHITE);
		contentPane.setLayout(null);

		JLabel l1 = new JLabel("Username");
		l1.setFont(new Font("Tahoma", Font.BOLD, 13));
		l1.setBounds(109, 83, 87, 29);
		contentPane.add(l1);

		JLabel l2 = new JLabel("New Password");
		l2.setFont(new Font("Tahoma", Font.BOLD, 13));
		l2.setBounds(109, 122, 75, 21);
		contentPane.add(l2);

		JLabel l3 = new JLabel("Confirm Password");
		l3.setFont(new Font("Tahoma", Font.BOLD, 13));
		l3.setBounds(109, 154, 156, 27);
		contentPane.add(l3);

		t1 = new JTextField();
		t1.setFont(new Font("Tahoma", Font.BOLD, 13));
		t1.setForeground(new Color(105, 105, 105));
		t1.setBounds(277, 88, 139, 20);
		contentPane.add(t1);
		t1.setColumns(10);

		t2 = new JTextField();
		t2.setFont(new Font("Tahoma", Font.BOLD, 13));
		t2.setForeground(new Color(165, 42, 42));
		t2.setColumns(10);
		t2.setBounds(277, 123, 139, 20);
		contentPane.add(t2);

		t3 = new JTextField();
		t3.setFont(new Font("Tahoma", Font.BOLD, 12));
		t3.setForeground(new Color(72, 61, 139));
		t3.setColumns(10);
		t3.setBounds(277, 161, 221, 20);
		contentPane.add(t3);

		ImageIcon c1 = new ImageIcon(ClassLoader.getSystemResource("icons/forgot.png"));
		Image i1 = c1.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT);
		ImageIcon i2 = new ImageIcon(i1);

		JLabel l6 = new JLabel(i2);
		l6.setBounds(560, 70, 200, 200);
		add(l6);

		b1 = new JButton("Reset Password");
		b1.addActionListener(this);
		b1.setFont(new Font("Tahoma", Font.BOLD, 12));
		b1.setBounds(133, 240, 150, 29);
		b1.setBackground(Color.BLACK);
		b1.setForeground(Color.WHITE);
		contentPane.add(b1);

		b3 = new JButton("Back");
		b3.addActionListener(this);
		b3.setFont(new Font("Tahoma", Font.BOLD, 13));
		b3.setBounds(293, 240, 101, 29);
		b3.setBackground(Color.BLACK);
		b3.setForeground(Color.WHITE);
		contentPane.add(b3);

		JPanel panel = new JPanel();
		panel.setBounds(47, 45, 508, 281);
		panel.setBackground(Color.LIGHT_GRAY);
		contentPane.add(panel);
	}

	public void actionPerformed(ActionEvent ae) {
		try {
			DBConnection c = new DBConnection();
			if (ae.getSource() == b1) {
				if (t2.getText().equals(t3.getText()))
				{
					String sql = "update usertable set password =? where username=?";
					PreparedStatement st = c.con.prepareStatement(sql);

					st.setString(1, t2.getText());
					st.setString(2, t1.getText());
					int i=st.executeUpdate();									System.out.println(i);
					JOptionPane.showMessageDialog(null, "Password Updated Successfully");
				} 
				else 
				{
					JOptionPane.showMessageDialog(null, "New Password and Confirm Password does not Match");

				}

			}
			if (ae.getSource() == b3) 
			{
				this.setVisible(false);
				new LogInPage().setVisible(true);

			}
		} catch (Exception e){

		}
	}



}
