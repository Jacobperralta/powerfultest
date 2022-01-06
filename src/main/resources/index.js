var btnAcceder = document.getElementById("Accesar")
btnAcceder.addEventListener("click", function() {
    axios.get("https://servidorfalso.herokuapp.com/Usuario", {
        nombre : document.getElementById("nombre").value,
        contraseña : document.getElementById("contraseña").value,
    }).then(function(){  
        window.location.href="tareas.html";
    })
})

function registro(){
    window.location.href="registro.html";
}