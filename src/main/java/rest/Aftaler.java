package rest;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.NewCookie;
import javax.ws.rs.core.Response;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

import static rest.GiraffeDao.*;


@Path("Aftaler")
    @Consumes({MediaType.APPLICATION_JSON})
    public class Aftaler {
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Patient> getGiraffes() {
        return getInstance().getGiraffes();
    }

SQL sql=new SQL();
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Patient postPatient(Patient p) {
        String CPR = null;
        getInstance().getGiraffes().add(p);
        sql.opretNyPatient(p.name, p.dato,"11:30","12:00", "knud", p.aftaleperson, "flibsmorkforb");
        if (p.name.length() == 10 && p.name.matches("[0-9]+")){
            CPR = p.name;
        }
        if (p.name.length() == 5)

        System.out.println("CPR er:"+CPR);


        return p;
    }



    }

