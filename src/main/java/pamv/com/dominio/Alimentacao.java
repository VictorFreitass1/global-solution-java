package pamv.com.dominio;

import java.util.Date;

public class Alimentacao {
    private int idAlimentacao;
    private int idPaciente;
    private Date dataRefeicao;
    private String descricaoRefeicao;
    private int calorias;

    public Alimentacao(int idAlimentacao, int idPaciente, Date dataRefeicao, String descricaoRefeicao, int calorias) {
        this.idAlimentacao = idAlimentacao;
        this.idPaciente = idPaciente;
        this.dataRefeicao = dataRefeicao;
        this.descricaoRefeicao = descricaoRefeicao;
        this.calorias = calorias;
    }
    
	public Alimentacao() {
		
	}

	public int getIdAlimentacao() {
		return idAlimentacao;
	}

	public void setIdAlimentacao(int idAlimentacao) {
		this.idAlimentacao = idAlimentacao;
	}

	public int getIdPaciente() {
		return idPaciente;
	}

	public void setIdPaciente(int idPaciente) {
		this.idPaciente = idPaciente;
	}

	public Date getDataRefeicao() {
		return dataRefeicao;
	}

	public void setDataRefeicao(Date dataRefeicao) {
		this.dataRefeicao = dataRefeicao;
	}

	public String getDescricaoRefeicao() {
		return descricaoRefeicao;
	}

	public void setDescricaoRefeicao(String descricaoRefeicao) {
		this.descricaoRefeicao = descricaoRefeicao;
	}

	public int getCalorias() {
		return calorias;
	}

	public void setCalorias(int calorias) {
		this.calorias = calorias;
	}
    
}
