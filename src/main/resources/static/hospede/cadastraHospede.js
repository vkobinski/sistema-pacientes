const quartoHospedagemCampo = document.getElementById("quartoHospedagem");
const tipoRefeicaoCampo = document.getElementById("refeicao");

fetch("/api/v1/quartohospedagem", {
        method: "GET"
    }).then(response => {
        return response.json();
    }).then(data => {
        
        data.forEach(element => {
            
            let option = document.createElement("option");
            option.text = element['nome'];

            quartoHospedagemCampo.add(option);
        });
})

fetch("/api/v1/tiporefeicao", {
        method: "GET"
    }).then(response => {
        return response.json();
    }).then(data => {
        
        data.forEach(element => {
            
            let option = document.createElement("option");
            option.text = element['nome'];

            tipoRefeicaoCampo.add(option);
        });
})

function getFrame() {
    return document.getElementById("atendidoFrame").contentWindow;
}

function getAtendido() {
  return getFrame().getAtendido();
}

function flattenObject(obj) {
    const result = {};
  
    for (const key in obj) {
      if (obj.hasOwnProperty(key)) {
        const value = obj[key];
  
        if (typeof value === 'object' && value !== null) {
          const flattenedObj = flattenObject(value);
          Object.assign(result, flattenedObj);
        } else {
          result[key] = value;
        }
      }
    }
  
    return result;
  }

function getHospede() {

    let dataEntrada = document.getElementById("dataEntrada").value;
    let dataSaida = document.getElementById("dataSaida").value;
    let quartoHospedagem = quartoHospedagemCampo.options[quartoHospedagemCampo.selectedIndex].text;
    let tipoRefeicao = tipoRefeicaoCampo.options[tipoRefeicaoCampo.selectedIndex].text;
    let tratamento = document.getElementById("tratamento").value;
    let horarioTratamento = document.getElementById("horarioTratamento").value;
    let condicoes = document.getElementById("condicoes").value;

    let hospede = {
        "atendido": getAtendido(),
        "dataEntrada": dataEntrada,
        "quartoHospedagem": quartoHospedagem,
        "tipoRefeicao": tipoRefeicao,
        "tratamento": tratamento,
        "horarioTratamento": horarioTratamento,
        "dataSaida": dataSaida,
        "condicoesTrabalho": condicoes,
    };

    return hospede;
}

document.getElementById("cadastrar").onclick = () => {
  let hospede = getHospede();
  delete hospede['atendido']['endereco'];

  let endereco = getHospede()['atendido']['endereco'];

  const span = document.getElementById("span-cadastro");
  const botaoCadastrar = document.getElementById("cadastrar");


  console.log(JSON.stringify({
    "hospede": flattenObject(hospede),
    endereco,
  }));

  fetch("/api/v1/hospede", {
    method: "POST",
    headers: {
      "Content-Type": "application/json",
    },
    body: JSON.stringify({
      "hospede": flattenObject(getHospede()),
     endereco,
    }),
  }).then(response => {
    if(response.status == 200) {
            span.innerHTML = "Cadastro concluído!";
            span.style.visibility = "visible";
            botaoCadastrar.disabled = true;
        } else {
            span.innerHTML = "Não foi possível Cadastrar";
            span.style.visibility = "visible";
        }
  });
}