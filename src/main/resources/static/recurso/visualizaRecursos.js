let tabela_medicamentos = document.getElementById("tabela-medicamentos");

fetch("/api/v1/medicamento", {
    method: "GET"
}).then(response => {
    return response.json();
}).then(data => {
    let i = 1;

    data.forEach(element => {
        let row = tabela_medicamentos.insertRow(i);

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
        cellPreco.innerHTML = element['preco'];
        cellFarmacia.innerHTML = element['farmacia_compra'];

        i++;
        
    });

})

let tabela_roupas = document.getElementById("tabela-roupas");

fetch("/api/v1/roupa", {
    method: "GET"
}).then(response => {
    return response.json();
}).then(data => {
    let i = 1;

    data.forEach(element => {
        let row = tabela_roupas.insertRow(i);

        let cellId = row.insertCell(0);
        let cellQtd = row.insertCell(1);
        let cellData = row.insertCell(2);
        let cellKit = row.insertCell(3);

        cellId.innerHTML = element['id_recurso'];
        cellQtd.innerHTML = element['quantidade'];
        cellData.innerHTML = formataData(element['data_aquisicao']);
        cellKit.innerHTML = element['kit'];

        i++;
        
    });

})

let tabela_material = document.getElementById("tabela-material");

fetch("/api/v1/material", {
    method: "GET"
}).then(response => {
    return response.json();
}).then(data => {
    let i = 1;

    data.forEach(element => {
        let row = tabela_material.insertRow(i);

        let cellId = row.insertCell(0);
        let cellQtd = row.insertCell(1);
        let cellData = row.insertCell(2);
        let cellTipo = row.insertCell(3);

        cellId.innerHTML = element['id_recurso'];
        cellQtd.innerHTML = element['quantidade'];
        cellData.innerHTML = formataData(element['data_aquisicao']);
        cellTipo.innerHTML = element['tipoMaterial']['nome'];

        i++;
        
    });

})

let tabela_cabelo = document.getElementById("tabela-cabelo");

fetch("/api/v1/cabelo", {
    method: "GET"
}).then(response => {
    return response.json();
}).then(data => {
    let i = 1;

    data.forEach(element => {
        let row = tabela_cabelo.insertRow(i);

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

        i++;
        
    });

})

let tabela_alimento = document.getElementById("tabela-alimento");

fetch("/api/v1/alimento", {
    method: "GET"
}).then(response => {
    return response.json();
}).then(data => {
    let i = 1;

    data.forEach(element => {
        let row = tabela_alimento.insertRow(i);

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

        i++;
        
    });

})