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
import webservice.entidades.atividade.Classificacao;
import webservice.entidades.atividade.Endereco;
import webservice.entidades.atividade.Pontuacao;

/**
 *
 * @author matheush
 */
public class AtividadeDao {
    private Mongo mongo;
    private DB db;
    private DBCollection dBCollection;

    public AtividadeDao() {
        this.mongo = new Mongo("localhost" , 27017);
        this.db = mongo.getDB("GamesApp");
        this.dBCollection = db.getCollection("Atividade");
    }
        
    public void insert(Atividade atividade) {
        BasicDBObject basicAtividade = new BasicDBObject();
        
        basicAtividade.put("situacao", atividade.getSituacao());
        basicAtividade.put("nome", atividade.getNome());
        basicAtividade.put("descricao", atividade.getDescricao());
        basicAtividade.put("data", atividade.getData());
        basicAtividade.put("hora", atividade.getHora());
        
        BasicDBObject basicEndereco = new BasicDBObject();
        basicEndereco.put("rua", atividade.getEndereco().getRua());
        basicEndereco.put("bairro", atividade.getEndereco().getBairro());
        basicEndereco.put("numero", atividade.getEndereco().getNumero());
        basicEndereco.put("complemento", atividade.getEndereco().getComplemento());
        basicAtividade.put("endereco", basicEndereco);
        
        BasicDBObject basicPontuacao = new BasicDBObject();
        basicPontuacao.put("primeiro", atividade.getPontuacao().getPrimeiro());
        basicPontuacao.put("segundo", atividade.getPontuacao().getSegundo());
        basicPontuacao.put("terceiro", atividade.getPontuacao().getTerceiro());
        basicAtividade.put("pontuacao", basicPontuacao);
        
        //if (atividade.getSituacao().equals("")) {
        //    BasicDBObject basicClassificacao = new BasicDBObject();
        //    basicClassificacao.put("primeiro", "");
        //    basicClassificacao.put("segundo", "");
        //    basicClassificacao.put("terceiro", "");
        //    basicAtividade.put("classificacao", basicClassificacao);
        //} else {
            BasicDBObject basicClassificacao = new BasicDBObject();
            basicClassificacao.put("primeiro", atividade.getClassificacao().getPrimeiro());
            basicClassificacao.put("segundo", atividade.getClassificacao().getSegundo());
            basicClassificacao.put("terceiro", atividade.getClassificacao().getTerceiro());
            basicAtividade.put("classificacao", basicClassificacao);
        //}
        
        dBCollection.insert(basicAtividade);
    }
    
    public ArrayList<Atividade> findAll() {
        ArrayList<Atividade> atividades = new ArrayList<>();
        
        DBCursor cursor = dBCollection.find();
        while(cursor.hasNext()) {
            Atividade atividade = new Atividade();
            BasicDBObject basicAtividade = (BasicDBObject) cursor.next();
        
            atividade.setId(basicAtividade.getString("_id"));
            atividade.setSituacao(basicAtividade.getString("situacao"));
            atividade.setNome(basicAtividade.getString("nome"));
            atividade.setDescricao(basicAtividade.getString("descricao"));
            atividade.setData(basicAtividade.getString("data"));
            atividade.setHora(basicAtividade.getString("hora"));
        
            Endereco endereco = new Endereco();
            BasicDBObject basicEndereco = (BasicDBObject) basicAtividade.get("endereco");
            endereco.setRua(basicEndereco.getString("rua"));
            endereco.setBairro(basicEndereco.getString("bairro"));
            endereco.setNumero(basicEndereco.getLong("numero"));
            endereco.setComplemento(basicEndereco.getString("complemento"));
            atividade.setEndereco(endereco);
        
            Pontuacao pontuacao = new Pontuacao();
            BasicDBObject basicPontuacao = (BasicDBObject) basicAtividade.get("pontuacao");
            pontuacao.setPrimeiro(basicPontuacao.getLong("primeiro"));
            pontuacao.setSegundo(basicPontuacao.getLong("segundo"));
            pontuacao.setTerceiro(basicPontuacao.getLong("terceiro"));
            atividade.setPontuacao(pontuacao);
            
            BasicDBObject basicClassificacao = (BasicDBObject) basicAtividade.get("classificacao");
            Classificacao classificacao = new Classificacao();
            classificacao.setPrimeiro(basicClassificacao.getString("primeiro"));
            classificacao.setSegundo(basicClassificacao.getString("segundo"));
            classificacao.setTerceiro(basicClassificacao.getString("terceiro"));
            atividade.setClassificacao(classificacao);
                                    
            atividades.add(atividade);
        }
        
        return atividades;
    }
    
