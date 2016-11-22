package webservice.dao;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.Mongo;
import java.util.ArrayList;
import org.bson.types.ObjectId;
import webservice.entidades.pessoa.Aluno;

/**
 *
 * @author matheush
 */
public class AlunoDao {
    private Mongo mongo;
    private DB db;
    private DBCollection dBCollection;

    public AlunoDao() {
        this.mongo = new Mongo("localhost" , 27017);
        this.db = mongo.getDB("GamesApp");
        this.dBCollection = db.getCollection("Turma");
    }
    
    public void insert(Aluno aluno) {
        BasicDBObject basicAluno = new BasicDBObject();
        
        basicAluno.put("nome", aluno.getNome());
        basicAluno.put("email", aluno.getEmail());
        basicAluno.put("matricula", aluno.getMatricula());
        basicAluno.put("senha", aluno.getSenha());
        
        dBCollection.insert(basicAluno);
    }
    
    public ArrayList<Aluno> findAll() {
        ArrayList<Aluno> alunos = new ArrayList<>();
        
        DBCursor cursor = dBCollection.find();
        while(cursor.hasNext()) {
            Aluno aluno = new Aluno();
            
            BasicDBObject basicAluno = (BasicDBObject) cursor.next();
            aluno.setId(basicAluno.getString("_id"));
            aluno.setNome(basicAluno.getString("nome"));
            aluno.setEmail(basicAluno.getString("email"));
            aluno.setSenha(basicAluno.getString("senha"));
            aluno.setMatricula(basicAluno.getString("matricula"));
            
            alunos.add(aluno);
        }
        
        return alunos;        
    }
    
    public void update(String id, Aluno aluno) {
        BasicDBObject basicAlterar = new BasicDBObject();
        basicAlterar.put("_id", new ObjectId(id));
        
        BasicDBObject basicAlteracoes = new BasicDBObject();
        basicAlteracoes.put("nome", aluno.getNome());
        basicAlteracoes.put("email", aluno.getEmail());
        basicAlteracoes.put("matricula", aluno.getMatricula());
        basicAlteracoes.put("senha", aluno.getSenha());
        
        dBCollection.update(basicAlterar, basicAlteracoes);
    }
}
