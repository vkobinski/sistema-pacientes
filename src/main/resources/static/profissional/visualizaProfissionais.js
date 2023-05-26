const tabela = document.getElementById("tabela-profissionais");

const tabelaHTML = tabela.innerHTML;

function preencheTabela() {
    fetch("/api/v1/profissional", {
        method: "GET"
    }).then(response => {
        return response.json();
    }).then(data => {

        tabela.innerHTML = tabelaHTML;

        let i = 1;

        data.forEach(element => {
            let row = tabela.insertRow(i);

            let cellId = row.insertCell(0);
            let cellNome = row.insertCell(1);
            let cellEspecialidade = row.insertCell(2);
            let cellDataCadastro = row.insertCell(3);
            let cellAtivo = row.insertCell(4);
            let cellDesativar = row.insertCell(5);

            cellId.innerHTML = element['id_profissional']
            cellNome.innerHTML = element['nome'];
            cellEspecialidade.innerHTML = element['especialidade']['nomeEspecialidade'];

            let valores = formataData(element['dataCadastro']);
            cellDataCadastro.innerHTML = valores;

            cellAtivo.innerHTML = element['ativo'] === true ? "Ativo" : "Inativo";
            cellDesativar.innerHTML = "<button onclick='desativar(" + element['id_profissional'] + ")'>Desativar</button>"

            i++;

        })
    })
}

function desativar(id) {
    fetch("/api/v1/profissional/ativo/" + id, {
        method: "PUT"
    }).then(response => {
        return response.json();
    }).then(data => {
        preencheTabela();
    })
}

preencheTabela();