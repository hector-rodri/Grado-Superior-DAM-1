let xmlDoc = null;
let jsonNotes = null;

async function carregarXML() {
    try {
        const resposta = await fetch('alumnes.xml');
        if (!resposta.ok) throw new Error('Error de xarxa o fitxer no trobat.');

        const xmlText = await resposta.text();
        const parser = new DOMParser();
        xmlDoc = parser.parseFromString(xmlText, 'application/xml');

        if (!xmlText || xmlDoc.getElementsByTagName("parsererror").length > 0) {
            document.getElementById('xmlAlumnes').textContent = 'Error: XML invàlid o buit.';
        } else {
            document.getElementById('xmlAlumnes').textContent = xmlText;
        }

    } catch (error) {
        document.getElementById('xmlAlumnes').textContent =
            "Error en carregar l'arxiu XML. Estàs executant des d'un servidor?: " + error.message;
    }
}

// Cargar JSON y mostrarlo
async function carregarJSON() {
    try {
        const resposta = await fetch('notes.json');
        if (!resposta.ok) throw new Error('Error de xarxa o fitxer no trobat.');

        jsonNotes = await resposta.json();

        if (!jsonNotes || jsonNotes.length === 0) {
            document.getElementById("jsonNotes").textContent = "Error: JSON invàlid o buit.";
        } else {
            document.getElementById("jsonNotes").textContent = JSON.stringify(jsonNotes, null, 2);
        }

    } catch (error) {
        document.getElementById('jsonNotes').textContent =
            "Error en carregar l'arxiu JSON. Estàs executant des d'un servidor?: " + error.message;
    }
}

// Añadir nueva asignatura a un alumno en el XML
function modificarXML() {
    const idAlumne = document.getElementById('idAlumne').value.trim();
    const assignatura = document.getElementById('assignatura').value.trim();

    if (!xmlDoc) {
        document.getElementById('xmlAlumnes').textContent = "Error: Primer s'ha de carregar l'XML.";
        return;
    }

    if (!idAlumne || !assignatura) {
        document.getElementById('xmlAlumnes').textContent = "Error: ID de l'alumne i assignatura són obligatoris.";
        return;
    }

    if (!confirm(`Vols afegir l'assignatura "${assignatura}" a l'alumne amb ID ${idAlumne}?`)) return;

    const alumnes = xmlDoc.getElementsByTagName('alumne');
    let trobat = false;

    for (let alumne of alumnes) {
        const id = alumne.getElementsByTagName('id')[0].textContent;
        if (id === idAlumne) {
            const assignaturesNode = alumne.getElementsByTagName('assignatures')[0];
            const novaAssignatura = xmlDoc.createElement('assignatura');
            novaAssignatura.textContent = assignatura;
            assignaturesNode.appendChild(novaAssignatura);
            trobat = true;
            break;
        }
    }

    if (trobat) {
        document.getElementById('xmlAlumnes').textContent = new XMLSerializer().serializeToString(xmlDoc);
    } else {
        document.getElementById('xmlAlumnes').textContent = "Error: Alumne amb aquest ID no trobat.";
    }
}

// Modificar una nota a un alumno en el JSON
function modificarJSON() {
    const idAlumne = document.getElementById('idAlumne').value.trim();
    const assignatura = document.getElementById('assignatura').value.trim();
    const nota = document.getElementById('nota').value.trim();

    if (!jsonNotes) {
        document.getElementById('jsonNotes').textContent = "Error: Primer s'ha de carregar el JSON.";
        return;
    }

    if (!idAlumne || !assignatura || !nota) {
        document.getElementById('jsonNotes').textContent = "Error: ID de l'alumne, assignatura i nota són obligatoris.";
        return;
    }

    if (isNaN(nota)) {
        document.getElementById('jsonNotes').textContent = "Error: La nota ha de ser un número.";
        return;
    }

    if (!confirm(`Vols modificar la nota de l'assignatura "${assignatura}" per a l'alumne amb ID ${idAlumne}?`)) return;

    let alumne = jsonNotes.find(a => a.id == idAlumne);

    if (alumne) {
        alumne[assignatura] = parseFloat(nota);
        document.getElementById('jsonNotes').textContent = JSON.stringify(jsonNotes, null, 2);
    } else {
        document.getElementById('jsonNotes').textContent = 'Error: Alumne amb aquest ID no trobat.';
    }
}

