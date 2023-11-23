package pamv.com.dominio;

public class Vacinas {
    private int idVacina;
    private String nomeVacina;
    private String descricao;
    private int idadeRecomendada;

    public Vacinas(int idVacina, String nomeVacina, String descricao, int idadeRecomendada) {
        this.idVacina = idVacina;
        this.nomeVacina = nomeVacina;
        this.descricao = descricao;
        this.idadeRecomendada = idadeRecomendada;
    }

    public Vacinas() {
        
    }

    public int getIdVacina() {
        return idVacina;
    }

    public void setIdVacina(int idVacina) {
        this.idVacina = idVacina;
    }

    public String getNomeVacina() {
        return nomeVacina;
    }

    public void setNomeVacina(String nomeVacina) {
        this.nomeVacina = nomeVacina;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getIdadeRecomendada() {
        return idadeRecomendada;
    }

    public void setIdadeRecomendada(int idadeRecomendada) {
        this.idadeRecomendada = idadeRecomendada;
    }
    
}