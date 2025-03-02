package com.FourMation.travels;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class LogInPage extends JFrame implements ActionListener
{
	private JPanel panel;
	private JTextField textField;
	private JPasswordField passwordField;
	private JButton b1,b2,b3;
	
	public static void main(String[] args) 
	{
		new LogInPage().setVisible(true);
	} 
	public LogInPage()
	{
		setBounds(550, 250, 700, 400);

		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		setContentPane(panel);
		panel.setLayout(null);

		JLabel l1 = new JLabel("Username : ");
		l1.setBounds(124, 89, 95, 24);
		panel.add(l1);

		JLabel l2 = new JLabel("Password : ");
		l2.setBounds(124, 124, 95, 24);
		panel.add(l2);

		textField = new JTextField();
		textField.setBounds(210, 93, 157, 20);
		panel.add(textField);

		passwordField = new JPasswordField();
		passwordField.setBounds(210, 128, 157, 20);
		panel.add(passwordField);
		
		JLabel l3 = new JLabel("");
		l3.setBounds(377, 79, 46, 34);
		panel.add(l3);

		JLabel l4 = new JLabel("");
		l4.setBounds(377, 124, 46, 34);
		panel.add(l3);

		ImageIcon c1 = new ImageIcon(ClassLoader.getSystemResource("icons/login.png"));
		Image i1 = c1.getImage().getScaledInstance(150, 150, Image.SCALE_DEFAULT);
		ImageIcon i2 = new ImageIcon(i1);

		JLabel l6 = new JLabel(i2);
		l6.setBounds(470, 70, 200, 150);
		add(l6);
		
		b1 = new JButton("Login");
		b1.addActionListener(this);

		b1.setForeground(new Color(46, 139, 87));
		b1.setBackground(new Color(176, 224, 230));
		b1.setBounds(149, 181, 113, 25);
		panel.add(b1);

		b2 = new JButton("SignUp");
		b2.addActionListener(this);

		b2.setForeground(new Color(139, 69, 19));
		b2.setBackground(new Color(255, 235, 205));
		b2.setBounds(289, 181, 113, 25);
		panel.add(b2);

		b3 = new JButton("Forgot Password");
		b3.addActionListener(this);

		b3.setForeground(new Color(205, 92, 92));
		b3.setBackground(new Color(253, 245, 230));
		b3.setBounds(210, 231, 179, 25);
		panel.add(b3);

		JLabel l5 = new JLabel("Trouble in Login?");
		l5.setFont(new Font("Tahoma", Font.PLAIN, 15));
		l5.setForeground(new Color(255, 0, 0));
		l5.setBounds(70, 235, 150, 20);
		panel.add(l5);

		JPanel panel2 = new JPanel();
		panel2.setBackground(new Color(255, 255, 204));
		panel2.setBounds(24, 40, 434, 263);
		panel.add(panel2);
	}
	@Override
	public void actionPerformed(ActionEvent ae) 
	{
		if (ae.getSource() == b1) {
			Boolean status = false;
			try {
				DBConnection c = new DBConnection();
				String sql = "select * from usertable where username=? and password=?";
				PreparedStatement st = c.con.prepareStatement(sql);

				st.setString(1, textField.getText());
				st.setString(2, passwordField.getText());

				ResultSet rs = st.executeQuery();
				if (rs.next()) {
					this.setVisible(false);
					new HomePage(textField.getText()).setVisible(true);
				} 
				else
				
					JOptionPane.showMessageDialog(null, "Invalid Login or Password!");

			} 
			catch (Exception e2)
			{
				e2.printStackTrace();
			}
		}
		if (ae.getSource() == b2) {
			setVisible(false);
			SignUpPage su = new SignUpPage();
			su.setVisible(true);
		}
		
		  if (ae.getSource() == b3) 
		  { 
			  setVisible(false); 
			  ForgotPassword forgot =new ForgotPassword(); 
			  forgot.setVisible(true);
		  }
		 
	}
	

}
