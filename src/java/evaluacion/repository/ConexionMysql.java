/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package evaluacion.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author jomad
 */
public class ConexionMysql {
    public Connection conectar()  {
        Connection con = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/veterinaria?useSSL=false";
            String user = "root";
            String password = "Mariel1721*";
            con = DriverManager.getConnection(url, user, password);
        } catch (SQLException ex) {
            System.out.println("Error : " + ex.getMessage());
        } catch(ClassNotFoundException ex){
            System.out.println("Error : " + ex.getMessage());
        }catch(Exception ex){
            System.out.println("Error : " + ex.getMessage());
        }
        return con;
    }
}
