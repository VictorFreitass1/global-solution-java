package pamv.com.service;

import java.util.List;

import pamv.com.banco.ProblemasSaudeDAO;
import pamv.com.dominio.ProblemasSaude;

public class ProblemasSaudeService {

    private ProblemasSaudeDAO problemasSaudeDAO;

    public ProblemasSaudeService() {
        this.problemasSaudeDAO = new ProblemasSaudeDAO();
    }

    public void cadastrarProblemaSaude(ProblemasSaude problemaSaude) {
        problemasSaudeDAO.cadastrarProblemaSaude(problemaSaude);
    }

    public void atualizarProblemaSaude(ProblemasSaude problemaSaude) {
        problemasSaudeDAO.atualizarProblemaSaude(problemaSaude);
    }

    public void deletarProblemaSaude(int idProblema) {
        problemasSaudeDAO.deletarProblemaSaude(idProblema);
    }

    public List<ProblemasSaude> listarProblemasSaude() {
        return problemasSaudeDAO.listarProblemasSaude();
    }
}