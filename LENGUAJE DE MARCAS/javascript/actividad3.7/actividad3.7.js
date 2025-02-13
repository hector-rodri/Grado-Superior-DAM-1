document.getElementById("menuBurger").addEventListener("click", function () {

    let links = document.getElementById("links");
    links.classList.toggle("claseHamburguesa");

    document.getElementById("links").addEventListener("click", function(){
        links.classList.remove("claseHamburguesa");
    });

});


document.getElementById("buscador").addEventListener('input', function() {

    var producto = document.querySelectorAll('.camiseta');
    var condicion = document.getElementById("buscador").value.toLowerCase();
    
    producto.forEach(producto => {
        let texto = producto.textContent.toLowerCase();
        if (texto.includes(condicion)) {
            producto.style.display = 'block';
        } else {
            producto.style.display = 'none';
        }
    });
});
