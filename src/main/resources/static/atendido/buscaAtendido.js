let atendido = null;
const tabela = document.getElementById("tabela-atendidos");

function getAtendido() {
    return atendido;
}

function preencheTabela(data) {
    let row;

    if(tabela.rows.length == 1) {
        row = tabela.insertRow(1);
    } else {
        row = tabela.rows[1];
    }

    let idCell = row.insertCell(0);
    let nomeCell = row.insertCell(1);
    let rgCell = row.insertCell(2);
    let cpfCell = row.insertCell(3);
    let adicionarBtn = row.insertCell(4);

    idCell.innerHTML = data['id_pessoa'];
    nomeCell.innerHTML = data['nome'];
    rgCell.innerHTML = data['rg'];
    cpfCell.innerHTML = data['cpf'];
    adicionarBtn.innerHTML = "<button id='adicionar'>Adicionar</button>";

    document.getElementById("adicionar").onclick = () => {
        atendido = idCell.innerHTML;
        console.log(atendido);
    }

};


function procuraPorNome(query) {
    fetch("/api/v1/atendido/nome/" + query, {
        method: "GET"
    }).then(response => {
        return response.json()
    }).then(data => {
        preencheTabela(data);
    });
}

function procuraPorRG(query) {
    fetch("/api/v1/atendido/rg/" + query, {
        method: "GET"
    }).then(response => {
        return response.json()
    }).then(data => {
        preencheTabela(data);
    });
}

function procuraPorCPF(query) {
    fetch("/api/v1/atendido/cpf/" + query, {
        method: "GET"
    }).then(response => {
        return response.json()
    }).then(data => {
        preencheTabela(data);
    });
}

document.getElementById("buscar").onclick = () => {
    let selectTipo = document.getElementById("tipo");
    let tipo = selectTipo.options[selectTipo.selectedIndex].text;
    let query = document.getElementById("query").value;
    switch (tipo) {
        case "Nome":
            procuraPorNome(query);
            break;
        case "RG":
            procuraPorRG(query);
            break;
        case "CPF":
            procuraPorCPF(query);
            break;
        default:
            break;
    }
};