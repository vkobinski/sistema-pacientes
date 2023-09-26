const socioeconomicaCampo = document.getElementById("socioeconomica");

fetch("/api/v1/situacaosocioeconomica", {
        method: "GET"
    }).then(response => {
        return response.json();
    }).then(data => {
        
        data.forEach(element => {
            
            let option = document.createElement("option");
            option.text = element['nome'];

            socioeconomicaCampo.add(option);
        });
})


function getEnderecoFrame() {
    return document.getElementById("enderecoframe").contentWindow;
}

function geraPessoa() {
    const rgCampo = document.getElementById("rg");
    const cpfCampo = document.getElementById("cpf-value");
    const nomeCampo = document.getElementById("nome");
    const sexoCampo = document.getElementById("sexo");
    const dataNascimentoCampo = document.getElementById("datanascimento");
    const profissaoCampo = document.getElementById("profissao");
    const redesSociaisCampo = document.getElementById("redessociais");
    const telefoneCampo = document.getElementById("telefone-value");
    const estadoCivilCampo = document.getElementById("estadocivil");

    return {
        "rg": rgCampo.value,
        "cpf": cpfCampo.value,
        "nome": nomeCampo.value,
        "sexo": sexoCampo.options[sexoCampo.selectedIndex].text,
        "dataNascimento": dataNascimentoCampo.value,
        "profissao": profissaoCampo.value,
        "redesSociais": redesSociaisCampo.options[redesSociaisCampo.selectedIndex].value == "Sim" ? "true" : "false",
        "telefone": telefoneCampo.value,
        "socioeconomica": socioeconomicaCampo.options[socioeconomicaCampo.selectedIndex].text,
        "estadoCivil": estadoCivilCampo.options[estadoCivilCampo.selectedIndex].value,
    }
}