    public ArrayList<Atividade> find(String queryPesquisa) {
        ArrayList<Atividade> atividades = new ArrayList<>();
        
        BasicDBObject basicAtividadeQuery = new BasicDBObject();
        //O código abaixo faz o método find virar case insensitive
        basicAtividadeQuery.put("nome", Pattern.compile(".*" + queryPesquisa + ".*" , Pattern.CASE_INSENSITIVE));
        
        DBCursor cursor = dBCollection.find(basicAtividadeQuery);
        while(cursor.hasNext()) { 
            Atividade atividade = new Atividade();
            BasicDBObject basicAtividade = (BasicDBObject) cursor.next();
        
            atividade.setId(basicAtividade.getString("_id"));
            atividade.setSituacao(basicAtividade.getString("situacao"));
            atividade.setNome(basicAtividade.getString("nome"));
            atividade.setDescricao(basicAtividade.getString("descricao"));
            atividade.setData(basicAtividade.getString("data"));
            atividade.setHora(basicAtividade.getString("hora"));
        
            Endereco endereco = new Endereco();
            BasicDBObject basicEndereco = (BasicDBObject) basicAtividade.get("endereco");
            endereco.setRua(basicEndereco.getString("rua"));
            endereco.setBairro(basicEndereco.getString("bairro"));
            endereco.setNumero(basicEndereco.getLong("numero"));
            endereco.setComplemento(basicEndereco.getString("complemento"));
            atividade.setEndereco(endereco);
        
            Pontuacao pontuacao = new Pontuacao();
            BasicDBObject basicPontuacao = (BasicDBObject) basicAtividade.get("pontuacao");
            pontuacao.setPrimeiro(basicPontuacao.getLong("primeiro"));
            pontuacao.setSegundo(basicPontuacao.getLong("segundo"));
            pontuacao.setTerceiro(basicPontuacao.getLong("terceiro"));
            atividade.setPontuacao(pontuacao);
            
            BasicDBObject basicClassificacao = (BasicDBObject) basicAtividade.get("classificacao");
            Classificacao classificacao = new Classificacao();
            classificacao.setPrimeiro(basicClassificacao.getString("primeiro"));
            classificacao.setSegundo(basicClassificacao.getString("segundo"));
            classificacao.setTerceiro(basicClassificacao.getString("terceiro"));
            atividade.setClassificacao(classificacao);
                                    
            atividades.add(atividade);
        }
        
        return atividades;
    }
    
    public void delete(String id) {
        BasicDBObject objectAtividade = new BasicDBObject();
        objectAtividade.put("_id", new ObjectId(id));
        dBCollection.remove(objectAtividade);
    }
    
    public void update(String id, Atividade atividade) {
        BasicDBObject basicAlterar = new BasicDBObject();
        basicAlterar.put("_id", new ObjectId(id));
        
        BasicDBObject basicAlteracoes = new BasicDBObject();
        basicAlteracoes.put("situacao", atividade.getSituacao());
        basicAlteracoes.put("nome", atividade.getNome());
        basicAlteracoes.put("descricao", atividade.getDescricao());
        basicAlteracoes.put("data", atividade.getData());
        basicAlteracoes.put("hora", atividade.getHora());
        
        BasicDBObject basicEndereco = new BasicDBObject();
        basicEndereco.put("rua", atividade.getEndereco().getRua());
        basicEndereco.put("bairro", atividade.getEndereco().getBairro());
        basicEndereco.put("numero", atividade.getEndereco().getNumero());
        basicEndereco.put("complemento", atividade.getEndereco().getComplemento());
        basicAlteracoes.put("endereco", basicEndereco);
        
        BasicDBObject basicPontuacao = new BasicDBObject();
        basicPontuacao.put("primeiro", atividade.getPontuacao().getPrimeiro());
        basicPontuacao.put("segundo", atividade.getPontuacao().getSegundo());
        basicPontuacao.put("terceiro", atividade.getPontuacao().getTerceiro());
        basicAlteracoes.put("pontuacao", basicPontuacao);
        
        BasicDBObject basicClassificacao = new BasicDBObject();
        basicClassificacao.put("primeiro", atividade.getClassificacao().getPrimeiro());
        basicClassificacao.put("segundo", atividade.getClassificacao().getSegundo());
        basicClassificacao.put("terceiro", atividade.getClassificacao().getTerceiro());
        basicAlteracoes.put("classificacao", basicClassificacao);
        
        dBCollection.update(basicAlterar, basicAlteracoes);
    }
}
