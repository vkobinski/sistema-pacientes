const urlParams = new URLSearchParams(window.location.search);

const arg1 = urlParams.get('id');

window.onload = function () {
    document
        .getElementById("visualizaRecurso")
        .contentWindow.fetchRecurso(arg1);
};

function criaDoacao() {


    const atendido = document
        .getElementById("buscaAtendido")
        .contentWindow.getAtendido();


    console.log(atendido);


    fetch("/api/v1/doacao", {
        method: "POST",
        headers: {
            "Content-Type": "application/json"
        },
        body: JSON.stringify({
            atendidoId: atendido,
            recursoId: arg1,
        })
    }).then(response => response.json())
        .then(data => {
        })


}