import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class View_Employee_Data extends JFrame implements ActionListener {
        JLabel l0,l1,l2,l3,l4,l5,l6,l7,l8;
        JLabel d1,d2,d3,d4,d5,d6,d7,d8;
        JButton btn1,btn2;
        JLabel image;
        Font f,f1,f2,f3;







    View_Employee_Data(String eid) {
        setTitle("Employee Details");
        setBounds(145, 0, 850, 1000);
        f = new Font("Segoe Print", Font.BOLD, 30);
        f1 = new Font("Segoe Print", Font.BOLD, 22);
        f2 = new Font("Comic Sans MS", Font.ITALIC,22);
        f3 = new Font("Comic Sans MS", Font.BOLD,18);

        image = new JLabel();
        ImageIcon i = new ImageIcon(this.getClass().getResource("image/bg.jpg"));
        Image i1 = i.getImage().getScaledInstance(1000, 800, Image.SCALE_DEFAULT);
        ImageIcon i2 = new ImageIcon(i1);
        image.setIcon(i2);
        add(image);

        l0 = new JLabel("Employee Details");
        l0.setFont(f);
        l0.setForeground(Color.WHITE);
        l0.setBounds(283, 25, 300, 60);
        image.add(l0);

        l1 = new JLabel("Name");
        l1.setFont(f1);
        l1.setForeground(Color.WHITE);
        l1.setBounds(100, 100, 100, 50);
        image.add(l1);

        l2 = new JLabel("Employee Id");
        l2.setFont(f1);
        l2.setForeground(Color.WHITE);
        l2.setBounds(100, 180, 200, 50);
        image.add(l2);

        l3 = new JLabel("Father's Name");
        l3.setFont(f1);
        l3.setForeground(Color.WHITE);
        l3.setBounds(100, 260, 200, 50);
        image.add(l3);

        l4 = new JLabel("Address");
        l4.setFont(f1);
        l4.setForeground(Color.WHITE);
        l4.setBounds(100, 340, 200, 50);
        image.add(l4);

        l5 = new JLabel("Mobile No");
        l5.setFont(f1);
        l5.setForeground(Color.WHITE);
        l5.setBounds(100, 420, 200, 50);
        image.add(l5);

        l6 = new JLabel("Email Id");
        l6.setFont(f1);
        l6.setForeground(Color.WHITE);
        l6.setBounds(100, 500, 200, 50);
        image.add(l6);

        l7 = new JLabel("Education");
        l7.setFont(f1);
        l7.setForeground(Color.WHITE);
        l7.setBounds(100, 580, 200, 50);
        image.add(l7);

        l8 = new JLabel("Job Post");
        l8.setFont(f1);
        l8.setForeground(Color.WHITE);
        l8.setBounds(100, 660, 200, 50);
        image.add(l8);


        String name=null;
        String e_id=null;
        String fname = null;
        String address = null;
        String mobileno = null;
        String email_id = null;
        String education = null;
        String job_post = null;
        try {
            Connection_ c = new Connection_();
            String q = "select * from employee where Employee_Id = '" + eid + "';";
            ResultSet rs = c.stm.executeQuery(q);
            if (rs.next()) {
                name = rs.getString(1);
                e_id = rs.getString(11);
                fname = rs.getString(2);
                address = rs.getString(5);
                mobileno = rs.getString(6);
                email_id = rs.getString(7);
                education = rs.getString(8);
                job_post = rs.getString(9);


            }

        } catch (Exception e) {

        }

        d1 = new JLabel(name);
        d1.setFont(f2);
        d1.setForeground(Color.WHITE);
        d1.setBounds(500, 100, 600, 50);
        image.add(d1);

        d2 = new JLabel(e_id);
        d2.setFont(f2);
        d2.setForeground(Color.WHITE);
        d2.setBounds(500, 180, 600, 50);
        image.add(d2);

        d3 = new JLabel(fname);
        d3.setFont(f2);
        d3.setForeground(Color.WHITE);
        d3.setBounds(500, 260, 600, 50);
        image.add(d3);

        d4 = new JLabel(address);
        d4.setFont(f2);
        d4.setForeground(Color.WHITE);
        d4.setBounds(500, 340, 600, 50);
        image.add(d4);

        d5 = new JLabel(mobileno);
        d5.setFont(f2);
        d5.setForeground(Color.WHITE);
        d5.setBounds(500, 420, 600 , 50);
        image.add(d5);

        d6 = new JLabel(email_id);
        d6.setFont(f2);
        d6.setForeground(Color.WHITE);
        d6.setBounds(500, 500, 600 , 50);
        image.add(d6);

        d7 = new JLabel(education);
        d7.setFont(f2);
        d7.setForeground(Color.WHITE);
        d7.setBounds(500, 580, 600 , 50);
        image.add(d7);

        d8 = new JLabel(job_post);
        d8.setFont(f2);
        d8.setForeground(Color.WHITE);
        d8.setBounds(500, 660, 600 , 50);
        image.add(d8);


        btn1 = new JButton("Print");
        btn1.setBackground(Color.WHITE);
        btn1.addActionListener(this);
        btn1.setBounds(220, 740 ,150 , 40);
        btn1.setFont(f3);
        image.add(btn1);

        btn2 = new JButton("Cancel");
        btn2.setBackground(Color.WHITE);
        btn2.addActionListener(this);
        btn2.setBounds(445, 740 ,150 , 40);
        btn2.setFont(f3);
        image.add(btn2);






        setVisible(true);
    }
























    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==btn1){
            JOptionPane.showMessageDialog(this , "Printed Successfully...");
            setVisible(false);
            new Homepage();
        }
        else{
            setVisible(false);
            new View_Employee();


        }

    }

    public static void main(String[] args) {
        View_Employee_Data v = new View_Employee_Data("001");
    }
}
