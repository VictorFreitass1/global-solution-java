package pamv.com.service;

import java.util.List;

import pamv.com.banco.ContatoMedicosDAO;
import pamv.com.dominio.ContatoMedicos;

public class ContatoMedicosService {

    private ContatoMedicosDAO contatoMedicosDAO;
    
    public ContatoMedicosService(ContatoMedicosDAO contatoMedicosDAO) {
        this.contatoMedicosDAO = contatoMedicosDAO;
    }

    public ContatoMedicosService() {
        this.contatoMedicosDAO = new ContatoMedicosDAO();
    }

    public void cadastrarContatoMedico(ContatoMedicos contatoMedicos) {
        contatoMedicosDAO.cadastrarContatoMedico(contatoMedicos);
    }

    public void atualizarContatoMedico(ContatoMedicos contatoMedicos) {
        contatoMedicosDAO.atualizarContatoMedico(contatoMedicos);
    }

    public void deletarContatoMedico(int idMedico) {
        contatoMedicosDAO.deletarContatoMedico(idMedico);
    }

    public List<ContatoMedicos> listarContatosMedicos() {
        return contatoMedicosDAO.listarContatosMedicos();
    }
}