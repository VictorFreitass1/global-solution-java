package pamv.com.dominio;

public class FilhosPaciente {
	private int idCrianca;
    private int idPaciente;
    
    public FilhosPaciente(int idCrianca, int idPaciente) {
        this.idCrianca = idCrianca;
        this.idPaciente = idPaciente;
    }

    public FilhosPaciente() {

    }
    
    public int getIdCrianca() {
        return idCrianca;
    }

    public void setIdCrianca(int idCrianca) {
        this.idCrianca = idCrianca;
    }

    public int getIdPaciente() {
        return idPaciente;
    }

    public void setIdPaciente(int idPaciente) {
        this.idPaciente = idPaciente;
    }
    
    
}