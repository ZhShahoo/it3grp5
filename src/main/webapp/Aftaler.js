BrugerFremvsinging();
let i = 1;

function BrugerFremvsinging() {
    Bruger = sessionStorage.getItem("Godkendt_Bruger");
    document.getElementById("Bruger").innerHTML = Bruger;
}

function AftaleOprettelse(){
    let Dato = document.getElementById("dato").value;
    let StartTid = document.getElementById("tid_fra").value;
    let Sluttid = document.getElementById("tid_til").value;
    let CPR = document.getElementById("CPR").value;
    let SP = document.getElementById("SP").value;
    let Notat = document.getElementById("Notat").value;



    if (Dato != null && StartTid != null && Sluttid != null && CPR.length == 10 && SP != null){
        document.getElementById("Dato"+i).innerHTML = Dato;
        document.getElementById("Starttid"+i).innerHTML = StartTid;
        document.getElementById("Sluttid"+i).innerHTML = Sluttid;
        document.getElementById("CPR"+i).innerHTML = CPR;
        document.getElementById("SP"+i).innerHTML = SP;
        Bruger = sessionStorage.getItem("Godkendt_Bruger");
        document.getElementById("Bruger"+i).innerHTML = Bruger;
        document.getElementById("Notat"+i).innerHTML = Notat;

        i++;
    } else{
        alert("Indtast venligst alle oplsyninger. ")
    }
}

function Clear(){

    for (let a = 1; a <= i; a++){
        document.getElementById("Dato"+a).innerHTML = "";
        document.getElementById("Starttid"+a).innerHTML = "";
        document.getElementById("Sluttid"+a).innerHTML = "";
        document.getElementById("CPR"+a).innerHTML = "";
        document.getElementById("SP"+a).innerHTML = "";
        document.getElementById("Bruger"+a).innerHTML = "";
        document.getElementById("Notat"+a).innerHTML = "";
    }
    i = 1;
}
