import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.ResultSet;
import java.sql.Statement;

public class Salary extends JFrame implements ActionListener {
    JLabel l0,l1,l2,l3,l4,l5,l6,l7,l8,l9,l10,l11;
    JTextField t1,t2,t3,t4,t5,t6,t7;
    Choice c1,c2,c3;
    JButton btn1,btn2;
    JPanel p1,p2,p3,p4;
    Font f1,f2;
    Border b;





    Salary(){
        b = BorderFactory.createLineBorder(Color.RED);
        f1 = new Font("Comic Sans MS", Font.BOLD, 30);
        f2 = new Font("Comic Sans MS", Font.BOLD, 22);


        setTitle("Salary");
        setSize(1000,691);

        l0 = new JLabel();
        ImageIcon i = new ImageIcon(this.getClass().getResource("image/salary2.png"));
        Image i1 = i.getImage().getScaledInstance(480, 527 ,Image.SCALE_DEFAULT);
        ImageIcon i2 = new ImageIcon(i1);
        l0.setIcon(i2);
//        p1 = new JPanel(){
//            @Override
//            protected void paintComponent(Graphics g) {
//                super.paintComponent(g);
//                g.drawImage(i.getImage(),0,0,null);
//            }
//        };







        l1 = new JLabel("Employee Salary");
        l1.setFont(f1);
        l1.setForeground(Color.BLACK);
        l1.setHorizontalAlignment(JLabel.CENTER);


        l2 = new JLabel("Select Employee Id");
        l2.setFont(f2);
        l2.setForeground(Color.BLACK);



        l3 = new JLabel("Name");
        l3.setFont(f2);
        l3.setForeground(Color.BLACK);


        l4 = new JLabel("Email");
        l4.setFont(f2);
        l4.setForeground(Color.BLACK);


        l5 = new JLabel("HRA");
        l5.setFont(f2);
        l5.setForeground(Color.BLACK);


        l6 = new JLabel("DA");
        l6.setFont(f2);
        l6.setForeground(Color.BLACK);


        l7 = new JLabel("MID");
        l7.setFont(f2);
        l7.setForeground(Color.BLACK);


        l8 = new JLabel("PF");
        l8.setFont(f2);
        l8.setForeground(Color.BLACK);


        l9 = new JLabel("Basic Salary");
        l9.setFont(f2);
        l9.setForeground(Color.BLACK);


        l10 = new JLabel("Select Month");
        l10.setFont(f2);
        l10.setForeground(Color.BLACK);


        l11 = new JLabel("Select Year");
        l11.setFont(f2);
        l11.setForeground(Color.BLACK);


        c1 = new Choice();
        c1.setFont(f2);

        c2 = new Choice();
        c2.setFont(f2);

        c3 = new Choice();
        c3.setFont(f2);

        t1 = new JTextField();
        t1.setEditable(false);
        t1.setFont(f2);

        t2 = new JTextField();
        t2.setEditable(false);
        t2.setFont(f2);

        t3 = new JTextField();
        t3.setFont(f2);

        t4 = new JTextField();
        t4.setFont(f2);

        t5 = new JTextField();
        t5.setFont(f2);

        t6 = new JTextField();
        t6.setFont(f2);

        t7 = new JTextField();
        t7.setFont(f2);
        t7.setBorder(b);


        btn1 = new JButton("Submit");
        btn1.setForeground(Color.WHITE);
        btn1.setBackground(Color.BLACK);
        btn1.setFont(f2);
        btn1.addActionListener(this);

        btn2 = new JButton("Cancel");
        btn2.setForeground(Color.WHITE);
        btn2.setBackground(Color.RED);
        btn2.setFont(f2);
        btn2.addActionListener(this);



//        p1 = new JPanel(new GridLayout(1,1,10,10));
//        p1.add(l1 , "North");
//        l0.add(p1);

        p2 = new JPanel(new GridLayout(1,1,5,5));
        p2.add(l1 , JLabel.CENTER);




        p3 = new JPanel(new GridLayout(11,2,5,5));
        p3.setBorder(new EmptyBorder(10,20,10,10));
        p3.add(l2);
        p3.add(c1);
        p3.add(l3);
        p3.add(t1);
        p3.add(l4);
        p3.add(t2);
        p3.add(l5);
        p3.add(t3);
        p3.add(l6);
        p3.add(t4);
        p3.add(l7);
        p3.add(t5);
        p3.add(l8);
        p3.add(t6);
        p3.add(l9);
        p3.add(t7);
        p3.add(l10);
        p3.add(c2);
        p3.add(l11);
        p3.add(c3);
        p3.add(btn1);
        p3.add(btn2);





        //p1.add(p2 , "Top");
        add(p2 , "North");
        add(p3 , "West");
        add(l0,"East");

        try{
            Connection_ c = new Connection_();
            String q = "select Employee_Id from employee;";
            ResultSet rs = c.stm.executeQuery(q);
            while (rs.next()){
                c1.add(rs.getString("Employee_Id"));



            }



        }

        catch (Exception e ){

        }

        c1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                try{
                    Connection_ c = new Connection_();
                    String eid = c1.getSelectedItem();
                    String q = "select * from employee where Employee_Id ='" + eid + "';";
                    ResultSet rs = c.stm.executeQuery(q);
                    while(rs.next()) {
                        t1.setText(rs.getString("Name"));
                        t2.setText(rs.getString("Email"));
                    }





                }
                catch (Exception ec){

                }









            }
        });




        c2.addItem("January");
        c2.addItem("February");
        c2.addItem("March");
        c2.addItem("April");
        c2.addItem("May");
        c2.addItem("June");
        c2.addItem("July");
        c2.addItem("August");
        c2.addItem("September");
        c2.addItem("October");
        c2.addItem("November");
        c2.addItem("December");


        c3.addItem("2015");
        c3.addItem("2016");
        c3.addItem("2017");
        c3.addItem("2018");
        c3.addItem("2019");
        c3.addItem("2020");
        c3.addItem("2021");
        c3.addItem("2022");

































        setVisible(true);








    }





















    @Override
    public void actionPerformed(ActionEvent e) {



        if (e.getSource()==btn1){
            try{
                String eid = c1.getSelectedItem();
                String name = t1.getText();
                String email = t2.getText();
                float hra = Float.parseFloat(t3.getText());
                float da = Float.parseFloat(t4.getText());
                float mid = Float.parseFloat(t5.getText());
                float pf = Float.parseFloat(t6.getText());
                float basic = Float.parseFloat(t7.getText());
                String month_year = c2.getSelectedItem() + " " + c3.getSelectedItem();


                Connection_ c = new Connection_();
                String q1 = "insert into salary values('"+ eid +"','" + name +"','" + email +"'," + hra +"," + da +"," + mid +"," + pf +"," + basic +",'" + month_year +"');";
                int no = c.stm.executeUpdate(q1);
                if (no==1){
                    JOptionPane.showMessageDialog(this , "Data Inserted Successfully");
                    setVisible(false);
                }
                else {
                    JOptionPane.showMessageDialog(this , "Please fill the details carefully");
                    setVisible(false);
                    setVisible(true);
                }

            }
            catch(Exception eex){

            }


        }
        else{
            setVisible(false);

        }

    }

    public static void main(String[] args) {
        Salary s = new Salary();
    }
}

