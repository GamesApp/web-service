/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package webservice.dao;

import com.mongodb.DBObject;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import webservice.conversor.ConversorAtividade;
import webservice.entidades.atividade.Atividade;

/**
 *
 * @author matheush
 */
public class AtividadeDao extends EntidadeDao<Atividade> {
    
    public AtividadeDao() {
        super(Atividade.class);
    }

    public void save(Atividade atividade) {
        Map<String, Object> mapPerson =
                new ConversorAtividade().converterToMap(atividade);

        save(mapPerson);
    }
    
    public void update(Atividade oldAtividade, Atividade newAtividade) {
        Map<String, Object> query =
                new ConversorAtividade().converterToMap(oldAtividade);

        Map<String, Object> map =
                new ConversorAtividade().converterToMap(newAtividade);

        update(query, map);
    }
    
    public void delete(Atividade atividade) {
        Map<String, Object> map =
                new ConversorAtividade().converterToMap(atividade);

        delete(map);
    }
    
    public Atividade findAtividade(Map<String, Object> mapKeyValue) {
        DBObject dbObject = findOne(mapKeyValue);

        Atividade atividade = new ConversorAtividade().converterToAtividade(dbObject);

        return atividade;
    }
    
    public List<Atividade> findAtividades() {
        List<DBObject> dbObject = findAll();

        List<Atividade> atividades = new ArrayList<Atividade>();

        for (DBObject dbo : dbObject) {
            Atividade atividade = new ConversorAtividade().converterToAtividade(dbo);

            atividades.add(atividade);
        }

        return atividades;
    }
    
    public List<Atividade> findAtividades(Map<String, Object> mapKeyValue) {
        List<DBObject> dbObject = findKeyValue(mapKeyValue);

        List<Atividade> atividades = new ArrayList<Atividade>();

        for (DBObject dbo : dbObject) {
            Atividade atividade = new ConversorAtividade().converterToAtividade(dbo);

            atividades.add(atividade);
        }

        return atividades;
    }
    
}
