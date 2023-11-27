const tabela = document.getElementById("tabela");
const tabelaHTML = tabela.innerHTML;

const urlParams = new URLSearchParams(window.location.search);

const arg1 = urlParams.get('id');
preencheTabela(arg1);

 window.onload = function () {
        document
          .getElementById("visualizaEndereco")
          .contentWindow.criaEnderecoTabela(arg1);
      };


function atualizar() {

  let input = gatherTableInputValues();

  document
      .getElementById("visualizaEndereco")
      .contentWindow.atualizar();

  fetch("/api/v1/paciente/" + arg1, {
    method: "PUT",
    headers: {
      "Content-Type": "application/json",
    },
    body: JSON.stringify(input)
  });
}


function gatherTableInputValues() {
  var rg = document.getElementById('rgInput').value;
  var nome = document.getElementById('nomeInput').value;
  var dataNascimento = document.getElementById('nascimentoInput').value;
  var profissao = document.getElementById('profissaoInput').value;
  var telefone = document.getElementById('telefoneInput').value;
  var sexo = document.getElementById('sexoInput').value;
  var estadoCivil = document.getElementById('estadoCivilInput').value;
  var socioeconomica = document.getElementById('socioeconomicaInput').value;
  var estagioDoenca = document.getElementById('estagioDoencaInput').value;
  var tipoCancro = document.getElementById('tipoCancroInput').value;
  var dataFalecimento = document.getElementById('dataFalecimentoInput').value;
  var condicoes = document.getElementById('condicoesInput').value;
  var nivelPrioridade = document.getElementById("nivelprioridadeinput").value;

  return {
    rg: rg,
    nome: nome,
    dataNascimento: dataNascimento,
    profissao: profissao,
    telefone: telefone,
    sexo: sexo,
    estadoCivil: estadoCivil,
    socioeconomica: socioeconomica,
    estagioDoenca: estagioDoenca,
    tipo_cancro: tipoCancro,
    condicoesTrabalho: condicoes,
    data_falecimento: dataFalecimento,
    nivel_prioridade: nivelPrioridade,
  };
}

function preencheTabela(id) {
  fetch("/api/v1/paciente/" + id, {
    method: "GET",
  })
    .then((response) => {
      return response.json();
    })
    .then((element) => {
      tabela.innerHTML = tabelaHTML;

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
      let cellDataRegistro = row.insertCell(10);
      let cellEstagioDoenca = row.insertCell(11);
      let cellTipoCancro = row.insertCell(12);
      let cellNivelPrioridade = row.insertCell(13);
      let cellDataFalecimento = row.insertCell(14);
      let cellCondicoes = row.insertCell(15);

      cellCondicoes.innerHTML =
          "<textarea id='condicoesInput' >" +
          element["condicoesTrabalho"] +
          "</textarea>";

      cellId.innerHTML = element["id_pessoa"];
      cellRg.innerHTML = "<input id='rgInput' value='" + element["rg"] + "'>";
      cellCpf.innerHTML = element["cpf"];
      cellNome.innerHTML = "<input id='nomeInput' value='" + element["nome"] + "'>";
      cellNascimento.innerHTML = "<input id='nascimentoInput' type='date' value='" + element["dataNascimento"] + "'>";
      cellProfissao.innerHTML = "<input id='profissaoInput' value='" + element["profissao"] + "'>";
      cellTelefone.innerHTML = "<input id='telefoneInput' value='" + element["telefone"] + "'>";
      cellSexo.innerHTML = "<input id='sexoInput' value='" + element["sexo"] + "'>";
      cellEstadoCivil.innerHTML = "<input id='estadoCivilInput' value='" + element["estadoCivil"] + "'>";
      cellSocioeconomica.innerHTML = "<input id='socioeconomicaInput' value='" + element["socioeconomica"]["nome"] + "'>";
      cellDataRegistro.innerHTML = element["data_registro"];
      cellEstagioDoenca.innerHTML = "<input id='estagioDoencaInput' value='" + element["estagioDoenca"]["nome"] + "'>";
      cellTipoCancro.innerHTML = "<input id='tipoCancroInput' value='" + element["tipo_cancro"] + "'>";
      cellDataFalecimento.innerHTML = "<input id='dataFalecimentoInput' type='date' value='" + element["data_falecimento"] + "'>";
      cellNivelPrioridade.innerHTML = "<input id='nivelprioridadeinput' value='" + element["nivel_prioridade"] + "'>";

    });
}
