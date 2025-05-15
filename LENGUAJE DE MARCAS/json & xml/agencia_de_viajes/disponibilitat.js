let xmlDisponibilitat;
let jsonVols;
let xmlHotels;

async function cercarDisponibilitat(event) {

    let origen = document.getElementById("origen").value.trim();
    let desti = document.getElementById("desti").value.trim();
    let adults = document.getElementById("adults").value.trim();
    let infants = document.getElementById("infants").value.trim();
    let dataInici = document.getElementById("dataInici").value.trim();
    let dataFi = document.getElementById("dataFi").value.trim();

    if (!origen || !desti || !adults || !infants || !dataInici || !dataFi) {
        alert("Tots els camps són obligatoris");
        event.preventDefault();
        return;
    }

    const xmlString = `<disponibilitat>
  <origen>${origen}</origen>
  <desti>${desti}</desti>
  <adults>${adults}</adults>
  <infants>${infants}</infants>
  <dataInici>${dataInici}</dataInici>
  <dataFi>${dataFi}</dataFi></disponibilitat>`.trim();

    document.getElementById("disponibilitat").textContent = formatXML(xmlString);
    const parser = new DOMParser();
    xmlDisponibilitat = parser.parseFromString(xmlString, "application/xml");

    try {

        const respostaHotels = await fetch("hotels.xml");
        if (!respostaHotels.ok) throw new Error("No s'ha pogut carregar hotels.xml");
        const textHotels = await respostaHotels.text();
        xmlHotels = parser.parseFromString(textHotels, "application/xml");

        mostrarHotelsDesti(desti);

        const respostaVols = await fetch("vols.json");
        if (!respostaVols.ok) throw new Error("No s'ha pogut carregar vols.json");
        jsonVols = await respostaVols.json();

        mostrarVolsOrigenDesti(origen, desti);

    } catch (error) {
        alert("Error en carregar fitxers: " + error.message);
    }
}

// Funció per formatar XML per mostrar (amb indentació)
function formatXML(xml) {
    // Senzill formatador d'indentació (per mostrar)
    let formatted = '';
    const reg = /(>)(<)(\/*)/g;
    xml = xml.replace(reg, '$1\n$2$3');
    let pad = 0;
    xml.split('\n').forEach(function(node) {
        let indent = 0;
        if (node.match(/.+<\/\w[^>]*>$/)) indent = 0;
        else if (node.match(/^<\/\w/)) pad -= 1;
        else if (node.match(/^<\w([^>]*[^/])?>.*$/)) indent = 1;
        else indent = 0;

        formatted += '  '.repeat(pad) + node + '\n';
        pad += indent;
    });
    return formatted.trim();
}

// Mostrar hotels que coincideixin amb el destí
function mostrarHotelsDesti(desti) {
    const hotels = xmlHotels.getElementsByTagName("hotel");
    let resultats = [];

    for (let hotel of hotels) {
        const destiHotel = hotel.getElementsByTagName("desti")[0]?.textContent.trim();
        if (destiHotel && destiHotel.toLowerCase() === desti.toLowerCase()) {
            const nomHotel = hotel.getElementsByTagName("nom")[0]?.textContent || "Sense nom";
            resultats.push(`Nom: ${nomHotel}`);
        }
    }

    const contenidor = document.getElementById("resultatsHotels");
    if (resultats.length > 0) {
        contenidor.innerHTML = "<b>Hotels disponibles a " + desti + ":</b><br>" + resultats.join("<br>");
    } else {
        contenidor.textContent = "No s'han trobat hotels al destí indicat.";
    }
}

// Mostrar vols que coincideixin amb origen i destí
function mostrarVolsOrigenDesti(origen, desti) {
    let resultats = [];

    for (let vol of jsonVols) {
        if (vol.origen.toLowerCase() === origen.toLowerCase() && vol.desti.toLowerCase() === desti.toLowerCase()) {
            resultats.push(`Vol: ${vol.origen} → ${vol.desti}, Preu: ${vol.preu.toFixed(2)}€`);
        }
    }

    const contenidor = document.getElementById("resultatsVols");
    if (resultats.length > 0) {
        contenidor.innerHTML = "<b>Vols disponibles d'" + origen + " a " + desti + ":</b><br>" + resultats.join("<br>");
    } else {
        contenidor.textContent = "No s'han trobat vols per a l'origen i destí indicats.";
    }
}

