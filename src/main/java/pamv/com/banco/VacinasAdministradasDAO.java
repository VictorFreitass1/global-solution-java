package pamv.com.banco;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import pamv.com.dominio.VacinasAdministradas;

public class VacinasAdministradasDAO {
    private Connection connection;
    
    public VacinasAdministradasDAO() {
        this.connection = new ConnectionFactory().getConnection();
    }
    
    public void cadastrarVacina(VacinasAdministradas vacina) {
        String sql = "INSERT INTO tb_vacinas_administradas (id_vacina, id_crianca, id_paciente, data_administracao) VALUES (?, ?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            stmt.setInt(1, vacina.getIdVacina());
            stmt.setInt(2, vacina.getIdCrianca());
            stmt.setInt(3, vacina.getIdPaciente());
            stmt.setDate(4, new java.sql.Date(vacina.getDataAdministracao().getTime()));

            stmt.executeUpdate();
            
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    
    public void atualizarVacina(VacinasAdministradas vacina) {
        String sql = "UPDATE tb_vacinas_administradas SET id_crianca = ?, id_paciente = ?, data_administracao = ? WHERE id_vacina = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, vacina.getIdCrianca());
            stmt.setInt(2, vacina.getIdPaciente());
            stmt.setDate(3, new java.sql.Date(vacina.getDataAdministracao().getTime()));
            stmt.setInt(4, vacina.getIdVacina());

            int linhasAfetadas = stmt.executeUpdate();
            if (linhasAfetadas == 0) {
                throw new SQLException("Vacina n�o encontrada, n�o foi poss�vel atualizar.");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void deletarVacina(int idVacina) {
        String sql = "DELETE FROM tb_vacinas_administradas WHERE id_vacina = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, idVacina);

            int linhasAfetadas = stmt.executeUpdate();
            if (linhasAfetadas == 0) {
                throw new SQLException("Vacina n�o encontrada, n�o foi poss�vel deletar.");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    
    public List<VacinasAdministradas> listarVacinas() {
        List<VacinasAdministradas> vacinas = new ArrayList<>();
        String sql = "SELECT * FROM tb_vacinas_administradas";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                VacinasAdministradas vacina = new VacinasAdministradas();
                vacina.setIdVacina(rs.getInt("id_vacina"));
                vacina.setIdCrianca(rs.getInt("id_crianca"));
                vacina.setIdPaciente(rs.getInt("id_paciente"));
                vacina.setDataAdministracao(rs.getDate("data_administracao"));

                vacinas.add(vacina);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return vacinas;
    }    
}