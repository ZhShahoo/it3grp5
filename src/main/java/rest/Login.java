package rest;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path("Login")
@Produces(MediaType.TEXT_PLAIN)
@Consumes(MediaType.TEXT_PLAIN)
public class Login {
    @GET
    public String LoginValidering(@QueryParam("InputBrugernavn") String user, @QueryParam("InputKode") String kode){
        System.out.println("Brugernavn: "+user);
        System.out.println("Kode: "+kode);
        return kode+user;
    }
}
