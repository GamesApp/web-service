package webservice.entidade;

/**
 *
 * @author matheush
 */
public class Aluno extends Pessoa {
    private String matricula;

    public Aluno(String nome, String email, String codConfirmacao, String matricula) {
        super.nome = nome;
        super.email = email;
        super.codConfirmacao = codConfirmacao;
        this.matricula = matricula;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
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
