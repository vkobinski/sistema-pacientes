function getFrame() {
    return document.getElementById("pessoaFrame").contentWindow;
}

function getEndereco() {
    return getFrame().getEnderecoFrame().geraEndereco();
}

function getPessoa() {
    return getFrame().geraPessoa();
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


function getFamiliar() {

  let pessoa = getPessoa();
  let endereco = getEndereco();
  let atendido = document.getElementById("buscaAtendido").contentWindow.getAtendido();

  let grauParentescoSelect = document.getElementById("grauParentesco");
  let grauParentesco = grauParentescoSelect.options[grauParentescoSelect.selectedIndex].text;

  let escolaridadeSelect = document.getElementById("escolaridade");
  let escolaridade = escolaridadeSelect.options[escolaridadeSelect.selectedIndex].text;

  let familiar = {
    pessoa,
    grauParentesco,
    escolaridade,
  }

  familiar = flattenObject(familiar);
  return {
    "familiar" :familiar,
    "endereco" :endereco,
    "atendido" :atendido,
  }

}

document.getElementById("cadastrar").onclick = () => {
  fetch("/api/v1/familiar", {
    method: "POST",
    headers: {
      "Content-Type": "application/json",
    },
    body: JSON.stringify(getFamiliar()),
  }).then(response => {
    return response.json();
  }).then(data => {
    console.log(data);
  })
}