import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class main2 implements ActionListener {
    JFrame jf1;
    JLabel l1,l2,l3;
    JButton b1,b2;
    Container c;
    main2() {
        jf1 = new JFrame("STUDENT");
        jf1.setSize(1550, 1200);
        jf1.setVisible(true);
        jf1.setLayout(null);
        c= jf1.getContentPane();
        c.setBackground(Color.DARK_GRAY);

        Font f1=new Font("Serif", Font.PLAIN,50);
        Font f2=new Font("Serif", Font.PLAIN,32);
        Font f3=new Font("Serif", Font.PLAIN,27);
        l1 = new JLabel("Welcome,");
        l1.setBounds(700, 30, 500, 200);
        l1.setFont(f1);
        l1.setForeground(Color.white);
        jf1.add(l1);

        l2= new JLabel("UPDATE");
        l2.setBounds(380, 260, 500, 200);
        l2.setFont(f2);
        l2.setForeground(Color.white);
        jf1.add(l2);

        l3= new JLabel("DELETE");
        l3.setBounds(1080, 260, 500, 200);
        l3.setFont(f2);
        l3.setForeground(Color.white);
        jf1.add(l3);

        b1=new JButton("UPDATE");
        b1.setBounds(350, 400, 200, 50);
        b1.setBackground(new Color(0,255,255));
        b1.setForeground(Color.black);
        b1.setFont(f3);
        b1.addActionListener(this);
        jf1.add(b1);

        b2=new JButton("DELETE");
        b2.setBounds(1030, 400, 200, 50);
        b2.setBackground(new Color(0,255,255));
        b2.setForeground(Color.black);
        b2.setFont(f3);
        b2.addActionListener(this);
        jf1.add(b2);


    }
    public static void main(String[] args){
        main2 m2=new main2();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==b1){
            jf1.dispose();
            new update();
        }
        if(e.getSource()==b2){
            jf1.dispose();
            new delete();
        }
    }
}
