package mx.uv.powerfultest.database;

public class Tareas {
    private String texto;

    public Tareas(){

    }

    public Tareas(String texto){
        this.setTexto(texto);
    }

    public String getTexto(){
        return texto;
    }

    public void setTexto(String texto){
        this.texto = texto;
    }
}
