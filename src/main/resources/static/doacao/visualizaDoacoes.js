
fetch("/api/v1/doacao", {
    method: "GET"
}).then(response => response.json())
.then(data => {


    const tabela = document.getElementById("tabela-doacoes");
    let i = 1;

        data.forEach(element => {

            let row = tabela.insertRow(i);

            let cellAtendido = row.insertCell(0);
            let cellTipo = row.insertCell(1);
            let cellQuantidade = row.insertCell(2);
            let cellData = row.insertCell(3);

            cellAtendido.innerHTML = element['atendido']['nome'];
            cellTipo.innerHTML = element['recurso']['tipoRecurso']['tipo'];
            cellQuantidade.innerHTML = element['recurso']['quantidade'];
            cellData.innerHTML = element['dataDoacao'];
            i++;


        });
});