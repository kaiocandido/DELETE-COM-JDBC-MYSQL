import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Connection conn = null;
        PreparedStatement pr = null;

        try {
            conn = DB.conectedDB();
            pr = conn.prepareStatement(
                    "DELETE FROM department "
                    + "WHERE "
                    + "Id = ?"
            );

            pr.setInt(1, 2);


            int rowAffected = pr.executeUpdate();
            System.out.println("Done!! " + rowAffected);

        }catch (SQLException e){
            throw new DBIntegretyException(e.getMessage());
        }finally {
            DB.closeStantment(pr);
            DB.closeConnection();
        }

    }
}