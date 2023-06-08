import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Generate_PaySlip extends JFrame implements ActionListener {
    JLabel l1,l2,l3,l4,l5;
    JPanel p1;
    JScrollPane js ;
    Choice c1,c2,c3;
    JTextArea a;
    JButton btn1,btn2;
    Font f1,f2;



    Generate_PaySlip(){
        setTitle("Generate Pay Slip");
        setSize(500,500);
        setResizable(false);
        f2 = new Font("Comic Sans MS", Font.BOLD, 22);
        f1 = new Font("Comic Sans MS", Font.BOLD, 15);
        c1 = new Choice();
        c1.setFont(f2);









        try{
            Connection_ c = new Connection_();
            String q = "select * from employee;";
            ResultSet rs = c.stm.executeQuery(q);
            while(rs.next()){
                c1.addItem(rs.getString("Employee_Id"));
            }

        }
        catch(Exception exc){


        }
        l1 = new JLabel("Employee Id");
        l1.setFont(f2);
        l2 = new JLabel("Month");
        l2.setFont(f2);
        l3 = new JLabel("Year");
        l3.setFont(f2);

        c2 = new Choice();
        c2.setFont(f2);
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

        c3 = new Choice();
        c3.setFont(f2);
        c3.addItem("2015");
        c3.addItem("2016");
        c3.addItem("2017");
        c3.addItem("2018");
        c3.addItem("2019");
        c3.addItem("2020");
        c3.addItem("2021");
        c3.addItem("2022");


        btn1 = new JButton("Print");
        btn1.setForeground(Color.WHITE);
        btn1.setBackground(Color.BLACK);
        btn1.setFont(f2);
        btn1.addActionListener(this);

        btn2 = new JButton("Close");
        btn2.setForeground(Color.WHITE);
        btn2.setBackground(Color.BLACK);
        btn2.setFont(f2);
        btn2.addActionListener(this);

        p1 = new JPanel(new GridLayout(4,2,10,10));
        p1.setBackground(Color.LIGHT_GRAY);
        p1.add(l1);
        p1.add(c1);
        p1.add(l2);
        p1.add(c2);
        p1.add(l3);
        p1.add(c3);
        p1.add(btn1);
        p1.add(btn2);

        add(p1,"South");

        a = new JTextArea();
        a.setFont(f1);
        js = new JScrollPane(a);
        a.setEditable(false);


        add(js , "Center");


















        setVisible(true);


    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btn1) {
            try {
                Connection_ c = new Connection_();
                String id = c1.getSelectedItem();
                String month_year = c2.getSelectedItem() + " " + c3.getSelectedItem();
                String q = "select * from employee where Employee_Id = '" + id + "';";
                a.setText("---------------------PAY SLIP------------------");
                ResultSet rs = c.stm.executeQuery(q);
                while (rs.next()) {
                    a.append("\n\n Employee Id : " + rs.getString("Employee_Id"));
                    a.append("\n Employee Name : " + rs.getString("Name"));
                    a.append("\n Employee Email : " + rs.getString("Email"));
                    a.append("\n-----------------------------------------------\n\n");
                }

                String q1 = "select * from salary where month_year = '" + month_year + "' and Employee_Id ='" + id + "';";
                ResultSet rs1 = c.stm.executeQuery(q1);
                if (rs1.next() == false) {
                    a.append("\n------------------------------------------------\n\n");
                    a.append("Record not found of this year & month");
                    a.append("\n-------------------------------------------------\n\n");
                    a.append("Please add salary of this year & month for this record\n");
                } else {

                        a.append("\nHRA : " + rs1.getString("hra"));
                        a.append("\nDA : " + rs1.getString("da"));
                        a.append("\nMID : " + rs1.getString("mid"));
                        a.append("\nPF : " + rs1.getString("pf"));
                        a.append("\nBasic Salary : " + rs1.getString("basic"));

                        float Gross_Salary;
                        float tax;
                        Gross_Salary = Float.parseFloat(rs1.getString("hra")) + Float.parseFloat(rs1.getString("da")) + Float.parseFloat(rs1.getString("pf")) + Float.parseFloat(rs1.getString("mid")) + Float.parseFloat(rs1.getString("basic"));
                        tax = (float)(Gross_Salary * 2.1) / 100;
                        a.append("\nGross Salary : " + Gross_Salary);
                        a.append("\nTotal : " + Gross_Salary);
                        a.append("\nTax( 2.1% of salary ) : " + tax);


                }
            } catch (Exception ex){
            }

        }
        if (e.getSource()==btn2){
            JOptionPane.showMessageDialog(this , " Are you sure?");
            setVisible(false);
        }
    }


    public static void main(String[] args) {
        Generate_PaySlip g = new Generate_PaySlip();

    }
}



