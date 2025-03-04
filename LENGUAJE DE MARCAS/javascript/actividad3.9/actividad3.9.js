const colores = ["red", "blue", "green", "purple", "yellow"];

function nuevaImagen() {
    let url = document.getElementById("url").value;

    let container = document.createElement("div");
    container.classList.add("imagenNueva");

    let img = document.createElement("img");
    img.src = url;
    container.appendChild(img);

    let borrarImagen = document.createElement("button");
    borrarImagen.textContent = "X";
    borrarImagen.onclick = function () {
        container.remove();
    }
    container.appendChild(borrarImagen);

    let cambiarBorde = document.createElement("button");
    cambiarBorde.textContent = "Canvi Color";
    cambiarBorde.onclick = function () {
        let colorInicial = container.style.borderColor;
        let otroColor = colores[(colores.indexOf(colorInicial) + 1) % colores.length];
        container.style.borderColor = otroColor;
    };
    container.appendChild(cambiarBorde);

    document.getElementById("imagenes").appendChild(container);
}

function borrarTodo() {
    document.getElementById("imagenes").innerHTML = "";
}

