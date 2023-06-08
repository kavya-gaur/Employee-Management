import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.ResultSet;
import javax.swing.*;
import javax.swing.border.EmptyBorder;


public class Update_Details_Data extends JFrame implements ActionListener {
        JPanel p1,p2,p3;
        JLabel l0,l1,l2,l3,l4,l5,l6,l7,l8,l9,l10,l11,l12;
        JTextField t1,t2,t3,t4,t5,t6,t7,t8,t9,t10,t11,t12;
        JButton btn1,btn2;
        Font f,f1,f2;
        Choice ch;




    Update_Details_Data(){
        setBackground(Color.LIGHT_GRAY);
        setLayout(new BorderLayout(10,10));
        setTitle("Update Employee Details");
        setBounds(0,0,800,800);
        ch = new Choice();
        ch.setFont(f1);
        f = new Font("Comic Sans MS",Font.BOLD,25);
        f1 = new Font("Comic Sans MS",Font.BOLD,18);
        f2 = new Font("Comic Sans MS",Font.BOLD,18);


        p1 = new JPanel(new GridLayout(1,1,10,10));
        l0 = new JLabel("Update Details");
        l0.setFont(f);
        l0.setHorizontalAlignment(JLabel.CENTER);
        p1.add(l0);
        add(p1 , "North");

        p2 = new JPanel(new GridLayout(1,1,10,10));

        ImageIcon i = new ImageIcon(this.getClass().getResource("image/update2.jpg"));
        Image i1 = i.getImage().getScaledInstance(380,230,Image.SCALE_DEFAULT);
        ImageIcon i2 = new ImageIcon(i1);
        l1 = new JLabel(i2);
        //
        p2.add(l1);
        add(p2 , "East");


        p3 = new JPanel(new GridLayout(12,2,10,10));
        p3.setBorder(new EmptyBorder(25,25,25,25));

        l2 = new JLabel("Employee Id");
        l2.setFont(f1);



        l3 = new JLabel("Name");
        l3.setFont(f1);




        l4 = new JLabel("Father's Name");
        l4.setFont(f1);


        l5 = new JLabel("Age");
        l5.setFont(f1);


        l6 = new JLabel("Date of Birth");
        l6.setFont(f1);


        l7 = new JLabel("Address");
        l7.setFont(f1);


        l8 = new JLabel("Phone");
        l8.setFont(f1);


        l9 = new JLabel("Email");
        l9.setFont(f1);


        l10 = new JLabel("Education");
        l10.setFont(f1);


        l11 = new JLabel("Job Post");
        l11.setFont(f1);


        l12 = new JLabel("Aadhar");
        l12.setFont(f1);





        t1 = new JTextField();
        t1.setFont(f1);


        t2 = new JTextField();
        t2.setFont(f1);


        t3 = new JTextField();
        t3.setFont(f1);


        t4 = new JTextField();
        t4.setFont(f1);


        t5 = new JTextField();
        t5.setFont(f1);


        t6 = new JTextField();
        t6.setFont(f1);


        t7 = new JTextField();
        t7.setFont(f1);


        t8 = new JTextField();
        t8.setFont(f1);


        t9 = new JTextField();
        t9.setFont(f1);


        t10 = new JTextField();
        t10.setFont(f1);


        t11 = new JTextField();
        t11.setFont(f1);
        //p3.add(t11);

        t12 = new JTextField();
        t12.setFont(f1);
        //p3.add(t12);


        //Adding into panel

        p3.add(l2);
        p3.add(ch);
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
        p3.add(t8);
        p3.add(l11);
        p3.add(t9);
        p3.add(l12);
        p3.add(t10);

        //buttons
        btn1 = new JButton("Update Data");
        btn2 = new JButton("Cancel");

        btn1.addActionListener(this);
        btn1.setForeground(Color.WHITE);
        btn1.setBackground(Color.BLACK);
        btn1.setFont(f2);

        btn2.addActionListener(this);
        btn2.setForeground(Color.WHITE);
        btn2.setBackground(Color.RED);
        btn2.setFont(f2);

        p3.add(btn1);
        p3.add(btn2);

        add(p3,"West");

        String q = "select Employee_Id from employee;";
        try{
            Connection_ c = new Connection_();
            ResultSet rs = c.stm.executeQuery(q);
            while (rs.next()){
                ch.add(rs.getString("Employee_Id"));
            }

        }
        catch(Exception e){
            e.printStackTrace();

        }






        ch.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                 String eid;
                try{
                    Connection_ c = new Connection_();
                    eid = ch.getSelectedItem();
                    String q1 = "select * from employee where Employee_Id ='" + eid + "';" ;
                    ResultSet rs = c.stm.executeQuery(q1);

                    while(rs.next()){
                        t1.setText(rs.getString(1));
                        t2.setText(rs.getString(2));
                        t3.setText(rs.getString(3));
                        t4.setText(rs.getString(4));
                        t5.setText(rs.getString(5));
                        t6.setText(rs.getString(6));
                        t7.setText(rs.getString(7));
                        t8.setText(rs.getString(8));
                        t9.setText(rs.getString(9));
                        t10.setText(rs.getString(10));

                    }


                }
                catch(Exception ex){

                }
            }
        });

        setVisible(true);
    }



    @Override
    public void actionPerformed(ActionEvent e) {

        String id = ch.getSelectedItem();
        String name = t1.getText();
        String fname = t2.getText();
        String age = t3.getText();
        String dob = t4.getText();
        String address = t5.getText();
        String phone = t6.getText() ;
        String email = t7.getText();
        String education = t8.getText();
        String jobpost = t9.getText();
        String aadhar = t10.getText();

        if (e.getSource()==btn1){
            try{
                Connection_ c = new Connection_();
                String q1 = "update employee set Name ='" + name +"',Fname='"+ fname + "',age='" + age + "', dob ='" + dob +"', Address ='" + address +"', phone='"+ phone +"', Email = '"+ email +"', Education = '" + education +"',Job_Post= '" + jobpost +"', Aadhar = '"+ aadhar + "' where Employee_Id = '" + id  +"';";
                int no = c.stm.executeUpdate(q1);
                if (no==1){
                    JOptionPane.showMessageDialog(this,"Details Uploaded Successfully");
                    setVisible(false);
                    new Update_Details_Data();
                }
                else{
                    JOptionPane.showMessageDialog(this , "Please fill details carefully...");

                }

            }
            catch(Exception exc){

            }
        }
       else{
           setVisible(false);
        }


    }

    public static void main(String[] args) {
        Update_Details_Data u = new Update_Details_Data();
    }
}
