import javax.swing.*;

import com.mysql.cj.protocol.Resultset;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;

class Editno extends JFrame implements ActionListener
{
    static Phone p1;
    JButton jsave,jcancel;
    JLabel jname,jsurname,jAdd_Number,jAdd_Email,lb;
	JTextField temail,tname,tnumber,tsurname,tcidd;
	
	Phone first;


    Editno(Phone p1)
    {
		first=p1;
        setLayout(null);
		jsave= new JButton("SAVE");
		jsave.setBounds(80,500,120,40);
        jsave.setRolloverEnabled(true);
        jsave.setFocusPainted(false);
        jsave.setFont(new Font("times new roman", Font.BOLD, 16));
        jsave.setForeground(Color.pink);
        //jsave.setBorder(new RoundedBorder(10));

        //jsave.setBorderPainted(false);
        jsave.setContentAreaFilled(false);

		jcancel= new JButton("CANCEL");
		jcancel.setBounds(300,500,120,40);
        jcancel.setRolloverEnabled(true);
        jcancel.setFocusPainted(false);
        jcancel.setFont(new Font("times new roman", Font.BOLD, 16));
        jcancel.setForeground(Color.pink);
        //jcancel.setBorder(new RoundedBorder(10));

        //jcancel.setBorderPainted(false);
        jcancel.setContentAreaFilled(false);


		jname= new JLabel("Name");
		tname=new JTextField("");
		tname.setBounds(220,100,110,40);
		jname.setBounds(80,100,80,40);
	    jname.setForeground(Color.pink);
		jname.setFont(new Font("Serif", Font.PLAIN, 18));

		
		jsurname= new JLabel("Surname");
		tsurname=new JTextField("");
		tsurname.setBounds(220,180,110,40);
		jsurname.setBounds(80,180,80,40);
	    jsurname.setForeground(Color.pink);
		jsurname.setFont(new Font("Serif", Font.PLAIN, 18));

		
		jAdd_Number= new JLabel("Phone Number");
		jAdd_Number.setBounds(80,260,100,80);
        jAdd_Number.setForeground(Color.pink);
		jAdd_Number.setFont(new Font("Serif", Font.PLAIN, 16));

		
		tnumber=new JTextField("");
		tnumber.setBounds(220,280,120,40);
		
		jAdd_Email= new JLabel("Email");
		jAdd_Email.setBounds(80,380,80,40);
		jAdd_Email.setForeground(Color.pink);
		jAdd_Email.setFont(new Font("Serif", Font.PLAIN, 18));
		
		temail=new JTextField("");
		temail.setBounds(220,380,150,40);

		tcidd=new JTextField();
		tcidd.setBounds(220,480,150,40);
		
		//lb= new JLabel(new ImageIcon("D:\\Thadomal Shahani Eng Clg\\MPR\\BgPhonebook.jpeg"));
		//lb.setBounds(0,0,500,600);
		
		//add(lb);
		add(jname);
		add(jsurname);
		add(jAdd_Number);
		add(jAdd_Email);
		add(tname);
		add(tsurname);
		add(tnumber);
		add(temail);
		add(jsave);
		add(jcancel);
		
		jsave.addActionListener(this);
		jcancel.addActionListener(this);

	    setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(500,600);
		this.setLocation(300,100);
		//this.setVisible(true);
		this.getContentPane().setBackground(Color.black);
		
		this.setTitle("Edit Contact");
		//this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
    }

    @Override
     public void actionPerformed(ActionEvent ae)
	{
		 Object jedit;
		if(ae.getSource()==jsave)
		 {
			 try 
			 {
				 Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
				 Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/phonebook","Khushi", "*Dilipbhatia02");
				 String query = "UPDATE Contacts SET SURNAME= ? , PHONE_NUMBER= ? , EMAIL =?  WHERE NAME= ? ;";

				 PreparedStatement st= con.prepareStatement(query);
				
				 st.setString (4, tname.getText());
				 st.setString (1, tsurname.getText());
				 st.setString (2, tnumber.getText());
				 st.setString (3, temail.getText());
				
				 st.execute();
				 con.close();
				 JOptionPane.showMessageDialog(jsave,"Contact has been UPDATED");
				 }
				 catch (Exception e)
				 {
					JOptionPane.showMessageDialog(jsave,"Contact cannot be Edited","ERROR",JOptionPane.ERROR_MESSAGE);
					 System.out.println(e);
				 }
			 }
		 

             if(ae.getSource()==jcancel)
             {
				int dialogResult = JOptionPane.showConfirmDialog(jcancel, "Are you sure you want to CANCEL", "", JOptionPane.YES_NO_OPTION);
				if(dialogResult == JOptionPane.YES_OPTION)
				{
					this.setVisible(false);
					first.setVisible(true);
				}
                
             }
	}

	public static void main(String args[])
	{
		Editno f1= new Editno(p1);
	}



}
