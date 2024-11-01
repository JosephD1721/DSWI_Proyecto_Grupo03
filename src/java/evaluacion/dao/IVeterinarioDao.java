/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package evaluacion.dao;

import evaluacion.entity.Veterinario;
import java.util.List;

/**
 *
 * @author jomad
 */
public interface IVeterinarioDao {
    // INSERT, DELETE, UPDATE
    public int operacionesEscritura(int indicador, Veterinario v);
    // SELECT 
    public List<Veterinario> operacionesLectura(int indicador, Veterinario v);
}
