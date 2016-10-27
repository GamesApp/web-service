package webservice.entidades.atividade;

/**
 *
 * @author matheush
 */
public class Endereco {
    private String rua;
    private String bairro;
    private long numero;
    private String complemento;
    private String referencia;

    public Endereco(String rua, String bairro, long numero, String complemento, String referencia) {
        this.rua = rua;
        this.bairro = bairro;
        this.numero = numero;
        this.complemento = complemento;
        this.referencia = referencia;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public long getNumero() {
        return numero;
    }

    public void setNumero(long numero) {
        this.numero = numero;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getReferencia() {
        return referencia;
    }

    public void setReferencia(String referencia) {
        this.referencia = referencia;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("\n");
        stringBuilder.append("\n" + rua);
        stringBuilder.append(", " + numero);
        stringBuilder.append(", " + complemento);
        stringBuilder.append(", " + bairro);
        
        return stringBuilder.toString();
    }  
}
