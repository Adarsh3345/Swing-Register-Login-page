import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class update implements ActionListener{
    JFrame jf;
    Container c,c2;

    JLabel l1,l2,l3,l4;

    JTextField t1,t2,t3,t4;

    JComboBox c1;

    JButton b1,b2;

    update(){
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
        l1 = new JLabel("UPDATE");
        l1.setBounds(670, 10, 500, 100);
        l1.setFont(f1);
        l1.setForeground(Color.white);
        jf.add(l1);



        l2 = new JLabel("MOBILE NUMBER");
        l2.setBounds(630, 90, 300, 100);
        l2.setFont(f2);
        l2.setForeground(Color.white);
        jf.add(l2);

        t1 = new JTextField();
        t1.setBounds(610, 160, 290, 40);
        t1.setFont(f3);
        jf.add(t1);


        l2 = new JLabel("PASSWORD");
        l2.setBounds(670, 190, 300, 100);
        l2.setFont(f2);
        l2.setForeground(Color.white);
        jf.add(l2);

        t2 = new JTextField();
        t2.setBounds(620, 260, 260, 40);
        t2.setFont(f3);
        jf.add(t2);

        l3 = new JLabel("BRANCH");
        l3.setBounds(280, 270, 300, 100);
        l3.setFont(f2);
        l3.setForeground(Color.white);
        jf.add(l3);

        String[] choose = {"B.TECH-CS", "B.TECH-EC", "B.TECH-ME","B.TECH-CE"};
        c1 = new JComboBox<>(choose);
        c1.setBounds(220, 340, 260, 40);
        c1.setFont(f4);
        jf.add(c1);

        l4 = new JLabel("NAME");
        l4.setBounds(1110, 270, 300, 100);
        l4.setFont(f2);
        l4.setForeground(Color.white);
        jf.add(l4);

        t3 = new JTextField();
        t3.setBounds(1040, 340, 260, 40);
        t3.setFont(f3);
        t3.setVisible(true);
        jf.add(t3);

        b1=new JButton("UPDATE");
        b1.setBounds(610, 510, 300, 40);
        b1.setBackground(new Color(0,255,255));
        b1.setForeground(Color.black);
        b1.addActionListener(this);
        b1.setFont(f3);
        jf.add(b1);


        t4 = new JTextField();
        t4.setBounds(540, 580, 440, 40);
        t4.setFont(f3);
        t4.setBackground(Color.DARK_GRAY);
        t4.setForeground(Color.red);
        t4.setVisible(false);
        jf.add(t4);

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
                    new main2();
                }
            }
        });

    }
    public static void main(String[] args){
       update upd=new update();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/project1", "root", "root");
        String a1=t1.getText();
        String a2=t2.getText();
        String a3= (String) c1.getSelectedItem();
        String a4=t3.getText();
        Statement st=cn.createStatement();

        ResultSet rs=st.executeQuery(" select * from student1 where mobileno='"+a1+"' and password='"+a2+"'");

        if(rs.next()) {
            if (e.getSource() == b1) {
                st.executeUpdate("update student1 set course='"+a3+"',name='"+a4+"' where mobileno='"+a1+"' and password='"+a2+"'");
                t4.setVisible(true);
                t4.setText("UPDATED");
                t4.setForeground(Color.GREEN);
                t4.setBounds(610, 580, 300, 40);
            }
        }
        else {
            if(e.getSource()==b1){
                t4.setVisible(true);
                t4.setText("Invalid Mobile number and password");
            }
        }


    }
        catch (Exception e1) {
        System.out.println(e1);
    }
    }
}
