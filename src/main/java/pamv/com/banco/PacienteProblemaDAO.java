package pamv.com.banco;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import pamv.com.dominio.PacienteProblema;

public class PacienteProblemaDAO {

    private Connection connection;

    public PacienteProblemaDAO() {
        this.connection = new ConnectionFactory().getConnection();
    }

    public void cadastrarPacienteProblema(PacienteProblema pacienteProblema) throws SQLException {
        String sql = "INSERT INTO tb_paciente_problema (id_paciente, id_problema) VALUES (?, ?)";

        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, pacienteProblema.getIdPaciente());
            statement.setInt(2, pacienteProblema.getIdProblema());

            statement.executeUpdate();
        }
    }

    public void atualizarPacienteProblema(PacienteProblema pacienteProblema) throws SQLException {
        String sql = "UPDATE tb_paciente_problema SET id_paciente = ?, id_problema = ? WHERE id_paciente = ? AND id_problema = ?";

        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, pacienteProblema.getIdPaciente());
            statement.setInt(2, pacienteProblema.getIdProblema());

            statement.executeUpdate();
        }
    }

    public void deletarPacienteProblema(int idPaciente, int idProblema) throws SQLException {
        String sql = "DELETE FROM tb_paciente_problema WHERE id_paciente = ? AND id_problema = ?";

        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, idPaciente);
            statement.setInt(2, idProblema);

            statement.executeUpdate();
        }
    }

    public List<PacienteProblema> listarPacienteProblema() {
        List<PacienteProblema> listaPacienteProblema = new ArrayList<>();
        String sql = "SELECT id_paciente, id_problema FROM tb_paciente_problema";

        try (PreparedStatement statement = connection.prepareStatement(sql);
             ResultSet resultSet = statement.executeQuery()) {

            while (resultSet.next()) {
                int idPaciente = resultSet.getInt("id_paciente");
                int idProblema = resultSet.getInt("id_problema");

                PacienteProblema pacienteProblema = new PacienteProblema(idPaciente, idProblema);
                listaPacienteProblema.add(pacienteProblema);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return listaPacienteProblema;
    }
}
