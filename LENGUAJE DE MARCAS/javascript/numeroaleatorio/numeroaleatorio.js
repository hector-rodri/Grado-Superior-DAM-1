var menuInicio = document.getElementById("botonesDificultad");
function generarNumeroFacil() {
    menuInicio.style.display = "none";
    let numero = Math.floor(Math.random() * 10) + 1;
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
