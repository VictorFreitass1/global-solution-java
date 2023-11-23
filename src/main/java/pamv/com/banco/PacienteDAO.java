package pamv.com.banco;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import pamv.com.dominio.Paciente;

public class PacienteDAO {
    private Connection connection;

    public PacienteDAO() {
        this.connection = new ConnectionFactory().getConnection();
    }

    public void cadastrarPaciente(Paciente paciente) {
        String sql = "INSERT INTO tb_paciente (nome_paciente, data_nascimento, email, senha, cpf) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            stmt.setString(1, paciente.getNomePaciente());
            stmt.setDate(2, new java.sql.Date(paciente.getDataNascimento().getTime()));
            stmt.setString(3, paciente.getEmail());
            stmt.setString(4, paciente.getSenha());
            stmt.setString(5, paciente.getCpf());

            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao cadastrar paciente: " + e.getMessage(), e);
        }
    }

    public Paciente realizarLogin(String email, String senha) {
        String sql = "SELECT * FROM tb_paciente WHERE email = ? AND senha = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, email);
            preparedStatement.setString(2, senha);

            ResultSet rs = preparedStatement.executeQuery();
            if (rs.next()) {
                return new Paciente(
                        rs.getString("nome_paciente"),
                        rs.getDate("data_nascimento"),
                        rs.getString("email"),
                        rs.getString("senha"),
                        rs.getString("cpf")
                );
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    
    public void atualizarPaciente(Paciente paciente) {
        String sql = "UPDATE tb_paciente SET nome_paciente=?, data_nascimento=?, email=?, senha=?, cpf=? WHERE id_paciente=?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, paciente.getNomePaciente());
            stmt.setDate(2, new java.sql.Date(paciente.getDataNascimento().getTime()));
            stmt.setString(3, paciente.getEmail());
            stmt.setString(4, paciente.getSenha());
            stmt.setString(5, paciente.getCpf());
            stmt.setInt(6, paciente.getIdPaciente());

            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao atualizar paciente: " + e.getMessage(), e);
        }
    }

    
    public void deletarPaciente(int idPaciente) {
        String sql = "DELETE FROM tb_paciente WHERE id_paciente=?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, idPaciente);
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    
    public List<Paciente> listarTodosPacientes() {
        List<Paciente> listaPacientes = new ArrayList<>();
        String sql = "SELECT * FROM tb_paciente";
        try (PreparedStatement stmt = connection.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                Paciente paciente = new Paciente(
                        rs.getString("nome_paciente"),
                        rs.getDate("data_nascimento"),
                        rs.getString("email"),
                        rs.getString("senha"),
                        rs.getString("cpf")
                );
                paciente.setIdPaciente(rs.getInt("id_paciente"));
                listaPacientes.add(paciente);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return listaPacientes;
    }

}
