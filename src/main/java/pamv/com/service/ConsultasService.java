package pamv.com.service;

import pamv.com.dominio.Consultas;
import pamv.com.banco.ConsultasDAO;

import java.sql.SQLException;
import java.util.List;

public class ConsultasService {
    private ConsultasDAO consultasDAO;

    public ConsultasService() {
        this.consultasDAO = new ConsultasDAO();
    }

    public void cadastrarConsulta(Consultas consulta) {
        try {
            consultasDAO.cadastrarConsulta(consulta);
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao cadastrar consulta", e);
        }
    }

    public void atualizarConsulta(Consultas consulta) {
        try {
            consultasDAO.atualizarConsulta(consulta);
        } catch (Exception e) {
            throw new RuntimeException("Erro ao atualizar consulta", e);
        }
    }

    public void deletarConsulta(int idConsulta) {
        try {
            consultasDAO.deletarConsulta(idConsulta);
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao deletar consulta", e);
        }
    }

    public List<Consultas> listarConsultas() {
        try {
            return consultasDAO.listarConsultas();
        } catch (RuntimeException e) {
            throw new RuntimeException("Erro ao listar consultas", e);
        }
    }
}
