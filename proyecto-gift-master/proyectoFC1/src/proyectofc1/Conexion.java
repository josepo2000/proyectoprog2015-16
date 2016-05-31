/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectofc1;

import java.sql.*;
import java.util.ArrayList;

/**
 *
 * @author 1gbd09
 */
public class Conexion {

    
    
    public static Connection con;
    private static PreparedStatement sentenciaCon;
    private static String plantilla;
    private static Statement sentencia;
    private static ResultSet resultado;
    
    private static Categoria categoria;
    private static Pregunta pregunta;
/**
 * conexion con la base de datos
 */
    public static void conectarBD() {
        try {
            DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
            String bd = "orcl";
            String login = "scott"; 
            String password = "bov";
            String url = "jdbc:oracle:thin:@server5560:1521:" + bd;

            con= DriverManager.getConnection(url, login, password);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
/**
 * cerrar la base de datos
 */
    public static void cerrarBD() {
        try {
            con.close();
        } catch (Exception e) {
        }

    }
/**
 * obtener el objeto connection
 * @return 
 */
    public static Connection getCon() {
        return con;
    }

     public static void crearCategoria(String nombre,String tipo) throws Exception {
        Conexion.conectarBD();
         System.out.println("conexion realizada"); 
        ResultSet comprobarrset = con.createStatement().executeQuery("SELECT * FROM CATEGORIA WHERE NOMBRE = '" + nombre + "'");
        if(comprobarrset.next()){
            System.out.println("Categoria ya existe");
        }else{
        
        plantilla = "Insert into categoria (nombre,tipo)";
        sentenciaCon = Conexion.getCon().prepareStatement(plantilla);
        sentenciaCon.setString(1, nombre);
        sentenciaCon.setString(2, tipo);
        sentenciaCon.executeUpdate();
        Conexion.getCon().commit();
        Conexion.cerrarBD();
        }
    }
     public static void crearPregunta(String enunciado,String nombre)throws Exception{
         Conexion.conectarBD();
         ResultSet comprobarrset = con.createStatement().executeQuery("SELECT * FROM Pregunta WHERE enunciado = '" + enunciado + "'");
        if(comprobarrset.next()){
            System.out.println("Pregunta ya existe");
                 
        }else{
            
               
        plantilla = "Insert into pregunta (enunciado,nombre)";
        sentenciaCon = Conexion.getCon().prepareStatement(plantilla);
        sentenciaCon.setString(1, enunciado);
        sentenciaCon.setString(2, nombre);
        sentenciaCon.executeUpdate();
        Conexion.getCon().commit();
        Conexion.cerrarBD();
        } 
     }
    public static void crearRespuesta(String enunciado,String texto,boolean solucion) throws SQLException{
        Conexion.conectarBD();
        plantilla = "Insert into respuesta (enunciado,texto,solucion)";
        sentenciaCon=Conexion.getCon().prepareStatement(plantilla);
        sentenciaCon.setString(1, enunciado);
        sentenciaCon.setString(2, texto);
        sentenciaCon.setBoolean(3,solucion);
        sentenciaCon.executeUpdate();
     
    }
    public static ArrayList<Categoria> listadocategorias() throws Exception {

        Conexion.conectarBD();
        sentencia = Conexion.getCon().createStatement();
        resultado = sentencia.executeQuery("Select * from categoria");

        ArrayList<Categoria> arrayCategoria = new ArrayList<>();

        while (resultado.next()) {

            categoria = new Categoria();
            categoria.setNombre(resultado.getString("nombre_categoria"));
            categoria.setTipo(resultado.getString("tipo_categoria"));
            arrayCategoria.add(categoria);

        }
        resultado.close();
        Conexion.cerrarBD();
        return arrayCategoria;
    }
    public static ArrayList<Pregunta> listadopreguntas(String nombre) throws Exception {

        Conexion.conectarBD();
        sentencia = Conexion.getCon().createStatement();
        resultado = sentencia.executeQuery("select * from pregunta where NOMBRE_CATEGORIA"+nombre+";");

        ArrayList<Pregunta> arrayPregunta = new ArrayList<>();

        while (resultado.next()) {

            pregunta = new Pregunta();
            pregunta.setNombreCategoria(resultado.getString("nombre_categoria"));
            pregunta.setEnunciado(resultado.getString("enunciado"));
            arrayPregunta.add(pregunta);

        }
        resultado.close();
        Conexion.cerrarBD();
        return arrayPregunta;
    }
    
    
    
    
    
}
