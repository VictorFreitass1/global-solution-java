package pamv.com.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import pamv.com.banco.FilhosPacienteDAO;
import pamv.com.dominio.FilhosPaciente;

public class FilhosPacienteService {
    private FilhosPacienteDAO filhosPacienteDAO;

    public FilhosPacienteService() {
    	this.filhosPacienteDAO = new FilhosPacienteDAO();
    }
    
    public FilhosPacienteService(Connection connection) {
        this.filhosPacienteDAO = new FilhosPacienteDAO(connection);
    }

    public void cadastrarFilho(FilhosPaciente filho) {
        try {
            filhosPacienteDAO.cadastrar(filho);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void atualizarFilho(FilhosPaciente filho) {
        try {
            filhosPacienteDAO.atualizar(filho);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deletarFilho(int idPaciente) {
        try {
            filhosPacienteDAO.deletar(idPaciente);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<FilhosPaciente> listarFilhos() {
        try {
            return filhosPacienteDAO.listar();
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
}
