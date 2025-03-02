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
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class BookPackage extends JFrame
{

	private JPanel contentPane;
	JTextField t1, t2;
	Choice c1, c2, c3;   //Class Level Variables
	JLabel l1,l2,l3,l4,l5;
	public static void main(String[] args) 
	{
		new BookPackage("").setVisible(true);
	}
	public BookPackage(final String username)
	{
		setBounds(420, 220, 1100, 450);
		contentPane = new JPanel();
		setContentPane(contentPane);
		contentPane.setLayout(null);

		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/bookpackage.jpg"));
		Image i3 = i1.getImage().getScaledInstance(500, 300, Image.SCALE_DEFAULT);
		ImageIcon i2 = new ImageIcon(i3);
		JLabel la1 = new JLabel(i2);
		la1.setBounds(450, 50, 700, 300);
		add(la1);

		JLabel lblName = new JLabel("BOOK PACKAGE");
		lblName.setFont(new Font("Yu Mincho", Font.PLAIN, 20));
		lblName.setBounds(118, 11, 300, 53);
		contentPane.add(lblName);

		
		  JLabel la2 = new JLabel("Username :"); la2.setBounds(35, 70, 200, 14);
		  contentPane.add(la2);
		  
		  l1 = new JLabel(username);
		  l1.setBounds(271, 70, 200, 14);
		  contentPane.add(l1);
		 
		JLabel lblId = new JLabel("Select Package :");
		lblId.setBounds(35, 110, 200, 14);
		contentPane.add(lblId);

		c1 = new Choice();
		c1.add("Gold Package");
		c1.add("Silver Package");
		c1.add("Bronze Package");
		c1.setBounds(271, 110, 150, 30);
		add(c1);

		JLabel la3 = new JLabel("Total Persons");
		la3.setBounds(35, 150, 200, 14);
		contentPane.add(la3);

		t1 = new JTextField();
		t1.setText("0");
		t1.setBounds(271, 150, 150, 20);
		contentPane.add(t1);
		t1.setColumns(10);

		JLabel lbl1 = new JLabel("ID :");
		lbl1.setBounds(35, 190, 200, 14);
		contentPane.add(lbl1);

	    l2 = new JLabel();
		l2.setBounds(271, 190, 200, 14);
		contentPane.add(l2);

		
		JLabel lblDeposite = new JLabel("Total Price :");
		lblDeposite.setBounds(35, 230, 200, 14);
		contentPane.add(lblDeposite);

		l5 = new JLabel();
		l5.setBounds(271, 230, 200, 14);
		l5.setForeground(Color.RED);
		contentPane.add(l5);
		
		try {
			DBConnection c = new DBConnection();
			ResultSet rs = c.st.executeQuery("select * from customer where username = '" + username + "'");
			while (rs.next()) {
				l2.setText(rs.getString("id_type"));
			
			}

			rs.close();
		} catch (SQLException e) {
		}
		
		JButton b1 = new JButton("Check Price");
		b1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String p = c1.getSelectedItem();
				int cost = 0;
				if (p.equals("Gold Package")) {
					cost += 12000;
				}
				if (p.equals("Silver Package")) {
					cost += 25000;
				} else if (p.equals("Bronze Package")) {
					cost += 32000;
				}

				cost *= Integer.parseInt(t1.getText());
				l5.setText("Rs " + cost);

			}
		});
		
		b1.setBounds(50, 310, 120, 30);
		b1.setBackground(Color.BLACK);
		b1.setForeground(Color.WHITE);
		contentPane.add(b1);
		JButton btnNewButton = new JButton("Book");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DBConnection c = new DBConnection();

				try {
					String s1 = c1.getSelectedItem();

					String q1 = "insert into bookpackage values('" + username + "', '" + c1.getSelectedItem() + "', '"
							+ t1.getText() + "', '" + l2.getText() + "', '" + l5.getText() + "')";
					c.st.executeUpdate(q1);

					JOptionPane.showMessageDialog(null, "Package Booked Successfully");
					setVisible(false);
				} catch (Exception ee) {
					System.out.println(ee.getMessage());
				}

			}
		});
		btnNewButton.setBounds(200, 310, 120, 30);
		btnNewButton.setBackground(Color.BLACK);
		btnNewButton.setForeground(Color.WHITE);
		contentPane.add(btnNewButton);

		JButton btnExit = new JButton("Back");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		btnExit.setBounds(350, 310, 120, 30);
		btnExit.setBackground(Color.BLACK);
		btnExit.setForeground(Color.WHITE);
		contentPane.add(btnExit);

		getContentPane().setBackground(Color.WHITE);
	}

}
