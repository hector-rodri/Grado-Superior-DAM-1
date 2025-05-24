var medidaIntro = 20;
let color = ["black", "red", "blue", "green"];


function aumentarTamano() {
    medidaIntro++;
    document.getElementById("texto").style.fontSize = medidaIntro + "px";
}

function disminuirTamano() {
    medidaIntro--;
    document.getElementById("texto").style.fontSize = medidaIntro + "px";
}

function cambiarColor() {
    let random = Math.floor(Math.random() * 10);
    document.getElementById("texto").style.color = color[random];
}

function tamanoInicial() {
    medidaIntro = 20;
    document.getElementById("texto").style.fontSize = medidaIntro + "px";
}




