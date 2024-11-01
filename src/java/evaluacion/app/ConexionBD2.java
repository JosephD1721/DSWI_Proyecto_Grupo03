/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package evaluacion.app;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

/**
 *
 * @author jomad
 */
public class ConexionBD2 {

    public static void main(String[] args) throws SQLException {
        Connection con = null;
        CallableStatement cst = null;
        ResultSet rs = null;
        try {
            String objetoBD = "{call usp_clientes (?,?,?,?,?,?,?)}";
            con = conexion();
            cst = con.prepareCall(objetoBD);
            // INSERTAR - ACTUALIZAR - ELIMINAR
//            cst.setInt(1, 1);
//            cst.setInt(2, 7);
//            cst.setString(3, "Carlos Antonio");
//            cst.setString(4, "Av. Tupac 1402");
//            cst.setString(5, "999888777");
//            cst.setString(6, "carlos.antonio@gmail.com");
//            LocalDate fechaRegistro = LocalDate.now();
//            cst.setDate(7, java.sql.Date.valueOf(fechaRegistro));
//            rs = cst.executeQuery();
            //CONSULTAR
            cst.setInt(1, 3);
            cst.setInt(2, 0);
            cst.setString(3, "");
            cst.setString(4, "");
            cst.setString(5, "");
            cst.setString(6, "");
            LocalDate fechaRegistro = LocalDate.now();
            cst.setDate(7, java.sql.Date.valueOf(fechaRegistro));
            rs = cst.executeQuery();
            while (rs.next()) {
                Date fecha = rs.getDate("fecha_registro");
                System.out.println(
                        "\nId: " + rs.getInt("id_cliente") + 
                        "\nNombre: " + rs.getString("nombre") + 
                        "\nDireccion: " + rs.getString("direccion") + 
                        "\nFecha: " + (fecha != null ? fecha.toLocalDate() : "No disponible"));
            }

        } catch (Exception ex) {
            System.out.println("Error : " + ex.getMessage());
        } finally {
            if (rs != null) rs.close();
            if (cst != null) cst.close();
            if (con != null) con.close();
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
