
function cambioColorTexto() { 

    document.getElementById("texto").style.color = "red";
    
}

document.getElementById("cambioColorListener").addEventListener("click", function(){

    let colorRojo = "red";
    let colorAzul = "blue"
    var titulo = document.getElementById("titulo");
    if(titulo.style.color =colorRojo){
        titulo.style.color = colorAzul;
    }
    
});