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
        console.log("teste");
    fetch("/api/v1/atendimento", {
       method: "POST",
       headers: {
        "Content-Type": "application/json",
       },
       body: JSON.stringify(getAtendimento()),
    }).then(response => {
        return response.json();
    }).then(data => {
        console.log(data);
    })
}