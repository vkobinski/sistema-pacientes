const botaoCadastrar = document.getElementById("botao-cadastrar");

botaoCadastrar.onclick = () => {
    let logradouro = document.getElementById("logradouro").value;
    let bairro = document.getElementById("bairro").value;
    let complemento = document.getElementById("complemento").value;
    let pontoReferencia = document.getElementById("ponto-referencia").value;

    let cidade = document.getElementById("cidade").value;
    let estado = document.getElementById("estado").value;
    let cep = document.getElementById("cep").value;

    let endereco = {
        "logradouro": logradouro,
        "bairro": bairro,
        "complemento": complemento,
        "pontoReferencia": pontoReferencia,
        "cidade": cidade,
        "estado": estado,
        "cep": cep
    }

    fetch("/api/v1/endereco", {
        method: "POST",
        headers: {
            "Content-Type": "application/json"
        },
        body: JSON.stringify(endereco)
    }).then(recurso => {
        console.log(recurso);

        return recurso.json();
    }).then(data => {
        console.log(data);
    })

}