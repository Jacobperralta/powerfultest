package mx.uv.powerfultest;

import static spark.Spark.*;

import mx.uv.powerfultest.database.*;
import com.google.gson.*;

public class App
{
    private static Gson gson = new Gson();
    public static void main( String[] args )
    {
        System.out.println("Hello World");
        staticFiles.location("/");
        port(getHerokuAssignedPort());
        options("/*", (request, response) -> {

            String accessControlRequestHeaders = request.headers("Access-Control-Request-Headers");
            if (accessControlRequestHeaders != null) {
                response.header("Access-Control-Allow-Headers", accessControlRequestHeaders);
            }

            String accessControlRequestMethod = request.headers("Access-Control-Request-Method");
            if (accessControlRequestMethod != null) {
                response.header("Access-Control-Allow-Methods", accessControlRequestMethod);
            }

            return "OK";
        });

        before((req, res) -> res.header("Access-Control-Allow-Origin", "*"));

        get("/", (req, res) -> {
            res.redirect("index.html");
            return null;
        });

        post("/Usuario", (req, res) -> {
            String payload = req.body();
            Usuario u = gson.fromJson(payload, Usuario.class);

            DAO dao = new DAO();
            JsonObject objetoJson = new JsonObject();
            objetoJson.addProperty("status", dao.crearUsuario(u));
            return objetoJson;
        });

        post("/Usuario", (req, res) -> {
            String payload = req.body();
            Usuario u = gson.fromJson(payload, Usuario.class);
            String nombre = u.getNombre();
            String contraseña = u.getContraseña();

            DAO dao = new DAO();
            JsonObject objetoJson = new JsonObject();
            dao.validarUsuario(nombre, contraseña);
            return objetoJson;
        });
    }

    static int getHerokuAssignedPort() {
        ProcessBuilder processBuilder = new ProcessBuilder();
        if (processBuilder.environment().get("PORT") != null) {
            return Integer.parseInt(processBuilder.environment().get("PORT"));
        }
        return 4567; //return default port if heroku-port isn't set (i.e. on localhost)
    }
}