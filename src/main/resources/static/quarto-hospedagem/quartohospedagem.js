const tabela = document.getElementById("tabela");

document.getElementById("cadastrar").onclick = () => {
  let estagioDoenca = document.getElementById("estagio_doenca").value;

  let voluntariaJ = {
    nome: estagioDoenca,
  };

  fetch("/api/v1/estagiodoenca", {
    method: "POST",
    headers: {
      "Content-Type": "application/json",
    },
    body: JSON.stringify(voluntariaJ),
  }).then(response => {
    if(response.status === 200) {
    document.getElementById("cadastroSpan").style = "";
    }
    return response.json();
  }).then(data => {
    preencheTabela();
  })
  
};

function preencheTabela() {

    let rowsCount = tabela.rows.length;

    for(let i = 1; i < rowsCount; i++) {
        tabela.deleteRow(1);
    }
    
  fetch("/api/v1/estagiodoenca", {
    method: "GET",
  }).then((response) => {
      return response.json();
    })
    .then((data) => {
      dataArray = [];
      if (!Array.isArray(data)) {
        dataArray[0] = data;
      } else {
        dataArray = data;
      }

      let i = 1;

      dataArray.forEach((element) => {
        let row = tabela.insertRow(i);

        let cellId = row.insertCell(0);
        let cellNome = row.insertCell(1);
        let cellAtivo = row.insertCell(2);
        let cellDeletar = row.insertCell(3);

        cellId.innerHTML = element["idEstagioDoenca"];
        cellNome.innerHTML = element["nome"];
        cellAtivo.innerHTML = element["ativo"] === true ? "Ativo" : "Inativo";
        cellDeletar.innerHTML = "<button onclick='deletar(" + element["idEstagioDoenca"] + ")'>Deletar</button>";
        
        i++;
      });
    });
}

function deletar(id) { 
    fetch("/api/v1/estagiodoenca/" + id, {
        method: "DELETE"
    }).then(response => {
        if(response.status === 200) {
            document.getElementById("deletarSpan").style = "";
        }
    })
}

preencheTabela();