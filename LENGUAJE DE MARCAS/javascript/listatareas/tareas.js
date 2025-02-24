function agregarTarea() {
    let tareaInput = document.getElementById("nuevaTarea");
    let lista = document.getElementById("listaTareas");

    if (tareaInput.value.trim() === "") {
        alert("Escribe una tarea antes de agregarla.");
        return;
    }

    let nuevaTarea = document.createElement("li");
    nuevaTarea.classList.add("tarea");
    
    let checkbox = document.createElement("input");
    checkbox.type = "checkbox";
    checkbox.addEventListener("change", function() {
        nuevaTarea.classList.toggle("completada");
    });

    let botonEliminar = document.createElement("button");
    botonEliminar.textContent = "Eliminar";
    botonEliminar.classList.add("botonEliminar");
    botonEliminar.onclick = function() {
        lista.removeChild(nuevaTarea);
    };
    
    nuevaTarea.appendChild(checkbox);
    nuevaTarea.textContent = tareaInput.value;
    nuevaTarea.appendChild(botonEliminar);
    lista.appendChild(nuevaTarea);

    tareaInput.value = "";
}




