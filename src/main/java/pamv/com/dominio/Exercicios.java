package pamv.com.dominio;

import java.util.Date;

public class Exercicios {
    private int idExercicio;
    private int idPaciente;
    private Date dataExercicio;
    private String tipoExercicio;
    private int duracaoEmMinutos;

    public Exercicios(int idExercicio, int idPaciente, Date dataExercicio, String tipoExercicio, int duracaoEmMinutos) {
        this.idExercicio = idExercicio;
        this.idPaciente = idPaciente;
        this.dataExercicio = dataExercicio;
        this.tipoExercicio = tipoExercicio;
        this.duracaoEmMinutos = duracaoEmMinutos;
    }
    
    public Exercicios() {

    }

	public int getIdExercicio() {
		return idExercicio;
	}

	public void setIdExercicio(int idExercicio) {
		this.idExercicio = idExercicio;
	}

	public int getIdPaciente() {
		return idPaciente;
	}

	public void setIdPaciente(int idPaciente) {
		this.idPaciente = idPaciente;
	}

	public Date getDataExercicio() {
		return dataExercicio;
	}

	public void setDataExercicio(Date dataExercicio) {
		this.dataExercicio = dataExercicio;
	}

	public String getTipoExercicio() {
		return tipoExercicio;
	}

	public void setTipoExercicio(String tipoExercicio) {
		this.tipoExercicio = tipoExercicio;
	}

	public int getDuracaoEmMinutos() {
		return duracaoEmMinutos;
	}

	public void setDuracaoEmMinutos(int duracaoEmMinutos) {
		this.duracaoEmMinutos = duracaoEmMinutos;
	}
    
}
