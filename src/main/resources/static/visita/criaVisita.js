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
    let voluntaria = selectVoluntaria.options[selectVoluntaria.selectedIndex].id;
    if(voluntarias.includes(voluntaria)) return;
    voluntarias.push(+voluntaria);
}

document.getElementById("cadastrar").onclick = () => {

    let data = document.getElementById("data_visita").value;
    let paciente = selectPaciente.options[selectPaciente.selectedIndex].id;
    
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
        console.log(response);

        return response.json();
    }).then(data => {
        console.log(data);
    })
}