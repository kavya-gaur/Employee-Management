
import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.management.Query;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;


public class Login extends JFrame implements ActionListener{

    Font font = new Font("",Font.BOLD , 20);
    JLabel l1;
    JLabel l2;
    JPasswordField p1;
    TextField t1;
    JButton b1,b2;
    Login(){


        l1 = new JLabel("Username");
        l1.setFont(font);
        l1.setBounds(30 , 30 ,120 ,30);
        //l1.setSize(200 , 100);
        this.add(l1);

        l2 = new JLabel("Password");
        l2.setFont(font);
        l2.setBounds(30 ,90 , 120 , 30);

        this.add(l2);

        t1 = new TextField();
        t1.setBounds(160,30,180 , 30);
        this.add(t1);

        p1 = new JPasswordField();
        p1.setBounds(160,90,180 , 30);
        this.add(p1);

        b1 = new JButton("Login");
        b1.setBounds(30 , 150 , 80 , 40);
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        b1.addActionListener(this);
        this.add(b1);

        b2 = new JButton("Cancel");
        b2.setBounds( 140, 150 , 80 , 40);
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.WHITE);
        b2.addActionListener(this);
        this.add(b2);
        //this.getContentPane();


        JLabel img = new JLabel();
        ImageIcon img1 = new ImageIcon(ClassLoader.getSystemResource("image/lock1.png"));
        Image img2 = img1.getImage().getScaledInstance(100 , 100 ,Image.SCALE_DEFAULT);
        ImageIcon img3 = new ImageIcon(img2);
        img.setIcon(img3);
        img.setBounds(380 ,30 , 50 , 50);
        //img.setHorizontalAlignment(SwingConstants.RIGHT);
        this.add(img);

        this.setVisible(true);
        this.setTitle("Login");
        this.setSize(550 , 300);
        this.setBackground(Color.WHITE);
        this.setLayout(null);

    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==b1){
            try {
                Connection_ c = new Connection_();
                String u = t1.getText();
                String p = p1.getText();



                String q = "select * from employee where username = '" + u + "' and password = '" + p +"'";
                ResultSet rs = c.stm.executeQuery(q);
                if (rs.next()){
                    new Homepage();
                    System.out.println("Login...");
                }
                else{
                    JOptionPane.showMessageDialog(this , "You have entered wrong username or password");
                    this.setVisible(false);
                    this.setVisible(true);
                }

            }
            catch (ClassNotFoundException ex) {
                ex.printStackTrace();
            }
            catch (SQLException ex) {
                ex.printStackTrace();
            }

        }








        else{
            setVisible(false);



        }

    }
}



class Main{


    public static void main(String[] args) throws SQLException, ClassNotFoundException {

        Login l =new Login();

    }
}