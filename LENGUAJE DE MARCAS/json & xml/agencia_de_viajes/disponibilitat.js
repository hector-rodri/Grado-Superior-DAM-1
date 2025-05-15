let xmlDisponibilitat;  
let jsonDisponibilitat; 
let mostrar = false;

async function cercarDisponibilitat(event) {
    //LIMPIEZA
    document.getElementById("disponibilitat").textContent = "";
    document.getElementById("resultatsHotels").textContent = "";
    document.getElementById("resultatsVols").textContent = "";
    document.getElementById("conversio").textContent = "";
    mostrar = false;
    jsonDisponibilitat = null;
    xmlDisponibilitat = null;
    //VALIDACIONES
    let origen = document.getElementById("origen").value;
    let desti = document.getElementById("desti").value;
    let adults = document.getElementById("adults").value;
    let infants = document.getElementById("infants").value;
    let dataInici = document.getElementById("dataInici").value;
    let dataFi = document.getElementById("dataFi").value;

    if (!origen || !desti || !adults || !infants || !dataInici || !dataFi) {
        alert("Ningún campo puede estar vacío");
        event.preventDefault();
        return;
    }
    //CREACIÓN XML
    const xmlString = `
  <disponibilitat>
    <origen>${origen}</origen>
    <desti>${desti}</desti>
    <adults>${adults}</adults>
    <infants>${infants}</infants>
    <dataInici>${dataInici}</dataInici>
    <dataFi>${dataFi}</dataFi>
  </disponibilitat>
  `.trim();

    document.getElementById("disponibilitat").textContent = xmlString;
    const parser = new DOMParser();
    xmlDisponibilitat = parser.parseFromString(xmlString, "application/xml");
    //LLAMADA A LAS FUNCIONES PARA BÚSQUEDA DE HOTELES Y VUELOS
    try {
        const respostaHotels = await fetch("hotels.xml");
        if (!respostaHotels.ok) throw new Error("No s'ha pogut carregar hotels.xml");
        const textHotels = await respostaHotels.text();
        const parser = new DOMParser();
        const xmlHotels = parser.parseFromString(textHotels, "application/xml");
        mostrarHotelsDesti(desti, xmlHotels);

        const respostaVols = await fetch("vols.json");
        if (!respostaVols.ok) throw new Error("No s'ha pogut carregar vols.json");
        const jsonVols = await respostaVols.json();
        mostrarVolsOrigenDesti(origen, desti, jsonVols);
    } catch (error) {
        alert(error.message);
    }
}

function convertir() {
    const convertido = document.getElementById("conversio");

    if (!xmlDisponibilitat) {
        convertido.textContent = "El fitxer no existeix";
        return;
    }

    if (!mostrar) {
        jsonDisponibilitat = convertirXMLaJSON(xmlDisponibilitat);
        convertido.textContent = JSON.stringify(jsonDisponibilitat, null, 2);
        mostrar = true;
    } else {
        const xmlReconvertit = convertirJSONaXML(jsonDisponibilitat);
        convertido.textContent = xmlReconvertit;
        mostrar = false;
    }
}

function convertirXMLaJSON(xml) {
    let obj = {};
    const nodes = xml.documentElement ? xml.documentElement.children : xml.children;
    for (let node of nodes) {
        obj[node.nodeName] = node.textContent;
    }
    return obj;
}

function convertirJSONaXML(json) {
    let xml = "";
    for (let key in json) {
        xml += `<${key}>${json[key]}</${key}>\n`;
    }
    return xml;
}
function mostrarHotelsDesti(desti, xmlHotels) {
    const hotels = xmlHotels.getElementsByTagName("hotel");
    let resultats = [];

    //Recorre cada hotel y mira si el destino coincide
    for (let i = 0; i < hotels.length; i++) {
        let hotel = hotels[i];
        let destiHotel = hotel.getElementsByTagName("desti")[0];
        if (destiHotel && destiHotel.textContent.trim().toLowerCase() === desti.toLowerCase()) {
            let nomHotel = hotel.getElementsByTagName("nom")[0];
            if (nomHotel) {
                resultats.push("Nom: " + nomHotel.textContent);
            }
        }
    }
    //Muestra los resultad
    let contenidor = document.getElementById("resultatsHotels");
    if (resultats.length > 0) {
        contenidor.innerHTML = "Hotels disponibles a " + desti + ":<br>" + resultats.join("<br>");
    } else {
        contenidor.textContent = "No s'han trobat hotels al destí indicat";
    }
}

function mostrarVolsOrigenDesti(origen, desti, jsonVols) {
    let resultats = [];
    //Recorre cada vuelo y mira si origen y destino coinciden
    for (let i = 0; i < jsonVols.length; i++) {
        let vol = jsonVols[i];
        if (vol.origen.toLowerCase() === origen.toLowerCase() && vol.desti.toLowerCase() === desti.toLowerCase()) {
            resultats.push("Vol: " + vol.origen + " → " + vol.desti + ", Preu: " + vol.preu.toFixed(2) + "€");
        }
    }
    //Muestra los resultados
    let contenidor = document.getElementById("resultatsVols");
    if (resultats.length > 0) {
        contenidor.innerHTML = "Vols disponibles de " + origen + " a " + desti + ":<br>" + resultats.join("<br>");
    } else {
        contenidor.textContent = "No s'han trobat vols per a l'origen i destí indicats";
    }
}