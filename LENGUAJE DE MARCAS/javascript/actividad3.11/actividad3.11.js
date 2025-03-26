document.addEventListener("DOMContentLoaded", function () {
    const formulario = document.getElementById("formulario");
    const fechaInicioInput = document.getElementById("FechaInicio");
    const fechaFinInput = document.getElementById("FechaFin");
    const numAdultosInput = document.getElementById("NumAdultos");
    const numNinosInput = document.getElementById("NumNiños");
    const origenInput = document.getElementById("Origen");
    const destinoInput = document.getElementById("Destino");

    if (formulario) {
        const hoy = new Date().toISOString().split("T")[0];

        formulario.addEventListener("submit", (event) => {
            event.preventDefault();

            const fechaInicio = fechaInicioInput.value;
            const fechaFin = fechaFinInput.value;
            const numAdultos = numAdultosInput.value;
            const numNinos = numNinosInput.value;
            const origen = origenInput.value;
            const destino = destinoInput.value;
            
            if (fechaInicio < hoy) {
                alert("La fecha de inicio ya pasó");
                return;
            }
            if (fechaFin < hoy) {
                alert("La fecha de fin ya pasó");
                return;
            }
            if (fechaFin < fechaInicio) {
                alert("La fecha de fin tiene que ser mayor a la fecha de inicio");
                return;
            }
            if (numAdultos < 1) {
                alert("Debe haber al menos 1 adulto ");
                return;
            }

            localStorage.setItem("origen", origen);
            localStorage.setItem("destino", destino);
            localStorage.setItem("fechaInicio", fechaInicio);
            localStorage.setItem("fechaFin", fechaFin);
            localStorage.setItem("numAdultos", numAdultos);
            localStorage.setItem("numNinos", numNinos);

            sessionStorage.setItem("origen", origen);
            sessionStorage.setItem("destino", destino);
            sessionStorage.setItem("fechaInicio", fechaInicio);
            sessionStorage.setItem("fechaFin", fechaFin);
            sessionStorage.setItem("numAdultos", numAdultos);
            sessionStorage.setItem("numNinos", numNinos);

            window.location.href = "actividad3.11.2.html";
        });
    }
});