const cadastra_button = document.getElementById("cadastraButton");
const nome_voluntaria = document.getElementById("nome");
const span_concluido = document.getElementById("concluido");

cadastra_button.onclick = function(){

    let nome_v = nome_voluntaria.value;

    fetch("/api/v1/voluntaria", {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify({
            nome: nome_v
        })
    })
    .then(response => {

        if(response.status === 200) {
            span_concluido.classList.remove("hidden");
        }
        return response.json()
    }).then(data => {
        span_concluido.innerHTML = "Cadastro concluído com ID: "+ data['id_voluntaria'];
    })
};