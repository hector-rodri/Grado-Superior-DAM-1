const colores = ["black", "blue", "green", "purple", "yellow","red","orange"];

function nuevaImagen() {
    let url = document.getElementById("url").value;
    if (url.trim() === "") {
        alert("Escribe una url, para añadir tu imagen");
        return;
    }

    let container = document.createElement("div");
    container.classList.add("imagenNueva");

    let img = document.createElement("img");
    img.src = url;
    container.appendChild(img);

    let borrarImagen = document.createElement("button");
    borrarImagen.textContent = "X";
    borrarImagen.style.background = "#DC3545";
    borrarImagen.onclick = function () {
        container.remove();
    }
    container.appendChild(borrarImagen);

    let cambiarBorde = document.createElement("button");
    cambiarBorde.textContent = "Canvi Color";
    cambiarBorde.style.background = "linear-gradient(to right, rgb(255, 30, 140) 10%, rgb(255, 102, 57), rgb(255, 230, 29) 40%, rgb(255, 230, 29), rgb(255, 230, 29) 60%, rgb(87, 229, 98), rgb(31, 179, 253) 85%, rgb(31, 179, 253), rgb(31, 179, 253))";
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

