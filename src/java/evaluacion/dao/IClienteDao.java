/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package evaluacion.dao;

import evaluacion.entity.Cliente;
import java.util.List;

/**
 *
 * @author jomad
 */
public interface IClienteDao {
    // INSERT, DELETE, UPDATE
    public int operacionesEscritura(int indicador, Cliente c);
    // SELECT 
    public List<Cliente> operacionesLectura(int indicador, Cliente c);
}
