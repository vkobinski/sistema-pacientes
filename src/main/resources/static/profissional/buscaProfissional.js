const tipo = document.getElementById("tipo");
const queryDiv = document.getElementById("queryDiv");

let profissionalId = null;

tipo.onchange = () => {
  let tipoValor = tipo.options[tipo.selectedIndex].text;
  if (tipoValor == "Nome") {
    queryDiv.innerHTML = "<input id='query' type='text'/>";
  } else {
    queryDiv.innerHTML = "<select id='query'></select>";
    let query = document.getElementById("query");
    fetch("/api/v1/especialidade", {
      method: "GET",
    })
      .then((response) => {
        return response.json();
      })
      .then((data) => {
        data.forEach((element) => {
          const option = document.createElement("option");
          option.text = element["nomeEspecialidade"];
          option.id = element["idEspecialidade"];

          query.add(option);
        });
      });
  }
};

function adicionarProfissional(id) {
    profissionalId = id;
}

function getProfissionalId() {
    return profissionalId;
}

function preencheTabela(data) {
  const tabela = document.getElementById("tabela-profissionais");

  for (let i = tabela.rows.length - 1; i > 0; i--) {
    tabela.deleteRow(i);
  }

  let i = 1;

  if (!Array.isArray(data)) {
    let row = tabela.insertRow(1);

    let cellId = row.insertCell(0);
    let cellNome = row.insertCell(1);
    let cellEspecialidade = row.insertCell(2);
    let cellDataCadastro = row.insertCell(3);
    let cellAtivo = row.insertCell(4);
    let cellButton = row.insertCell(5);

    cellId.innerHTML = data["id_profissional"];
    cellNome.innerHTML = data["nome"];
    cellEspecialidade.innerHTML = data["especialidade"]["nomeEspecialidade"];

    let valores = data["dataCadastro"];
    cellDataCadastro.innerHTML = valores;

    cellAtivo.innerHTML = data["ativo"] === true ? "Ativo" : "Inativo";
    cellButton.innerHTML =
      "<button onclick='adicionarProfissional(" +
      data["id_profissional"] +
      ")'>Adicionar</button>";
  } else {
    data.forEach((element) => {
      let row = tabela.insertRow(i);

      let cellId = row.insertCell(0);
      let cellNome = row.insertCell(1);
      let cellEspecialidade = row.insertCell(2);
      let cellDataCadastro = row.insertCell(3);
      let cellAtivo = row.insertCell(4);
      let cellButton = row.insertCell(5);

      cellId.innerHTML = element["id_profissional"];
      cellNome.innerHTML = element["nome"];
      cellEspecialidade.innerHTML =
        element["especialidade"]["nomeEspecialidade"];

      let valores = element["dataCadastro"];
      cellDataCadastro.innerHTML = valores;

      cellAtivo.innerHTML = element["ativo"] === true ? "Ativo" : "Inativo";
      cellButton.innerHTML =
        "<button onclick='adicionarProfissional(" +
        element["id_profissional"] +
        ")'>Adicionar</button>";

      i++;
    });
  }
}

function procuraPorNome() {
  let busca = document.getElementById("query").value;
  fetch("/api/v1/profissional/nome/" + busca, {
    method: "GET",
  })
    .then((response) => {
      return response.json();
    })
    .then((data) => {
      preencheTabela(data);
    });
}

function procuraPorEspecialidade() {
  let buscaCampo = document.getElementById("query");
  let busca = buscaCampo.options[buscaCampo.selectedIndex].id;

  fetch("/api/v1/profissional/especialidade/" + busca, {
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
  let tipoValor = tipo.options[tipo.selectedIndex].text;
  switch (tipoValor) {
    case "Nome":
      procuraPorNome();
      break;
    case "Especialidade":
      procuraPorEspecialidade();
      break;
  }
};
