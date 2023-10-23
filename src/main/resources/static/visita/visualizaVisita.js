const tabela = document.getElementById("tabela-visitas");

fetch("/api/v1/visita", {
  method: "GET",
})
  .then((response) => {
    return response.json();
  })
  .then((data) => {
    let i = 1;

    data.forEach((element) => {
      let row = tabela.insertRow(i);

      let cellId = row.insertCell(0);
      let cellData = row.insertCell(1);
      let cellVoluntarias = row.insertCell(2);
      let cellPaciente = row.insertCell(3);
      let cellDescricao = row.insertCell(4);
      let cellEdita = row.insertCell(5);

      voluntariasString = "";

      element["voluntarias"].forEach((voluntaria) => {
        voluntariasString += voluntaria.nome + ", ";
      });

      console.log(element["voluntarias"]);

      cellId.innerHTML = element["id_visita"];
      cellData.innerHTML = element["data_visita"];
      cellVoluntarias.innerHTML = voluntariasString;
      cellPaciente.innerHTML = element["paciente"]["nome"];
      cellDescricao.innerHTML = "<textarea disabled='true'>" + element["descricaoVisita"] + "</textarea>";
      cellEdita.innerHTML =
        "<a href='/visita/editaVisita.html?id=" +
        element["id_visita"] +
        "'><button>Editar</button></a>";
    });
  });
