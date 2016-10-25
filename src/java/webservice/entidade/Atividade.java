package webservice.entidade;

/**
 *
 * @author matheush
 */
public class Atividade {
    private String hora;
    private String descricao;
    private Pontuacao pontuacao;
    private DadosAtividade dadosAtividade;

    public Atividade(String hora, String descricao, Pontuacao pontuacao, DadosAtividade dadosAtividade) {
        this.hora = hora;
        this.descricao = descricao;
        this.pontuacao = pontuacao;
        this.dadosAtividade = dadosAtividade;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Pontuacao getPontuacao() {
        return pontuacao;
    }

    public void setPontuacao(Pontuacao pontuacao) {
        this.pontuacao = pontuacao;
    }

    public DadosAtividade getDadosAtividade() {
        return dadosAtividade;
    }

    public void setDadosAtividade(DadosAtividade dadosAtividade) {
        this.dadosAtividade = dadosAtividade;
    }    
}
