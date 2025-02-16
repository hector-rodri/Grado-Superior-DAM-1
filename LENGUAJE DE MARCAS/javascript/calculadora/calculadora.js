function calcular(operador) {
    let num1 = parseFloat(document.getElementById("num1").value);
    let num2 = parseFloat(document.getElementById("num2").value);
    let resultado = document.getElementById("resultado");

    if (isNaN(num1) || isNaN(num2)) {
        resultado.textContent = "Introduce números válidos";
        return;
    }

    switch (operador) {
        case '+': resultado.textContent = num1 + num2; break;
        case '-': resultado.textContent = num1 - num2; break;
        case '*': resultado.textContent = num1 * num2; break;
        case '/': resultado.textContent = num2 !== 0 ? num1 / num2 : "Error: División por 0"; break;
    }
}
