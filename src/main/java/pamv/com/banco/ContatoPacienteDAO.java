package pamv.com.banco;

import pamv.com.dominio.ContatoPaciente;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ContatoPacienteDAO {

    public void cadastrarContatoPaciente(ContatoPaciente contatoPaciente) {
        Connection conexao = new ConnectionFactory().getConnection();

        String sql = "INSERT INTO tb_contato_paciente (id_paciente, telefone_paciente) VALUES (?, ?)";

        try (PreparedStatement pstmt = conexao.prepareStatement(sql)) {
        	pstmt.setInt(1, contatoPaciente.getIdPaciente());
            pstmt.setString(2, contatoPaciente.getTelefonePaciente());

            pstmt.executeUpdate();
            System.out.println("Contato do paciente cadastrado com sucesso!");
        } catch (SQLException e) {
            System.err.println("Erro ao cadastrar contato do paciente: " + e.getMessage());
        } finally {
            try {
                conexao.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public void atualizarContatoPaciente(ContatoPaciente contatoPaciente) {
        Connection conexao = new ConnectionFactory().getConnection();

        String sql = "UPDATE tb_contato_paciente SET telefone_paciente=? WHERE id_paciente=?";

        try (PreparedStatement pstmt = conexao.prepareStatement(sql)) {
            pstmt.setString(1, contatoPaciente.getTelefonePaciente());
            pstmt.setInt(2, contatoPaciente.getIdPaciente());

            pstmt.executeUpdate();
            System.out.println("Contato do paciente atualizado com sucesso!");
        } catch (SQLException e) {
            System.err.println("Erro ao atualizar contato do paciente: " + e.getMessage());
        } finally {
            try {
                conexao.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public void deletarContatoPaciente(int idPaciente) {
        Connection conexao = new ConnectionFactory().getConnection();

        String sql = "DELETE FROM tb_contato_paciente WHERE id_paciente=?";

        try (PreparedStatement pstmt = conexao.prepareStatement(sql)) {
            pstmt.setInt(1, idPaciente);

            pstmt.executeUpdate();
            System.out.println("Contato do paciente deletado com sucesso!");
        } catch (SQLException e) {
            System.err.println("Erro ao deletar contato do paciente: " + e.getMessage());
        } finally {
            try {
                conexao.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public List<ContatoPaciente> listarTodosContatosPacientes() {
        List<ContatoPaciente> listaContatosPacientes = new ArrayList<>();
        Connection conexao = new ConnectionFactory().getConnection();

        String sql = "SELECT * FROM tb_contato_paciente";

        try (PreparedStatement pstmt = conexao.prepareStatement(sql); ResultSet rs = pstmt.executeQuery()) {
            while (rs.next()) {
                ContatoPaciente contatoPaciente = new ContatoPaciente();
                contatoPaciente.setIdPaciente(rs.getInt("id_paciente"));
                contatoPaciente.setTelefonePaciente(rs.getString("telefone_paciente"));

                listaContatosPacientes.add(contatoPaciente);
            }
        } catch (SQLException e) {
            System.err.println("Erro ao listar contatos dos pacientes: " + e.getMessage());
        } finally {
            try {
                conexao.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return listaContatosPacientes;
    }
}
