function mudarDiv(i) {
    const divs = ["medicamento-div", "roupas-div", "material-div", "cabelo-div", "alimento-div"];
    let mudarDiv = document.getElementById(divs[i]);
    mudarDiv.hidden = false;
}

function hideDiv() {

    const divs = ["medicamento-div", "roupas-div", "material-div", "cabelo-div", "alimento-div"];
    divs.forEach((divAtual) => {
            document.getElementById(divAtual).hidden = true;
        }
    )
}


hideDiv();

function fetchRecurso(id) {
    fetch("/api/v1/recurso/" + id, {
        method: "GET",
    })
        .then(response => response.json())
        .then(data => {
            preencheTabela(data);
        })
}

function preencheTabela(recurso) {

    const tabelas = ["tabela-medicamentos", "tabela-roupas", "tabela-material", "tabela-cabelo", "tabela-alimento"];
    const divs = ["medicamento-div", "roupas-div", "material-div", "cabelo-div", "alimento-div"];


    let i = 0;


    const tipoRecurso = recurso["tipoRecurso"];

    switch (tipoRecurso["tipo"]) {
        case "Medicamento":
            i = 0;
            preencheMedicamento(recurso["id_recurso"]);
            break;
        case "Roupa":
            i = 1;
            preencheRoupa(recurso["id_recurso"]);
            break;
        case "Material":
            i = 2;
            preencheMaterial(recurso["id_recurso"]);
            break;
        case "Cabelo":
            i = 3;
            preencheCabelo(recurso["id_recurso"]);
            break;
        case "Alimento":
            i = 4;
            preencheAlimento(recurso["id_recurso"]);
            break;
    }

    mudarDiv(i);
}


function preencheMedicamento(id) {

    console.log(id);

    let tabela_medicamentos = document.getElementById("tabela-medicamentos");

    fetch("/api/v1/medicamento/" + id, {
        method: "GET"
    }).then(response => {
        return response.json();
    }).then(element => {
            let row = tabela_medicamentos.insertRow(1);

            let cellId = row.insertCell(0);
            let cellQtd = row.insertCell(1);
            let cellNome = row.insertCell(2);
            let cellData = row.insertCell(3);
            let cellPreco = row.insertCell(4);
            let cellFarmacia = row.insertCell(5);

            cellId.innerHTML = element['id_recurso'];
            cellQtd.innerHTML = element['quantidade'];
            cellNome.innerHTML = element['nome'];
            cellData.innerHTML = formataData(element['data_aquisicao']);
            cellPreco.innerHTML = "R$" + element['preco'];
            cellFarmacia.innerHTML = element['farmacia_compra'];

    });
}

function preencheRoupa(id) {
    let tabela_roupas = document.getElementById("tabela-roupas");

    fetch("/api/v1/roupa/" + id, {
        method: "GET"
    }).then(response => {
        return response.json();
    }).then(element => {

            let row = tabela_roupas.insertRow(1);

            let cellId = row.insertCell(0);
            let cellQtd = row.insertCell(1);
            let cellData = row.insertCell(2);
            let cellKit = row.insertCell(3);

            cellId.innerHTML = element['id_recurso'];
            cellQtd.innerHTML = element['quantidade'];
            cellData.innerHTML = formataData(element['data_aquisicao']);
            cellKit.innerHTML = element['kit'];

    });
}


function preencheMaterial(id) {
    let tabela_material = document.getElementById("tabela-material");

    fetch("/api/v1/material/" + id, {
        method: "GET"
    }).then(response => {
        return response.json();
    }).then(element => {
            let row = tabela_material.insertRow(1);

            let cellId = row.insertCell(0);
            let cellQtd = row.insertCell(1);
            let cellData = row.insertCell(2);
            let cellTipo = row.insertCell(3);

            cellId.innerHTML = element['id_recurso'];
            cellQtd.innerHTML = element['quantidade'];
            cellData.innerHTML = formataData(element['data_aquisicao']);
            cellTipo.innerHTML = element['tipoMaterial']['nome'];

        });
}


function preencheCabelo(id) {
    let tabela_cabelo = document.getElementById("tabela-cabelo");

    fetch("/api/v1/cabelo/" + id, {
        method: "GET"
    }).then(response => {
        return response.json();
    }).then(element => {

            let row = tabela_cabelo.insertRow(1);

            let cellId = row.insertCell(0);
            let cellQtd = row.insertCell(1);
            let cellData = row.insertCell(2);
            let cellTipo = row.insertCell(3);
            let cellComprimento = row.insertCell(4);

            cellId.innerHTML = element['id_recurso'];
            cellQtd.innerHTML = element['quantidade'];
            cellData.innerHTML = formataData(element['data_aquisicao']);
            cellTipo.innerHTML = element['tipoCabelo']['tipo'];
            cellComprimento.innerHTML = element['comprimento'] + " cm";

        });

}


function preencheAlimento(id) {

    let tabela_alimento = document.getElementById("tabela-alimento");

    fetch("/api/v1/alimento/" + id, {
        method: "GET"
    }).then(response => {
        return response.json();
    }).then(element => {

            let row = tabela_alimento.insertRow(1);

            let cellId = row.insertCell(0);
            let cellQtd = row.insertCell(1);
            let cellData = row.insertCell(2);
            let cellNome = row.insertCell(3);
            let cellTipo = row.insertCell(4);

            cellId.innerHTML = element['id_recurso'];
            cellQtd.innerHTML = element['quantidade'];
            cellData.innerHTML = formataData(element['data_aquisicao']);
            cellNome.innerHTML = element['nome'];
            cellTipo.innerHTML = element['tipoAlimento']['nome'];


        });
}