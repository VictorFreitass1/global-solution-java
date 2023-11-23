package pamv.com.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import pamv.com.banco.PacienteProblemaDAO;
import pamv.com.dominio.PacienteProblema;

public class PacienteProblemaService {

    private PacienteProblemaDAO pacienteProblemaDAO;

    public PacienteProblemaService() {
        this.pacienteProblemaDAO = new PacienteProblemaDAO();
    }

    public void cadastrarPacienteProblema(PacienteProblema pacienteProblema) {
        try {
            pacienteProblemaDAO.cadastrarPacienteProblema(pacienteProblema);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void atualizarPacienteProblema(PacienteProblema pacienteProblema) {
        try {
            pacienteProblemaDAO.atualizarPacienteProblema(pacienteProblema);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deletarPacienteProblema(int idPaciente, int idProblema) {
        try {
            pacienteProblemaDAO.deletarPacienteProblema(idPaciente, idProblema);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<PacienteProblema> listarPacienteProblema() {
        try {
            return pacienteProblemaDAO.listarPacienteProblema();
        } catch (Exception e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }

}
