import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.*;

public class Connection_ {
    Statement stm;
    Connection_() throws ClassNotFoundException, SQLException {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hello?" + "autoReconnect=true&useSSL=false" , "root" , "Kavya@123");
            stm = con.createStatement();












    }





}

class Mmain{
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        Connection_ c = new Connection_();

    }
}
