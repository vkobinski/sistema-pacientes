const tabela = document.getElementById("table")

fetch("/api/v1/voluntaria", {
    method: "GET"
})
    .then(response => {
        return response.json()
    })
    .then(data => {
        let i = 1;
        data.forEach(element => {
            
            let row = tabela.insertRow(i);

            let cell1 = row.insertCell(0);
            let cell2 = row.insertCell(1);

            cell1.innerHTML = element['id_voluntaria'];
            cell2.innerHTML = element['nome'];

            i++;
        });
    });
