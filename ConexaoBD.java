import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoBD 
{

   static 
   {
      try 
      {
         Class.forName("com.mysql.cj.jdbc.Driver");
      } 
      catch (ClassNotFoundException e)
      {
         throw new RuntimeException(e);
      }
   }

   public static Connection conectar() throws SQLException 
   {
      String servidor = "localhost";
      String porta = "3306";
      String database = "certificacao";
      String usuario = "root";
      String senha = "1234";
      String timeZone = "&useTimezone=true&serverTimezone=UTC";

      return DriverManager
         	.getConnection("jdbc:mysql://"+servidor+":"+porta+
            "/"+database+"?user="+usuario+"&password="+senha + timeZone);
   }

   public static void desconectar(Connection conn) throws SQLException 
   {
      conn.close();
   }
}
