package pamv.com.dominio;

public class Crianca {
    private int idCrianca;
    private String nomeCrianca;
    private int idade;

    public Crianca(int idCrianca, String nomeCrianca, int idade) {
        this.idCrianca = idCrianca;
        this.nomeCrianca = nomeCrianca;
        this.idade = idade;
    }
    
    public Crianca() {

    }
    
    public int getIdCrianca() {
        return idCrianca;
    }

    public void setIdCrianca(int idCrianca) {
        this.idCrianca = idCrianca;
    }

    public String getNomeCrianca() {
        return nomeCrianca;
    }

    public void setNomeCrianca(String nomeCrianca) {
        this.nomeCrianca = nomeCrianca;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }
}