package pamv.com.service;

import pamv.com.banco.ContatoPacienteDAO;
import pamv.com.dominio.ContatoPaciente;
import java.util.List;

public class ContatoPacienteService {

    private ContatoPacienteDAO contatoPacienteDAO;

    public ContatoPacienteService() {
        this.contatoPacienteDAO = new ContatoPacienteDAO();
    }

    public void cadastrarContatoPaciente(ContatoPaciente contatoPaciente) {
        try {
            contatoPacienteDAO.cadastrarContatoPaciente(contatoPaciente);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void atualizarContatoPaciente(ContatoPaciente contatoPaciente) {
        try {
            contatoPacienteDAO.atualizarContatoPaciente(contatoPaciente);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void deletarContatoPaciente(int idPaciente) {
        try {
            contatoPacienteDAO.deletarContatoPaciente(idPaciente);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<ContatoPaciente> listarTodosContatosPacientes() {
        try {
            return contatoPacienteDAO.listarTodosContatosPacientes();
        } catch (Exception e) {
            e.printStackTrace();
            return null; 
        }
    }
}
