/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package evaluacion.impl;

import evaluacion.dao.IVeterinarioDao;
import evaluacion.entity.Veterinario;
import evaluacion.repository.ConexionMysql;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author jomad
 */
public class VeterinarioDaoImpl implements IVeterinarioDao {

    @Override
    public int operacionesEscritura(int indicador, Veterinario v) {
        ConexionMysql connection = new ConexionMysql();
        Connection con = null;
        CallableStatement cst = null;
        int procesar = -1;
        String procedimiento = "{call usp_veterinarios (?,?,?,?,?,?)}";
        try {
            con = connection.conectar();
            cst = con.prepareCall(procedimiento);
            cst.setInt(1, indicador);
            cst.setInt(2, v.getIdVeterinario());
            cst.setString(3, v.getNombre());
            cst.setString(4, v.getEspecialidad());
            cst.setString(5, v.getTelefono());
            cst.setString(6, v.getEmail());
            procesar = cst.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("operacionesEscritura - Error : " + ex.getMessage());
        } finally {
            try {
                if (cst != null) {
                    cst.close();
                }
                if (con != null) {
                    con.close();
                }
            } catch (SQLException ex) {
                System.out.println("Error : " + ex.getMessage());
            }
        }
        return procesar;
    }

    @Override
    public List<Veterinario> operacionesLectura(int indicador, Veterinario v) {
        Connection con = null;
        CallableStatement cst = null;
        ResultSet rs = null;
        ConexionMysql connection = new ConexionMysql();
        List<Veterinario> lista = new ArrayList<>();
        String procedimiento = "{call usp_veterinarios (?,?,?,?,?,?)}";
        try {
            con = connection.conectar();
            cst = con.prepareCall(procedimiento);
            cst.setInt(1, indicador);
            cst.setInt(2, v.getIdVeterinario());
            cst.setString(3, v.getNombre());
            cst.setString(4, v.getEspecialidad());
            cst.setString(5, v.getTelefono());
            cst.setString(6, v.getEmail());
            rs = cst.executeQuery();
            Veterinario objVeterinario;
            while (rs.next()) {
                objVeterinario = new Veterinario();
                objVeterinario.setIdVeterinario(rs.getInt(1));
                objVeterinario.setNombre(rs.getString(2));
                objVeterinario.setEspecialidad(rs.getString(3));
                objVeterinario.setTelefono(rs.getString(4));
                objVeterinario.setEmail(rs.getString(5));
                lista.add(objVeterinario);
            }
        } catch (SQLException ex) {

        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (cst != null) {
                    cst.close();
                }
                if (con != null) {
                    con.close();
                }
            } catch (SQLException ex) {
            }
        }
        return lista;
    }
}
