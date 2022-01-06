const input = document.querySelector('input');
const addbtn = document.querySelector('.btn-add');
const ul = document.querySelector("ul");
const empty = document.querySelector(".empty");

addbtn.addEventListener("click", (e) => {
    e.preventDefault();
    
    const text = input.value;

    const li = document.createElement('li');
    const p = document.createElement('p');
    p.textContent = text;

    li.appendChild(p);
    li.appendChild(addDeletebtn());
    ul.appendChild(li);

    input.value= "";
    empty.style.display = "none";
});

function addDeletebtn(){
    const deletebtn = document.createElement('boton');

    deletebtn.textContent = "x";
    deletebtn.className = "btn-delete";

    deletebtn.addEventListener('click', (e) => {
        const item = e.target.parentElement;
        ul.removeChild(item);
    });
    return deletebtn;
}

function index(){
    window.location.href="index.html";
}