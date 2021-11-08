BrugerFremvsinging();

function BrugerFremvsinging() {
    Bruger = sessionStorage.getItem("Godkendt_Bruger");
    document.getElementById("Bruger").innerHTML = Bruger;
}
