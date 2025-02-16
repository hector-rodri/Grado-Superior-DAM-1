document.getElementById('formulariContacte').addEventListener('submit', function (event) {
    event.preventDefault();
    let formatValidEmail = /^[a-zA-Z0-9._-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,6}$/;
    let nombre = document.getElementById('nom').value.trim();
    let email = document.getElementById('email').value.trim();
    let asunto = document.getElementById('assumpte').value.trim();
    let mensaje = document.getElementById('descripcio').value.trim();
    let nombreInput = document.getElementById('nom');
    let emailInput = document.getElementById('email');
    let asuntoInput = document.getElementById('assumpte');
    let mensajeInput = document.getElementById('descripcio');

    if (nombre === '') {
        alert('El campo nombre no puede estar vacío');
        nombreInput.focus();
    } else if (formatValidEmail.test(email) == false) {
        alert('El campo email no cumple con el formato de email');
        emailInput.focus();
    } else if (asunto === '') {
        alert('El campo asunto no puede estar vacío');
        asuntoInput.focus();
    } else if (mensaje === '') {
        alert('El campo mensaje no puede estar vacío');
        mensajeInput.focus();
    } else {
        alert('Formulario enviado correctamente :)');
    }

    document.getElementById("formulariContacte").reset();

});