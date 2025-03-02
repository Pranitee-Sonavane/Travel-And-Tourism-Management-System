package com.FourMation.travels;

import java.awt.Choice;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class AddCustomer extends JFrame implements ActionListener
{
	private JPanel contentPane;
	private JTextField t1,t2,t3,t4,t5,t6,t7,t8;
        JComboBox comboBox;
        JRadioButton r1,r2;
        Choice c1;
	public static void main(String[] args) 
	{
		new AddCustomer("").setVisible(true);
	}
	public AddCustomer(String username)
	{
		setBounds(580, 220, 850, 550);
		contentPane = new JPanel();
		setContentPane(contentPane);
		contentPane.setLayout(null);
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/addcustomer2.jpg"));
		Image i3 = i1.getImage().getScaledInstance(450, 500, Image.SCALE_DEFAULT);
		ImageIcon i2 = new ImageIcon(i3);
		JLabel l1 = new JLabel(i2);
		l1.setBounds(450, 10, 450, 500);
		add(l1);

		JLabel lblName = new JLabel("NEW CUSTOMER FORM");
		lblName.setFont(new Font("Javanese Text", Font.BOLD, 20));
		lblName.setBounds(118, 11, 260, 53);
		contentPane.add(lblName);

		JLabel l3 = new JLabel("Username :");
		l3.setBounds(35, 70, 200, 14);
		contentPane.add(l3);

		t7 = new JTextField();
		t7.setBounds(230, 70, 180, 20);
		contentPane.add(t7);
		t7.setColumns(10);

		JLabel lblId = new JLabel("ID :");
		lblId.setBounds(35, 110, 200, 14);
		contentPane.add(lblId);

		comboBox = new JComboBox(new String[] { "Passport", "Aadhar Card", "Voter Id", "Driving license" });
		comboBox.setBounds(230 ,110, 180, 20);
		contentPane.add(comboBox);

		JLabel l2 = new JLabel("Number :");
		l2.setBounds(35, 150, 200, 14);
		contentPane.add(l2);

		t1 = new JTextField();
		t1.setBounds(230, 150, 180, 20);
		contentPane.add(t1);
		t1.setColumns(10);

		JLabel lblName_1 = new JLabel("Name :");
		lblName_1.setBounds(35, 190, 200, 14);
		contentPane.add(lblName_1);

		t2 = new JTextField();
		t2.setBounds(230, 190, 180, 20);
		contentPane.add(t2);
		t2.setColumns(10);

		JLabel lblGender = new JLabel("Gender :");
		lblGender.setBounds(35, 230, 200, 14);
		contentPane.add(lblGender);

		r1 = new JRadioButton("Male");
		r1.setFont(new Font("Raleway", Font.BOLD, 14));
		r1.setBackground(Color.WHITE);
		r1.setBounds(230, 230, 80, 12);
		add(r1);

		r2 = new JRadioButton("Female");
		r2.setFont(new Font("Raleway", Font.BOLD, 14));
		r2.setBackground(Color.WHITE);
		r2.setBounds(310, 230, 100, 12);
		add(r2);

		JLabel lblCountry = new JLabel("Country :");
		lblCountry.setBounds(35, 270, 200, 14);
		contentPane.add(lblCountry);

		t3 = new JTextField();
		t3.setBounds(230, 270, 180, 20);
		contentPane.add(t3);
		t3.setColumns(10);

		JLabel lblReserveRoomNumber = new JLabel("Permanent Address :");
		lblReserveRoomNumber.setBounds(35, 310, 200, 14);
		contentPane.add(lblReserveRoomNumber);

		t5 = new JTextField();
		t5.setBounds(230, 310, 180, 20);
		contentPane.add(t5);
		t5.setColumns(10);

		JLabel lblCheckInStatus = new JLabel("Phone :");
		lblCheckInStatus.setBounds(35, 350, 200, 14);
		contentPane.add(lblCheckInStatus);

		t6 = new JTextField();
		t6.setBounds(230, 350, 180, 20);
		contentPane.add(t6);
		t6.setColumns(10);

		JLabel lblDeposite = new JLabel("Email :");
		lblDeposite.setBounds(35, 390, 200, 14);
		contentPane.add(lblDeposite);

		t8 = new JTextField();
		t8.setBounds(230, 390, 180, 20);
		contentPane.add(t8);
		t8.setColumns(10);
		
		try {
			DBConnection c = new DBConnection();
			ResultSet rs = c.st.executeQuery("select * from usertable where username = '" + username + "'");
			while (rs.next()) {
				t7.setText(rs.getString("username"));
				t2.setText(rs.getString("username"));
			}
		} catch (Exception e) {
		}
		
		JButton btnNewButton = new JButton("Add");
		
		
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DBConnection c = new DBConnection();
				String radio = null;

				if (r1.isSelected()) {
					radio = "Male";
				} else if (r2.isSelected()) {
					radio = "Female";
				}

				try {
					String s9 = t7.getText(); // username
					String s1 = (String) comboBox.getSelectedItem();
					String s2 = t1.getText();
					String s3 = t2.getText();
					String s4 = radio;
					String s5 = t3.getText();
					String s7 = t5.getText(); // address
					String s8 = t6.getText();
					String s10 = t8.getText(); // email

					String q1 = "insert into customer values('" + s9 + "','" + s1 + "','" + s2 + "','" + s3 + "','" + s4
							+ "','" + s5 + "','" + s7 + "','" + s8 + "','" + s10 + "')";
					c.st.executeUpdate(q1);

					JOptionPane.showMessageDialog(null, "Customer Added Successfully");
					setVisible(false);
				} catch (SQLException e1) {
					System.out.println(e1.getMessage());
				} catch (NumberFormatException s) {
					JOptionPane.showMessageDialog(null, "Please enter a valid Number");
				}
			}
		});
		
		btnNewButton.setBounds(100, 430, 120, 30);
		btnNewButton.setBackground(Color.GREEN);
		btnNewButton.setForeground(Color.BLACK);
		contentPane.add(btnNewButton);
		JButton btnExit = new JButton("Back");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		btnExit.setBounds(260, 430, 120, 30);
		btnExit.setBackground(Color.GREEN);
		btnExit.setForeground(Color.BLACK);
		contentPane.add(btnExit);

		getContentPane().setBackground(Color.WHITE);
	}
	
}
