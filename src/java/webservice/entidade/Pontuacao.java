package webservice.entidade;

/**
 *
 * @author matheush
 */
public class Pontuacao {
    protected long primeiro;
    protected long segundo;
    protected long terceiro;

    public Pontuacao(long primeiro, long segundo, long terceiro) {
        this.primeiro = primeiro;
        this.segundo = segundo;
        this.terceiro = terceiro;
    }

    public long getPrimeiro() {
        return primeiro;
    }

    public void setPrimeiro(long primeiro) {
        this.primeiro = primeiro;
    }

    public long getSegundo() {
        return segundo;
    }

    public void setSegundo(long segundo) {
        this.segundo = segundo;
    }

    public long getTerceiro() {
        return terceiro;
    }

    public void setTerceiro(long terceiro) {
        this.terceiro = terceiro;
    }
}
