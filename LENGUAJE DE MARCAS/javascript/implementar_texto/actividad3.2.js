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




