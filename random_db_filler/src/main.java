import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
//import java.sql.ResultSet;

public class main {
    public static final String URL = "jdbc:mysql://localhost:3306/csm_database?autoReconnect=true&useSSL=false";
    public static final String mysql_user = "spectra";
    public static final String mysql_pass = "123456789";

    public static void main(String[] args)
    {
        alumnoGen();
    }

    public static Connection getConnection()
    {
        Connection con = null;
        try {
            System.out.println("1");
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = (Connection) DriverManager.getConnection(URL, mysql_user, mysql_pass);
            System.out.println("Connection successful");
        } catch (Exception e) {
            System.out.println(e);
        }
        return con;
    }

    public static void insertData(String statement)
    {
        Connection con = getConnection();
        try {
            System.out.println("Probando para alumno con este statement: " + statement);
            PreparedStatement st = (PreparedStatement) con.prepareStatement(statement);
            int rs = st.executeUpdate();
        } catch (Exception e){
            System.out.println(e);
        }
    }

    public static void alumnoGen()
    {
        int id_alumno = 2;
        String nombre = "pablo";
        String primer_apellido = "dominguez";
        String segundo_apellido = "medina";
        String correo = nombre + "." + primer_apellido + "." + id_alumno + "@cetys.edu.mx";
        int id_grupo = 2;
        insertData("insert into alumno (id_alumno, correo, nombre, primer_apellido, segundo_apellido, id_grupo) values ("+
                id_alumno +", '"+ correo +"', '"+ nombre +"', '"+ primer_apellido +"', '"+ segundo_apellido +"', "+ id_grupo +")");
        System.out.println("Alumno generado, correo: " + correo);
    }
}
