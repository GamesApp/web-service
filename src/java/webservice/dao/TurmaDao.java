package webservice.dao;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.Mongo;
import java.util.ArrayList;
import java.util.regex.Pattern;
import org.bson.types.ObjectId;
import webservice.entidades.atividade.Atividade;
import webservice.entidades.turma.Turma;

/**
 *
 * @author matheush
 */
public class TurmaDao {
    private Mongo mongo;
    private DB db;
    private DBCollection dBCollection;

    public TurmaDao() {
        this.mongo = new Mongo("localhost" , 27017);
        this.db = mongo.getDB("GamesApp");
        this.dBCollection = db.getCollection("Turma");
    }
    
    public void insert(Turma turma) {
        BasicDBObject basicTurma = new BasicDBObject();
        
        basicTurma.put("nome", turma.getNome());
        basicTurma.put("anoInicio", turma.getAnoInicio());
        basicTurma.put("curso", turma.getCurso());
        basicTurma.put("pontos", turma.getPontos());
        basicTurma.put("alunos", turma.getAlunos());
        
        dBCollection.insert(basicTurma);
    }
    
    public ArrayList<Turma> findAll() {
        ArrayList<Turma> turmas = new ArrayList<>();
        
        DBCursor cursor = dBCollection.find();
        while(cursor.hasNext()) {
            Turma turma = new Turma();
            
            BasicDBObject basicTurma = (BasicDBObject) cursor.next();
            turma.setId(basicTurma.getString("_id"));
            turma.setNome(basicTurma.getString("nome"));
            turma.setAnoInicio(basicTurma.getInt("anoInicio"));
            turma.setCurso(basicTurma.getString("curso"));
            turma.setPontos(basicTurma.getLong("pontos"));
            turma.setAlunos((ArrayList<String>) basicTurma.get("alunos"));
            
            turmas.add(turma);
        }
        
        return turmas;
    }
    
    /*public ArrayList<Turma> find(String queryPesquisa) {
        ArrayList<Turma> turmas = new ArrayList<>();
        
        BasicDBObject basicTurmaQuery = new BasicDBObject();
        //O código abaixo faz o método find virar case insensitive
        basicTurmaQuery.put("nome", Pattern.compile(".*" + queryPesquisa + ".*" , Pattern.CASE_INSENSITIVE));
        
        DBCursor cursor = dBCollection.find(basicTurmaQuery);
        while(cursor.hasNext()) { 
            Turma turma = new Turma();
            BasicDBObject basicTurma = (BasicDBObject) cursor.next();
            
            turma.setId(basicTurma.getString("_id"));
            turma.setNome(basicTurma.getString("nome"));
            turma.setAnoInicio(basicTurma.getInt("anoInicio"));
            turma.setCurso(basicTurma.getString("curso"));
            turma.setPontos(basicTurma.getLong("pontos"));
            turma.setAlunos((ArrayList<String>) basicTurma.get("alunos"));
            
            turmas.add(turma);
        }
        
        return turmas;
    }*/
    
    public void delete(String id) {
        BasicDBObject objectTurma = new BasicDBObject();
        objectTurma.put("_id", new ObjectId(id));
        dBCollection.remove(objectTurma);
    }
    
    public void update(String id, Turma turma) {
        BasicDBObject basicAlterar = new BasicDBObject();
        basicAlterar.put("_id", new ObjectId(id));
        
        BasicDBObject basicAlteracoes = new BasicDBObject();
        basicAlteracoes.put("nome", turma.getNome());
        basicAlteracoes.put("anoInicio", turma.getAnoInicio());
        basicAlteracoes.put("curso", turma.getCurso());
        basicAlteracoes.put("pontos", turma.getPontos());
        basicAlteracoes.put("alunos", turma.getAlunos());
        
        dBCollection.update(basicAlterar, basicAlteracoes);
    }
}
