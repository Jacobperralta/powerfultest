var btnRegistrarse = document.getElementById('registrarse')
btnRegistrarse.addEventListener('click', function () {
    axios.post("https://servidorfalso.herokuapp.com/Usuario", {
        nombre : document.getElementById("nombre").value,
        matricula : document.getElementById("matricula").value,
        correo : document.getElementById("correo").value,
        contraseña : document.getElementById("contraseña").value
    })
    .then(function (response) {
        alert("Usuario creado");
        estado=response.data.status;
    })
    .catch(function (error) {
        console.log(error);
    })
})

function index(){
    window.location.href="index.html";
}