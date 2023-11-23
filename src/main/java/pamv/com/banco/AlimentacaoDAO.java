package pamv.com.banco;

import pamv.com.dominio.Alimentacao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class AlimentacaoDAO {

    public void cadastrarAlimentos(Alimentacao alimentacao) {
        Connection conexao = new ConnectionFactory().getConnection();

        String sql = "INSERT INTO tb_alimentacao (id_paciente, data_refeicao, descricao_refeicao, calorias) VALUES (?, ?, ?, ?)";

        try (PreparedStatement pstmt = conexao.prepareStatement(sql)) {
            pstmt.setInt(1, alimentacao.getIdPaciente());
            pstmt.setDate(2, new java.sql.Date(alimentacao.getDataRefeicao().getTime()));
            pstmt.setString(3, alimentacao.getDescricaoRefeicao());
            pstmt.setInt(4, alimentacao.getCalorias());

            pstmt.executeUpdate();
            System.out.println("Alimento cadastrado com sucesso!");
        } catch (SQLException e) {
            System.err.println("Erro ao cadastrar alimento: " + e.getMessage());
        } finally {
            try {
                conexao.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public void atualizarAlimento(Alimentacao alimentacao) {
        Connection conexao = new ConnectionFactory().getConnection();

        String sql = "UPDATE tb_alimentacao SET id_paciente=?, data_refeicao=?, descricao_refeicao=?, calorias=? WHERE id_alimentacao=?";

        try (PreparedStatement pstmt = conexao.prepareStatement(sql)) {
            pstmt.setInt(1, alimentacao.getIdPaciente());

            if (alimentacao.getDataRefeicao() != null) {
                pstmt.setDate(2, new java.sql.Date(alimentacao.getDataRefeicao().getTime()));
            } else {
                pstmt.setNull(2, java.sql.Types.DATE);
            }

            pstmt.setString(3, alimentacao.getDescricaoRefeicao());
            pstmt.setInt(4, alimentacao.getCalorias());
            pstmt.setInt(5, alimentacao.getIdAlimentacao());

            pstmt.executeUpdate();
            System.out.println("Alimento atualizado com sucesso!");
        } catch (SQLException e) {
            System.err.println("Erro ao atualizar alimento: " + e.getMessage());
        } finally {
            try {
                conexao.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }


    public void deletarAlimento(int idAlimentacao) {
        Connection conexao = new ConnectionFactory().getConnection();

        String sql = "DELETE FROM tb_alimentacao WHERE id_alimentacao=?";

        try (PreparedStatement pstmt = conexao.prepareStatement(sql)) {
            pstmt.setInt(1, idAlimentacao);

            pstmt.executeUpdate();
            System.out.println("Alimento deletado com sucesso!");
        } catch (SQLException e) {
            System.err.println("Erro ao deletar alimento: " + e.getMessage());
        } finally {
            try {
                conexao.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public List<Alimentacao> listarTodosAlimentos() {
        List<Alimentacao> listaAlimentos = new ArrayList<>();
        Connection conexao = new ConnectionFactory().getConnection();

        String sql = "SELECT * FROM tb_alimentacao";

        try (PreparedStatement pstmt = conexao.prepareStatement(sql); ResultSet rs = pstmt.executeQuery()) {
            while (rs.next()) {
                Alimentacao alimentacao = new Alimentacao();
                alimentacao.setIdAlimentacao(rs.getInt("id_alimentacao"));
                alimentacao.setIdPaciente(rs.getInt("id_paciente"));
                alimentacao.setDataRefeicao(rs.getDate("data_refeicao"));
                alimentacao.setDescricaoRefeicao(rs.getString("descricao_refeicao"));
                alimentacao.setCalorias(rs.getInt("calorias"));

                listaAlimentos.add(alimentacao);
            }
        } catch (SQLException e) {
            System.err.println("Erro ao listar alimentos: " + e.getMessage());
        } finally {
            try {
                conexao.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return listaAlimentos;
    }
}