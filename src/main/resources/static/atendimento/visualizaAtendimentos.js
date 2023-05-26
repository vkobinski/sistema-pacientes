const tabela = document.getElementById("tabela");
const tabelaHTML = tabela.innerHTML;

function formataData(data) {

    const originalDate = new Date(data);

    const formattedDate = new Intl.DateTimeFormat("en-GB", {
        day: "2-digit",
        month: "2-digit",
        year: "numeric",
        hour: "2-digit",
        minute: "2-digit"
      }).format(originalDate);

    return formattedDate;
}

function apagaAtendimento(id) {
    fetch("/api/v1/atendimento/" + id, {
        method: "DELETE"
    }).then(response => {
        return response.json();
    }).then(data => {
        console.log(data);
    });

    preencheTabela();
}

function preencheTabela() {
    fetch("/api/v1/atendimento",  {
        method: "GET",
    }).then(response => {
        return response.json();
    }).then(dataRec => {
        colocaDados(dataRec);
    })
}

function colocaDados(data) {

    tabela.innerHTML = tabelaHTML;

    let i = 1;

    data.forEach(element => {
        let row = tabela.insertRow(i);

        let cellId = row.insertCell(0);
        let cellData = row.insertCell(1);
        let cellProfissional = row.insertCell(2);
        let cellAtendido = row.insertCell(3);
        let cellApagar = row.insertCell(4);

        cellId.innerHTML = element['id_Atendimento'];
        cellData.innerHTML = formataData(element['data']);
        cellProfissional.innerHTML = element['profissional']['nome'];
        cellAtendido.innerHTML = element['atendido']['nome'];
        cellApagar.innerHTML = "<button id='apagar' onclick='apagaAtendimento(" + element['id_Atendimento'] + ")'>Apagar</button>";


    });

}

preencheTabela();