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
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JButton;

public class DeleteCustomer1 extends JFrame implements ActionListener
{
		private JPanel contentPane;
		Choice c1;

	public static void main(String[] args) 
	{
		new DeleteCustomer1("").setVisible(true);
	}
	public DeleteCustomer1(String username)
	{
		
		setForeground(Color.RED);
		setLayout(null);
		setBounds(550, 250, 700, 400);

		
		setBounds(580, 220, 850, 550);
		contentPane = new JPanel();
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/DeleteCustomer.jpg"));
		Image i3 = i1.getImage().getScaledInstance(300, 300, Image.SCALE_DEFAULT);
		ImageIcon i2 = new ImageIcon(i3);
		JLabel l1 = new JLabel(i2);
		l1.setBounds(500, 100, 300, 300);
		add(l1);

		JLabel lblName = new JLabel("DELETE CUSTOMER DETAILS");
		lblName.setFont(new Font("Lucida Fax", Font.BOLD, 20));
		lblName.setBounds(118, 11, 330, 53);
		contentPane.add(lblName);                  //PLAIN

		JLabel lb3 = new JLabel("Username :");
		lb3.setBounds(35, 70, 200, 14);
		contentPane.add(lb3);

		c1 =new Choice();
		DBConnection c = new DBConnection();
		try 
		{
			ResultSet rs = c.st.executeQuery("select * from customer");
			while (rs.next()) 
			{
				c1.add(rs.getString("username"));
			}
			rs.close();
		} 
		catch (SQLException e)
		{
			
		}
		c1.setBounds(271, 70, 150, 30);
		add(c1);
		
		JLabel lblId = new JLabel("ID :");
		lblId.setBounds(35, 110, 200, 14);
		contentPane.add(lblId);

		JLabel l2 = new JLabel();
		l2.setBounds(271, 110, 200, 14);
		contentPane.add(l2);

		JLabel lb2 = new JLabel("Number :");
		lb2.setBounds(35, 150, 200, 14);
		contentPane.add(lb2);

		JLabel l3 = new JLabel();
		l3.setBounds(271, 150, 200, 14);
		contentPane.add(l3);

		JLabel lblName_1 = new JLabel("Name :");
		lblName_1.setBounds(35, 190, 200, 14);
		contentPane.add(lblName_1);

		JLabel l4 = new JLabel();
		l4.setBounds(271, 190, 200, 14);
		contentPane.add(l4);

		JLabel lblGender = new JLabel("Gender :");
		lblGender.setBounds(35, 230, 200, 14);
		contentPane.add(lblGender);

		JLabel l5 = new JLabel();
		l5.setBounds(271, 230, 200, 14);
		contentPane.add(l5);

		JLabel lblCountry = new JLabel("Country :");
		lblCountry.setBounds(35, 270, 200, 14);
		contentPane.add(lblCountry);

		JLabel l6 = new JLabel();
		l6.setBounds(271, 270, 200, 14);
		contentPane.add(l6);
		
		JLabel lblReserveRoomNumber = new JLabel("Permanent Address :");
		lblReserveRoomNumber.setBounds(35, 310, 200, 14);
		contentPane.add(lblReserveRoomNumber);
		JLabel l7 = new JLabel();
		l7.setBounds(271, 310, 200, 14);
		contentPane.add(l7);

		JLabel lblCheckInStatus = new JLabel("Phone :");
		lblCheckInStatus.setBounds(35, 350, 200, 14);
		contentPane.add(lblCheckInStatus);

		JLabel l8 = new JLabel();
		l8.setBounds(271, 350, 200, 14);
		contentPane.add(l8);

		JLabel lblDeposite = new JLabel("Email :");
		lblDeposite.setBounds(35, 390, 200, 14);
		contentPane.add(lblDeposite);

		JLabel l9 = new JLabel();
		l9.setBounds(271, 390, 200, 14);
		contentPane.add(l9);
		
		JButton b1 = new JButton("Check");
		b1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DBConnection c = new DBConnection();

				try {
					ResultSet rs = c.st.executeQuery("select * from customer where username = '" + c1.getSelectedItem() + "'");
					if (rs.next()) {
						l2.setText(rs.getString(2));
						l3.setText(rs.getString(3));
						l4.setText(rs.getString(4));
						l5.setText(rs.getString(5));
						l6.setText(rs.getString(6));
						l7.setText(rs.getString(7));
						l8.setText(rs.getString(8));
						l9.setText(rs.getString(9));
					}
				} catch (Exception ee) {
				}
			}
		});
		b1.setBounds(425, 70, 80, 22);
		b1.setBackground(Color.red);
		b1.setForeground(Color.white);
		contentPane.add(b1);
		
		JButton btnNewButton = new JButton("DELETE");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DBConnection c = new DBConnection();

				try {
					String s1 = c1.getSelectedItem();

					String q1 = "delete from customer where username = '" + s1 + "'";
					c.st.executeUpdate(q1);

					JOptionPane.showMessageDialog(null, "Customer Detail Deleted Successfully");
					setVisible(false);
				} catch (SQLException e1) {
					System.out.println(e1.getMessage());
				} catch (NumberFormatException s) {
					JOptionPane.showMessageDialog(null, "Please enter a valid Number");
				}
			}
		});
		btnNewButton.setBounds(100, 430, 120, 30);
		btnNewButton.setBackground(Color.pink);
		btnNewButton.setForeground(Color.black);
		contentPane.add(btnNewButton);
		
		JButton btnExit = new JButton("BACK");
		btnExit.addActionListener(this);
		btnExit.setBounds(260, 430, 120, 30);
		btnExit.setBackground(Color.pink);
		btnExit.setForeground(Color.black);
		contentPane.add(btnExit);

		getContentPane().setBackground(Color.WHITE);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		dispose();
	}
	
	}

