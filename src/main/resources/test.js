var loading = document.getElementById('loading');
var loading = document.getElementById('mensaje');

var boton = document.getElementById('carga_ajax');
boton.addEventListener('click', function(){
    loading.style.display = 'block';
    axios.get('texto.txt', {
        responseType: 'text'
    })
    .then(function(res){
        if(res.status==200){
               mensaje.innerHTML = res.data;
        }
        console.log(res);
    })
    .catch(function(err){
        mensaje.innerText = 'error de conexión' + err;
     });
});