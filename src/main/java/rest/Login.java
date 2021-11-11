package rest;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.NewCookie;
import javax.ws.rs.core.Response;
import java.net.URI;
import java.net.URISyntaxException;



@Path("Login")
@Produces({MediaType.TEXT_PLAIN})
public class Login {


    @GET
    public Response LoginValidering(@QueryParam("InputBrugernavn") String user, @QueryParam("InputKode") String kode) throws URISyntaxException {

        SQL sql = new SQL();

        try {
            for (int i = 1; i <= 100; i++) {
                sql.getEKGDataFromTable(i);
                if (user.matches(sql.Brugernavn) && kode.equals(sql.Adgangskode)) {
                    Response Login_Cookie = Response.seeOther(new URI("../Home.html")).cookie(new NewCookie("user", user)).build();
                    System.out.println("Brugernavn: " + user);
                    System.out.println("Kodeord: " + kode);

                    return Login_Cookie;
                }
            }
        } catch (URISyntaxException e) {
            throw new WebApplicationException("Fejl", Response.Status.FORBIDDEN);
        }
        return null;
    }
}


