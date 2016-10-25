package webservice.entidade;

/**
 *
 * @author matheush
 */
public class Professor extends Pessoa {
    private String siape;

    public Professor(String nome, String email, String codConfirmacao, String siape) {
        super.nome = nome;
        super.email = email;
        super.codConfirmacao = codConfirmacao;
        this.siape = siape;
    }

    public String getSiape() {
        return siape;
    }

    public void setSiape(String siape) {
        this.siape = siape;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCodConfirmacao() {
        return codConfirmacao;
    }

    public void setCodConfirmacao(String codConfirmacao) {
        this.codConfirmacao = codConfirmacao;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
}
