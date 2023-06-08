import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.JTableHeader;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class View_Attendance extends JFrame implements ActionListener {
        JTable table;
        JPanel p1,p2,p3;
        JButton btn1;
        JTextField t;
        JLabel l1,l2;
        String y [][];
        String x [];
        Font f1,f2;
        Color c;




    View_Attendance(){
        c = new Color(249,150,69,255);
        setSize(1480,400);
        setLocation(32,200);
        y = new String [20][6];
        f1 = new Font("Microsoft JhengHei UEI",Font.PLAIN,20);
        f2 = new Font("Microsoft JhengHei UEI",Font.BOLD,20);
        int i=0;
        int j=0;
        String x[] = {"Name","Employee Id","Email","First Half","Second Half","Date"};

        try {
            Connection_ c = new Connection_();
            String q = "select * from attendance;";
            ResultSet rs = c.stm.executeQuery(q);

            while(rs.next()) {

                        y[i][j++]=rs.getString(1);
                        y[i][j++]=rs.getString(2);
                        y[i][j++]=rs.getString(3);
                        y[i][j++]=rs.getString(4);
                        y[i][j++]=rs.getString(5);
                        y[i][j++]=rs.getString(6);
                        j=0;
                        i++;

            }

        }
        catch (Exception e){

        }
        table = new JTable(y,x);

        l1 = new JLabel("Search Any Employee");
        l1.setFont(f2);
        l1.setHorizontalAlignment(JLabel.CENTER);

        l2 = new JLabel("Employee Id");
        l2.setFont(f2);

        t = new JTextField();
        t.setFont(f2);

        btn1 = new JButton("Search");
        btn1.setForeground(Color.WHITE);
        btn1.setFont(f1);
        btn1.setBackground(Color.BLACK);
        btn1.addActionListener(this);


        p1 = new JPanel(new GridLayout(1,1,10,10));
        p1.add(l1);

        p2 = new JPanel(new GridLayout(1,3,10,10));
        p2.add(l2);
        p2.add(t);
        p2.add(btn1);

        p3 = new JPanel(new GridLayout(2,1,10,10));
        p3.add(p1);
        p3.add(p2);
        p3.setBorder(new EmptyBorder(10,10,10,10));
        add(p3,"South");

        JScrollPane js = new JScrollPane(table);
        add(js);
        //add(table,"North");

        JTableHeader h = table.getTableHeader();
        h.setBackground(c);
        h.setForeground(Color.WHITE);
        h.setFont(f2);
















        setVisible(true);









    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==btn1){
            String eid = t.getText();
            new View_Attendance_Single(eid);
        }

    }

    public static void main(String[] args) {
        View_Attendance v = new View_Attendance();
    }
}
