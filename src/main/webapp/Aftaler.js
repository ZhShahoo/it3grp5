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
    //    addRow()
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

function addRow(){
    let tableRef = document.getElementById(Konsultationstabel);
    let newRow = tableRef.insertRow(-1);

    let newCell0 = newRow.insertCell(0);
    let newCell1 = newRow.insertCell(1);
    let newCell2 = newRow.insertCell(2);
    let newCell3 = newRow.insertCell(3);
    let newCell4 = newRow.insertCell(4);
    let newCell5 = newRow.insertCell(5);

    let newText0 = document.createTextNode('0000');
    let newText1 = document.createTextNode('1111');
    let newText2 = document.createTextNode('2222');
    let newText3 = document.createTextNode('3333');
    let newText4 = document.createTextNode('4444');
    let newText5 = document.createTextNode('5555');

    newCell0.appendChild(newText0);
    newCell1.appendChild(newText1);
    newCell2.appendChild(newText2);
    newCell3.appendChild(newText3);
    newCell4.appendChild(newText4);
    newCell4.appendChild(newText5);
}