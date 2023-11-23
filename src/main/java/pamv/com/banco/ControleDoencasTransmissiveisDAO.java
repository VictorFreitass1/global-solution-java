package pamv.com.banco;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import pamv.com.dominio.ControleDoencasTransmissiveis;

public class ControleDoencasTransmissiveisDAO {
    private Connection connection;

    public ControleDoencasTransmissiveisDAO() {
        this.connection = new ConnectionFactory().getConnection();
    }

    public void cadastrarControleDoencasTransmissiveis(ControleDoencasTransmissiveis controle) throws SQLException {
        String sql = "INSERT INTO tb_controle_doencas_transmissiveis (id_paciente, id_problema, tratamento_recomendado, observacoes) VALUES (?, ?, ?, ?)";

        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, controle.getIdPaciente());
            statement.setInt(2, controle.getIdProblema());
            statement.setString(3, controle.getTratamentoRecomendado());
            statement.setString(4, controle.getObservacoes());

            statement.executeUpdate();
        }
    }

    public void atualizarControleDoencasTransmissiveis(ControleDoencasTransmissiveis controle) throws SQLException {
        String sql = "UPDATE tb_controle_doencas_transmissiveis SET id_paciente = ?, id_problema = ?, tratamento_recomendado = ?, observacoes = ? WHERE id_controle = ?";

        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, controle.getIdPaciente());
            statement.setInt(2, controle.getIdProblema());
            statement.setString(3, controle.getTratamentoRecomendado());
            statement.setString(4, controle.getObservacoes());
            statement.setInt(5, controle.getIdControle());

            statement.executeUpdate();
        }
    }

    public void deletarControleDoencasTransmissiveis(int idControle) throws SQLException {
        String sql = "DELETE FROM tb_controle_doencas_transmissiveis WHERE id_controle = ?";

        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, idControle);

            statement.executeUpdate();
        }
    }

    public List<ControleDoencasTransmissiveis> listarControleDoencasTransmissiveis() {
        List<ControleDoencasTransmissiveis> controles = new ArrayList<>();
        String sql = "SELECT id_controle, id_paciente, id_problema, tratamento_recomendado, observacoes FROM tb_controle_doencas_transmissiveis";

        try (PreparedStatement statement = connection.prepareStatement(sql);
             ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                int idControle = resultSet.getInt("id_controle");
                int idPaciente = resultSet.getInt("id_paciente");
                int idProblema = resultSet.getInt("id_problema");
                String tratamentoRecomendado = resultSet.getString("tratamento_recomendado");
                String observacoes = resultSet.getString("observacoes");

                ControleDoencasTransmissiveis controle = new ControleDoencasTransmissiveis(idControle, idPaciente, idProblema, tratamentoRecomendado, observacoes);
                controles.add(controle);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return controles;
    }
}
