package webservice.entidade;

import java.util.Date;

/**
 *
 * @author matheush
 */
public class DadosAtividade {
    protected String data;
    protected String nome;
    protected Endereco endereco;

    public DadosAtividade(String data, String nome, Endereco endereco) {
        this.data = data;
        this.nome = nome;
        this.endereco = endereco;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }
    
    
}
