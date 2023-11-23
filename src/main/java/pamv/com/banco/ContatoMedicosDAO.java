package pamv.com.banco;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import pamv.com.dominio.ContatoMedicos;

public class ContatoMedicosDAO {

    private Connection connection;

    public ContatoMedicosDAO() {
        this.connection = new ConnectionFactory().getConnection();
    }

    public void cadastrarContatoMedico(ContatoMedicos contatoMedicos) {
        String sql = "INSERT INTO tb_contato_medicos (id_medico, telefone_medico) VALUES (?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            stmt.setInt(1, contatoMedicos.getIdMedico());
            stmt.setString(2, contatoMedicos.getTelefoneMedico());

            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void atualizarContatoMedico(ContatoMedicos contatoMedicos) {
        String sql = "UPDATE tb_contato_medicos SET telefone_medico = ? WHERE id_medico = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, contatoMedicos.getTelefoneMedico());
            stmt.setInt(2, contatoMedicos.getIdMedico());

            int linhasAfetadas = stmt.executeUpdate();

            if (linhasAfetadas == 0) {
                throw new SQLException("Falha ao atualizar o contato do médico, nenhum registro foi modificado.");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void deletarContatoMedico(int idMedico) {
        String sql = "DELETE FROM tb_contato_medicos WHERE id_medico = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, idMedico);

            int linhasAfetadas = stmt.executeUpdate();

            if (linhasAfetadas == 0) {
                throw new SQLException("Falha ao excluir o contato do médico, nenhum registro foi modificado.");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<ContatoMedicos> listarContatosMedicos() {
        List<ContatoMedicos> listaContatosMedicos = new ArrayList<>();
        String sql = "SELECT id_medico, telefone_medico FROM tb_contato_medicos";

        try (PreparedStatement stmt = connection.prepareStatement(sql);
             ResultSet resultSet = stmt.executeQuery()) {

            while (resultSet.next()) {
                ContatoMedicos contatoMedicos = new ContatoMedicos();
                contatoMedicos.setIdMedico(resultSet.getInt("id_medico"));
                contatoMedicos.setTelefoneMedico(resultSet.getString("telefone_medico"));

                listaContatosMedicos.add(contatoMedicos);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return listaContatosMedicos;
    }
}
