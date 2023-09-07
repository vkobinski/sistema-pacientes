document.getElementById("cadastrar").onclick = () => {

    const nomeEspecialidade = document.getElementById("nome").value;

    const body = {
        "nomeEspecialidade": nomeEspecialidade,
    }

    console.log(body);

    fetch("/api/v1/especialidade", {
        method: "POST",
        headers: {
            "Content-Type": "application/json"
        },
        body: JSON.stringify({
            nomeEspecialidade: nomeEspecialidade
        }),
    })
    .then(response => {
        if(response.status === 200) document.getElementById("especialidade-span").style = "";
    })
};