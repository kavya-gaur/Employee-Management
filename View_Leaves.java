import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.table.JTableHeader;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class View_Leaves extends JFrame implements ActionListener {
    JTable table;
    String x [];
    String y [][];
    JPanel p1,p2,p3;
    JLabel l1,l2;
    JTextField t1;
    JButton btn1;
    Font f1,f2;




    View_Leaves(){
        setSize(1480,400);
        setLocation(32,200);

        f1 = new Font("Comic Sans MS",Font.PLAIN,20);
        f2 = new Font("Comic Sans MS",Font.BOLD,20);



        String x [] = {"Name","Employee Id","Email","Start Date","End Date","Reason","Apply Date"};

        l1 = new JLabel("Search any employee");
        l1.setFont(f2);
        l1.setHorizontalAlignment(JLabel.CENTER);
        p1 = new JPanel(new GridLayout(1,1,10,10));
        p1.add(l1);


        l2 = new JLabel("Employee Id");
        l2.setFont(f2);

        t1 = new JTextField();
        t1.setFont(f2);

        btn1 = new JButton("Search");
        btn1.setFont(f2);
        btn1.setBackground(Color.BLACK);
        btn1.setForeground(Color.WHITE);
        btn1.addActionListener(this);


        p2 = new JPanel(new GridLayout(1,3,10,10));
        p2.add(l2);
        p2.add(t1);
        p2.add(btn1);

        p3 = new JPanel(new GridLayout(2 , 1, 10 , 10));
        p3.add(p1);
        p3.add(p2);
        p3.setBorder(new EmptyBorder(10,10,10,10));

        add(p3,"South");

        String y [][] = new String[20][7];
        int i=0;
        int j=0;
        try{
            Connection_ c = new Connection_();
            String q = "select * from apply_leave;";
            ResultSet rs = c.stm.executeQuery(q);

            while (rs.next()){
                y[i][j++]=rs.getString(1);
                y[i][j++]=rs.getString(2);
                y[i][j++]=rs.getString(3);
                y[i][j++]=rs.getString(4);
                y[i][j++]=rs.getString(5);
                y[i][j++]=rs.getString(6);
                y[i][j++]=rs.getString(7);
                j=0;
                i++;

            }

            table = new JTable(y,x);
            JTableHeader h = table.getTableHeader();
            h.setBackground(Color.ORANGE);
            h.setForeground(Color.WHITE);
            h.setFont(f1);


            JScrollPane js = new JScrollPane(table);
            add(js);

            Border b = BorderFactory.createLineBorder(Color.ORANGE);
            t1.setBorder(b);
            table.setBorder(new EmptyBorder(10,10,10,10));




        }
        catch(Exception e){

        }



















        setVisible(true);

    }


    @Override
    public void actionPerformed(ActionEvent e) {
        String eid = t1.getText();
        new View_Leaves_Single(eid);
        setVisible(false);




    }

    public static void main(String[] args) {
        View_Leaves v = new View_Leaves();

    }
}
