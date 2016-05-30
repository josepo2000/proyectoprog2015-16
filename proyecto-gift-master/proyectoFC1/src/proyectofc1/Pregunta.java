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
public class Pregunta {
    private String enunciado;
    
    
   private List<Respuesta> r=new ArrayList<>();

    public List<Respuesta> getR() {
        return r;
    }

    public String getEnunciado() {
        return enunciado;
    }

    public void setEnunciado(String enunciado) {
        this.enunciado = enunciado;
    }

    
    
}
