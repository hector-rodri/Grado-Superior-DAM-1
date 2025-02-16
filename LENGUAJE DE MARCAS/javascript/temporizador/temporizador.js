function iniciarTemporizador() {
    let segundos = parseInt(document.getElementById("tiempo").value);
    let contador = document.getElementById("contador");

    if (isNaN(segundos) || segundos <= 0) {
        alert("Introduce un número mayor que 0");
        return;
    }

    contador.textContent = segundos;

    let intervalo = setInterval(() => {
        segundos--;
        contador.textContent = segundos;

        if (segundos <= 0) {
            clearInterval(intervalo);
            alert("¡Tiempo finalizado!");
        }
    }, 1000);
}
