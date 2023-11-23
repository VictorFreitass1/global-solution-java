package pamv.com.banco;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import pamv.com.dominio.ProblemasSaude;

public class ProblemasSaudeDAO {

    private Connection connection;

    public ProblemasSaudeDAO() {
        this.connection = new ConnectionFactory().getConnection();
    }

    public void cadastrarProblemaSaude(ProblemasSaude problemaSaude) {
        String sql = "INSERT INTO tb_problemas_saude (nome_problema, descricao) VALUES (?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            stmt.setString(1, problemaSaude.getNomeProblema());
            stmt.setString(2, problemaSaude.getDescricao());

            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void atualizarProblemaSaude(ProblemasSaude problemaSaude) {
        String sql = "UPDATE tb_problemas_saude SET nome_problema = ?, descricao = ? WHERE id_problema = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, problemaSaude.getNomeProblema());
            stmt.setString(2, problemaSaude.getDescricao());
            stmt.setInt(3, problemaSaude.getIdProblema());

            int linhasAfetadas = stmt.executeUpdate();

            if (linhasAfetadas == 0) {
                throw new SQLException("Falha ao atualizar o problema de saúde, nenhum registro foi modificado.");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void deletarProblemaSaude(int idProblema) {
        String sql = "DELETE FROM tb_problemas_saude WHERE id_problema = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, idProblema);

            int linhasAfetadas = stmt.executeUpdate();

            if (linhasAfetadas == 0) {
                throw new SQLException("Falha ao excluir o problema de saúde, nenhum registro foi modificado.");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<ProblemasSaude> listarProblemasSaude() {
        List<ProblemasSaude> listaProblemasSaude = new ArrayList<>();
        String sql = "SELECT id_problema, nome_problema, descricao FROM tb_problemas_saude";

        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            ResultSet resultSet = stmt.executeQuery();

            while (resultSet.next()) {
                ProblemasSaude problemaSaude = new ProblemasSaude();
                problemaSaude.setIdProblema(resultSet.getInt("id_problema"));
                problemaSaude.setNomeProblema(resultSet.getString("nome_problema"));
                problemaSaude.setDescricao(resultSet.getString("descricao"));

                listaProblemasSaude.add(problemaSaude);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return listaProblemasSaude;
    }
}