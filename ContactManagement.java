import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
class ContactManagement extends JFrame implements ActionListener
{
	static Phone p1;
	
	JButton jsave,jreset,jback;
	JLabel jname,jsurname,jAdd_Number,jAdd_Email,lb;
	JTextField temail,tname,tnumber,tsurname;
	Phone firstframe;
	ContactManagement(Phone p1)
	{
		firstframe=p1;
		setLayout(null);
		jsave= new JButton("SAVE");
		jsave.setBounds(80,500,80,40);
		jsave.setFocusPainted(false);
        jsave.setFont(new Font("times new roman", Font.BOLD, 12));
        jsave.setForeground(Color.pink);
        //jsave.setBorder(new RoundedBorder(10));

        //jsave.setBorderPainted(false);
        jsave.setContentAreaFilled(false);

		jreset= new JButton("RESET");
		jreset.setBounds(200,500,80,40);
		jreset.setFocusPainted(false);
        jreset.setFont(new Font("times new roman", Font.BOLD, 12));
        jreset.setForeground(Color.pink);
        //jreset.setBorder(new RoundedBorder(10));

        //jreset.setBorderPainted(false);
        jreset.setContentAreaFilled(false);

		jback= new JButton("BACK");
		jback.setBounds(320,500,80,40);
		jback.setFocusPainted(false);
        jback.setFont(new Font("times new roman", Font.BOLD, 12));
        jback.setForeground(Color.pink);
        //jback.setBorder(new RoundedBorder(10));

        //jback.setBorderPainted(false);
        jback.setContentAreaFilled(false);

		jname= new JLabel("Name");
		tname=new JTextField("Enter Name");
		tname.setBounds(220,100,110,40);
		jname.setBounds(80,100,80,40);
	    jname.setForeground(Color.pink);
		jname.setFont(new Font("Serif", Font.PLAIN, 18));

		
		jsurname= new JLabel("Surname");
		tsurname=new JTextField("Enter Surname");
		tsurname.setBounds(220,180,110,40);
		jsurname.setBounds(80,180,80,40);
	    jsurname.setForeground(Color.pink);
		jsurname.setFont(new Font("Serif", Font.PLAIN, 18));

		
		jAdd_Number= new JLabel("Phone Number");
		jAdd_Number.setBounds(80,260,100,80);
        jAdd_Number.setForeground(Color.pink);
		jAdd_Number.setFont(new Font("Serif", Font.PLAIN, 16));

		
		tnumber=new JTextField("Enter Phone Number");
		tnumber.setBounds(220,280,120,40);
		
		jAdd_Email= new JLabel("Email");
		jAdd_Email.setBounds(80,380,80,40);
		jAdd_Email.setForeground(Color.pink);
		jAdd_Email.setFont(new Font("Serif", Font.PLAIN, 18));
		
		temail=new JTextField("Enter Email");
		temail.setBounds(220,380,150,40);
		
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
		add(jreset);
		add(jback);
		jsave.addActionListener(this);
		jreset.addActionListener(this);
		jback.addActionListener(this);
	    setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(500,600);
		this.setLocation(300,100);
		//this.setVisible(true);
		this.getContentPane().setBackground(Color.black);
		
		this.setTitle("Add Contacts");
		//this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
	@Override
     public void actionPerformed(ActionEvent ae)
	{
		 if(ae.getSource()==jsave)
		 {
			 try 
			 {
				 Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
				 Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/phonebook","Khushi", "*Dilipbhatia02");
				 
				 String query="insert into contacts (`NAME`,`SURNAME`,`PHONE_NUMBER`,`EMAIL`) values (?,?,?,?)";
				 PreparedStatement st= con.prepareStatement(query);
				 st.setString (1, tname.getText());
				 st.setString (2, tsurname.getText());
				 st.setString (3, tnumber.getText());
				 st.setString (4, temail.getText());
				 st.execute();
				 con.close();
				 JOptionPane.showMessageDialog(jsave,"Contact has been ADDED");
				 
			 }
			 catch (Exception e)
			 {
				JOptionPane.showMessageDialog(jsave,"Same Names cannot be used","ERROR",JOptionPane.ERROR_MESSAGE);
				 System.out.println(e);
				 
			 }
		 }
		 else if(ae.getSource()==jreset)
		 {
			int dialogResult = JOptionPane.showConfirmDialog(jreset, "Are you sure you want to Reset", "", JOptionPane.YES_NO_OPTION);
			if(dialogResult == JOptionPane.YES_OPTION)
			{
				tname.setText("");
			    tsurname.setText("");
			    temail.setText("");
			    tnumber.setText("");

			}
			 
		 }

		 else if(ae.getSource()==jback)
		 {
			int dialogResult = JOptionPane.showConfirmDialog(jback, "Are you sure you want to go BACK?", "", JOptionPane.YES_NO_OPTION);
			if(dialogResult == JOptionPane.YES_OPTION)
			{
				this.setVisible(false);
			    firstframe.setVisible(true);
			}
			 
		 }
	}
 
	public static void main(String args[])
	{
		ContactManagement t1= new ContactManagement(p1);
	}
}