function formataData(data) {
    let valores = data.substring(0,10).split("-");
    valores = valores.reverse();
    valores = valores[0] + "/" + valores[1] + "/" + valores[2];

    return valores;
}