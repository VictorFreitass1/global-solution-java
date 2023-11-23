package pamv.com.dominio;

import java.util.Date;

public class Paciente {
    private int idPaciente;
    private String nomePaciente;
    private Date dataNascimento;
    private String email;
    private String senha;
    private String cpf;


    public Paciente(String nomePaciente, Date dataNascimento, String email, String senha, String cpf) {
        this.nomePaciente = nomePaciente;
        this.dataNascimento = dataNascimento;
        this.email = email;
        this.senha = senha;
        this.cpf = cpf;
    }
    
    public Paciente () {
    	
    }
  
	public void setIdPaciente(int idPaciente) {
		this.idPaciente = idPaciente;
	}

	public void setNomePaciente(String nomePaciente) {
		this.nomePaciente = nomePaciente;
	}

	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	
	public void setSenha(String senha) {
	    this.senha = senha;
	}

	public int getIdPaciente() {
		return idPaciente;
	}

	public String getNomePaciente() {
		return nomePaciente;
	}

	public Date getDataNascimento() {
		return dataNascimento;
	}

	public String getEmail() {
		return email;
	}

	public String getCpf() {
		return cpf;
	}

	public String getSenha() {
		return senha;
	}  
}