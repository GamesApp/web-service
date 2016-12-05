package webservice;

import com.google.gson.Gson;
import java.util.ArrayList;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;
import webservice.dao.AlunoDao;
import webservice.dao.AtividadeDao;
import webservice.dao.ProfessorDao;
import webservice.dao.TurmaDao;
import webservice.entidades.atividade.Atividade;
import webservice.entidades.pessoa.Aluno;
import webservice.entidades.pessoa.Professor;
import webservice.entidades.turma.Turma;

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
    @Path("Professor/login/{email}/{senha}")
    public String getProfessorLogin(@PathParam("email") String email,
            @PathParam("senha") String senha) {
        Professor professor;

        System.out.println("Senha entrada: " + senha);
        professor = new ProfessorDao().findLogin(email, senha);
        
        if (!professor.equals("")) {
            Gson gson = new Gson();
            return gson.toJson(professor);
        } else {
            return "Inexistente";
        }
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("Aluno/login/{email}")
    public String getAluno(@PathParam("email") String email) {
        Aluno aluno;
        
        aluno = new AlunoDao().findLogin(email);
        
        if (!aluno.equals("")) {
            Gson gson = new Gson();
            return gson.toJson(aluno);
        } else {
            return "Inexistente";
        }
    }
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("Turma/get/todas")
    public String getTurma() {
        ArrayList<Turma> turmas;
        
        turmas = new TurmaDao().findAll();
        
        Gson gson = new Gson();
        return gson.toJson(turmas);
    }
    /*
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("Atividade/get/{atividade}")
    public String getAtividade(@PathParam("atividade") String atividade) {
        
        return "";
    }*/
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("Atividade/get/todas")
    public String getAtividadeLista() {
        ArrayList<Atividade> atividades;
        
        atividades = new AtividadeDao().findAll();
        
        Gson gson = new Gson();
        return gson.toJson(atividades);
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
