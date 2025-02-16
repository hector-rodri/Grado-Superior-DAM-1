var nota = prompt("Introduce tu primera nota");
var nota2 = prompt("Introduce tu segunda nota");
var nota3 = prompt("Introduce tu tercera nota");

var media = (parseFloat(nota) + parseFloat(nota2) + parseFloat(nota3)) / 3;  
alert("Tu media es: " + media);

if (media < 5) {
    console.log("Suspendido");
}else if (media >= 5 && media < 7) {
    console.log("Aprobado");
} else if (media >= 7 && media < 9) {
    console.log("Notable");
} else {
    console.log("Sobresaliente");
}

var assignaturesPrimer = ["Llenguatges", "Sistemes", "Programació"];
var assignaturesSegon = ["Sistemes de gestió", "Base de dades", "Interfcies"];

var assignaturesDam = [assignaturesPrimer, assignaturesSegon];

console.log(assignaturesDam[0][1]);