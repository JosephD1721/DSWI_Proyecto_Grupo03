/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package evaluacion.impl;

import evaluacion.dao.IClienteDao;
import evaluacion.entity.Cliente;
import evaluacion.repository.ConexionMysql;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author jomad
 */
public class ClienteDaoImpl implements IClienteDao {
    @Override
    public int operacionesEscritura(int indicador, Cliente c) {
        ConexionMysql connection = new ConexionMysql();
        Connection con = null;
        CallableStatement cst = null;
        int procesar = -1;
        String procedimiento = "{call usp_clientes (?,?,?,?,?,?,?)}";
        try {
            con = connection.conectar();
            cst = con.prepareCall(procedimiento);
            cst.setInt(1, indicador);
            cst.setInt(2, c.getIdCliente());
            cst.setString(3, c.getNombre());
            cst.setString(4, c.getDireccion());
            cst.setString(5, c.getTelefono());
            cst.setString(6, c.getEmail());
            cst.setDate(7, java.sql.Date.valueOf(c.getFechaRegistro()));
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
    public List<Cliente> operacionesLectura(int indicador, Cliente c) {
        Connection con = null;
        CallableStatement cst = null;
        ResultSet rs = null;
        ConexionMysql connection = new ConexionMysql();
        List<Cliente> lista = new ArrayList<>();
        String procedimiento = "{call usp_clientes (?,?,?,?,?,?,?)}";
        try {
            con = connection.conectar();
            cst = con.prepareCall(procedimiento);
            cst.setInt(1, indicador);
            cst.setInt(2, c.getIdCliente());
            cst.setString(3, c.getNombre());
            cst.setString(4, c.getDireccion());
            cst.setString(5, c.getTelefono());
            cst.setString(6, c.getEmail());
            LocalDate fechaRegistro = LocalDate.now();
            cst.setDate(7, java.sql.Date.valueOf(fechaRegistro));
            rs = cst.executeQuery();
            Cliente objCliente;
            while (rs.next()) {
                objCliente = new Cliente();
                objCliente.setIdCliente(rs.getInt(1));
                objCliente.setNombre(rs.getString(2));
                objCliente.setDireccion(rs.getString(3));
                objCliente.setTelefono(rs.getString(4));
                objCliente.setEmail(rs.getString(5));
                objCliente.setFechaRegistro(rs.getDate(6).toLocalDate());
                lista.add(objCliente);
            }
        } catch (SQLException ex) {
             System.out.println("operacionesLectura - Error : " + ex.getMessage());
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
                System.out.println("Error al cerrar recursos : " + ex.getMessage());
            }
        }
        return lista;
    }
}
