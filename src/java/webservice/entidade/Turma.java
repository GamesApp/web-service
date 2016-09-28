package webservice.entidade;

import java.util.List;

/**
 *
 * @author matheush
 */
public class Turma {
    private String curso;
    private int anoInicio;
    private double pontos;
    private List<String> etapasGanhas;

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    public int getAnoInicio() {
        return anoInicio;
    }

    public void setAnoInicio(int anoInicio) {
        this.anoInicio = anoInicio;
    }

    public double getPontos() {
        return pontos;
    }

    public void setPontos(double pontos) {
        this.pontos = pontos;
    }

    public List<String> getEtapasGanhas() {
        return etapasGanhas;
    }

    public void setEtapasGanhas(List<String> etapasGanhas) {
        this.etapasGanhas = etapasGanhas;
    }
}
