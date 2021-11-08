BrugerFremvsinging();

function BrugerFremvsinging() {
    Bruger = sessionStorage.getItem("Godkendt_Bruger");
    document.getElementById("Bruger").innerHTML = Bruger;
}

function AftaleOprettelse(){
    let Dato = document.getElementById("dato").value;
    let StartTid = document.getElementById("tid_fra").value;
    let Sluttid = document.getElementById("tid_til").value;
    let CPR = document.getElementById("CPR").value;

    document.getElementById("1").innerHTML = Dato;
    document.getElementById("2").innerHTML = StartTid;
    document.getElementById("3").innerHTML = Sluttid;
    document.getElementById("4").innerHTML = CPR;

}
