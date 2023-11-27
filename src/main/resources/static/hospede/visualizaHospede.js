const tabela = document.getElementById("tabela");
const tabelaHTML = tabela.innerHTML;

const urlParams = new URLSearchParams(window.location.search);

const arg1 = urlParams.get("id");
preencheTabela(arg1);

window.onload = function () {
  document
      .getElementById("visualizaEndereco")
      .contentWindow.criaEnderecoTabela(arg1);
};


function atualizar() {

  let input = gatherTableInputValues();

  fetch("/api/v1/hospede/" + arg1, {
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
  var dataRegistro = document.getElementById('dataRegistroInput').value;
  var estagioDoenca = document.getElementById('estagioDoencaInput').value;
  var tipoCancro = document.getElementById('tipoCancroInput').value;
  var quartoHospedagem = document.getElementById('quartoHospedagemInput').value;
  var tratamento = document.getElementById('tratamentoInput').value;
  var horarioTratamento = document.getElementById('horarioTratamentoInput').value;
  var tipoRefeicao = document.getElementById('tipoRefeicaoInput').value;
  var dataFalecimento = document.getElementById('dataFalecimentoInput').value;
  var condicoes = document.getElementById('condicoesInput').value;

  return {
    rg: rg,
    nome: nome,
    dataNascimento: dataNascimento,
    profissao: profissao,
    telefone: telefone,
    sexo: sexo,
    estadoCivil: estadoCivil,
    socioeconomica: socioeconomica,
    data_registro: dataRegistro,
    estagioDoenca: estagioDoenca,
    tipo_cancro: tipoCancro,
    quartoHospedagem: quartoHospedagem,
    condicoesTrabalho: condicoes,
    tratamento: tratamento,
    horarioTratamento: horarioTratamento,
    tipoRefeicao: tipoRefeicao,
    data_falecimento: dataFalecimento
  };
}

function preencheTabela(id) {
  fetch("/api/v1/hospede/" + id, {
    method: "GET",
  })
    .then((response) => {
      return response.json();
    })
    .then((data) => {
      tabela.innerHTML = tabelaHTML;

      if (data.length === 0) return;

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
      let cellQuartoHospedagem = row.insertCell(13);
      let cellTratamento = row.insertCell(14);
      let cellHorarioTratamento = row.insertCell(15);
      let cellTipoRefeicao = row.insertCell(16);
      let cellDataFalecimento = row.insertCell(17);
      let cellCondicoes = row.insertCell(18);

      cellCondicoes.innerHTML =
          "<textarea id='condicoesInput' >" +
          data["condicoesTrabalho"] +
          "</textarea>";


      cellId.innerHTML = data["id_pessoa"];
      cellRg.innerHTML = "<input id='rgInput' value='" + data["rg"] + "'>";
      cellCpf.innerHTML = data["cpf"];
      cellNome.innerHTML = "<input id='nomeInput' value='" + data["nome"] + "'>";
      cellNascimento.innerHTML = "<input id='nascimentoInput' type='date' value='" + data["dataNascimento"] + "'>";
      cellProfissao.innerHTML = "<input id='profissaoInput' value='" + data["profissao"] + "'>";
      cellTelefone.innerHTML = "<input id='telefoneInput' value='" + data["telefone"] + "'>";
      cellSexo.innerHTML = "<input id='sexoInput' value='" + data["sexo"] + "'>";
      cellEstadoCivil.innerHTML = "<input id='estadoCivilInput' value='" + data["estadoCivil"] + "'>";
      cellSocioeconomica.innerHTML = "<input id='socioeconomicaInput' value='" + data["socioeconomica"]["nome"] + "'>";
      cellDataRegistro.innerHTML = "<input id='dataRegistroInput' type='date' value='" + data["data_registro"] + "'>";
      cellEstagioDoenca.innerHTML = "<input id='estagioDoencaInput' value='" + data["estagioDoenca"]["nome"] + "'>";
      cellTipoCancro.innerHTML = "<input id='tipoCancroInput' value='" + data["tipo_cancro"] + "'>";
      cellQuartoHospedagem.innerHTML = "<input id='quartoHospedagemInput' value='" + data["quartoHospedagem"]["nome"] + "'>";
      cellTratamento.innerHTML = "<input id='tratamentoInput' value='" + data["tratamento"] + "'>";
      cellHorarioTratamento.innerHTML = "<input id='horarioTratamentoInput' value='" + data["horarioTratamento"] + "'>";
      cellTipoRefeicao.innerHTML = "<input id='tipoRefeicaoInput' value='" + data["tipoRefeicao"]["nome"] + "'>";
      cellDataFalecimento.innerHTML = "<input id='dataFalecimentoInput' type='date' value='" + data["data_falecimento"] + "'>";


    });
}