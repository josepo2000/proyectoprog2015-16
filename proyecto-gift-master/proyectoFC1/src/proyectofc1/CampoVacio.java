package proyectofc1;

public class CampoVacio extends Exception {

    private String campo;

    // Constructor sobrecargado
    public CampoVacio() {
    }

    public CampoVacio(String campo) {
        this.campo = campo;
    }

    
   
    }

