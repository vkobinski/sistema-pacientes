const tabela = document.getElementById("tabela");
const tabelaHTML = tabela.innerHTML;


const urlParams = new URLSearchParams(window.location.search);

const arg1 = urlParams.get("id");

window.onload = function () {
  document
      .getElementById("visualizaEndereco")
      .contentWindow.criaEnderecoTabela(arg1);
};

preencheTabela(arg1);


function atualizar() {

  let input = gatherInputValues();

  fetch("/api/v1/familiar/" + arg1, {
    method: "PUT",
    headers: {
      "Content-Type": "application/json",
    },
    body: JSON.stringify(input)
  });
}

function gatherInputValues() {
  var rg = document.getElementById('rgInput').value;
  var nome = document.getElementById('nomeInput').value;
  var nascimento = document.getElementById('nascimentoInput').value;
  var profissao = document.getElementById('profissaoInput').value;
  var telefone = document.getElementById('telefoneInput').value;
  var sexo = document.getElementById('sexoInput').value;
  var estadoCivil = document.getElementById('estadoCivilInput').value;
  var socioeconomica = document.getElementById('socioeconomicaInput').value;
  var parentesco = document.getElementById('parentescoInput').value;
  var atendido = document.getElementById('atendidoInput').value;
  var condicoes = document.getElementById('condicoesInput').value;

  return {
    rg: rg,
    nome: nome,
    nascimento: nascimento,
    profissao: profissao,
    telefone: telefone,
    sexo: sexo,
    estadoCivil: estadoCivil,
    socioeconomica: socioeconomica,
    parentesco: parentesco,
    condicoesTrabalho: condicoes,
    atendido: atendido
  };
}

function preencheTabela(id) {
  fetch("/api/v1/familiar/" + id, {
    method: "GET",
  })
    .then((response) => {
      return response.json();
    })
    .then((data) => {
      tabela.innerHTML = tabelaHTML;

      if (data.length == 0) return;

      let row = tabela.insertRow(1);

      let cellId = row.insertCell(0);
      let cellRg = row.insertCell(1);
      let cellCpf = row.insertCell(2);
      let cellNome = row.insertCell(3);
      let cellNascimento = row.insertCell(4);
      let cellProfissao = row.insertCell(5);
      let cellTelefone = row.insertCell(6);
      let cellSexo = row.insertCell(7);
      let cellEstadoCivil = row.insertCell(8);
      let cellSocioeconomica = row.insertCell(9);
      let cellParentesco = row.insertCell(10);
      let cellAtendido = row.insertCell(11);
      let cellCondicoes = row.insertCell(12);

      cellCondicoes.innerHTML =
        "<textarea id='condicoesInput' >" +
        data["condicoesTrabalho"] +
        "</textarea>";

      cellId.innerHTML = data["id_pessoa"];
      cellCpf.innerHTML = data["cpf"];
      cellRg.innerHTML = "<input id='rgInput' value='" + data["rg"] + "'>";
      cellNome.innerHTML = "<input id='nomeInput' value='" + data["nome"] + "'>";
      cellNascimento.innerHTML = "<input id='nascimentoInput' type='date' value='" + data["dataNascimento"] + "'>";
      cellProfissao.innerHTML = "<input id='profissaoInput' value='" + data["profissao"] + "'>";
      cellTelefone.innerHTML = "<input id='telefoneInput' value='" + data["telefone"] + "'>";
      cellSexo.innerHTML = "<input id='sexoInput' value='" + data["sexo"] + "'>";
      cellEstadoCivil.innerHTML = "<input id='estadoCivilInput' value='" + data["estadoCivil"] + "'>";
      cellSocioeconomica.innerHTML = "<input id='socioeconomicaInput' value='" + data["socioeconomica"]["nome"] + "'>";
      cellParentesco.innerHTML = "<input id='parentescoInput' value='" + data["grauParentesco"] + "'>";
      cellAtendido.innerHTML = "<input id='atendidoInput' value='" + data["atendido"]['nome'] + "'>";

    });
}

