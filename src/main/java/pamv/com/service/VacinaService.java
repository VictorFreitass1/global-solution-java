package pamv.com.service;

import java.util.List;

import pamv.com.banco.VacinaDAO;
import pamv.com.dominio.Vacinas;

public class VacinaService {

    private VacinaDAO vacinaDAO;

    public VacinaService() {
        this.vacinaDAO = new VacinaDAO();
    }

    public void cadastrarVacina(Vacinas vacina) {
        try {
            vacinaDAO.cadastrarVacina(vacina);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Erro ao cadastrar vacina", e);
        }
    }

    public void atualizarVacina(Vacinas vacina) {
        try {
            vacinaDAO.atualizarVacina(vacina);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Erro ao atualizar vacina", e);
        }
    }

    public void deletarVacina(int idVacina) {
        try {
            vacinaDAO.deletarVacina(idVacina);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Erro ao deletar vacina", e);
        }
    }

    public List<Vacinas> listarVacina() {
        try {
            return vacinaDAO.listarVacinas();
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Erro ao listar vacinas", e);
        }
    }
}
