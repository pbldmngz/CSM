package com.example.csm;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLIntegrityConstraintViolationException;

public class Connect {
    public static final String URL = "jdbc:mysql://localhost:3306/csm_database?autoReconnect=true&useSSL=false";
    public static final String mysql_user = "spectra";
    public static final String mysql_pass = "123456789";

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

    public static void updateDB(String statement)
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
    {   //Esto no devuelve datos utilizables, devuelve el resultSet,
        // Falta crear el objeto de la consulta y darla las características,
        // luego utilizar algo como:
        //    while(result.next()) {
        //      Product prod = new Product();
        //      prod.setTotal(result.getDouble("total"))
        //      products.add(prod); //Añadir el objeto a una lista
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
}
