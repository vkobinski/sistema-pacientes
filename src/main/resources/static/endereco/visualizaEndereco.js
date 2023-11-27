const tabela = document.getElementById("tabela");
const tabelaHTML = tabela.innerHTML;

let idEndereco;


function atualizar() {

  let input =  gatherAddressInputValues();

  fetch("/api/v1/endereco/" + idEndereco, {
    method: "PUT",
    headers: {
      "Content-Type": "application/json",
    },
    body: JSON.stringify(input)
  });
}


function gatherAddressInputValues() {
  var logradouro = document.getElementById('logradouroInput').value;
  var bairro = document.getElementById('bairroInput').value;
  var complemento = document.getElementById('complementoInput').value;
  var referencia = document.getElementById('referenciaInput').value;
  var cidade = document.getElementById('cidadeInput').value;
  var estado = document.getElementById('estadoInput').value;
  var cep = document.getElementById('cepInput').value;

  return {
    logradouro: logradouro,
    bairro: bairro,
    complemento: complemento,
    pontoReferencia: referencia,
    nomeCidade: cidade,
    nomeEstado: estado,
    cep: cep,
  };
}

function criaEnderecoTabela(id) {

  idEndereco = id;

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

      cellLogradouro.innerHTML = "<input id='logradouroInput' value='" + element["logradouro"] + "'>";
      cellBairro.innerHTML = "<input id='bairroInput' value='" + element["bairro"] + "'>";
      cellComplemento.innerHTML = "<input id='complementoInput' value='" + element["complemento"] + "'>";
      cellReferencia.innerHTML = "<input id='referenciaInput' value='" + element["pontoReferencia"] + "'>";
      cellCidade.innerHTML = "<input id='cidadeInput' value='" + element["nomeCidade"] + "'>";
      cellEstado.innerHTML = "<input id='estadoInput' value='" + element["nomeEstado"] + "'>";
      cellCEP.innerHTML = "<input id='cepInput' value='" + element["cep"] + "'>";
    });
}
