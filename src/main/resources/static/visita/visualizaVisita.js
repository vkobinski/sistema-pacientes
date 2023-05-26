const tabela = document.getElementById("tabela-visitas");

fetch("/api/v1/visita", {
    method:"GET",
}).then(response => {
    return response.json();
}).then(data => { 
    let i = 1;

    data.forEach(element => {
       let row = tabela.insertRow(i);

       let cellId = row.insertCell(0);
       let cellData = row.insertCell(1);
       let cellVoluntarias = row.insertCell(2);
       let cellPaciente = row.insertCell(3);

       cellId.innerHTML = element['id_visita'];
       cellData.innerHTML = element['data_visita'];
       cellVoluntarias.innerHTML = element['voluntarias'];
       cellPaciente.innerHTML = element['paciente']['nome'];
    });
});