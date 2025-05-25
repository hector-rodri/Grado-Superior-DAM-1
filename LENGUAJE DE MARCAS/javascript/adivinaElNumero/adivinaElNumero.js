var menuInicio = document.getElementById("botonesDificultad");
var dificultad = document.getElementById("dificultad");
var botonJugar = document.getElementById("jugar");
var tipoJuego = document.getElementById("tipoJuego");
var mensaje = document.getElementById("mensaje");
var intentosMensaje = document.getElementById("intentos");
var maxValor;
var numero;
var intentos = 0;
var juegoTerminado = false;

function jugar() {
    switch (dificultad.value) {
        case "10":
            generarNumeroFacil();
            break;
        case "50":
            generarNumeroMedio();
            break;
        case "100":
            generarNumeroDificil();
            break;
        default:
            alert("Elige una dificultad para empezar a jugar");
            break;
    }
    document.getElementById("titulo").textContent = "Adivina el número entre 1 y " + maxValor;
    juegoTerminado = false;
}

function generarNumeroFacil() {
    menuInicio.style.display = "none";
    tipoJuego.style.display = "block";
    numero = Math.floor(Math.random() * 10) + 1;
    maxValor = 10;
    intentos = 0;
    intentosMensaje.textContent = "Intentos: " + intentos;
}

function generarNumeroMedio() {
    menuInicio.style.display = "none";
    tipoJuego.style.display = "block";
    numero = Math.floor(Math.random() * 50) + 1;
    maxValor = 50;
    intentos = 0;
    intentosMensaje.textContent = "Intentos: " + intentos;
}

function generarNumeroDificil() {
    menuInicio.style.display = "none";
    tipoJuego.style.display = "block";
    numero = Math.floor(Math.random() * 100) + 1;
    maxValor = 100;
    intentos = 0;
    intentosMensaje.textContent = "Intentos: " + intentos;
}

function comprovarNumero() {
    if (juegoTerminado) return;

    let input = document.getElementById("inputNumero");
    let numeroUsuario = input.value;

    if (numeroUsuario === "") {
        mensaje.textContent = "Introduce un número";
        mensaje.style.color = "red";
        return;
    }

    numeroUsuario = parseInt(numeroUsuario);

    if (numeroUsuario < 1 || numeroUsuario > maxValor) {
        mensaje.textContent = "Introduce un número válido";
        mensaje.style.color = "red";
        return;
    }
    intentos++;
    intentosMensaje.textContent = "Intentos: " + intentos;

    if (numeroUsuario < numero) {
        mensaje.textContent = "Número bajo";
        mensaje.style.color = "red";
    } else if (numeroUsuario > numero) {
        mensaje.textContent = "Número alto";
        mensaje.style.color = "red";
    } else if (numeroUsuario == numero) {
        mensaje.textContent = "HAS ACERTADO";
        mensaje.style.color = "green";
        juegoTerminado = true;
    }
}

function reiniciar() {
    menuInicio.style.display = "block";
    tipoJuego.style.display = "none";
    mensaje.textContent = "";
    document.getElementById("inputNumero").value = "";
    numero = null;
    maxValor = null;
    intentos = 0;
    intentosMensaje.textContent = "Intentos: " + intentos;
    juegoTerminado = false;
}