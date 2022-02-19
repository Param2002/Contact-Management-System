import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
class Phone extends JFrame implements ActionListener
{
    JButton jedit,jview,jnew,jdel;
    JLabel jphone,lb;
    

    Phone()
    {
        //lb= new JLabel(new ImageIcon("D:\\Thadomal Shahani Eng Clg\\MPR\\phonebg.jpeg"));
        //lb.setBounds(0,0,700,800);

        jphone=new JLabel("THE PHONE BOOK");
        jphone.setBounds(180,25,400,300);
        jphone.setForeground(Color.pink);
        
        jphone.setFont(new Font("Times New Roman", Font.ITALIC, 40));


        jedit= new JButton("EDIT");
        jedit.setBounds(160,390,100,40);
        //jedit.setBackground(Color.white);
        jedit.setRolloverEnabled(true);
        jedit.setFocusPainted(false);
        jedit.setFont(new Font("times new roman", Font.BOLD, 14));
        jedit.setForeground(Color.pink);
        //jedit.setBorder(new RoundedBorder(10));

        //jedit.setBorderPainted(false);
        jedit.setContentAreaFilled(false);

        jnew= new JButton("NEW");
        jnew.setBounds(300,450, 100, 40);
        jnew.setRolloverEnabled(true);
        jnew.setFocusPainted(false);
        jnew.setFont(new Font("times new roman", Font.BOLD,14));
        jnew.setForeground(Color.pink);
        //jedit.setBorder(new RoundedBorder(10));

        //jedit.setBorderPainted(false);
        jnew.setContentAreaFilled(false);

        jview=new JButton("VIEW");
        jview.setBounds(440, 390, 100, 40);
        jview.setRolloverEnabled(true);
        jview.setFocusPainted(false);
        jview.setFont(new Font("times new roman", Font.BOLD,14));
        jview.setForeground(Color.pink);
        //jedit.setBorder(new RoundedBorder(10));

        //jedit.setBorderPainted(false);
        jview.setContentAreaFilled(false);

        jdel=new JButton("DELETE");
        jdel.setBounds(300, 340, 100, 40);
        jdel.setRolloverEnabled(true);
        jdel.setFocusPainted(false);
        jdel.setFont(new Font("times new roman", Font.BOLD,14));
        jdel.setForeground(Color.pink);
        //jedit.setBorder(new RoundedBorder(10));

        //jedit.setBorderPainted(false);
        jdel.setContentAreaFilled(false);


        setLayout(null);

        
        add(jphone);
        add(jedit);
        add(jnew);
        add(jview);
        add(jdel);

        jedit.addActionListener(this);
        jnew.addActionListener(this);
        jview.addActionListener(this);
        jdel.addActionListener(this);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       // setVisible(true);
    }

    public void actionPerformed(ActionEvent e)
    {
        if (e.getActionCommand().equals("EDIT"))
        {
            this.setVisible(false);
            Editno f1=new Editno(this);
        }
         if(e.getActionCommand().equals("NEW"))
        {
            this.setVisible(false);
            ContactManagement t1 = new ContactManagement(this);
        }

        if(e.getActionCommand().equals("VIEW"))
        { 
            this.setVisible(false);
            viewno v1=new viewno(this);
        }
        if(e.getActionCommand().equals("DELETE"))
        {
            this.setVisible(false);
            delno d1 = new delno(this);
        }

    
    }
    public static void main(String[] args)
    {
        Phone p1 =new Phone();
        {
            p1.setSize(700,700);
           // p1.setLocation(300,100);
            p1.setVisible(true);
            p1.setLayout(null);
            p1.getContentPane().setBackground(Color.black);
            
            p1.setTitle("The PhoneBook - First Page");
            p1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        }
        
    }
}

   










