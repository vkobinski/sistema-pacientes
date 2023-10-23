let voluntarias = [];

const selectVoluntaria = document.getElementById("voluntarias");
const selectPaciente = document.getElementById("paciente");


fetch("/api/v1/voluntaria", {
    method: "GET"
}).then(response => {
    return response.json();
}).then(data => {
    data.forEach(element => {
        let option = document.createElement("option");
        option.text = element['nome'];
        option.id = element['id_voluntaria'];

        selectVoluntaria.add(option);

    });
});

fetch("/api/v1/paciente", {
    method: "GET"
}).then(response => {
    return response.json();
}).then(data => {
    data.forEach(element => {
        let option = document.createElement("option");
        option.text = element['nome'];
        option.id = element['id_pessoa'];

        selectPaciente.add(option);

    });
});

document.getElementById("voluntariaBtn").onclick = () => {
    const span = document.getElementById("span-voluntaria");

    let voluntaria = selectVoluntaria.options[selectVoluntaria.selectedIndex].id;
    if(voluntarias.includes(voluntaria)) return;

    span.style.visibility = "visible";

    setTimeout(() => {
        span.style.visibility = "hidden";
    }, 1500);
    voluntarias.push(+voluntaria);
}

document.getElementById("cadastrar").onclick = () => {

    let data = document.getElementById("data_visita").value;
    let paciente = selectPaciente.options[selectPaciente.selectedIndex].id;

    const span = document.getElementById("span-cadastro");
    const botaoCadastrar = document.getElementById("cadastrar");

    
    let voluntariaJ = {
        "data_visita": data,
        "paciente": +paciente,
        "voluntarias": voluntarias,
    }

    console.log(JSON.stringify(voluntariaJ));


    fetch("/api/v1/visita", {
        method: "POST",
        headers: {
            "Content-Type": "application/json"
        },
        body: JSON.stringify(voluntariaJ),
    }).then(response => {
        if(response.status == 200) {
            span.innerHTML = "Cadastro concluído!";
            span.style.visibility = "visible";
            botaoCadastrar.disabled = true;
        } else {
            span.innerHTML = "Não foi possível Cadastrar";
            span.style.visibility = "visible";
        }
    });
}