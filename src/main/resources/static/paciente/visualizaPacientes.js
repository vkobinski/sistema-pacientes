const tabela = document.getElementById("tabela");
const tabelaHTML = tabela.innerHTML;


function preencheTabela() {
  fetch("/api/v1/paciente", {
    method: "GET",
  })
    .then((response) => {
      return response.json();
    })
    .then((data) => {
      tabela.innerHTML = tabelaHTML;

      let i = 1;

      if(data.length == 0) return;

      if (Array.isArray(data)) {
        data.forEach((element) => {
          let row = tabela.insertRow(i);

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
          console.log(element);
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
          cellDataFalecimento.innerHTML = element["data_falecimento"];
          cellNivelPrioridade.innerHTML = element["nivel_prioridade"];

          i++;
        });
      } else {
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

        cellId.innerHTML = data["id_pessoa"];
        cellRg.innerHTML = data["rg"];
        cellCpf.innerHTML = data["cpf"];
        cellNome.innerHTML = "<a href='/paciente/visualizaPaciente.html?id=" + data['id_pessoa'] + "'>" + data['nome'] + "</a>";
        cellNascimento.innerHTML = data["dataNascimento"];
        cellProfissao.innerHTML = data["profissao"];
        cellTelefone.innerHTML = data["telefone"];
        cellSexo.innerHTML = data["sexo"];
        cellEstadoCivil.innerHTML = data["estadoCivil"];
        cellSocioeconomica.innerHTML = data["socioeconomica"]["nome"];
        cellDataRegistro.innerHTML = data["data_registro"];
        cellEstagioDoenca.innerHTML = data["estagioDoenca"]["nome"];
        cellTipoCancro.innerHTML = data["tipo_cancro"];
        cellDataFalecimento.innerHTML = data["data_falecimento"];
        cellNivelPrioridade.innerHTML = data["nivel_prioridade"];
      }
    });
}

preencheTabela();
