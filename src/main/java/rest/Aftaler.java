package rest;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.NewCookie;
import javax.ws.rs.core.Response;
import java.net.URI;
import java.net.URISyntaxException;



@Path("Aftaler")
@Produces({MediaType.TEXT_PLAIN})
public class Aftaler {

    @GET
    public Response AftaleOprettelse(@QueryParam("dato") String dato, @QueryParam("tid_fra") String starttid, @QueryParam("tid_til") String sluttid, @QueryParam("CPR") String CPR, @QueryParam("SP") String sundhedspersonale,@QueryParam("Notat") String notat  ) throws URISyntaxException {
        SQL sql = new SQL();

        try {
            sql.retrieveAftale(1);
            Response Login_Cookie = Response.seeOther(new URI("../Home.html")).cookie(new NewCookie("user", user)).build();

        }

    }

}
