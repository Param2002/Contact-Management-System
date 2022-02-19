import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.awt.event.*;

class delno extends JFrame implements ActionListener
{
    static Phone p1;
    JButton jdel, jcancel;
    JLabel jname;
	JTextField tname;
	Phone second;

    delno(Phone p1)
    {
        second = p1;

        setLayout(null);
		jdel= new JButton("DELETE");
		jdel.setBounds(100,300,100,40);
		jdel.setFocusPainted(false);
        jdel.setFont(new Font("times new roman", Font.BOLD, 12));
        jdel.setForeground(Color.pink);
        //jdel.setBorder(new RoundedBorder(10));

        //jdel.setBorderPainted(false);
        jdel.setContentAreaFilled(false);


        jcancel= new JButton("CANCEL");
		jcancel.setBounds(280,300,100,40);
		jcancel.setFocusPainted(false);
        jcancel.setFont(new Font("times new roman", Font.BOLD, 12));
        jcancel.setForeground(Color.pink);
        //jcancel.setBorder(new RoundedBorder(10));

        //jcancel.setBorderPainted(false);
        jcancel.setContentAreaFilled(false);


        jname= new JLabel("Name");
		tname=new JTextField("");
		tname.setBounds(220,200,110,40);
		jname.setBounds(120,200,100,40);
	    jname.setForeground(Color.pink);
		jname.setFont(new Font("Serif", Font.BOLD, 24));

        add(jname);
		add(tname);
		add(jdel);
		add(jcancel);

        jdel.addActionListener(this);
		jcancel.addActionListener(this);

        setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(500,600);
		this.setLocation(300,100);
		//this.setVisible(true);
		this.getContentPane().setBackground(Color.black);
		
		this.setTitle("Delete Contacts");

    }
    public void actionPerformed(ActionEvent ae)
	{
		 if(ae.getSource()==jdel)
		 {
            int dialogResult = JOptionPane.showConfirmDialog(jcancel, "Are you sure you want to Delete?", "", JOptionPane.YES_NO_OPTION);
            if(dialogResult == JOptionPane.YES_OPTION)
            {
			 try 
			 {
				 Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
				 Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/phonebook","Khushi", "*Dilipbhatia02");
				 
				 String query="Delete From Contacts where NAME=?;";
				 PreparedStatement st= con.prepareStatement(query);
				 st.setString (1, tname.getText());
				 st.execute();
				 con.close();
			 }
            
			 catch (Exception e)
			 {
				JOptionPane.showMessageDialog(jdel,"Contact cannot be DELETED","ERROR",JOptionPane.ERROR_MESSAGE);
				System.out.println(e);
			 }
            }
            else if (dialogResult == JOptionPane.NO_OPTION)
            {
                tname.setText("");
            }
		 }
		 else if(ae.getSource()==jcancel)
		 {
             //tname.setText("");
             int dialogResult = JOptionPane.showConfirmDialog(jcancel, "Are you sure you want to go BACK?", "", JOptionPane.YES_NO_OPTION);
            if(dialogResult == JOptionPane.YES_OPTION)
            {
                this.setVisible(false);
			    second.setVisible(true);
            }
           /* else if (dialogResult == JOptionPane.NO_OPTION)
            {

            }
            */

		 }
     }

     public static void main(String args[])
	{
		delno d1= new delno(p1);
	}



}