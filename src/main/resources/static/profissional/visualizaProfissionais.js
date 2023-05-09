const tabela = document.getElementById("tabela-profissionais");

fetch("/api/v1/profissional", {
    method: "GET"
}).then(response => {
    return response.json();
}).then(data => {
    let i = 1;

    data.forEach(element => {
        let row = tabela.insertRow(i);

        let cellId = row.insertCell(0);
        let cellNome = row.insertCell(1);
        let cellEspecialidade = row.insertCell(2);
        let cellDataCadastro = row.insertCell(3);
        let cellAtivo = row.insertCell(4);

        cellId.innerHTML = element['id_profissional']
        cellNome.innerHTML = element['nome'];
        cellEspecialidade.innerHTML = element['especialidade']['nomeEspecialidade'];

        let valores = formataData(element['dataCadastro']);
        cellDataCadastro.innerHTML = valores;

        cellAtivo.innerHTML = element['ativo'] === true ? "Ativo" : "Inativo";

        i++;

    })
})