document.getElementById("formulario").addEventListener("submit", function(event) {
    let email = document.getElementById("email").value;
    let mensaje = document.getElementById("mensaje");
    let regex = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;

    if (email === "") {
        mensaje.textContent = "El campo no puede estar vacío.";
        mensaje.style.color = "red";
        event.preventDefault();
    } else if (!regex.test(email)) {
        mensaje.textContent = "Formato de correo inválido.";
        mensaje.style.color = "red";
        event.preventDefault();
    } else {
        mensaje.textContent = "Formulario enviado correctamente.";
        mensaje.style.color = "green";
    }
});
