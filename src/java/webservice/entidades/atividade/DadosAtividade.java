package webservice.entidades.atividade;

import java.util.Date;

/**
 *
 * @author matheush
 */
public class DadosAtividade {
    protected String data;
    protected Endereco endereco;

    public DadosAtividade(String data, Endereco endereco) {
        this.data = data;
        this.endereco = endereco;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }
}
