
document.getElementById("menuBurger").addEventListener("click", function () {

    let links = document.getElementById("links");
    links.classList.toggle("claseHamburguesa");

    document.getElementById("links").addEventListener("click", function(){
        links.classList.remove("claseHamburguesa");
    });

});


