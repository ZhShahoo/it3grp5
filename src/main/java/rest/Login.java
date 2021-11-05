package rest;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.awt.*;
import java.io.File;
import java.io.IOException;

@Path("Login")
@Produces({MediaType.TEXT_PLAIN})
public class Login {
    String Brugernavn = null;
    String Kodeord = null;
    @GET
    public void LoginValidering(@QueryParam("InputBrugernavn") String user, @QueryParam("InputKode") String kode){
        Brugernavn = user;
        Kodeord = kode;
        LoginChecker();
    }
    public void LoginChecker(){
        if(Brugernavn != null && Kodeord != null) {
            System.out.println("B, " + Brugernavn + ".");
            System.out.println("K, " + Kodeord + ".");

        }
        else{
        }
    }
}
