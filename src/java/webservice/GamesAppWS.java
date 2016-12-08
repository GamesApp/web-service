package webservice;

import com.google.gson.Gson;
import java.util.ArrayList;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
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
    @Path("Professor/recuperacao/{email}")
    public String getProfessorRecuperacao(@PathParam("email") String email) {
        Professor professor;

        professor = new ProfessorDao().getSenhaLogin(email);
        
        if (!professor.equals("")) {
            Gson gson = new Gson();
            return gson.toJson(professor);
        } else {
            return "Inexistente";
        }
    }
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("Professor/insert")
    public void insertProfessor(String professorJson) {
        Gson gson = new Gson();
        
        Professor professor = (Professor) gson.fromJson(professorJson, Professor.class);
        
        new ProfessorDao().insert(professor);
    }
    
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("Professor/alterar")
    public void alterarProfessor(String professorJson) {
        Gson gson = new Gson();
        
        Professor professor = (Professor) gson.fromJson(professorJson, Professor.class);
        
        new ProfessorDao().update(professor.getId(), professor);
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("Aluno/login/{email}/{senha}")
    public String getAlunoLogin(@PathParam("email") String email,
            @PathParam("senha") String senha) {
        Aluno aluno;
        
        aluno = new AlunoDao().findLogin(email, senha);
        
        if (!aluno.equals("")) {
            Gson gson = new Gson();
            return gson.toJson(aluno);
        } else {
            return "Inexistente";
        }
    }
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("Aluno/insert")
    public void insertAluno(String alunoJson) {
        Gson gson = new Gson();
        
        Aluno aluno = (Aluno) gson.fromJson(alunoJson, Aluno.class);
        
        new AlunoDao().insert(aluno);
    }
    
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("Aluno/alterar")
    public void alterarAluno(String alunoJson) {
        Gson gson = new Gson();
        
        Aluno aluno = (Aluno) gson.fromJson(alunoJson, Aluno.class);
        
        new AlunoDao().update(aluno.getId(), aluno);
    }
    
    /*@GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("Turma/get/{turma}")
    public String getTurma(@PathParam("turma") String turma) {
        ArrayList<Turma> turmas;
        
        //Tratar pelo nome abreviado INF2013
        
        turmas = new TurmaDao().findAll();
        
        Gson gson = new Gson();
        return gson.toJson(turmas);
    }*/
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("Turma/get/todas")
    public String getTurmaLista() {
        ArrayList<Turma> turmas;
        
        turmas = new TurmaDao().findAll();
        
        Gson gson = new Gson();
        return gson.toJson(turmas);
    }
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("Turma/insert")
    public void insertTurma(String turmaJson) {
        Gson gson = new Gson();
        
        Turma turma = (Turma) gson.fromJson(turmaJson, Turma.class);
        
        new TurmaDao().insert(turma);
    }
    
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("Turma/alterar")
    public void alterarTurma(String turmaJson) {
        Gson gson = new Gson();
        
        Turma turma = (Turma) gson.fromJson(turmaJson, Turma.class);
        
        new TurmaDao().update(turma.getId(), turma);
    }
    
    @DELETE
    @Path("Turma/delete/{id}")
    public boolean deteleTurma(@PathParam("id") String id) {
        
        new TurmaDao().delete(id);
        
        return true;
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
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("Atividade/insert")
    public void insertAtividade(String atividadeJson) {
        Gson gson = new Gson();
        
        Atividade atividade = (Atividade) gson.fromJson(atividadeJson, Atividade.class);
        
        new AtividadeDao().insert(atividade);
    }
    
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("Atividade/alterar")
    public void alterarAtividade(String atividadeJson) {
        Gson gson = new Gson();
        
        Atividade atividade = (Atividade) gson.fromJson(atividadeJson, Atividade.class);
        
        new AtividadeDao().update(atividade.getId(), atividade);
    }
    
    @DELETE
    @Path("Atividade/delete/{id}")
    public boolean deteleAtividade(@PathParam("id") String id) {
        
        new AtividadeDao().delete(id);
        
        return true;
    }
}
