/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package evaluacion.app;

import evaluacion.entity.Cliente;
import evaluacion.service.ServicioCliente;
import java.util.List;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
/**
 *
 * @author jomad
 */
@WebService(serviceName = "WSCliente")
public class WSCliente {
    @WebMethod(operationName = "ayuda")
    public String ayuda(@WebParam(name = "name") String nombre) {
        return "Autor " + nombre + " !";
    }
    
    @WebMethod(operationName = "listadoCliente")
    public List<Cliente> listadoCliente(){
        System.out.println("....");
        ServicioCliente servicio = new ServicioCliente();
        Cliente c= new Cliente();
        c.setIdCliente(0);
        c.setNombre("");
        c.setDireccion("");
        c.setTelefono("");
        c.setEmail("");
        List<Cliente> lista = servicio.operacionesLectura(3, c);
        return lista;
    }
}
