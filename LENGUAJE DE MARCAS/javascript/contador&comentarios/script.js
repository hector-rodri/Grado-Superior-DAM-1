var contador = 0;
var resultado = document.getElementById("resultado")
function contar() {
    contador++;
    document.getElementById("resultado").textContent = contador;
    if (contador >= 1) {
        document.getElementById("reiniciar").style.display = "flex";
    }
    if (contador == 10) {
        document.getElementById("contar").style.display = "none";
    }

}

function reiniciar() {
    document.getElementById("resultado").textContent = "0";
    document.getElementById("reiniciar").style.display = "none";
    contador = 0;
    if(contador == 0){
        document.getElementById("contar").style.display = "flex";
    }
}

function agregarComentario() {
    var comentarioUsuario = document.getElementById("nuevoComentario");
    var comentarios = document.getElementById("comentarios");

    if (comentarioUsuario.value.trim() === "") {
        alert("Escribe un comentario antes de pulsar añadir");
        return;
    }

    var nuevoComentario= document.createElement("p");
    nuevoComentario.textContent = comentarioUsuario.value;
    comentarios.appendChild(nuevoComentario);
}

function eliminarComentario(){
    comentarios.remove();
}