import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Date;
import java.sql.ResultSet;

public class Apply_Employee_Leave extends JFrame implements ActionListener {
    JLabel l0,l1,l2,l3,l4,l5,l6,l7;
    Choice c1,c2;
    JTextField t1,t2,t3,t4;
    JPanel p1,p2,p3;
    JButton btn1,btn2;
    Font f1,f2;





    Apply_Employee_Leave() {
        setResizable(false);
        f1 = new Font("Comic Sans MS", Font.BOLD, 30);
        f2 = new Font("Comic Sans MS", Font.BOLD, 20);
        Border border = BorderFactory.createLineBorder(Color.RED);


        l1 = new JLabel("Apply Leave");
        l1.setHorizontalAlignment(JLabel.CENTER);
        l1.setFont(f1);


        l2 = new JLabel("Select Employee Id");
        l2.setFont(f2);

        l3 = new JLabel("Name");
        l3.setFont(f2);

        l4 = new JLabel("Email");
        l4.setFont(f2);

        l5 = new JLabel("Start Date");
        l5.setFont(f2);

        l6 = new JLabel("End Date");
        l6.setFont(f2);

        l7 = new JLabel("Leave Reason");
        l7.setFont(f2);

        t1 = new JTextField();
        t1.setFont(f2);
        t1.setEditable(false);



        t2 = new JTextField();
        t2.setFont(f2);
        t2.setEditable(false);

        t3 = new JTextField();
        t3.setFont(f2);
        t3.setBorder(border);

        t4 = new JTextField();
        t4.setFont(f2);
        t4.setBorder(border);

        c1 = new Choice();
        c1.setFont(f2);

        c2 = new Choice();
        c2.setFont(f2);
        c2.add("Health Issue");
        c2.add("Family Member Health Issue");
        c2.add("Function/Celebration");
        c2.add("Others");

        btn1 = new JButton("Submit");
        btn1.setFont(f2);
        btn1.setForeground(Color.WHITE);
        btn1.setBackground(Color.BLACK);
        btn1.addActionListener(this);

        btn2 = new JButton("Cancel");
        btn2.setFont(f2);
        btn2.setBackground(Color.RED);
        btn2.setForeground(Color.WHITE);
        btn2.addActionListener(this);

        p1 = new JPanel(new GridLayout(1, 1, 10, 10));
        p1.add(l1);

        p2 = new JPanel(new GridLayout(7, 2, 10, 10));
        p2.setBorder(new EmptyBorder(20, 20, 20, 20));
        p2.add(l2);
        p2.add(c1);
        p2.add(l3);
        p2.add(t1);
        p2.add(l4);
        p2.add(t2);
        p2.add(l5);
        p2.add(t3);
        p2.add(l6);
        p2.add(t4);
        p2.add(l7);
        p2.add(c2);
        p2.add(btn1);
        p2.add(btn2);

        add(p1, "North");

        add(p2, "West");


        setSize(700, 450);
        setLocation(350, 150);

//        ImageIcon i = new ImageIcon(this.getClass().getResource("image/leave2.png"));
//        Image i1 = i.getImage().getScaledInstance(300, 300, Image.SCALE_DEFAULT);
//        ImageIcon i2 = new ImageIcon(i1);
//        l0 = new JLabel();
//        l0.setIcon(i2);
//        p3 = new JPanel(new GridLayout(1, 1, 10, 10));
//        p3.add(l0);
//        add(p3, "East");


        setVisible(true);


        try {
            Connection_ c = new Connection_();
            String q = "select Employee_Id from employee;";
            ResultSet rs = c.stm.executeQuery(q);
            while (rs.next()) {
                c1.add(rs.getString("Employee_Id"));
            }


        } catch (Exception ex) {

        }

        c1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                try{
                    String eid = c1.getSelectedItem();
                    Connection_ c = new Connection_();
                    String q = "select * from employee where Employee_Id ='"+eid +"';";
                    ResultSet rs = c.stm.executeQuery(q);
                    while (rs.next()){
                        t1.setText(rs.getString("Name"));
                        t2.setText(rs.getString("Email"));

                    }

                }
                catch(Exception esx){

                }




            }
        });


    }




    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==btn1) {
            String name = t1.getText();
            String eid = c1.getSelectedItem();
            String email = t2.getText();
            String start_date = t3.getText();
            String end_date = t4.getText();
            String reason = c2.getSelectedItem();
            String date = new java.util.Date().toLocaleString();


            try {
                Connection_ c = new Connection_();
                String q = "insert into apply_leave values('" + name + "','" + eid + "','" + email + "','" + start_date + "','" + end_date + "','" + reason + "','" + date + "');";
                int no = c.stm.executeUpdate(q);
                if (no == 1) {
                    JOptionPane.showMessageDialog(this, "Leave Applied Successfully");
                    setVisible(false);
                } else {
                    JOptionPane.showMessageDialog(this, "Please fill all the details carefully");
                }


            }
            catch (Exception esx) {

            }
        }
            else{
                setVisible(false);
            }











    }

    public static void main(String[] args) {
        Apply_Employee_Leave a = new Apply_Employee_Leave();

    }
}
