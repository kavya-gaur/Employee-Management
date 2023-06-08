import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.JTableHeader;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class Delete_Employee extends JFrame implements ActionListener {
    JLabel l1,l2;
    Font f1,f2;
    JPanel p1,p2,p3;
    JTextField t1;
    JTable t;
    int i=0;
    int j=0;
    JButton btn1,btn2;
    Color c;


    Delete_Employee(){
        c= new Color(249,150,69,255);
        setSize(1480,400);
        setTitle("Employee Records");
        String [] x = {"Employee Id","Name" , "Email","Age","Date of Birth","Post"};
        String [][]y = new String [20][6];
        f1 = new Font("Microsoft JhengHei UEI",Font.BOLD,20);

        f2 =new Font("Microsoft JhengHei UEI",Font.BOLD,14);

        try{
            Connection_ c = new Connection_();
            String q = "select * from employee;";
            ResultSet rs = c.stm.executeQuery(q);
            while (rs.next()){
                y[i][j++]=rs.getString("Employee_Id");
                y[i][j++]=rs.getString("Name");
                y[i][j++]=rs.getString("Email");
                y[i][j++]=rs.getString("age");
                y[i][j++]=rs.getString("DOB");
                y[i][j++]=rs.getString("Job_Post");
                i++;
                j=0;
            }

        }
        catch(Exception e){
        }

        t = new JTable(y,x);


        JScrollPane js = new JScrollPane(t);
        JPanel p1 =new JPanel(new GridLayout(1,1,10,10));
        JLabel l0 = new JLabel("Delete employee");
        l0.setFont(f1);
        l0.setHorizontalAlignment(JLabel.CENTER);
        p1.add(l0);

        JPanel p2 = new JPanel(new GridLayout(1,3,10,10));

        l1 = new JLabel("Employee_Id");
        l1.setFont(f1);
        t1 = new JTextField();
        t1.setFont(f1);
        btn1 = new JButton("Delete employee");
        btn1.addActionListener(this);
        btn1.setFont(f1);
        btn1.setForeground(Color.white);
        btn1.setBackground(Color.BLACK);

        p2.add(l1);
        p2.add(t1);
        p2.add(btn1);

        JPanel p3 = new JPanel(new GridLayout(2,1,10,10));
        p3.setBorder(new EmptyBorder(10,10,10,10));
        p3.add(p1);
        p3.add(p2);

        add(p3,"South");
        add(js,"Center");

        JTableHeader h = t.getTableHeader();
        h.setForeground(Color.WHITE);
        h.setBackground(c);
        h.setFont(f1);









        setVisible(true);

    }
    @Override
    public void actionPerformed(ActionEvent e) {
        try{
            Connection_ c = new Connection_();
            String q = "delete from employee where Employee_Id='"+t1.getText()+"';";
            String q1 = "delete from salary where Employee_Id='"+t1.getText()+"';";
            String q2 = "delete from attendance where Employee_Id='"+t1.getText()+"';";
            String q3 = "delete from apply_leave where Employee_Id='"+t1.getText()+"';";
            int rs = c.stm.executeUpdate(q);
            if (rs==1){
                c.stm.executeUpdate(q1);
                c.stm.executeUpdate(q2);
                c.stm.executeUpdate(q3);

                JOptionPane.showMessageDialog(this ,"Record deleted successfully");
                setVisible(false);
                new Delete_Employee();
            }
            else{
                JOptionPane.showMessageDialog(this , "Delete failed...Try again");
                setVisible(false);
                new Delete_Employee();
            }


        }
        catch (Exception ex){

        }

    }



    public static void main(String[] args) {
        Delete_Employee d = new Delete_Employee();



    }



}
