package pamv.com.dominio;

import java.util.Date;

public class VacinasAdministradas {
    private int idRegistroVacina;
    private int idVacina;
    private int idCrianca;
    private int idPaciente;
    private Date dataAdministracao;

    public VacinasAdministradas(int idRegistroVacina, int idVacina, int idCrianca, int idPaciente, Date dataAdministracao) {
        this.idRegistroVacina = idRegistroVacina;
        this.idVacina = idVacina;
        this.idCrianca = idCrianca;
        this.idPaciente = idPaciente;
        this.dataAdministracao = dataAdministracao;
    }
    
    public VacinasAdministradas() {
 
    }

    public int getIdRegistroVacina() {
        return idRegistroVacina;
    }

    public void setIdRegistroVacina(int idRegistroVacina) {
        this.idRegistroVacina = idRegistroVacina;
    }

    public int getIdVacina() {
        return idVacina;
    }

    public void setIdVacina(int idVacina) {
        this.idVacina = idVacina;
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

    public Date getDataAdministracao() {
        return dataAdministracao;
    }

    public void setDataAdministracao(Date dataAdministracao) {
        this.dataAdministracao = dataAdministracao;
    }
    
    
}