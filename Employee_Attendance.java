import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.ResultSet;

public class Employee_Attendance extends JFrame implements ActionListener {
    JPanel p;
    JLabel l1,l2,l3,l4,l5;
    JTextField t1,t2;
    Choice c1,c2,c3;
    JButton btn1,btn2;
    Font f,f1;
    Color c;

    Employee_Attendance(){
        c = new Color(243,116,55,255);
        setTitle("Employee Attendence");
        setSize(500,400);
        setResizable(false);
        setLocation(580,200);
        p = new JPanel(new GridLayout(6,2,5,5));
        f = new Font("Comic Sans MS",Font.BOLD,22);
        f1 = new Font("Comic Sans MS",Font.PLAIN,22);


        //JLabel
        l1 = new JLabel("Select Employee Id");
        l1.setFont(f);
        //l1.setHorizontalAlignment(JLabel.LEFT);


        l2 = new JLabel("Name");
        l2.setFont(f);
        //l2.setHorizontalAlignment(JLabel.LEFT);


        l3 = new JLabel("Email");
        l3.setFont(f);


        l4 = new JLabel("First Half");
        l4.setFont(f);


        l5 = new JLabel("Second Half");
        l5.setFont(f);

        c1 = new Choice();
        c1.setFont(f1);

        c2 = new Choice();
        c2.add("Present");
        c2.add("Absent");
        c2.setFont(f1);


        c3 = new Choice();
        c3.add("Present");
        c3.add("Absent");
        c3.setFont(f1);

        t1 = new JTextField();
        t1.setFont(f1);

        t2 = new JTextField();
        t2.setFont(f1);

        btn1 = new JButton("Submit");
        btn1.setBackground(Color.BLACK);
        btn1.setForeground(Color.WHITE);
        btn1.addActionListener(this);

        btn2 = new JButton("Cancel");
        btn2.setBackground(c);
        btn2.setForeground(Color.WHITE);
        btn2.addActionListener(this);

        p.add(l1);
        p.add(c1);
        p.add(l2);
        p.add(t1);
        p.add(l3);
        p.add(t2);
        p.add(l4);
        p.add(c2);
        p.add(l5);
        p.add(c3);
        p.add(btn1);
        p.add(btn2);

        p.setBorder(new EmptyBorder(10,10,10,10));



        add(p);

        try{
            Connection_ c = new Connection_();
            String q = "select Employee_Id from employee;";
            ResultSet rs = c.stm.executeQuery(q);
            while (rs.next()){
                c1.add(rs.getString("Employee_Id"));
            }

        }
        catch(Exception e){

        }

        t1.setEditable(false);
        t2.setEditable(false);





















        setVisible(true);
        c1.addMouseListener(new MouseAdapter() {
            String eid;
            @Override
            public void mouseClicked(MouseEvent e) {
                try {
                    eid = c1.getSelectedItem();
                    Connection_ c = new Connection_();
                    String q = "select Name, Email from employee where Employee_Id = '" + eid + "';";
                    ResultSet rs = c.stm.executeQuery(q);
                    if (rs.next()) {
                        t1.setText(rs.getString("Name"));
                        t2.setText(rs.getString("Email"));
                    }
                }

                catch(Exception ex){

                }


            }
        });



    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource()==btn1){
            String eid = c1.getSelectedItem();
            String first = c2.getSelectedItem();
            String second = c3.getSelectedItem();
            String name = t1.getText();
            String email = t2.getText();
            String d = new java.util.Date().toLocaleString();
            try {
                Connection_ con = new Connection_();
                String q = "insert into attendance values('" + name + "','" + eid + "','" + email +"','" + first + "','" +second +"','" +d +"');";
                int rs = con.stm.executeUpdate(q);
                if (rs==1){
                    JOptionPane.showMessageDialog(this , "Attendance updated successfully");
                    setVisible(false);
                }
                else{
                    JOptionPane.showMessageDialog(this,"Fill all details carefully");
                }


            }
            catch(Exception exc){

            }
        }
        else{
            setVisible(false);
            new Homepage();
        }








    }





    public static void main(String[] args) {
        Employee_Attendance e = new Employee_Attendance();

    }
}
