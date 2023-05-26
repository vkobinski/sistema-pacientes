function geraEndereco() {
    let logradouro = document.getElementById("logradouro").value;
    let bairro = document.getElementById("bairro").value;
    let complemento = document.getElementById("complemento").value;
    let pontoReferencia = document.getElementById("ponto-referencia").value;

    let cidade = document.getElementById("cidade").value;
    let estado = document.getElementById("estado").value;
    let cep = document.getElementById("cep-value").value;

    return {
        "logradouro": logradouro,
        "bairro": bairro,
        "complemento": complemento,
        "pontoReferencia": pontoReferencia,
        "nomeCidade": cidade,
        "nomeEstado": estado,
        "cep": cep
    }

    //fetch("/api/v1/endereco", {
        //method: "POST",
        //headers: {
            //"Content-Type": "application/json"
        //},
        //body: JSON.stringify(endereco)
    //}).then(recurso => {
        //console.log(recurso);

        //return recurso.json();
    //}).then(data => {
        //console.log(data);
    //})

}