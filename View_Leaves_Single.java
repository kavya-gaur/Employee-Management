import javax.swing.*;
import javax.swing.table.JTableHeader;
import java.awt.*;
import java.sql.ResultSet;

public class View_Leaves_Single extends JFrame {

    JTable table;
    String x [];
    String y [][];
    Font f1,f2;




    View_Leaves_Single(String eid) {


        setSize(1480, 400);
        setLocation(32, 200);

        f1 = new Font("Comic Sans MS", Font.PLAIN, 20);
        f2 = new Font("Comic Sans MS", Font.BOLD, 20);


        String x[] = {"Name", "Employee Id", "Email", "Start Date", "End Date", "Reason", "Apply Date"};
        String y [][] = new String[20][7];
        int i=0;
        int j=0;
        int count =0;
        try {
            Connection_ c = new Connection_();
            String q = "select * from apply_leave where Employee_Id = '"+eid+"';";
            ResultSet rs = c.stm.executeQuery(q);

            while (rs.next()) {
                y[i][j++] = rs.getString(1);
                y[i][j++] = rs.getString(2);
                y[i][j++] = rs.getString(3);
                y[i][j++] = rs.getString(4);
                y[i][j++] = rs.getString(5);
                y[i][j++] = rs.getString(6);
                y[i][j++] = rs.getString(7);
                count++;
                j = 0;
                i++;

            }
        }
        catch(Exception exc){

        }
        if (count==0){
            JOptionPane.showMessageDialog(this , "No records found");
            setVisible(false);
        }
        else {
            table = new JTable(y, x);
            JTableHeader h = table.getTableHeader();
            h.setBackground(Color.ORANGE);
            h.setForeground(Color.WHITE);
            h.setFont(f1);

            JScrollPane js = new JScrollPane(table);
            add(js);


            setVisible(true);
        }
    }

    public static void main(String[] args) {

    }







}
