import javax.swing.*;
import javax.swing.plaf.TableHeaderUI;
import javax.swing.table.JTableHeader;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class View_Attendance_Single extends JFrame implements ActionListener {
    JTable table;
    String y [][];
    String x [];
    Color c;
    Font f1;


    View_Attendance_Single(String eid){
        c = new Color(249,150,69,255);
        f1 = new Font("Microsoft JhengHei UEI",Font.BOLD,20);
        setTitle("Details");
        setSize(1480,400);
        setLocation(32,200);
        y = new String [20][6];











        int i=0;
        int j=0;
        String x[] = {"Name","Employee Id","Email","First Half","Second Half","Date"};
        int count=0;

        try {
            Connection_ c = new Connection_();
            String q = "select * from attendance where Employee_Id = '" + eid +"';";
            ResultSet rs = c.stm.executeQuery(q);

            while(rs.next()) {
                count++;
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
        if (count==0){
            setVisible(true);
            JOptionPane.showMessageDialog(this,"No records found");
            setVisible(false);
        }
        else {
            table = new JTable(y, x);
            JTableHeader h = table.getTableHeader();
            h.setBackground(c);
            h.setForeground(Color.WHITE);
            h.setFont(f1);




            JScrollPane js = new JScrollPane(table);
            add(js);
            setVisible(true);

        }

    }
    @Override
    public void actionPerformed(ActionEvent e) {

    }




}
