function cercarDisponibilitat(event) {

    let origen = document.getElementById("origen").value;
    let desti = document.getElementById("desti").value;
    let adults = document.getElementById("adults").value;
    let infants = document.getElementById("infants").value;
    let dataInici = document.getElementById("dataInici").value;
    let dataFi = document.getElementById("dataFi").value;

    if (!origen || !desti || !adults || !infants || !dataInici || !dataFi) {
        alert("Ningún campo puede estar vacío");
        event.preventDefault();
    }








}