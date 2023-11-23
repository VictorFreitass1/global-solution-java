package pamv.com.service;

import java.util.List;

import pamv.com.banco.CriancaDAO;
import pamv.com.dominio.Crianca;

public class CriancaService {
    private CriancaDAO criancaDAO;

    public CriancaService() {
        this.criancaDAO = new CriancaDAO();
    }

    public void cadastrarCrianca(Crianca crianca) {
        criancaDAO.cadastrarCrianca(crianca);
    }

    public void atualizarCrianca(Crianca crianca) {
        criancaDAO.atualizarCrianca(crianca);
    }
    
    public void deletarCrianca(int idVacina) {
        criancaDAO.deletarCrianca(idVacina);
    }
    
    public List<Crianca> listarCriancas() {
        return criancaDAO.listarCriancas();
    }
}