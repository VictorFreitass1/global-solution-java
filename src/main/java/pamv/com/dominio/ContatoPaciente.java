package pamv.com.dominio;

public class ContatoPaciente {
    private int idPaciente;
    private String telefonePaciente;

    public ContatoPaciente(int idPaciente, String telefonePaciente) {
        this.idPaciente = idPaciente;
        this.telefonePaciente = telefonePaciente;
    }

	public ContatoPaciente() {

	}

	public int getIdPaciente() {
		return idPaciente;
	}

	public void setIdPaciente(int idPaciente) {
		this.idPaciente = idPaciente;
	}

	public String getTelefonePaciente() {
		return telefonePaciente;
	}

	public void setTelefonePaciente(String telefonePaciente) {
		this.telefonePaciente = telefonePaciente;
	}
    
}