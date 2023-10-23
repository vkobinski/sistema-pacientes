document.getElementById("cadastrar").onclick = () => {

    const nomeEspecialidade = document.getElementById("nome").value;
    const span = document.getElementById("span-cadastro");
    const botaoCadastrar = document.getElementById("cadastrar");

    console.log(JSON.stringify({nome: nomeEspecialidade}));

    fetch("/api/v1/tiporefeicao", {
        method: "POST",
        headers: {
            "Content-Type": "application/json"
        },
        body: JSON.stringify({
            nome: nomeEspecialidade
        }),
    })
    .then(response => {
       if(response.status == 200) {
            span.innerHTML = "Cadastro concluído!";
            span.style.visibility = "visible";
            botaoCadastrar.disabled = true;
        } else {
            span.innerHTML = "Não foi possível Cadastrar";
            span.style.visibility = "visible";
        }
    })
};