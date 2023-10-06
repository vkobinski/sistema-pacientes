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

    const span = document.getElementById("span-cadastro");
  const botaoCadastrar = document.getElementById("cadastrarButton");

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