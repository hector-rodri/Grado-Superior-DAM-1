const borderColors = ["red", "blue", "green", "purple", "yellow"];

function nuevaImagen() {
    let url = document.getElementById("url").value;

    let container = document.createElement("div");
    container.classList.add("imagenNueva");

    let img = document.createElement("img");
    img.src = url;
    container.appendChild(img);

    let borrarImagen = document.createElement("button");
    borrarImagen.textContent = "Eliminar Imagen";
    borrarImagen.onclick = function () {
        container.remove();
    }
    container.appendChild(borrarImagen);

    document.getElementById("imagenes").appendChild(container);
    document.getElementById("url").value = "";
}



