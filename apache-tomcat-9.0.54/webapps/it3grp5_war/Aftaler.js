BrugerFremvsinging();
let i = 1;
let json;

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
        KonsultationsUdfyldning();
        Bruger = sessionStorage.getItem("Godkendt_Bruger");

        document.getElementById("Dato"+i).innerHTML = Dato;
        document.getElementById("Starttid"+i).innerHTML = StartTid;
        document.getElementById("Sluttid"+i).innerHTML = Sluttid;
        document.getElementById("CPR"+i).innerHTML = CPR;
        document.getElementById("SP"+i).innerHTML = SP;
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

function KonsultationsUdfyldning(){
    var tabel = document.getElementById("Konsultationstabel");
    var raekke = tabel.insertRow(i);

    var Dato = raekke.insertCell(0);
    Dato.id="Dato"+i
    Dato.noWrap= true;

    var Starttid = raekke.insertCell(1);
    Starttid.id="Starttid"+i
    Starttid.noWrap= true;

    var Sluttid = raekke.insertCell(2);
    Sluttid.id="Sluttid"+i
    Sluttid.noWrap= true;

    var CPR = raekke.insertCell(3);
    CPR.id="CPR"+i
    CPR.noWrap= true;

    var SP = raekke.insertCell(4);
    SP.id="SP"+i
    SP.noWrap= true;

    var Bruger = raekke.insertCell(5);
    Bruger.id="Bruger"+i
    Bruger.noWrap= true;

    var Notat = raekke.insertCell(6);
    Notat.style.height='100px'
    var TextArea = document.createElement("TEXTAREA");
    TextArea.style.border= 'none';
    TextArea.style.height= '100px';
    TextArea.style.width= '100%';
    TextArea.style.boxSizing= 'border-box';
    Notat.appendChild(TextArea)
    TextArea.id="Notat"+i
}
