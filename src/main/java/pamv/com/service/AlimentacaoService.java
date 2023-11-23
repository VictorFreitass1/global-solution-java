package pamv.com.service;

import pamv.com.banco.AlimentacaoDAO;
import pamv.com.dominio.Alimentacao;

import java.util.List;

public class AlimentacaoService {

    private final AlimentacaoDAO alimentacaoDAO;

    public AlimentacaoService() {
        this.alimentacaoDAO = new AlimentacaoDAO();
    }

    public void cadastrarAlimentos(Alimentacao alimentacao) {
        try {
            alimentacaoDAO.cadastrarAlimentos(alimentacao);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Erro ao cadastrar alimentos", e);
        }
    }

    public void atualizarAlimento(Alimentacao alimentacao) {
        try {
            alimentacaoDAO.atualizarAlimento(alimentacao);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Erro ao atualizar alimento", e);
        }
    }

    public void deletarAlimento(int idAlimentacao) {
        try {
            alimentacaoDAO.deletarAlimento(idAlimentacao);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Erro ao deletar alimento", e);
        }
    }

    public List<Alimentacao> listarTodosAlimentos() {
        try {
            return alimentacaoDAO.listarTodosAlimentos();
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Erro ao listar todos alimentos", e);
        }
    }
}
