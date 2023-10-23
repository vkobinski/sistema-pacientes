function getFrame() {
    return document.getElementById("atendidoFrame").contentWindow;
}

function getAtendido() {
  return getFrame().getAtendido();
}

function getPaciente() {
  let nivelPrioridade = document.getElementById("nivelPrioridade").value;
    let condicoes = document.getElementById("condicoes").value;
    console.log(condicoes);

  let paciente = {
    "atendido": getAtendido(),
    "nivel_prioridade": nivelPrioridade,
    "condicoesTrabalho": condicoes,
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

  const span = document.getElementById("span-cadastro");
  const botaoCadastrar = document.getElementById("cadastrar");


  fetch("/api/v1/paciente", {
    method: "POST",
    headers: {
      "Content-Type": "application/json",
    },
    body: JSON.stringify({
      "paciente": flattenObject(getPaciente()),
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