import java.sql.*;
//import java.sql.ResultSet;

public class main {
    public static final String URL = "jdbc:mysql://localhost:3306/csm_database?autoReconnect=true&useSSL=false";
    public static final String mysql_user = "spectra";
    public static final String mysql_pass = "123456789";

    public static void main(String[] args)
    {
        //classicStart(24, 500);
        notificationGen(23, 50);
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

    public static void classicStart(int profesores, int alumnos)
    {
        for (int i = 1; i < profesores; i++)
        {
            profesorGen(i);
        }
        for (int i = 1; i < alumnos; i++)
        {
            alumnoGen(i);
        }
    }

    public static void notificationGen(int maxIndex, int cantidad)
    {
        for (int i = 0; i < cantidad; i++)
        {
            insertData("insert into notificacion (contenido, id_emisor, id_receptor) values ('" + messageGen()
                    + "', " + (int) (Math.random() * maxIndex) + ", " + (int) (Math.random() * maxIndex) + ")");
        }
    }

    public static void insertData(String statement)
    {
        Connection con = getConnection();
        try {
            System.out.println("Se ha pasado este statement: " + statement);
            PreparedStatement st = (PreparedStatement) con.prepareStatement(statement);
            int rs = st.executeUpdate();
        } catch (SQLIntegrityConstraintViolationException e){
            System.out.println("Ya existe un perfil con este ID, se pasará al siguiente");
        } catch (Exception ex)
        {
            ex.printStackTrace();
            System.exit(0);
        }
    }

    public static ResultSet getDataRS(String statement)
    {
        Connection con = getConnection();
        ResultSet rs = null;
        try {
            System.out.println("Se ha pasado este statement: " + statement);
            PreparedStatement st = (PreparedStatement) con.prepareStatement(statement);
            rs = st.executeQuery();
        } catch (Exception ex)
        {
            ex.printStackTrace();
            System.exit(0);
        }
        return rs;
    }

    public static void alumnoGen(int id)
    {
        int id_alumno = id;
        String nombre = nombreGen(true);
        String primer_apellido = nombreGen(false);
        String segundo_apellido = nombreGen(false);
        String correo = nombre + "." + primer_apellido + "." + id_alumno + "@cetys.edu.mx";
        int id_grupo = (int) (Math.random() * 8);
        insertData("insert into alumno (id_alumno, correo, nombre, primer_apellido, segundo_apellido, id_grupo) values ("+
                id_alumno +", '"+ correo +"', '"+ nombre +"', '"+ primer_apellido +"', '"+ segundo_apellido +"', "+ id_grupo +")");
        System.out.println("Alumno generado, correo: " + correo);
        asignarMateria(false, id_alumno);
    }

    public static void profesorGen(int id)
    {
        int id_empleado = id;
        String nombre = nombreGen(true);
        String primer_apellido = nombreGen(false);
        String segundo_apellido = nombreGen(false);
        String correo = nombre + "." + primer_apellido + "." + id_empleado + "@cetys.mx";
        String telefono = telGen();
        insertData("insert into profesor (id_empleado, correo, nombre, primer_apellido, segundo_apellido, telefono) values ("+
                id_empleado +", '"+ correo +"', '"+ nombre +"', '"+ primer_apellido +"', '"+ segundo_apellido +"', "+ telefono +")");
        System.out.println("Profesor generado, correo: " + correo);
        asignarMateria(true, id_empleado);
    }

    public static void asignarMateria(boolean esProfesor, int id)
    {
        String opcion = esProfesor ? "materia_profesor":"materia_alumno";
        for (int i = 0; i < 7; i++){
            if ((int) (Math.random() * 4) == 2){
                insertData("insert into " + opcion + " values (" + i + ", "+ id + ")");
            }
        }

    }

    public static String telGen()
    {
        String n = "";
        for (int i = 0; i < 10; i++)
        {
            n += (int) (Math.random() * 9) + "";
        }
        return n;
    }
    public static String nombreGen(boolean isName)
    {
        String[] nombres = { "Andrea", "David", "Baldomero", "Balduino", "Baldwin", "Baltasar", "Barry", "Bartolo",
                "Bartolomé", "Baruc", "Baruj", "Candelaria", "Cándida", "Canela", "Caridad", "Carina", "Carisa",
                "Caritina", "Carlota", "Baltazar", "Arturo", "Juan", "José", "Luis", "José", "María", "Guadalupe", "Francisco", "Guadalupe", "María", "Juana", "Antonio", "Jesús", "Miguel", "Ángel", "Pedro", "Alejandro", "Manuel", "Margarita", "María", "Del", "Carmen", "Juan", "Carlos", "Roberto", "Fernando", "Daniel", "Carlos", "Jorge", "Ricardo", "Miguel", "Eduardo", "Javier", "Rafael",
                "Martín", "Raúl", "David", "Josefina", "José", "Antonio", "Arturo", "Marco", "Antonio", "José", "Manuel", "Francisco", "Javier", "Enrique", "Verónica", "Gerardo", "María", "Elena", "Leticia", "Rosa", "Mario", "Francisca", "Alfredo", "Teresa", "Alicia", "María", "Fernanda", "Sergio", "Alberto", "Luis", "Armando", "Alejandra", "Martha", "Santiago", "Yolanda", "Patricia", "María", "De", "Los", "Ángeles", "Juan", "Manuel", "Rosa", "María", "Elizabeth", "Gloria", "Ángel", "Gabriela", "Salvador", "Víctor", "Manuel", "Silvia", "María", "De", "Guadalupe", "María", "De", "Jesús", "Gabriel", "Andrés", "Óscar", "Guillermo", "Ana", "María", "Ramón", "María", "Isabel", "Pablo", "Ruben", "Antonia", "María", "Luisa", "Luis", "Ángel", "María", "Del", "Rosario", "Felipe", "Jorge", "Jesús", "Jaime", "José", "Guadalupe", "Julio", "Cesar", "José", "De", "Jesús", "Diego", "Araceli", "Andrea", "Isabel", "María", "Teresa", "Irma", "Carmen", "Lucía", "Adriana", "Agustín", "María", "De", "La", "Luz", "Gustavo"};
        String[] apellidos = { "Gomez", "Guerrero", "Cardenas", "Cardiel", "Cardona", "Cardoso", "Cariaga", "Carillo",
                "Carion", "Castiyo", "Castorena", "Castro", "Grande", "Grangenal", "Grano", "Grasia", "Griego",
                "Grigalva", "Fernandez", "Quevedo", "Pendragon", "Garcia", "Gonzalez", "Rodriguez", "Fernandez", "Lopez", "Martinez", "Sanchez", "Perez", "Gomez", "Martin", "Jimenez", "Ruiz", "Hernandez", "Diaz", "Moreno", "Alvarez", "Muñoz", "Romero", "Alonso", "Gutierrez", "Navarro", "Torres", "Dominguez", "Vazquez", "Ramos", "Gil", "Ramirez", "Serrano", "Blanco", "Suarez", "Molina", "Morales", "Ortega", "Delgado", "Castro", "Ortiz", "Rubio", "Marin", "Sanz", "Nuñez", "Iglesias", "Medina", "Garrido", "Santos", "Castillo", "Cortes", "Lozano", "Guerrero", "Cano", "Prieto", "Mendez", "Calvo", "Cruz", "Gallego", "Vidal", "Leon", "Herrera", "Marquez", "Peña", "Cabrera", "Flores", "Campos", "Vega", "Diez", "Fuentes", "Carrasco", "Caballero", "Nieto", "Reyes", "Aguilar", "Pascual", "Herrero", "Santana", "Lorenzo", "Hidalgo", "Montero", "Ibañez", "Gimenez", "Ferrer", "Duran", "Vicente", "Benitez", "Mora", "Santiago", "Arias", "Varga", "Carmona", "Crespo", "Roman", "Pastor", "Soto", "Saez", "Velasco", "Soler", "Moya", "Esteban", "Parra", "Bravo", "Gallardo", "Rojas" };

        int random = isName ? (int) (Math.random() * nombres.length - 1) : (int) (Math.random() * apellidos.length - 1);

        return isName ? nombres[random] : apellidos[random];
    }

    public static String messageGen()
    {
        String[] palabras = {  };
        return "esto es un texto de prueba, eventualmente será algo más elegante";
    }
}