// Guardar XML modificado
function desarXML() {
    if (!xmlDoc) {
        alert('Primer cal carregar i/o modificar el XML.');
        return;
    }

    const xmlString = new XMLSerializer().serializeToString(xmlDoc);
    const blob = new Blob([xmlString], { type: 'application/xml' });
    const url = URL.createObjectURL(blob);

    const link = document.createElement('a');
    link.href = url;
    link.download = 'alumnes_modificat.xml';
    document.body.appendChild(link);
    link.click();
    document.body.removeChild(link);

    URL.revokeObjectURL(url);
}

// Guardar JSON modificado
function desarJSON() {
    if (!jsonNotes) {
        alert('Primer cal carregar i/o modificar el JSON.');
        return;
    }

    const jsonString = JSON.stringify(jsonNotes, null, 2);
    const blob = new Blob([jsonString], { type: 'application/json' });
    const url = URL.createObjectURL(blob);

    const link = document.createElement('a');
    link.href = url;
    link.download = 'notes_modificat.json';
    document.body.appendChild(link);
    link.click();
    document.body.removeChild(link);

    URL.revokeObjectURL(url);
}

// Buscar alumnos con una asignatura específica mediante XPath
function trobarAlumnesXpath() {
    if (!xmlDoc) {
        document.getElementById('xmlAlumnes').textContent = "Error: Primer s'ha de carregar l'XML.";
        return;
    }

    const xpath = "//alumne[assignatures/assignatura = 'Llenguatges de marques']";
    const resultats = xmlDoc.evaluate(xpath, xmlDoc, null, XPathResult.ORDERED_NODE_SNAPSHOT_TYPE, null);

    document.getElementById('xmlAlumnes').innerHTML = "Alumnes amb l'assignatura Llenguatges de marques:<br>";

    for (let i = 0; i < resultats.snapshotLength; i++) {
        const alumne = resultats.snapshotItem(i);
        const nom = alumne.getElementsByTagName('nom')[0].textContent;
        document.getElementById('xmlAlumnes').innerHTML += nom + "<br>";
    }
}

// Convertir XML a JSON
function convertirXMLaJSON() {
    if (!xmlDoc) {
        document.getElementById("jsonNotes").textContent = "Error: Primer s'ha de carregar l'XML.";
        return;
    }

    const alumnes = xmlDoc.getElementsByTagName("alumne");
    let resultat = [];

    for (let i = 0; i < alumnes.length; i++) {
        const alumne = alumnes[i];
        const id = parseInt(alumne.getElementsByTagName("id")[0].textContent);
        const nomNode = alumne.getElementsByTagName("nom")[0];
        const nom = nomNode ? nomNode.textContent : "Desconegut";

        const assignaturaNodes = alumne.getElementsByTagName("assignatura");
        let assignatures = [];

        for (let j = 0; j < assignaturaNodes.length; j++) {
            assignatures.push(assignaturaNodes[j].textContent);
        }

        resultat.push({
            id: id,
            nom: nom,
            assignatures: assignatures
        });
    }

    jsonNotes = resultat;
    document.getElementById("jsonNotes").textContent = JSON.stringify(jsonNotes, null, 2);
}

// Convertir JSON a XML
function convertirJSONaXML() {
    if (!jsonNotes || jsonNotes.length === 0) {
        document.getElementById("xmlAlumnes").textContent = "Error: Primer s'ha de carregar el JSON.";
        return;
    }

    let xml = `<alumnes>\n`;

    jsonNotes.forEach(alumne => {
        xml += `  <alumne>\n`;
        xml += `    <id>${alumne.id}</id>\n`;
        xml += `    <asignatures>\n`;

        Object.keys(alumne).forEach(clau => {
            if (clau !== "id") {
                xml += `      <assignatura nom="${clau}">${alumne[clau]}</assignatura>\n`;
            }
        });

        xml += `    </asignatures>\n`;
        xml += `  </alumne>\n`;
    });

    xml += `</alumnes>`;
    document.getElementById("xmlAlumnes").textContent = xml;
}
