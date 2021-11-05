function LoginValidation() {
    let navn = document.getElementById("InputBrugernavn").value;
    let kode = document.getElementById("InputKode").value;

    fetch("http://localhost:8080/it3grp5_war/rest/Login?" + new URLSearchParams({
        InputKode: kode, InputBrugernavn: navn}
    )).then(resp => resp.text().then(data => validering(data)));
}

function validering(x) {
    console.log(x);
}