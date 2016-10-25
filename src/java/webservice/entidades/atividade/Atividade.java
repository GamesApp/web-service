package webservice.entidades.atividade;

/**
 *
 * @author matheush
 */
public class Atividade {
    private String nome;
    private String hora;
    private String descricao;
    private Pontuacao pontuacao;
    private DadosAtividade dadosAtividade;

    public Atividade(String nome, String hora, String descricao, Pontuacao pontuacao, DadosAtividade dadosAtividade) {
        this.nome = nome;
        this.hora = hora;
        this.descricao = descricao;
        this.pontuacao = pontuacao;
        this.dadosAtividade = dadosAtividade;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
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

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("\n");
        stringBuilder.append("\nATIVIDADE");
        stringBuilder.append("\nNome: " + nome);
        stringBuilder.append("\nData: " + dadosAtividade.getData());
        stringBuilder.append("\nHora: " + hora);
        stringBuilder.append("\nEndereço: " + dadosAtividade.getEndereco().toString());
        stringBuilder.append("\nReferência: " + dadosAtividade.getEndereco().getReferencia());
        stringBuilder.append("\nDescrição: " + descricao);
        stringBuilder.append("\nPontuação:");
        stringBuilder.append("\n" + pontuacao.toString());
          
        return stringBuilder.toString();
    }
}
