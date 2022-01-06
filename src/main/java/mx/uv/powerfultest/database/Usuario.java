package mx.uv.powerfultest.database;



public class Usuario {
    private String nombre;
    private String matricula;
    private String contraseña;
    private String correo;

    public Usuario(){
    }

    public Usuario(String nombre, String matricula, String contraseña, String correo){
        this.setNombre(nombre);
        this.setMatricula(matricula);
        this.setContraseña(contraseña);
        this.setCorreo(correo);
    }

    public String getNombre(){
        return nombre;
    }

    public void setNombre(String nombre){
        this.nombre = nombre;
    }

    public String getMatricula(){
        return matricula;
    }

    public void setMatricula(String matricula){
        this.matricula = matricula;
    }

    public String getContraseña(){
        return contraseña;
    }

    public void setContraseña(String contraseña){
        this.contraseña = contraseña;
    }

    public String getCorreo(){
        return correo;
    }

    public void setCorreo(String correo){
        this.correo = correo;
    }
}
