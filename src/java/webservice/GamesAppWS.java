package webservice;

import com.google.gson.Gson;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.core.MediaType;

/**
 * REST Web Service
 *
 * @author matheush
 */
@Path("GamesApp")
public class GamesAppWS {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of GamesAppWS
     */
    public GamesAppWS() {
    }

    /**
     * Retrieves representation of an instance of web.service.GamesAppWS
     * @return an instance of java.lang.String
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getJson() {
        //TODO return proper representation object
//        throw new UnsupportedOperationException();
        return "ws teste coisa linda";
    }
    
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("Usuario/Professor/get")
    public String getProfessor() {
        /*Professor professor = new Professor();

        professor.setEmail("teste@teste.com");
        professor.setNome("Teste");
        professor.setCodigoConfirmacao("AAB432");
        professor.setId("adas123dasqwe");

        //Converte objeto java para Json
        Gson gson = new Gson();
        return gson.toJson(professor);*/
        return "coisa";
    }

    /**
     * PUT method for updating or creating an instance of GamesAppWS
     * @param content representation for the resource
     */
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public void putJson(String content) {
    }
}
