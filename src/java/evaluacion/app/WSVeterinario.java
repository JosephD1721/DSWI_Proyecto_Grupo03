/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package evaluacion.app;

import evaluacion.entity.Veterinario;
import evaluacion.service.ServicioVeterinario;
import java.util.List;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
/**
 *
 * @author jomad
 */
@WebService(serviceName = "WSVeterinario")
public class WSVeterinario {
    @WebMethod(operationName = "ayuda")
    public String ayuda(@WebParam(name = "name") String nombre) {
        return "Autor " + nombre + " !";
    }
    
    @WebMethod(operationName = "listadoVeterinario")
    public List<Veterinario> listadoVeterinario(){
        System.out.println("....");
        ServicioVeterinario servicio = new ServicioVeterinario();
        Veterinario v= new Veterinario();
        v.setIdVeterinario(0);
        v.setNombre("");
        v.setEspecialidad("");
        v.setTelefono("");
        v.setEmail("");
        List<Veterinario> lista = servicio.operacionesLectura(3, v);
        return lista;
    }
}
