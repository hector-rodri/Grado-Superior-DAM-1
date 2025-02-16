var assignaturesPrimer = ["Llenguatges", "Sistemes", "Programació",];
var assignaturesSegon = ["Sistemes de gestió", "Base de dades", "Interfcies"];

var assignaturesDam = [assignaturesPrimer, assignaturesSegon];

console.log(assignaturesDam);

var assignaturaUsuario = prompt("Introduce una asignatura");
assignaturesPrimer.push(assignaturaUsuario);
console.log(assignaturesPrimer);

