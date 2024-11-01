/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package evaluacion.app;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author jomad
 */
public class ConexionBD {
    public static void main(String[] args) throws SQLException {
        Connection con = null;
        CallableStatement cst = null;
        ResultSet rs = null;
        try {
            String objetoBD = "{call usp_veterinarios (?,?,?,?,?,?)}";
            con = conexion();
            cst = con.prepareCall(objetoBD);
            cst.setInt(1, 3);
            cst.setInt(2, 0);
            cst.setString(3, "");
            cst.setString(4, "");
            cst.setString(5, "");
            cst.setString(6, "");
            rs = cst.executeQuery();
            while (rs.next()) {
                System.out.println(
                        "\nId: " + rs.getInt("id_veterinario") + "\nNombre: " + rs.getString("nombre") + "\nEspecialidad: " + rs.getString("especialidad"));
            }

        } catch (Exception ex) {
            System.out.println("Error : " + ex.getMessage());
        } finally {
            rs.close();
            cst.close();
            con.close();
        }
    }
    
    public static Connection conexion() throws ClassNotFoundException {
        Connection con = null;
        Class.forName("com.mysql.cj.jdbc.Driver");
        String url = "jdbc:mysql://localhost:3306/veterinaria";
        try {
            con = DriverManager.getConnection(url, "root", "Mariel1721*");
        } catch (Exception ex) {
            System.out.println("conexion-Error: " + ex.getMessage());
        }
        return con;
    }
}
