

function LoginValidation() {
    let Brugernavn = document.getElementById("InputBrugernavn");
    let Kodeord = document.getElementById("InputKode");

    function validering(data) {
        console.log("kontrol");
    }

    fetch("http://localhost:8080/it3grp5_war/rest/Login?" + new URLSearchParams({
        InputKode: Kodeord, InputBrugernavn: Brugernavn}
    )).then(resp => resp.text().then(data => validering(data)));

}