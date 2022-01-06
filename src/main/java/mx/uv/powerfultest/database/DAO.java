package mx.uv.powerfultest.database;

import java.io.IOException;
import java.net.URISyntaxException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;


public class DAO extends conexion {

    private conexion conection = new conexion();
    Connection con;
    PreparedStatement stm;
    ResultSet rs;

    public String crearUsuario(Usuario u) {
        PreparedStatement stm = null;
        Connection con = null;
        String msj = "";

        con = conection.getConnection();
        try {
            String sql = "INSERT INTO Usuario (nombre, mamtricula, contraseña, correo) VALUES (?, ?, ?, ?)";
            stm = con.prepareStatement(sql);
            stm.setString(1, u.getNombre());
            stm.setString(2, u.getMatricula());
            stm.setString(3, u.getCorreo());
            stm.setString(4, u.getContraseña());

            if (stm.executeUpdate() > 0)
                msj = "El usuario fue agregado";
            else
                msj = "El usuario no se agrego";

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (stm != null) {
                try {
                    stm.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            try {
                con.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return msj;
    }

    public void validarUsuario( String nombre, String contraseña){
        Statement stm = null;
          ResultSet rs = null;
          Connection con = null;

          con = conection.getConnection();
          try{
              String sql = "SELECT * FROM Usuario WHERE nombre='"+ nombre + "' AND contraseña='"+ contraseña +"'";
              stm = con.createStatement();
              rs = stm.executeQuery(sql);
              if(rs.next()){
                  System.out.println("Bienvenido");
                  if(java.awt.Desktop.isDesktopSupported()){
                      java.awt.Desktop desktop = java.awt.Desktop.getDesktop();
                      if(desktop.isSupported(java.awt.Desktop.Action.BROWSE)){
                          try{
                              java.net.URI uri = new java.net.URI("https://powerfultest.herokuapp.com/tareas.html");
                              desktop.browse(uri);
                          } catch (URISyntaxException | IOException ex) {}
                      }
                  }

              }else{
                  System.out.println("No se puede ingresar");
              }
          }catch (Exception e){
              e.printStackTrace();
          } finally{
              if (stm != null) {
                  try {
                      stm.close();
                  } catch (Exception e) {
                      e.printStackTrace();
                  }
              }
              try {
                  con.close();
              } catch (Exception e) {
                  e.printStackTrace();
              }
          }  
  }
}