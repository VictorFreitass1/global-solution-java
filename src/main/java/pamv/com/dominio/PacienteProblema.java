package pamv.com.dominio;

public class PacienteProblema {
    private int idPaciente;
    private int idProblema;

    public PacienteProblema(int idPaciente, int idProblema) {
        this.idPaciente = idPaciente;
        this.idProblema = idProblema;
    }

	public int getIdPaciente() {
		return idPaciente;
	}

	public void setIdPaciente(int idPaciente) {
		this.idPaciente = idPaciente;
	}

	public int getIdProblema() {
		return idProblema;
	}

	public void setIdProblema(int idProblema) {
		this.idProblema = idProblema;
	}
    
}
