function foiSalvo(response) {
  const span = document.getElementById("span-cadastro");
  const botaoCadastrar = document.getElementById("cadastraButton");

  if (response.status == 200) {
    span.innerHTML = "Cadastro concluído!";
    span.style.visibility = "visible";
    botaoCadastrar.disabled = true;
  } else {
    span.innerHTML = "Não foi possível Cadastrar";
    span.style.visibility = "visible";
  }
}

function getRecurso() {
  let quantidadeV = parseInt(document.getElementById("qtd").value);
  let dataAq = document.getElementById("data_aquisicao").value;
  const tipoRecursoSelect = document.getElementById("tipo_recurso");
  let tipoRecurso =
    tipoRecursoSelect.options[tipoRecursoSelect.selectedIndex].text;

  return {
    quantidade: quantidadeV,
    tipoRecurso: tipoRecurso,
    data_aquisicao: dataAq,
  };
}

function enviaMaterial() {
  const tipoMaterialSelect = document.getElementById("tipoMaterial");
  let tipoMaterial =
    tipoMaterialSelect.options[tipoMaterialSelect.selectedIndex].text;

  let recurso = getRecurso();
  recurso["tipoMaterial"] = tipoMaterial;

  fetch("/api/v1/material", {
    method: "POST",
    headers: {
      "Content-Type": "application/json",
    },
    body: JSON.stringify(recurso),
  }).then((response) => {
    foiSalvo(response);
  });
}

function enviaRoupa() {
  let kit = document.getElementById("kit").value;

  let recurso = getRecurso();
  recurso["kit"] = kit;

  fetch("/api/v1/roupa", {
    method: "POST",
    headers: {
      "Content-Type": "application/json",
    },
    body: JSON.stringify(recurso),
  }).then((response) => {
    foiSalvo(response);
  });
}

function enviaCabelo() {
  const corTipoSelect = document.getElementById("cor");
  let corTipo = corTipoSelect.options[corTipoSelect.selectedIndex].text;
  let comprimento = document.getElementById("comprimento").value;

  let recurso = getRecurso();
  recurso["cor"] = corTipo;
  recurso["comprimento"] = comprimento;

  fetch("/api/v1/cabelo", {
    method: "POST",
    headers: {
      "Content-Type": "application/json",
    },
    body: JSON.stringify(recurso),
  }).then((response) => {
    foiSalvo(response);
  });
}

function enviaMedicamento() {
  let nome = document.getElementById("nome").value;

  let precoField = document.getElementById("preco").value;

  let preco = parseFloat(precoField.replace(",", "."));
  let farmaciaCompra = document.getElementById("farmacia-compra").value;

  let recurso = getRecurso();
  recurso["nome"] = nome;
  recurso["preco"] = preco;
  recurso["farmacia_compra"] = farmaciaCompra;

  console.log(JSON.stringify(recurso));

  fetch("/api/v1/medicamento", {
    method: "POST",
    headers: {
      "Content-Type": "application/json",
    },
    body: JSON.stringify(recurso),
  }).then((response) => {
    foiSalvo(response);
  });
}

function enviaAlimento() {
  const tipoAlimentoSelect = document.getElementById("tipoAlimento");
  let tipoAlimento =
    tipoAlimentoSelect.options[tipoAlimentoSelect.selectedIndex].text;

  let recurso = getRecurso();
  recurso["tipoAlimento"] = tipoAlimento;

  fetch("/api/v1/alimento", {
    method: "POST",
    headers: {
      "Content-Type": "application/json",
    },
    body: JSON.stringify(recurso),
  }).then((response) => {
    foiSalvo(response);
  });
}

function criaMedicamento() {
  area_adicional.innerHTML = `
        <div class="inputBoth">
        <label class="inputText" for="nome">Nome:</label>
        <input class="inputField" type="text" id="nome"/>
        </div>
        <div class="inputBoth">
        <label class="inputText" for="preco">Preço:</label>
        <input class="inputField" type="number" step="0.01" id="preco"/>
        </div>
        <div class="inputBoth">
        <label class="inputText" for="farmacia-compra">Farmácia de compra:</label>
        <input class="inputField" type="text" id="farmacia-compra"/>
        </div>
    `;
}

function criaRoupa() {
  area_adicional.innerHTML = `
        <div class="inputBoth">
        <label class="inputText" for="kit">Tamanho do Kit:</label>
        <input class="inputField" type="number" id="kit"/>
        </div>
    `;
}

function criaAlimento() {
  area_adicional.innerHTML = `
        <div class="inputBoth">
        <label class="inputText" for="tipoAlimento">Tipo do Alimento:</label>
        <select class="inputField" id="tipoAlimento"></select>
        </div>
    `;

  let select_alimento = document.getElementById("tipoAlimento");

  fetch("/api/v1/tipoalimento", {
    method: "GET",
  })
    .then((response) => {
      return response.json();
    })
    .then((data) => {
      data.forEach((element) => {
        let option = document.createElement("option");
        option.text = element["nome"];

        select_alimento.add(option);
      });
    });
}

function criaMaterial() {
  area_adicional.innerHTML = `
        <div class="inputBoth">
        <label class="inputText" for="tipoMaterial">Tipo do Material:</label>
        <select class="inputField" id="tipoMaterial"></select>
        </div>
    `;

  let select_material = document.getElementById("tipoMaterial");

  fetch("/api/v1/tipomaterial", {
    method: "GET",
  })
    .then((response) => {
      return response.json();
    })
    .then((data) => {
      data.forEach((element) => {
        let option = document.createElement("option");
        option.text = element["nome"];

        select_material.add(option);
      });
    });
}

function criaCabelo() {
  area_adicional.innerHTML = `
        <div class="inputBoth">
        <label class="inputText" for="cor">Cor:</label>
        <select class="inputField" id="cor"></select>
        </div>
        <div class="inputBoth">
        <label class="inputText" for="comprimento">Comprimento (cm):</label>
        <input class="inputField" id="comprimento" type="number"/>
        </div>
    `;

  let select_cor = document.getElementById("cor");

  fetch("/api/v1/tipocabelo", {
    method: "GET",
  })
    .then((response) => {
      return response.json();
    })
    .then((data) => {
      data.forEach((element) => {
        let option = document.createElement("option");
        option.text = element["tipo"];

        select_cor.add(option);
      });
    });
}
