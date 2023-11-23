package pamv.com.dominio;

public class ProblemasSaude {
    private int idProblema;
    private String nomeProblema;
    private String descricao;

    public ProblemasSaude(int idProblema, String nomeProblema, String descricao) {
        this.idProblema = idProblema;
        this.nomeProblema = nomeProblema;
        this.descricao = descricao;
    }
    
    public ProblemasSaude() {

    }
 
    public int getIdProblema() {
        return idProblema;
    }

    public void setIdProblema(int idProblema) {
        this.idProblema = idProblema;
    }

    public String getNomeProblema() {
        return nomeProblema;
    }

    public void setNomeProblema(String nomeProblema) {
        this.nomeProblema = nomeProblema;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    
    
}