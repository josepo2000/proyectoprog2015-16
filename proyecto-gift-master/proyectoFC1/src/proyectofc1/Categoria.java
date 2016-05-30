/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package proyectofc1;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author joseba
 */
public class Categoria {
    
    
    private String nombre;
    private String tipo;
    
    private List<Pregunta>p=new ArrayList<>();

    @Override
    public String toString() {
        return "Categoria{" + "nombre=" + nombre + ", tipo=" + tipo + ", p=" + p + '}';
    }

    public List<Pregunta> getP() {
        return p;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    
    
    
    
    
}
