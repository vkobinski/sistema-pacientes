const seletor = document.getElementById("tipo_recurso");
const area_adicional = document.getElementById("area-adicional");
const botao_cria = document.getElementById("botao-cria");

let adicionar = false;



fetch("/api/v1/tiporecurso", {
  method: "GET",
})
  .then((response) => {
    return response.json();
  })
  .then((data) => {
    data.forEach((element) => {
      let option = document.createElement("option");
      option.text = element["tipo"];

      seletor.add(option);
    });
  });

botao_cria.onclick = () => {
  if (adicionar) {
    enviaElementos();
  } else {
    adicionaElementos();
  }
};

function enviaElementos() {
  let elemento = seletor.options[seletor.selectedIndex];
  elemento = elemento.text;

  adicionar = true;

  switch (elemento) {
    case "Medicamento":
      enviaMedicamento();
      break;
    case "Roupa":
      enviaRoupa();
      break;
    case "Material":
      enviaMaterial();
      break;
    case "Cabelo":
      enviaCabelo();
      break;
    case "Alimento":
      enviaAlimento();
      break;
  }
}

function adicionaElementos() {
  let elemento = seletor.options[seletor.selectedIndex];
  elemento = elemento.text;

  adicionar = true;

  elemento = elemento.trim();

  switch (elemento) {
    case "Medicamento":
      criaMedicamento();
      break;
    case "Roupa":
      criaRoupa();
      break;
    case "Material":
      criaMaterial();
      break;
    case "Cabelo":
      criaCabelo();
      break;
    case "Alimento":
      criaAlimento();
      break;
  }
}
