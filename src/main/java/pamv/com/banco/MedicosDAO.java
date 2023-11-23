package pamv.com.banco;

import pamv.com.dominio.Medicos;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class MedicosDAO {
    private Connection connection;

    public MedicosDAO() {
        this.connection = new ConnectionFactory().getConnection();
    }
    
    public void cadastrarMedico(Medicos medico) {
        String sql = "INSERT INTO tb_medicos (nome_medico, especialidade, email, senha) VALUES (?, ?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            stmt.setString(1, medico.getNomeMedico());
            stmt.setString(2, medico.getEspecialidade());
            stmt.setString(3, medico.getEmail());
            stmt.setString(4, medico.getSenha());

            stmt.executeUpdate();
            
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    
    public Medicos realizarLogin(String email, String senha) {
        String sql = "SELECT * FROM tb_medicos WHERE email = ? AND senha = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
        	preparedStatement.setString(1, email);
        	preparedStatement.setString(2, senha);

            ResultSet rs = preparedStatement.executeQuery();
            if (rs.next()) {
                return new Medicos(
                        rs.getInt("id_medico"),
                        rs.getString("nome_medico"),
                        rs.getString("especialidade"),
                        rs.getString("email"),
                        rs.getString("senha")
                );
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }  
        return null;
    }
    
    public void atualizarMedico(Medicos medico) {
        String sql = "UPDATE tb_medicos SET nome_medico=?, especialidade=?, email=?, senha=? WHERE id_medico=?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, medico.getNomeMedico());
            stmt.setString(2, medico.getEspecialidade());
            stmt.setString(3, medico.getEmail());
            stmt.setString(4, medico.getSenha());
            stmt.setInt(5, medico.getIdMedico());

            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    
    public void deletarMedico(int idMedico) {
        String sql = "DELETE FROM tb_medicos WHERE id_medico=?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, idMedico);
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    
    public List<Medicos> listarTodosMedicos() {
        List<Medicos> listaMedicos = new ArrayList<>();
        String sql = "SELECT * FROM tb_medicos";
        try (PreparedStatement stmt = connection.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                Medicos medico = new Medicos();
                medico.setIdMedico(rs.getInt("id_medico"));
                medico.setNomeMedico(rs.getString("nome_medico"));
                medico.setEspecialidade(rs.getString("especialidade"));
                medico.setEmail(rs.getString("email"));
                medico.setSenha(rs.getString("senha"));
                listaMedicos.add(medico);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return listaMedicos;
    }
}
