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

        getInstance().getGiraffes().add(p);

        sql.opretNyPatient(p.CPR,p.dato,p.startTidspunkt,p.slutTidspunkt,p.name,p.name,p.notater);

        System.out.println("dato: " + p.dato );
        System.out.println("CPR: " + p.CPR );
        System.out.println("name: " + p.name );
        System.out.println("start: " + p.startTidspunkt );
        System.out.println("slut: " + p.slutTidspunkt );
        System.out.println("CPR: " + p.notater );
        return p;



        }




    }




