const cadastra_button = document.getElementById("cadastraButton");
const nome_voluntaria = document.getElementById("nome");
const setor_voluntaria = document.getElementById("setor");
const contato_voluntaria = document.getElementById("contato");
const span_concluido = document.getElementById("concluido");

cadastra_button.onclick = function () {

    let nome_v = nome_voluntaria.value;
    let setor_v = setor_voluntaria.value;
    let contato_v = contato_voluntaria.value;

    const span = document.getElementById("span-cadastro");
    const botaoCadastrar = document.getElementById("cadastraButton");


    fetch("/api/v1/voluntaria", {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify({
            nome: nome_v,
            setor: setor_v,
            contato: contato_v,
        })
    })
        .then(response => {

            if (response.status === 200) {
                span.innerHTML = "Cadastro concluído!";
                span.style.visibility = "visible";
                botaoCadastrar.disabled = true;
            } else {
                span.innerHTML = "Não foi possível Cadastrar";
                span.style.visibility = "visible";
            }
        });
};