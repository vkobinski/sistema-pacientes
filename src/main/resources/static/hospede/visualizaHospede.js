const tabela = document.getElementById("tabela");
const tabelaHTML = tabela.innerHTML;

function preencheTabela(id) {
  fetch("/api/v1/hospede/" + id, {
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
      let cellDataRegistro = row.insertCell(10);
      let cellEstagioDoenca = row.insertCell(11);
      let cellTipoCancro = row.insertCell(12);
      let cellQuartoHospedagem = row.insertCell(13);
      let cellTratamento = row.insertCell(14);
      let cellHorarioTratamento = row.insertCell(15);
      let cellTipoRefeicao = row.insertCell(16);
      let cellDataFalecimento = row.insertCell(17);
      let cellCondicoes = row.insertCell(15);
          cellCondicoes.innerHTML = "<textarea disabled='true'>" + element["condicoesTrabalho"] + "</textarea>";


      cellId.innerHTML = data["id_pessoa"];
      cellRg.innerHTML = data["rg"];
      cellCpf.innerHTML = data["cpf"];
      cellNome.innerHTML = data["nome"];
      cellNascimento.innerHTML = data["dataNascimento"];
      cellProfissao.innerHTML = data["profissao"];
      cellTelefone.innerHTML = data["telefone"];
      cellSexo.innerHTML = data["sexo"];
      cellEstadoCivil.innerHTML = data["estadoCivil"];
      cellSocioeconomica.innerHTML = data["socioeconomica"]["nome"];
      cellDataRegistro.innerHTML = data["data_registro"];
      cellEstagioDoenca.innerHTML = data["estagioDoenca"]["nome"];
      cellTipoCancro.innerHTML = data["tipo_cancro"];
      cellQuartoHospedagem.innerHTML = data["quartoHospedagem"]["nome"];
      cellTratamento.innerHTML = data["tratamento"];
      cellHorarioTratamento.innerHTML = data["horarioTratamento"];
      cellTipoRefeicao.innerHTML = data["tipoRefeicao"]["nome"];
      cellDataFalecimento.innerHTML = data["data_falecimento"];

      window.onload = function () {
        document
          .getElementById("visualizaEndereco")
          .contentWindow.criaEnderecoTabela(data["endereco"]["id_endereco"]);
      };
    });
}

const urlParams = new URLSearchParams(window.location.search);

const arg1 = urlParams.get("id");
preencheTabela(arg1);