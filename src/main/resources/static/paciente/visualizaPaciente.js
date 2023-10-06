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

      cellId.innerHTML = element["id_pessoa"];
      cellRg.innerHTML = element["rg"];
      cellCpf.innerHTML = element["cpf"];
      cellNome.innerHTML = element["nome"];
      cellNascimento.innerHTML = element["dataNascimento"];
      cellProfissao.innerHTML = element["profissao"];
      cellTelefone.innerHTML = element["telefone"];
      cellSexo.innerHTML = element["sexo"];
      cellEstadoCivil.innerHTML = element["estadoCivil"];
      cellSocioeconomica.innerHTML = element["socioeconomica"]["nome"];
      cellDataRegistro.innerHTML = element["data_registro"];
      cellEstagioDoenca.innerHTML = element["estagioDoenca"]["nome"];
      cellTipoCancro.innerHTML = element["tipo_cancro"];
      cellDataFalecimento.innerHTML = element["data_falecimento"];
      cellNivelPrioridade.innerHTML = element["nivel_prioridade"];

     
    });
}
