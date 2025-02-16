function generarNumero() {
    let numero = Math.floor(Math.random() * 100) + 1;
    document.getElementById("numero").textContent = numero;
}
