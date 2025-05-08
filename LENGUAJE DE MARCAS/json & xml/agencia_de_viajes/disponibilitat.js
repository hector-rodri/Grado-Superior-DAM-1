function cercarDisponibilitat(event) {

    let origen = document.getElementById("origen").value;
    let desti = document.getElementById("desti").value;
    let adults = document.getElementById("adults").value;
    let infants = document.getElementById("infants").value;
    let dataInici = document.getElementById("dataInici").value;
    let dataFi = document.getElementById("dataFi").value;

    if (origen === "") {
        alert("El campo origen no puede estar vacío");
        event.preventDefault();
    }

    if (desti === "") {
        alert("El campo destino no puede estar vacío");
        event.preventDefault();
    }

    if (adults === "") {
        alert("El campo número de adultos no puede estar vacío");
        event.preventDefault();
    }

    if (infants === "") {
        alert("El campo número de niños no puede estar vacío");
        event.preventDefault();
    }

    if (dataInici === "") {
        alert("El campo fecha de inicio no puede estar vacío");
        event.preventDefault();
    }

    if (dataFi === "") {
        alert("El campo fecha de fin no puede estar vacío");
        event.preventDefault();
    }







}