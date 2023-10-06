function getAtendimento() {
    let data = document.getElementById("data").value;

    let atendido = document.getElementById("buscaAtendido").contentWindow.getAtendido();
    let profissional = document.getElementById("buscaProfissional").contentWindow.getProfissionalId();

    return {
        "atendido": atendido,
        "profissional": profissional,
        "data": data,
    }
}

document.getElementById("cadastrar").onclick = () => {

    const span = document.getElementById("span-cadastro");
    const botaoCadastrar = document.getElementById("cadastrar");

    fetch("/api/v1/atendimento", {
       method: "POST",
       headers: {
        "Content-Type": "application/json",
       },
       body: JSON.stringify(getAtendimento()),
    }).then(response => {
        if(response.status == 200) {
            span.innerHTML = "Cadastro concluído!";
            span.style.visibility = "visible";
            botaoCadastrar.disabled = true;
        } else {
            span.innerHTML = "Não foi possível Cadastrar";
            span.style.visibility = "visible";
        }
    })
}