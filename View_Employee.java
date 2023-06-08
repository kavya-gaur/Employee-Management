import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class View_Employee extends JFrame implements ActionListener {
    JLabel l;
    JLabel l1;
    JTextField t;
    JButton btn1;
    JButton btn2;
    Font f;







    View_Employee(){
        setSize( 612,383);
        setLayout(null);
        setBounds(400 , 200 ,612,383);

        f = new Font("Segoe Print", Font.BOLD,30);
        Color c = new Color(22,52,101,255);
        l=new JLabel();
        l.setBounds(0,0,612,383);
        ImageIcon i = new ImageIcon(this.getClass().getResource("image/view6.jpg"));
        //Image i1 = i.getImage().getScaledInstance(700,400 , Image.SCALE_DEFAULT);
        //ImageIcon i2 = new ImageIcon(i1);
        l.setIcon(i);
        add(l);

        l1 = new JLabel("Employee Id");
        l1.setBounds(70,50,200,200);
        l1.setFont(f);
        l1.setForeground(Color.BLACK);
        l.add(l1);

        //textfield
        t = new JTextField();
        t.setBounds(360,135 , 200 , 30);
        l.add(t);

        //Jbutton
        btn1 = new JButton("Search");
        btn1.setBounds(170 , 230 ,100 ,50 );
        btn1.setBackground(Color.BLACK);
        btn1.setForeground(Color.WHITE);
        btn1.addActionListener(this);
        l.add(btn1);




        btn2 = new JButton("Cancel");
        btn2.setBounds(335 , 230 ,100 ,50 );
        btn2.setBackground(Color.BLACK);
        btn2.setForeground(Color.WHITE);
        btn2.addActionListener(this);
        l.add(btn2);






        setVisible(true);
    }


    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource()==btn1){
            setVisible(false);
            new View_Employee_Data(t.getText());

        }
        else{
            setVisible(false);
            new Homepage();
        }

    }


    public static void main(String[] args) {
        View_Employee v = new View_Employee();
    }


}
