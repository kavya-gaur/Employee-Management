


import java.awt.*;
import java.awt.event.*;
import javax.swing.*;





public class Homepage extends JFrame implements ActionListener {
    JFrame f;
    Font font = new Font("",Font.BOLD , 30);



    Homepage() {
        this.setLayout(null);
        this.setSize(1550,800);
        this.setTitle("Employee Homepage");

        //setSize(900, 900);
        setLayout(new BorderLayout());

        JMenuBar m1 = new JMenuBar();
        JMenu men1 = new JMenu("Profile");
        JMenuItem ment1 = new JMenuItem("Complete Profile");
        JMenuItem ment2 = new JMenuItem("View Profile");
        men1.add(ment1 );
        men1.add(ment2 );


        JMenu men2 = new JMenu("Manage");
        JMenuItem ment3 = new JMenuItem("Update Details");
        men2.add(ment3);

        JMenu men3 = new JMenu("Attendance");
        JMenuItem ment4 = new JMenuItem("Take Attendance");
        JMenuItem ment5 = new JMenuItem("View Attendance");
        men3.add(ment4);
        men3.add(ment5);

        JMenu men4 = new JMenu("Leave");
        JMenuItem ment6 = new JMenuItem("Apply Leave");
        JMenuItem ment7 = new JMenuItem("View Leaves");
        men4.add(ment6);
        men4.add(ment7);

        JMenu men5 = new JMenu("Salary");
        JMenuItem ment8 = new JMenuItem("Add Salary");
        JMenuItem ment9 = new JMenuItem("Generate Salary Slip");
        men5.add(ment8);
        men5.add(ment9);

        JMenu men6 = new JMenu("Delete");
        JMenuItem ment10 = new JMenuItem("Delete Employee");
        men6.add(ment10);

        JMenu men7 = new JMenu("Exit");
        JMenuItem ment11 = new JMenuItem("Logout");
        men7.add(ment11);

        ment1.addActionListener(this);
        ment2.addActionListener(this);
        ment3.addActionListener(this);
        ment4.addActionListener(this);
        ment5.addActionListener(this);
        ment6.addActionListener(this);
        ment7.addActionListener(this);
        ment8.addActionListener(this);
        ment9.addActionListener(this);
        ment10.addActionListener(this);
        ment11.addActionListener(this);





        m1.add(men1);
        m1.add(men2);
        m1.add(men3);
        m1.add(men4);
        m1.add(men5);
        m1.add(men6);
        m1.add(men7);

        men1.setFont(font);
        men2.setFont(font);
        men3.setFont(font);
        men4.setFont(font);
        men5.setFont(font);
        men6.setFont(font);
        men7.setFont(font);


        Color mycolour = new Color(56,90,100,255);
        Color mycolour1 = new Color(225,225,225,255);
        Color mycolour2 = new Color(56,169,150,255);
        Color mycolour3 = new Color(243,116,55,255);

        men1.setForeground(mycolour);
        men2.setForeground(mycolour);
        men3.setForeground(mycolour);
        men4.setForeground(mycolour);
        men5.setForeground(mycolour);
        men6.setForeground(mycolour);
        men7.setForeground(mycolour);


        ment1.setForeground(mycolour2);
        ment2.setForeground(mycolour2);
        ment3.setForeground(mycolour2);
        ment4.setForeground(mycolour2);
        ment5.setForeground(mycolour2);
        ment6.setForeground(mycolour2);
        ment7.setForeground(mycolour2);
        ment8.setForeground(mycolour2);
        ment9.setForeground(mycolour2);
        ment10.setForeground(mycolour2);
        ment11.setForeground(mycolour2);

        men7.setForeground(mycolour3);



        JLabel label = new JLabel(); //JLabel Creation
        ImageIcon img = new ImageIcon(this.getClass().getResource("image/employees.png"));
        Image img1 = img.getImage().getScaledInstance(1550 , 800 , Image.SCALE_DEFAULT);
        ImageIcon img2 = new ImageIcon(img1);
        label.setIcon(img2);
        label.setHorizontalAlignment(SwingConstants.CENTER);
        this.add(label);
//        Container c = this.getContentPane();
//        label.setIcon(new ImageIcon("image/employee.png")); //Sets the image to be displayed as an icon
//        Dimension size = label.getPreferredSize(); //Gets the size of the image
//        label.setBounds(100, 200, size.width, size.height);
//        c.add(label , BorderLayout.CENTER);












        m1.setBackground(mycolour1);

        this.add(m1 , BorderLayout.NORTH);
        this.setVisible(true);


    }


    @Override
    public void actionPerformed(ActionEvent e) {
        String cmnd = e.getActionCommand();
        if (cmnd.equals("Complete Profile")){
             new Add_Employee();
        }
        else if(cmnd.equals("View Profile")){
            new View_Employee();
        }
        else if (cmnd.equals("Update Details")){
            new Update_Details_Data();
        }
        else if (cmnd.equals("Take Attendance")){
            new Employee_Attendance();
        }
        else if (cmnd.equals("View Attendance")){
            new View_Attendance();
        }
        else if (cmnd.equals("Apply Leave")){
            new Apply_Employee_Leave();
        }
        else if (cmnd.equals("View Leaves")){
            new View_Leaves();
        }
        else if (cmnd.equals("Add Salary")){
            new Salary();
        }
        else if (cmnd.equals("Generate Salary Slip")){
            new Generate_PaySlip();
        }
        else if (cmnd.equals("Delete Employee")){
            new Delete_Employee().setVisible(true);
        }
        else if (cmnd.equals("Logout")){
            setVisible(false);
        }









    }
}


class Maain{
    public static void main(String[] args) {
        Homepage h = new Homepage();
    }

}
