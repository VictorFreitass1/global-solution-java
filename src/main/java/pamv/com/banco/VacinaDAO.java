package pamv.com.banco;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import pamv.com.dominio.Vacinas;

public class VacinaDAO {
    private Connection connection;
    
    public VacinaDAO() {
        this.connection = new ConnectionFactory().getConnection();
    }
    
    public void cadastrarVacina(Vacinas vacina) {
        String sql = "INSERT INTO tb_vacinas (nome_vacina, descricao, idade_recomendada) VALUES (?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            stmt.setString(1, vacina.getNomeVacina());
            stmt.setString(2, vacina.getDescricao());
            stmt.setInt(3, vacina.getIdadeRecomendada());

            stmt.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    
    public void atualizarVacina(Vacinas vacina) {
        String sql = "UPDATE tb_vacinas SET nome_vacina = ?, descricao = ?, idade_recomendada = ? WHERE id_vacina = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, vacina.getNomeVacina());
            stmt.setString(2, vacina.getDescricao());
            stmt.setInt(3, vacina.getIdadeRecomendada());
            stmt.setInt(4, vacina.getIdVacina()); // Supondo que o ID da vacina já esteja definido no objeto

            int linhasAfetadas = stmt.executeUpdate();

            if (linhasAfetadas == 0) {
                throw new SQLException("Falha ao atualizar a vacina, nenhum registro foi modificado.");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    
    public void deletarVacina(int idVacina) {
        String sql = "DELETE FROM tb_vacinas WHERE id_vacina = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, idVacina);

            int linhasAfetadas = stmt.executeUpdate();

            if (linhasAfetadas == 0) {
                throw new SQLException("Falha ao excluir a vacina, nenhum registro foi modificado.");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    
    public List<Vacinas> listarVacinas() {
        List<Vacinas> listaVacinas = new ArrayList<>();
        String sql = "SELECT id_vacina, nome_vacina, descricao, idade_recomendada FROM tb_vacinas";

        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            ResultSet resultSet = stmt.executeQuery();

            while (resultSet.next()) {
                Vacinas vacina = new Vacinas();
                vacina.setIdVacina(resultSet.getInt("id_vacina"));
                vacina.setNomeVacina(resultSet.getString("nome_vacina"));
                vacina.setDescricao(resultSet.getString("descricao"));
                vacina.setIdadeRecomendada(resultSet.getInt("idade_recomendada"));

                listaVacinas.add(vacina);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return listaVacinas;
    }


}