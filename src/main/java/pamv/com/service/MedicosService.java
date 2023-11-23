package pamv.com.service;

import pamv.com.dominio.Medicos;
import pamv.com.banco.MedicosDAO;

import java.util.List;

public class MedicosService {

    private MedicosDAO medicosDAO = new MedicosDAO();

    public void cadastrarMedico(Medicos medico) {
        try {
            medicosDAO.cadastrarMedico(medico);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Erro ao cadastrar médico", e);
        }
    }

    public Medicos realizarLogin(String email, String senha) {
        try {
            return medicosDAO.realizarLogin(email, senha);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Erro ao realizar login", e);
        }
    }

    public void atualizarMedico(Medicos medico) {
        try {
            medicosDAO.atualizarMedico(medico);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Erro ao atualizar médico", e);
        }
    }

    public void deletarMedico(int idMedico) {
        try {
            medicosDAO.deletarMedico(idMedico);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Erro ao deletar médico", e);
        }
    }

    public List<Medicos> listarTodosMedicos() {
        try {
            return medicosDAO.listarTodosMedicos();
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Erro ao listar médicos", e);
        }
    }
}
