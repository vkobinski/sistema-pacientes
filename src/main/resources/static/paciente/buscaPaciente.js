let paciente = null;
const tabela = document.getElementById("tabela-busca");

function getPaciente() {
  return paciente;
}

function preencheTabela(data) {
  let row;

  if (tabela.rows.length == 1) {
    row = tabela.insertRow(1);
  } else {
    row = tabela.rows[1];
  }

  let idCell = row.insertCell(0);
  let nomeCell = row.insertCell(1);
  let cpfCell = row.insertCell(2);
  let adicionarBtn = row.insertCell(3);

  idCell.innerHTML = data["id_pessoa"];
  nomeCell.innerHTML =
    "<a href='/paciente/visualizaPaciente.html?id=" +
    data["id_pessoa"] +
    "'>" +
    data["nome"] +
    "</a>";
  cpfCell.innerHTML = data["cpf"];
  adicionarBtn.innerHTML = "<button id='adicionar'>Adicionar</button>";

  document.getElementById("adicionar").onclick = () => {
    paciente = idCell.innerHTML;
    console.log(paciente);
  };
}

function procuraPorNome(query) {
  fetch("/api/v1/paciente/nome/" + query, {
    method: "GET",
  })
    .then((response) => {
      return response.json();
    })
    .then((data) => {
      preencheTabela(data);
    });
}

function procuraPorCPF(query) {
  querySearch = query.replace(/[^0-9]/g, "");

  fetch("/api/v1/paciente/cpf/" + querySearch, {
    method: "GET",
  })
    .then((response) => {
      return response.json();
    })
    .then((data) => {
      preencheTabela(data);
    });
}

document.getElementById("buscar").onclick = () => {
  let selectTipo = document.getElementById("tipo");
  let tipo = selectTipo.options[selectTipo.selectedIndex].text;
  let query = document.getElementById("query").value;
  switch (tipo) {
    case "Nome":
      procuraPorNome(query);
      break;
    case "CPF":
      procuraPorCPF(query);
      break;
    default:
      break;
  }
};
