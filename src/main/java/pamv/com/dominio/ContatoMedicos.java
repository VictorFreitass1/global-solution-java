package pamv.com.dominio;

public class ContatoMedicos {
    private int idMedico;
    private String telefoneMedico;

    public ContatoMedicos(int idMedico, String telefoneMedico) {
        this.idMedico = idMedico;
        this.telefoneMedico = telefoneMedico;
    }

    public ContatoMedicos() {

    }
    
    public int getIdMedico() {
        return idMedico;
    }

    public void setIdMedico(int idMedico) {
        this.idMedico = idMedico;
    }

    public String getTelefoneMedico() {
        return telefoneMedico;
    }

    public void setTelefoneMedico(String telefoneMedico) {
        this.telefoneMedico = telefoneMedico;
    }
}
