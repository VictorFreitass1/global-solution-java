package pamv.com.service;

import pamv.com.banco.PacienteDAO;
import pamv.com.dominio.Paciente;

import java.util.List;

public class PacienteService {
    private PacienteDAO pacienteDAO;

    public PacienteService() {
        this.pacienteDAO = new PacienteDAO();
    }

    public void cadastrarPaciente(Paciente paciente) {
        pacienteDAO.cadastrarPaciente(paciente);
    }

    public void atualizarPaciente(Paciente paciente) {
        pacienteDAO.atualizarPaciente(paciente);
    }

    public void deletarPaciente(int idPaciente) {
        pacienteDAO.deletarPaciente(idPaciente);
    }

    public List<Paciente> listarTodosPacientes() {
        return pacienteDAO.listarTodosPacientes();
    }

    public Paciente realizarLogin(String email, String senha) {
        return pacienteDAO.realizarLogin(email, senha);
    }
}
