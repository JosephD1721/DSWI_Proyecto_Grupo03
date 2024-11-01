/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package evaluacion.service;

import evaluacion.dao.IClienteDao;
import evaluacion.entity.Cliente;
import evaluacion.impl.ClienteDaoImpl;
import java.util.List;

/**
 *
 * @author jomad
 */
public class ServicioCliente {
    public int operacionesEscritura(int indicador, Cliente c){
        IClienteDao dao = new ClienteDaoImpl();
        return dao.operacionesEscritura(indicador, c);
    }
    
    public List<Cliente> operacionesLectura(int indicador, Cliente c){
        IClienteDao dao = new ClienteDaoImpl();
        return dao.operacionesLectura(indicador, c);
    }
}
