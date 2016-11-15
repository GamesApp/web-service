package webservice.dao;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.Mongo;
import webservice.entidades.atividade.Atividade;

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
        
        if (atividade.getClassificacao() != null) {
            BasicDBObject basicClassificacao = new BasicDBObject();
            basicClassificacao.put("primeiro", atividade.getClassificacao().getPrimeiro());
            basicClassificacao.put("segundo", atividade.getClassificacao().getSegundo());
            basicClassificacao.put("terceiro", atividade.getClassificacao().getTerceiro());
            basicAtividade.put("classificacao", basicClassificacao);
        }
        
        dBCollection.insert(basicAtividade);
    }
}
