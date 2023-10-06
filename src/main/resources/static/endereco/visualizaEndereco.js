const tabela = document.getElementById("tabela");
const tabelaHTML = tabela.innerHTML;

function criaEnderecoTabela(id) {

  fetch("/api/v1/endereco/" + id, {
    method: "GET",
  })
    .then((response) => {
      return response.json();
    })
    .then((element) => {
      tabela.innerHTML = tabelaHTML;

      let row = tabela.insertRow(1);

      let cellLogradouro = row.insertCell(0);
      let cellBairro = row.insertCell(1);
      let cellComplemento = row.insertCell(2);
      let cellReferencia = row.insertCell(3);
      let cellCidade = row.insertCell(4);
      let cellEstado = row.insertCell(5);
      let cellCEP = row.insertCell(6);

      cellLogradouro.innerHTML = element["logradouro"];
      cellBairro.innerHTML = element["bairro"];
      cellComplemento.innerHTML = element["complemento"];
      cellReferencia.innerHTML = element["pontoReferencia"];
      cellCidade.innerHTML = element["nomeCidade"];
      cellEstado.innerHTML = element["nomeEstado"];
      cellCEP.innerHTML = element["cep"];
    });
}
