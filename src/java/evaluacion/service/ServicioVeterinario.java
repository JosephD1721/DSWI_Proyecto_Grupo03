/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package evaluacion.service;

import evaluacion.dao.IVeterinarioDao;
import evaluacion.entity.Veterinario;
import evaluacion.impl.VeterinarioDaoImpl;
import java.util.List;

/**
 *
 * @author jomad
 */
public class ServicioVeterinario {
    public int operacionesEscritura(int indicador, Veterinario v){
        IVeterinarioDao dao = new VeterinarioDaoImpl();
        return dao.operacionesEscritura(indicador, v);
    }
    
    public List<Veterinario> operacionesLectura(int indicador, Veterinario v){
        IVeterinarioDao dao = new VeterinarioDaoImpl();
        return dao.operacionesLectura(indicador, v);
    }
}
