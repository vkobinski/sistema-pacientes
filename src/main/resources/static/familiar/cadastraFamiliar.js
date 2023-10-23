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

      if (typeof value === "object" && value !== null) {
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
  let atendido = document
    .getElementById("buscaAtendido")
    .contentWindow.getAtendido();

  let grauParentescoSelect = document.getElementById("grauParentesco");
  let grauParentesco =
    grauParentescoSelect.options[grauParentescoSelect.selectedIndex].text;

  let escolaridadeSelect = document.getElementById("escolaridade");
  let escolaridade =
    escolaridadeSelect.options[escolaridadeSelect.selectedIndex].text;

    let condicoesTrabalho = document.getElementById("condicoes").value;

  let familiar = {
    pessoa,
    grauParentesco,
    escolaridade,
    condicoesTrabalho,
  };

  familiar = flattenObject(familiar);
  return {
    familiar: familiar,
    endereco: endereco,
    atendido: atendido,
  };
}

document.getElementById("cadastrar").onclick = () => {
  const span = document.getElementById("span-cadastro");
  const botaoCadastrar = document.getElementById("cadastrar");

  fetch("/api/v1/familiar", {
    method: "POST",
    headers: {
      "Content-Type": "application/json",
    },
    body: JSON.stringify(getFamiliar()),
  }).then((response) => {
    if (response.status == 200) {
      span.innerHTML = "Cadastro concluído!";
      span.style.visibility = "visible";
      botaoCadastrar.disabled = true;
    } else {
      span.innerHTML = "Não foi possível Cadastrar";
      span.style.visibility = "visible";
    }
  });
};
