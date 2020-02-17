/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Cabinet_veterinar_app;

//package testconnect1;

import java.sql.Connection;

import java.sql.DriverManager;

import java.sql.SQLException;

import static Cabinet_veterinar_app.DBconnect.connect;

/**
 *
 * @author alexa
 */
public class Main {

    /**
     * @param args the command line arguments
     */
     public static void main(String[] args) throws ClassNotFoundException {

        // TODO code application logic here

        connect(); 
     }
    
}
