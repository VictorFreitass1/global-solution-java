package pamv.com.dominio;

public class ControleDoencasTransmissiveis {
    private int idControle;
    private int idPaciente;
    private int idProblema;
    private String tratamentoRecomendado;
    private String observacoes;

    public ControleDoencasTransmissiveis(int idControle, int idPaciente, int idProblema, String tratamentoRecomendado, String observacoes) {
        this.idControle = idControle;
        this.idPaciente = idPaciente;
        this.idProblema = idProblema;
        this.tratamentoRecomendado = tratamentoRecomendado;
        this.observacoes = observacoes;
    }
    
    public ControleDoencasTransmissiveis() {
        
    }

	public int getIdControle() {
		return idControle;
	}

	public void setIdControle(int idControle) {
		this.idControle = idControle;
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

	public String getTratamentoRecomendado() {
		return tratamentoRecomendado;
	}

	public void setTratamentoRecomendado(String tratamentoRecomendado) {
		this.tratamentoRecomendado = tratamentoRecomendado;
	}

	public String getObservacoes() {
		return observacoes;
	}

	public void setObservacoes(String observacoes) {
		this.observacoes = observacoes;
	}
    
}
