const tabela = document.getElementById("tabela");
const tabelaHTML = tabela.innerHTML;


function criaLinha(element) {

    let row = tabela.insertRow(-1);

    let cellId = row.insertCell(-1);
    let cellRg = row.insertCell(-1);
    let cellCpf = row.insertCell(-1);
    let cellNome = row.insertCell(-1);
    let cellNascimento = row.insertCell(-1);
    let cellProfissao = row.insertCell(-1);
    let cellTelefone = row.insertCell(-1);
    let cellSexo = row.insertCell(-1);
    let cellEstadoCivil = row.insertCell(-1);
    let cellSocioeconomica = row.insertCell(-1);
    let cellDataRegistro = row.insertCell(-1);
    let cellEstagioDoenca = row.insertCell(-1);
    let cellTipoCancro = row.insertCell(-1);
    let cellTratamento = row.insertCell(-1);
    let cellNivelPrioridade = row.insertCell(-1);
    let cellDataFalecimento = row.insertCell(-1);
    let cellCondicoes = row.insertCell(-1);

    cellCondicoes.innerHTML = "<textarea disabled='true'>" + element["condicoesTrabalho"] + "</textarea>";

    cellId.innerHTML = element["id_pessoa"];
    cellRg.innerHTML = element["rg"];
    cellCpf.innerHTML = element["cpf"];
    cellNome.innerHTML = "<a href='/paciente/visualizaPaciente.html?id=" + element['id_pessoa'] + "'>" + element['nome'] + "</a>";
    cellNascimento.innerHTML = element["dataNascimento"];
    cellProfissao.innerHTML = element["profissao"];
    cellTelefone.innerHTML = element["telefone"];
    cellSexo.innerHTML = element["sexo"];
    cellEstadoCivil.innerHTML = element["estadoCivil"];
    cellSocioeconomica.innerHTML = element["socioeconomica"]["nome"];
    cellDataRegistro.innerHTML = element["data_registro"];
    cellEstagioDoenca.innerHTML = element["estagioDoenca"]["nome"];
    cellTipoCancro.innerHTML = element["tipo_cancro"];
    cellTratamento.innerHTML = element["tratamento"];
    cellNivelPrioridade.innerHTML = element["nivel_prioridade"];
    cellDataFalecimento.innerHTML = element["data_falecimento"];

}
function preencheTabela() {
    fetch("/api/v1/paciente", {
        method: "GET",
    })
        .then((response) => {
            return response.json();
        })
        .then((data) => {
            tabela.innerHTML = tabelaHTML;

            if (data.length === 0) return;

            if (!Array.isArray(data)) {
                criaLinha(data);
            }

            data.forEach((element) => {
                criaLinha(element);
            });
        });
}

preencheTabela();
