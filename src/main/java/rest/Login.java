package rest;

import javax.ws.rs.*;
import javax.ws.rs.core.Cookie;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.NewCookie;
import javax.ws.rs.core.Response;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

import static java.awt.SystemColor.window;

@Path("Login")
@Produces({MediaType.TEXT_PLAIN})
public class Login {


    @GET

    public Response LoginValidering(@QueryParam("InputBrugernavn") String user, @QueryParam("InputKode") String kode) throws URISyntaxException {

        if (user.matches("[a-zA-Z]+"+"[1-9]+") && 1 <= kode.length()){
            Response Login_Cookie = Response.seeOther(new URI("../Home.html")).cookie(new NewCookie("user",user)).build();
            System.out.println("Brugernavn: "+user);
            System.out.println("Kodeord: "+kode);
            return Login_Cookie;
        } else {
            throw new WebApplicationException("Fejl",Response.Status.FORBIDDEN);
        }
    }
}

