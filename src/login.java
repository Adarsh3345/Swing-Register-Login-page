import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class login implements ActionListener{
    JFrame jf;
    Container c;

    JLabel l1,l2,l3;

    JTextField t1,t2,t3;


    JButton b1,b2;

    login() {
        jf = new JFrame("STUDENT");
        jf.setSize(1550, 1200);
        jf.setVisible(true);
        jf.setLayout(null);
        c = jf.getContentPane();
        c.setBackground(Color.DARK_GRAY);

        Font f1 = new Font("Serif", Font.PLAIN, 50);
        Font f2 = new Font("Serif", Font.PLAIN, 32);
        Font f3 = new Font("Serif", Font.PLAIN, 27);
        Font f4 = new Font("Serif", Font.PLAIN, 20);
        l1 = new JLabel("Login");
        l1.setBounds(690, 120, 500, 100);
        l1.setFont(f1);
        l1.setForeground(Color.white);
        jf.add(l1);


        l2 = new JLabel("MOBILE NUMBER");
        l2.setBounds(620, 270, 300, 100);
        l2.setFont(f2);
        l2.setForeground(Color.white);
        jf.add(l2);

        t1 = new JTextField();
        t1.setBounds(610, 340, 290, 40);
        t1.setFont(f3);
        jf.add(t1);


        l2 = new JLabel("PASSWORD");
        l2.setBounds(670, 430, 300, 100);
        l2.setFont(f2);
        l2.setForeground(Color.white);
        jf.add(l2);

        t2 = new JTextField();
        t2.setBounds(620, 500, 260, 40);
        t2.setFont(f3);
        jf.add(t2);

        l3 = new JLabel("LOGIN");
        l3.setBounds(700, 570, 300, 100);
        l3.setFont(f2);
        l3.setForeground(Color.white);
        jf.add(l3);

        b1=new JButton("LOGIN");
        b1.setBounds(620, 640, 260, 40);
        b1.setBackground(new Color(0,255,255));
        b1.setForeground(Color.black);
        b1.addActionListener(this);
        b1.setFont(f3);
        jf.add(b1);

        t3 = new JTextField();
        t3.setBounds(540, 690, 440, 40);
        t3.setFont(f3);
        t3.setBackground(Color.DARK_GRAY);
        t3.setForeground(Color.red);
        t3.setVisible(false);
        jf.add(t3);

        b2=new JButton("BACK");
        b2.setBounds(0, 0, 150, 40);
        b2.setBackground(new Color(0,255,255));
        b2.setForeground(Color.black);
        b2.setFont(f3);
        jf.add(b2);
        b2.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                if(e.getSource()==b2)
                {
                    jf.dispose();
                    new Main();
                }
            }
        });

    }
    public static void main(String[] args){
           login login=new login();

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/project1", "root", "root");
            String a1=t1.getText();
            String a2=t2.getText();
            Statement st=cn.createStatement();

            ResultSet rs=st.executeQuery(" select * from student1 where mobileno='"+a1+"' and password='"+a2+"'");

            if(rs.next()){
                if(e.getSource()==b1){
                    jf.dispose();
                    new main2();
                }
            }
            else {
                if(e.getSource()==b1){
                    t3.setVisible(true);
                    t3.setText("Invalid Mobile number and password");
                }
            }

        }
        catch (Exception e1) {
            System.out.println(e1);
        }
    }
}
