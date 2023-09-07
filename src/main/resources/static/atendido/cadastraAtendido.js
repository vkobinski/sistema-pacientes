const estagioDoencaField = document.getElementById("estagioDoenca");

fetch("/api/v1/estagiodoenca", {
        method: "GET"
    }).then(response => {
        return response.json();
    }).then(data => {
        
        data.forEach(element => {

            if(element['ativo'] == false) return;

            let option = document.createElement("option");
            option.text = element['nome'];

            estagioDoencaField.add(option);
        });
})

function getFrame() {
    return document.getElementById("pessoaFrame").contentWindow;
}

function getEndereco() {
    return getFrame().getEnderecoFrame().geraEndereco();
}

function getAtendido() {
    let pessoa = getFrame().geraPessoa();
    let endereco = getEndereco();

    let estagioDoenca = estagioDoencaField.options[estagioDoencaField.selectedIndex].text;

    let tipoCancro = document.getElementById("tipoCancro").value;

    return {
        pessoa,
        endereco,
        "estagioDoenca": estagioDoenca,
        "tipo_cancro": tipoCancro,
    };

}