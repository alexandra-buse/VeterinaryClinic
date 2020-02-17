/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Cabinet_veterinar_app;

/**
 *
 * @author alexa
 */
import java.sql.Connection;

import java.sql.DriverManager;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;


public class DBconnect {

    public static Connection connect(){ //throws ClassNotFoundException{ 

    Connection con =null; 

        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DBconnect.class.getName()).log(Level.SEVERE, null, ex);
        }

    String connectionURL="jdbc:sqlserver://localhost:1433;databaseName=Cabinet_veterinar;user=alexandra;password=12345"; 

    try{

    con=DriverManager.getConnection(connectionURL);
    System.out.println("Connection is successfull");

    }

    catch(SQLException e){

     System.out.println(e);

    }
        return con;
    }

}

