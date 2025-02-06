var medidaIntro = 20;
let color = ["black", "red", "blue", "green"];
let nuevoTextoUsuario = document.createElement("p");


function aumentarTamano() {
    medidaIntro++;
    document.getElementById("texto").style.fontSize = medidaIntro + "px";
}

function disminuirTamano() {
    medidaIntro--;
    document.getElementById("texto").style.fontSize = medidaIntro + "px";
}

function cambiarColor() {
    let random = Math.floor(Math.random() * 4);
    document.getElementById("texto").style.color = color[random];
}

function tamanoInicial() {
    medidaIntro = 20;
    document.getElementById("texto").style.fontSize = medidaIntro + "px";
}

function implementarTexto() {
    var texto = prompt("Introduce tu texto:");
    nuevoTextoUsuario.textContent = texto;
    document.getElementById("contenedor").appendChild(nuevoTextoUsuario);
}

function borrarTexto() {
    var contenedor = document.getElementById("contenedor");
    contenedor.removeChild(nuevoTextoUsuario);

}

function implementarEstilos() {
    document.getElementById('titulo').classList.add("añadido");
}

function borrarEstilos() {
    document.getElementById('titulo').classList.remove("añadido");
}

let textENG = "The server received the request, but the database was slow to respond.The caching system prevented a collapse while queries were processed.";
let textESP = "El servidor recibió la solicitud, pero la base de datos tardó en responder. El sistema de caché evitó el colapso mientras se procesaban las consultas.";

document.getElementById("traducir1").addEventListener("click", function () {

    var textoTraducido = document.getElementById("texto2");
    
    if (textoTraducido.textContent == textENG) {
        textoTraducido.textContent = textESP;
    } else {
        textoTraducido.textContent = textENG;
    }
    
});

document.getElementById("boton2").addEventListener("mouseover", function () {

    document.getElementById("boton2").classList.add("botonMagicoMolon");


});

document.getElementById("boton2").addEventListener("mouseout", function () {

    document.getElementById("boton2").classList.remove("botonMagicoMolon");
    

});

