import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Add_Employee extends JFrame implements ActionListener {
    JLabel id1,id2,id3,id4,id5,id6,id7,id8,id9,id10,id11,id12,id13;
    JTextField t,t1,t2,t3,t4,t5,t6,t7,t8,t9,t10,t11,t12,t13;
    JButton btn1,btn2;
    Font f,f1;



    Add_Employee() {
        f = new Font("Segoe Print", Font.BOLD,26);
        f1 = new Font("Segoe Print", Font.BOLD,20);
        Color c = new Color(236,69,67,255);

        setTitle("Add Employee");
        setLayout(null);
        setSize(900,600);
        setLocation(300,100);
        JLabel label = new JLabel();
        label.setBounds(0,0,900,600);
        ImageIcon i = new ImageIcon(this.getClass().getResource("image/add5.png"));
        Image i1 = i.getImage().getScaledInstance(900 , 600 , Image.SCALE_DEFAULT);
        ImageIcon i2 = new ImageIcon(i1);
        label.setIcon(i2);
        this.add(label);


        id1 = new JLabel("New Employee Details");
        id1.setFont(f);
        id1.setForeground(Color.BLACK);
        id1.setBounds(280 , 30 ,500 , 50);

        label.add(id1);

        id2 = new JLabel("Name");
        id2.setFont(f1);
        id2.setForeground(Color.BLACK);
        id2.setBounds(40 , 110 ,100 , 35);

        label.add(id2);

        id3 = new JLabel("Age");
        id3.setFont(f1);
        id3.setForeground(Color.BLACK);
        id3.setBounds(40 , 170 ,100 , 35);
        label.add(id3);


        id4 = new JLabel("Address");
        id4.setFont(f1);
        id4.setForeground(Color.BLACK);
        id4.setBounds(40 , 230 ,150 , 35);
        label.add(id4);


        id5 = new JLabel("Email Id");
        id5.setFont(f1);
        id5.setForeground(Color.BLACK);
        id5.setBounds(40 , 290 ,150 , 35);
        label.add(id5);


        id6 = new JLabel("Job Post");
        id6.setFont(f1);
        id6.setForeground(Color.BLACK);
        id6.setBounds(40 , 350 ,150 , 35);
        label.add(id6);


        id6 = new JLabel("Employee Id");
        id6.setFont(f1);
        id6.setForeground(Color.BLACK);
        id6.setBounds(40 , 410 ,200 , 35);
        label.add(id6);

        //Textfield
        t = new JTextField();
        t.setBounds(180 , 110 ,200 , 35);
        label.add(t);

        t1 = new JTextField();
        t1.setBounds(180 , 170 ,200 , 35);
        label.add(t1);

        t2 = new JTextField();
        t2.setBounds(180 , 230 ,200 , 35);
        label.add(t2);

        t3 = new JTextField();
        t3.setBounds(180 , 290 ,200 , 35);
        label.add(t3);

        t4 = new JTextField();
        t4.setBounds(180 , 350 ,200 , 35);
        label.add(t4);

        t5 = new JTextField();
        t5.setBounds(180 , 410 ,200 , 35);
        label.add(t5);

        //Jlabel
        id7 = new JLabel("Father's Name");
        id7.setFont(f1);
        id7.setForeground(Color.BLACK);
        id7.setBounds(460 , 110 ,150 , 35);
        label.add(id7);

        id8 = new JLabel("Date of Birth");
        id8.setFont(f1);
        id8.setForeground(Color.BLACK);
        id8.setBounds(460 , 170 ,150 , 35);
        label.add(id8);

        id9 = new JLabel("Phone");
        id9.setFont(f1);
        id9.setForeground(Color.BLACK);
        id9.setBounds(460 , 230 ,150 , 35);
        label.add(id9);

        id10 = new JLabel("Education");
        id10.setFont(f1);
        id10.setForeground(Color.BLACK);
        id10.setBounds(460 , 290 ,150 , 35);
        label.add(id10);

        id11 = new JLabel("Aadhar No");
        id11.setFont(f1);
        id11.setForeground(Color.BLACK);
        id11.setBounds(460 , 350 ,150 , 35);
        label.add(id11);

        //Textfield

        t6 = new JTextField();
        t6.setBounds(630 , 110 ,200 , 35);
        label.add(t6);

        t7 = new JTextField();
        t7.setBounds(630 , 170 ,200 , 35);
        label.add(t7);

        t8 = new JTextField();
        t8.setBounds(630 , 230 ,200 , 35);
        label.add(t8);

        t9 = new JTextField();
        t9.setBounds(630 , 290 ,200 , 35);
        label.add(t9);

        t10 = new JTextField();
        t10.setBounds(630 , 350 ,200 , 35);
        label.add(t10);

        //buttons
        btn1 = new JButton("Submit");
        btn1.setForeground(Color.WHITE);
        btn1.setBackground(Color.BLACK);
        btn1.setBounds(250 , 480 , 150 , 40);
        btn1.addActionListener(this);
        label.add(btn1);





        btn2 = new JButton("Cancel");
        btn2.setForeground(Color.WHITE);
        btn2.setBackground(c);
        btn2.setBounds(450 , 480 , 150 , 40);
        label.add(btn2);
        btn2.addActionListener(this);

















        setVisible(true);


    }

    @Override
    public void actionPerformed(ActionEvent e) {

        String name = t.getText();
        String age = t1.getText();
        String address = t2.getText();
        String email_id = t3.getText();
        String job_post = t4.getText();
        String employee_id = t5.getText();
        String father_name = t6.getText();
        String date_of_birth = t7.getText();
        String phone = t8.getText();
        String education = t9.getText();
        String aadhar_no = t10.getText();

        if (e.getSource()==btn1){
            try{
                Connection_ c = new Connection_();
                String q = "insert into employee values ( '" + name +"','"+father_name+ "'," + age +",'" + date_of_birth + "','" +address +"'," + phone +",'"+ email_id +"','"+ education +"','" + job_post +"'," + aadhar_no +",'"
                         + employee_id + "')";
                c.stm.executeUpdate(q);
                JOptionPane.showMessageDialog(this , "Details inserted successfully");
                setVisible(false);
                new Homepage();







            }
            catch(Exception ex){
                System.out.println(ex);
            }
        }
        else{
            setVisible(false);
            new Homepage();
        }

















    }

    public static void main(String[] args) {

        Add_Employee e = new Add_Employee();
    }
}
