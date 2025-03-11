var menuInicio = document.getElementById("botonesDificultad");
var dificultad = document.getElementById("dificultad");
var botonJugar = document.getElementById("jugar");

function jugar() {
    if (dificultad.value == "") {
        alert("Elige una dificultad para empezar a jugar");
        return;
    }
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
            break;

    }
}

    function generarNumeroFacil() {
        menuInicio.style.display = "none";
        var numero = Math.floor(Math.random() * 10) + 1;
        document.getElementById("numero").textContent = numero;
    }

    function generarNumeroMedio() {
        menuInicio.style.display = "none";
        let numero = Math.floor(Math.random() * 50) + 1;
        document.getElementById("numero").textContent = numero;
    }

    function generarNumeroDificil() {
        menuInicio.style.display = "none";
        let numero = Math.floor(Math.random() * 100) + 1;
        document.getElementById("numero").textContent = numero;
    }
