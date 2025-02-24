function agregarTarea() {
    let tareaInput = document.getElementById("nuevaTarea");
    let lista = document.getElementById("listaTareas");

    if (tareaInput.value.trim() === "") {
        alert("Escribe una tarea antes de agregarla.");
        return;
    }

    let nuevaTarea = document.createElement("li");
    nuevaTarea.textContent = tareaInput.value;
    // nuevaTarea.onclick = function() {
    //     lista.removeChild(nuevaTarea);
    // };
    lista.appendChild(nuevaTarea);
    tareaInput.value = "";
}
