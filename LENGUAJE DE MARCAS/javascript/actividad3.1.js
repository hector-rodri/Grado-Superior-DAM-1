var texto = document.getElementById("texto");
var colores = ["green", "red", "gray", "yellow", "blue", "pink"];
var coloresPosicion= 0;

function aumentarTamano() {
    let tamanoActual = parseInt(texto.style.fontSize); 
    texto.style.fontSize = (tamanoActual+5) +"px";
}

function disminuirTamano() {
    texto.style.fontSize = (tamanoActual-5) +"px";
}

function cambioColor() {
    indexColor = (indexColor + 1) % colors.length;
    document.getElementById("text").style.color = colores[coloresPosicion++];
}

