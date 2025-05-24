document.addEventListener("DOMContentLoaded", function () {
    // Obtener los elementos donde se mostrará la información
    const origenSpan = document.querySelector("#resultado p:nth-child(1) span");
    const destinoSpan = document.querySelector("#resultado p:nth-child(2) span");
    const fechaInicioSpan = document.querySelector("#resultado p:nth-child(3) span");
    const fechaFinSpan = document.querySelector("#resultado p:nth-child(4) span");
    const numAdultosSpan = document.querySelector("#resultado p:nth-child(5) span");
    const numNinosSpan = document.querySelector("#resultado p:nth-child(6) span");
    const descuentoSpan = document.querySelector("#resultado p:nth-child(7) span");

    // Obtener los datos de localStorage o sessionStorage
    const origen = localStorage.getItem("origen") || "No especificado";
    const destino = localStorage.getItem("destino") || "No especificado";
    const fechaInicio = localStorage.getItem("fechaInicio") || "No especificado";
    const fechaFin = localStorage.getItem("fechaFin") || "No especificado";
    const numAdultos = localStorage.getItem("numAdultos") || "0";
    const numNinos = localStorage.getItem("numNinos") || "0";
    const descuento = localStorage.getItem("descuento") || "Ninguno";

    // Mostrar los datos en el HTML
    origenSpan.textContent = origen;
    destinoSpan.textContent = destino;
    fechaInicioSpan.textContent = fechaInicio;
    fechaFinSpan.textContent = fechaFin;
    numAdultosSpan.textContent = numAdultos;
    numNinosSpan.textContent = numNinos;
    descuentoSpan.textContent = descuento;
});