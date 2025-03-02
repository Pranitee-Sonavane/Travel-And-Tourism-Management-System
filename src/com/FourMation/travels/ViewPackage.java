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
import javax.swing.JPanel;

public class ViewPackage extends JFrame 
{

	private JPanel contentPane;
    Choice c1;;
	public static void main(String[] args)
	{
		new ViewPackage("").setVisible(true);
	
	}
	public ViewPackage(String username)
	{
		setBounds(580, 220, 850, 450);
		contentPane = new JPanel();
		setContentPane(contentPane);
		contentPane.setLayout(null);
                
       ImageIcon i1  = new ImageIcon(ClassLoader.getSystemResource("icons/bookeddetails.jpg"));
       Image i3 = i1.getImage().getScaledInstance(500, 350,Image.SCALE_DEFAULT);
       ImageIcon i2 = new ImageIcon(i3);
       JLabel la1 = new JLabel(i2);
       la1.setBounds(450,40,350,350);
       add(la1);
		
		JLabel lblName = new JLabel("VIEW PACKAGE DETAILS");
		lblName.setFont(new Font("Yu Mincho", Font.PLAIN, 20));
		lblName.setBounds(88, 11, 350, 53);
		contentPane.add(lblName);
                
        JLabel lb3 = new JLabel("Username :");
		lb3.setBounds(35, 70, 200, 14);
		contentPane.add(lb3);
                
        JLabel l1 = new JLabel();
		l1.setBounds(271, 70, 200, 14);
		contentPane.add(l1);
                
        JLabel lblId = new JLabel("Package :");
		lblId.setBounds(35, 110, 200, 14);
		contentPane.add(lblId);
                
        JLabel l2 = new JLabel();
		l2.setBounds(271, 110, 200, 14);
		contentPane.add(l2);
                
        JLabel lb2 = new JLabel("Number of Persons :");
		lb2.setBounds(35, 150, 200, 14);
		contentPane.add(lb2);
                
        JLabel l3 = new JLabel();
		l3.setBounds(271, 150, 200, 14);
		contentPane.add(l3);
		
		JLabel lblName_1 = new JLabel("ID :");
		lblName_1.setBounds(35, 190, 200, 14);
		contentPane.add(lblName_1);
		
		JLabel l4 = new JLabel();
		l4.setBounds(271, 190, 200, 14);
		contentPane.add(l4);

		JLabel lblReserveRoomNumber = new JLabel("Price :");
		lblReserveRoomNumber.setBounds(35, 230, 200, 14);
		contentPane.add(lblReserveRoomNumber);
                
         JLabel l7 = new JLabel();
		l7.setBounds(271, 230, 200, 14);
		contentPane.add(l7);
		DBConnection c = new DBConnection();
        try{

            ResultSet rs = c.st.executeQuery("select * from bookpackage where username = '"+username+"'");
            while(rs.next()){
                l1.setText(rs.getString(1));
                l2.setText(rs.getString(2));
                l3.setText(rs.getString(3));
                l4.setText(rs.getString(4));
                l7.setText(rs.getString(5));
                
            }

            rs.close();
        }catch(SQLException e){}
		
		
		
		JButton btnExit = new JButton("Back");
		btnExit.addActionListener(new ActionListener() {
	    public void actionPerformed(ActionEvent e) {
        setVisible(false);
			}
		}); 
		btnExit.setBounds(160, 350, 120, 30);
        btnExit.setBackground(Color.BLACK);
        btnExit.setForeground(Color.WHITE);
		contentPane.add(btnExit);
                
        getContentPane().setBackground(Color.WHITE);
	}

}
