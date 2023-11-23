package pamv.com.dominio;


public class Medicos {
    private int idMedico;
    private String nomeMedico;
    private String especialidade;
    private String email;
    private String senha;

    public Medicos (String nomeMedico, String especialidade, String email, String senha) {
        this.nomeMedico = nomeMedico;
        this.especialidade = especialidade;
        this.email = email;
        this.senha = senha;
    }
    
    public Medicos(int idMedico, String nomeMedico, String especialidade, String email, String senha) {
        this.idMedico = idMedico;
        this.nomeMedico = nomeMedico;
        this.especialidade = especialidade;
        this.email = email;
        this.senha = senha;
    }

	public Medicos() {

	}

	public int getIdMedico() {
		return idMedico;
	}

	public String getNomeMedico() {
		return nomeMedico;
	}

	public String getEspecialidade() {
		return especialidade;
	}

	public String getEmail() {
		return email;
	}

	public String getSenha() {
		return senha;
	}

	public void setIdMedico(int idMedico) {
		this.idMedico = idMedico;
	}

	public void setNomeMedico(String nomeMedico) {
		this.nomeMedico = nomeMedico;
	}

	public void setEspecialidade(String especialidade) {
		this.especialidade = especialidade;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}    
}
