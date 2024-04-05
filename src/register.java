import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.lang.*;


public class register implements ActionListener {
    JFrame jf;
    Container c;

    JLabel l1,l2,l3,l4,l5;

    static JTextField t1,t2,t3;

    static JComboBox c1;

    static JButton b1,b2;

    register(){
        jf = new JFrame("STUDENT");
        jf.setSize(1550, 1200);
        jf.setVisible(true);
        jf.setLayout(null);
        c= jf.getContentPane();
        c.setBackground(Color.DARK_GRAY);

        Font f1=new Font("Serif", Font.PLAIN,50);
        Font f2=new Font("Serif", Font.PLAIN,32);
        Font f3=new Font("Serif", Font.PLAIN,27);
        Font f4=new Font("Serif", Font.PLAIN,20);
        l1 = new JLabel("Register");
        l1.setBounds(670, 20, 500, 100);
        l1.setFont(f1);
        l1.setForeground(Color.white);
        jf.add(l1);



        l2 = new JLabel("NAME");
        l2.setBounds(700, 120, 100, 100);
        l2.setFont(f2);
        l2.setForeground(Color.white);
        jf.add(l2);

        t1 = new JTextField();
        t1.setBounds(610, 190, 290, 40);
        t1.setFont(f3);
        jf.add(t1);


        l2 = new JLabel("PASSWORD");
        l2.setBounds(670, 250, 300, 100);
        l2.setFont(f2);
        l2.setForeground(Color.white);
        jf.add(l2);

        t2 = new JTextField();
        t2.setBounds(620, 320, 260, 40);
        t2.setFont(f3);
        jf.add(t2);


        l3 = new JLabel("BRANCH");
        l3.setBounds(680, 380, 300, 100);
        l3.setFont(f2);
        l3.setForeground(Color.white);
        jf.add(l3);

        String[] choose = {"B.TECH-CS", "B.TECH-EC", "B.TECH-ME","B.TECH-CE"};
        c1 = new JComboBox<>(choose);
        c1.setBounds(620, 450, 260, 40);
        c1.setFont(f4);
        jf.add(c1);

        l4 = new JLabel("MOBILE NUMBER");
        l4.setBounds(630, 510, 300, 100);
        l4.setFont(f2);
        l4.setForeground(Color.white);
        jf.add(l4);

        t3 = new JTextField();
        t3.setBounds(610, 580, 300, 40);
        t3.setFont(f3);
        jf.add(t3);

        l5 = new JLabel("REGISTER");
        l5.setBounds(680, 640, 300, 100);
        l5.setFont(f2);
        l5.setForeground(Color.white);
        jf.add(l5);

        b1=new JButton("REGISTER");
        b1.setBounds(610, 710, 300, 40);
        b1.setBackground(new Color(0,255,255));
        b1.setForeground(Color.black);
        b1.setFont(f3);
        b1.addActionListener(this);
        jf.add(b1);


        b2=new JButton("BACK");
        b2.setBounds(0, 0, 150, 40);
        b2.setBackground(new Color(0,255,255));
        b2.setForeground(Color.black);
        b2.setFont(f3);
        b2.addActionListener(this);
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
        register reg=new register();
    }

    @Override
    public void actionPerformed(ActionEvent e ){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/project1", "root", "root");
            PreparedStatement ps = cn.prepareStatement("insert into student1 values(?,?,?,?)");

            String a1=t1.getText();
            String a2=t2.getText();
            String a3= (String) c1.getSelectedItem();
            String a4=t3.getText();
            if (e.getSource()==b1) {
                ps.setString(1,a1);
                ps.setString(2,a2);
                ps.setString(3, a3);
                ps.setString(4,a4);
                ps.executeUpdate();
                cn.close();
                jf.dispose();
                new login();
            }


        }
        catch (Exception e1) {
            System.out.println(e1);
        }
    }
}
