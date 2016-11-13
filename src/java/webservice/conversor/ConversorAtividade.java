package webservice.conversor;

import com.mongodb.BasicDBList;
import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import webservice.entidades.atividade.Atividade;
import webservice.entidades.atividade.Classificacao;
import webservice.entidades.atividade.DadosAtividade;
import webservice.entidades.atividade.Endereco;
import webservice.entidades.atividade.Pontuacao;

/**
 *
 * @author matheush
 */
public class ConversorAtividade {
    public Map<String, Object> converterToMap(Atividade atividade) {
        Map<String, Object> mapPerson = new HashMap<String, Object>();
        mapPerson.put("data", atividade.getDadosAtividade().getData());
        mapPerson.put("hora", atividade.getHora());
        mapPerson.put("local", atividade.getDadosAtividade().getEndereco().toString());
        mapPerson.put("descricao", atividade.getDescricao());
        mapPerson.put("nome", atividade.getNome());
        
        /*
        BasicDBList pontuacao = new BasicDBList();
        pontuacao.add(atividade.getPontuacao().getPrimeiro());
        pontuacao.add(atividade.getPontuacao().getSegundo());
        pontuacao.add(atividade.getPontuacao().getTerceiro());
        mapPerson.put("pontuacao", pontuacao);
        */
        mapPerson.put("pontuacao_primeiro", atividade.getPontuacao().getPrimeiro());
        mapPerson.put("pontuacao_segundo", atividade.getPontuacao().getSegundo());
        mapPerson.put("pontuacao_terceiro", atividade.getPontuacao().getTerceiro());
        mapPerson.put("vencedor_primeiro", atividade.getClassificacao().getPrimeiro());
        mapPerson.put("vencedor_segundo", atividade.getClassificacao().getSegundo());
        mapPerson.put("vencedor_terceiro", atividade.getClassificacao().getTerceiro());
        
        
        return mapPerson;
    }
    
    public Atividade converterToAtividade(DBObject dbo) {
        Atividade atividade = new Atividade();
        atividade.setId(dbo.get("_id").toString());
        atividade.setDadosAtividade(new DadosAtividade((String) dbo.get("data"),
                new Endereco((String) dbo.get("local"))));
        atividade.setHora((String) dbo.get("hora"));
        atividade.setDescricao((String) dbo.get("descricao"));
        atividade.setNome((String) dbo.get("nome"));
        
        Pontuacao pontuacao = new Pontuacao(
            (Long) dbo.get("pontuacao_primeiro"),
            (Long) dbo.get("pontuacao_segundo"),
            (Long) dbo.get("pontuacao_terceiro"));
        atividade.setPontuacao(pontuacao);
        
        Classificacao classificacao = new Classificacao(
                (String) dbo.get("vencedor_primeiro"),
                (String) dbo.get("vencedor_segundo"), 
                (String) dbo.get("vencedor_terceiro"));
        atividade.setClassificacao(classificacao);

        return atividade;
    }
}
