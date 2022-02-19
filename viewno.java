import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.*;
import javax.swing.*;
public class viewno extends JFrame implements ActionListener 
{


	static Phone p1;
	 
	JTable jt;
	JScrollPane sp;
	JButton b1;
	Phone thirdframe;
	viewno(Phone p1)
	{
        thirdframe=p1;
	
	
		String column[]={"NAME","SURNAME","PHONE NUMBER","EMAIL"};
		String data[][]=new String[100][7];
		
		 b1=new JButton("OK");
		try{  
                Class.forName("com.mysql.cj.jdbc.Driver").newInstance();//this statement loads the driver for the databse
                Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/phonebook","Khushi","*Dilipbhatia02");  
                
                Statement stmt=con.createStatement();  
                ResultSet rs=stmt.executeQuery("select * from Contacts");  
                int i=0;
                while(rs.next()==true) 
                       
                {
					//System.out.println("Hello");
					
					data[i][0]=rs.getString(1);
                    data[i][1]=rs.getString(2);
                    data[i][2]=rs.getString(3);
                    data[i][3]=rs.getString(4);
                    
				
                    
                    i++;
                 }
                jt=new JTable(data,column);
				sp=new JScrollPane(jt);
				//jt.setBackground(Color.black);
				jt.setBounds(80,100,500,600);
				//jt.setForeground(Color.pink);
				b1.setBounds(150, 610, 100, 25);
				b1.setFocusPainted(false);
                b1.setFont(new Font("times new roman", Font.BOLD, 12));
                //b1.setForeground(Color.pink);

                //b1.setBorderPainted(false);
                b1.setContentAreaFilled(false);
                sp.setBounds(20,200,500,300);
				 add(sp,BorderLayout.CENTER);
				 add(b1,BorderLayout.SOUTH);
				 b1.addActionListener(this);
				 this.setSize(600,200);
				 this.setVisible(true);
				 this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                con.close();  
				
                }catch(Exception ex)
                { 
                    System.out.println(ex);
                }	
		
	}
	
	
	public void actionPerformed(ActionEvent e)
				{
					if(e.getActionCommand().equals("OK"))
					{
						this.setVisible(false);
						thirdframe.setVisible(true);
					}
				}
		
	
	
	
     public static void main(String args[])
     {
         viewno v1= new viewno(p1);
     }
            
                
	


}