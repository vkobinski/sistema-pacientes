function getFrame() {
    return document.getElementById("atendidoFrame").contentWindow;
}

function getAtendido() {
  return getFrame().getAtendido();
}

function getPaciente() {
  let nivelPrioridade = document.getElementById("nivelPrioridade").value;

  let paciente = {
    "atendido": getAtendido(),
    "nivel_prioridade": nivelPrioridade,
  }
  return paciente;
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

document.getElementById("cadastrarPaciente").onclick = () => {
  let paciente = getPaciente();
  delete paciente['atendido']['endereco'];

  let endereco = getPaciente()['atendido']['endereco'];

  console.log(JSON.stringify({
      "paciente": flattenObject(getPaciente()),
      endereco}));

  fetch("/api/v1/paciente", {
    method: "POST",
    headers: {
      "Content-Type": "application/json",
    },
    body: JSON.stringify({
      "paciente": flattenObject(getPaciente()),
      endereco
    }),
  }).then(response => {
    if(response.status === 200) console.log("Bem sucedido");
    return response.json();
  }).then(data => {
    console.log(data);
  })
}