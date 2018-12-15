import java.sql.Connection;
import java.sql.SQLException;

public class TesteCurso
{
    public static void main(String[] args) throws SQLException
    {
        new Tabela(new ConexaoBD().conectar());
    }
}