package pamv.com.service;

import pamv.com.banco.ControleDoencasTransmissiveisDAO;
import pamv.com.dominio.ControleDoencasTransmissiveis;

import java.sql.SQLException;
import java.util.List;

public class ControleDoencasTransmissiveisService {
    private ControleDoencasTransmissiveisDAO controleDAO;

    public ControleDoencasTransmissiveisService() {
        this.controleDAO = new ControleDoencasTransmissiveisDAO();
    }

    public void cadastrarControleDoencasTransmissiveis(ControleDoencasTransmissiveis controle) {
        try {
            controleDAO.cadastrarControleDoencasTransmissiveis(controle);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void atualizarControleDoencasTransmissiveis(ControleDoencasTransmissiveis controle) {
        try {
            controleDAO.atualizarControleDoencasTransmissiveis(controle);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deletarControleDoencasTransmissiveis(int idControle) {
        try {
            controleDAO.deletarControleDoencasTransmissiveis(idControle);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<ControleDoencasTransmissiveis> listarControleDoencasTransmissiveis() {
        try {
            return controleDAO.listarControleDoencasTransmissiveis();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
