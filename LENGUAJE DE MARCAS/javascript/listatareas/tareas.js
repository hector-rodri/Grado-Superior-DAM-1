function agregarTarea() {
    let tareaInput = document.getElementById("nuevaTarea");
    let lista = document.getElementById("listaTareas");

    if (tareaInput.value.trim() === "") {
        alert("Escribe una tarea antes de agregarla.");
        return;
    }

    let nuevaTarea = document.createElement("li");
    nuevaTarea.classList.add("tarea");

    let tareaTexto = document.createElement("p");
    tareaTexto.textContent = tareaInput.value;

    let checkbox = document.createElement("input");
    checkbox.type = "checkbox";
    checkbox.addEventListener("change", function () {
        if (checkbox.checked) {
            tareaTexto.style.textDecoration = "line-through";
        } else {
            tareaTexto.style.textDecoration = "none";
        }
    });

    let botonEliminar = document.createElement("button");
    botonEliminar.textContent = "Eliminar";
    botonEliminar.classList.add("botonEliminar");
    botonEliminar.onclick = function () {
        lista.removeChild(nuevaTarea);
    };

    nuevaTarea.appendChild(checkbox);
    nuevaTarea.appendChild(tareaTexto);
    nuevaTarea.appendChild(botonEliminar);
    lista.appendChild(nuevaTarea);

    tareaInput.value = "";
}

function eliminarCompletadas() {
    let lista = document.getElementById("listaTareas");
    let tareas = document.querySelectorAll(".tarea");

    tareas.forEach(tarea => {
        if (tarea.querySelector("input").checked) {
            lista.removeChild(tarea);
        }
    });
}

function tareasCompletadas() {
    let tareas = document.querySelectorAll(".tarea");
    tareas.forEach(tarea => {
        if (!tarea.querySelector("input").checked) {
            tarea.style.display = "none";
        }
        if (tarea.querySelector("input").checked) {
            tarea.style.display = "flex";
        }
    });
}

function sinCompletar() {
    let tareas = document.querySelectorAll(".tarea");
    tareas.forEach(tarea => {
        if (tarea.querySelector("input").checked) {
            tarea.style.display = "none";
        }
        if (!tarea.querySelector("input").checked) {
            tarea.style.display = "flex";
        }
    });
}

function todas() {
    let tareas = document.querySelectorAll(".tarea");
    tareas.forEach(tarea => {
        tarea.style.display = "flex";
    });
}

function eliminarTodas() {
    let lista = document.getElementById("listaTareas");
    let tareas = document.querySelectorAll(".tarea");
    tareas.forEach(tarea => {
        lista.removeChild(tarea);
    });
}