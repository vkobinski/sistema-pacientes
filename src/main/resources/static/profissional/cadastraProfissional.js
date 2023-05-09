const select_especialidade = document.getElementById("especialidade");
fetch("/api/v1/especialidade", {
    method: "GET"
}).then(response => {
    return response.json();
}).then(data => {
    data.forEach(element => {
       const option = document.createElement("option");
       option.text = element['nomeEspecialidade'];

       select_especialidade.add(option);
    });
})


const cadastrarBotao = document.getElementById("cadastrarButton");

cadastrarBotao.onclick = () => {

    let nome = document.getElementById("nome").value;
    let especialidadeC = select_especialidade.options[select_especialidade.selectedIndex].text;

    let profissional = {
        "nome": nome,
        "especialidade": especialidadeC,
    }

    fetch("/api/v1/profissional", {
        method: "POST",
        headers: {
            "Content-Type": "application/json"
        },
        body: JSON.stringify(profissional),
    }).then(response => {
        console.log(response);

        return response.json();
    }).then(data => {
        console.log(data);
    })
}