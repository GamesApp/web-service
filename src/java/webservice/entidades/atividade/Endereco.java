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

    public Endereco(String rua, String bairro, long numero, String complemento) {
        this.rua = rua;
        this.bairro = bairro;
        this.numero = numero;
        this.complemento = complemento;
    }

    public Endereco(String endereco) {
        String enderecoJunto = endereco;
        String array[] = new String[4];
        array = enderecoJunto.split(";");
        
        this.rua = array[0];
        this.bairro = array[1];
        this.numero = Long.parseLong(array[2]);
        this.complemento = array[3];
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

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("" + rua);
        stringBuilder.append(";" + numero);
        stringBuilder.append(";" + complemento);
        stringBuilder.append(";" + bairro);
        
        return stringBuilder.toString();
    }  
}
