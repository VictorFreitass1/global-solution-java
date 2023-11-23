package pamv.com.service;

import pamv.com.banco.VacinasAdministradasDAO;
import pamv.com.dominio.VacinasAdministradas;
import java.util.List;

public class VacinasAdministradasService {
    private VacinasAdministradasDAO vacinasAdministradasDAO;

    public VacinasAdministradasService() {
        this.vacinasAdministradasDAO = new VacinasAdministradasDAO();
    }

    public void cadastrarVacina(VacinasAdministradas vacina) {
        try {
            vacinasAdministradasDAO.cadastrarVacina(vacina);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Erro ao cadastrar vacina", e);
        }
    }

    public void atualizarVacina(VacinasAdministradas vacina) {
        try {
            vacinasAdministradasDAO.atualizarVacina(vacina);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Erro ao atualizar vacina", e);
        }
    }

    public void deletarVacina(int idVacina) {
        try {
            vacinasAdministradasDAO.deletarVacina(idVacina);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Erro ao deletar vacina", e);
        }
    }

    public List<VacinasAdministradas> listarVacinas() {
        try {
            return vacinasAdministradasDAO.listarVacinas();
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Erro ao listar vacina", e);
        }
    }
}
