package sample.models;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Observable;

//Data Access Object Intermediario Java(POO) - DB
public class CancionesDAO {
    private int id_cancion;
    private String nombre_cancion;
    private int duracion;
    private String portada;
    private int anio;
    private String letra;


    public int getId_cancion() {
        return id_cancion;
    }

    public void setId_cancion(int id_cancion) {
        this.id_cancion = id_cancion;
    }

    public String getNombre_cancion() {
        return nombre_cancion;
    }

    public void setNombre_cancion(String nombre_cancion) {
        this.nombre_cancion = nombre_cancion;
    }

    public int getDuracion() {
        return duracion;
    }

    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }

    public String getPortada() {
        return portada;
    }

    public void setPortada(String portada) {
        this.portada = portada;
    }

    public int getAnio() {
        return anio;
    }

    public void setAnio(int anio) {
        this.anio = anio;
    }

    public String getLetra() {
        return letra;
    }

    public void setLetra(String letra) {
        this.letra = letra;
    }

    //Manda datos
    public void INSERT(){
        try{
            String query = "INSERT INTO tbl_canciones (nombre_cancion, duracion, portada, anio, letra) " +
                    "VALUES('"+nombre_cancion+"',"+duracion+","+portada+","+anio+",'"+letra+"')";

            Statement stmt = Conexion.conexion.createStatement();
            stmt.executeUpdate(query);
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    //Manda datos (Actualiza la DB)
    public void UPDATE(){
        try{
            String query = "UPDATE tbl_canciones SET nombre_cancion = '"+nombre_cancion+"', duracion = "+duracion+", " +
                    "portada = '"+portada+"', anio =  "+anio+", letra = '"+letra+"' WHERE id_cancion = "+id_cancion;

            Statement stmt = Conexion.conexion.createStatement();
            stmt.executeUpdate(query);
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    //Borra datos
    public void DELETE(){
        try{
            String query = "DELETE FROM tbl_canciones WHERE id_cancion = "+ id_cancion;
            Statement stmt = Conexion.conexion.createStatement();
            stmt.executeUpdate(query);
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    //Trae datos
    public ObservableList<CancionesDAO> SELECT(){

        ObservableList<CancionesDAO> listaC = FXCollections.observableArrayList();
        try{
            CancionesDAO objC;

            String query = "SELECT * FROM tbl_canciones ORDER BY nombre_cancion ASC";
            Statement stmt = Conexion.conexion.createStatement();
            ResultSet res = stmt.executeQuery(query);
            while(res.next()){
                objC = new CancionesDAO();
                objC.id_cancion = res.getInt("id_cancion");
                objC.nombre_cancion = res.getString("nombre_cancion");
                objC.duracion = res.getInt("duracion");
                objC.portada = res.getString("portada");
                objC.letra = res.getString("letra");
                listaC.add(objC);
            }
            stmt.executeUpdate(query);
        }catch(Exception e){
            e.printStackTrace();
        }
        return listaC;
    }
}
