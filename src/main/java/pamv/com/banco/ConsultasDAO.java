package pamv.com.banco;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import pamv.com.dominio.Consultas;

public class ConsultasDAO {
	private Connection connection;
    
    public ConsultasDAO() {
        this.connection = new ConnectionFactory().getConnection();
    }	
    
	public void cadastrarConsulta(Consultas consulta) throws SQLException {
        String sql = "INSERT INTO tb_consultas (id_paciente, id_medico, data_consulta, tipo_consulta, observacoes) VALUES  (?, ?, ?, ?, ?)";

        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, consulta.getIdPaciente());
            statement.setInt(2, consulta.getIdMedico());
            statement.setDate(3, new java.sql.Date(consulta.getDataConsulta().getTime()));
            statement.setString(4, consulta.getTipoConsulta());
            statement.setString(5, consulta.getObservacoes());

            statement.executeUpdate();
        }
	}
	
	public void atualizarConsulta(Consultas consulta) {
	    String sql = "UPDATE tb_consultas SET id_paciente=?, id_medico=?, data_consulta=?, tipo_consulta=?, observacoes=? WHERE id_consulta=?";

	    try (Connection conexao = new ConnectionFactory().getConnection();
	         PreparedStatement pstmt = conexao.prepareStatement(sql)) {

	        pstmt.setInt(1, consulta.getIdPaciente());
	        pstmt.setInt(2, consulta.getIdMedico());
	        
	        if (consulta.getDataConsulta() != null) {
	            pstmt.setDate(3, new java.sql.Date(consulta.getDataConsulta().getTime()));
	        } else {
	            pstmt.setNull(3, java.sql.Types.DATE);
	        }

	        pstmt.setString(4, consulta.getTipoConsulta());
	        pstmt.setString(5, consulta.getObservacoes());
	        pstmt.setInt(6, consulta.getIdConsulta());

	        pstmt.executeUpdate();
	        System.out.println("Consulta atualizada com sucesso!");

	    } catch (SQLException e) {
	        System.err.println("Erro ao atualizar consulta: " + e.getMessage());
	    }
	}

	public void deletarConsulta(int idConsulta) throws SQLException {
        String sql = "DELETE FROM tb_consultas WHERE id_consulta = ?";

        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, idConsulta);

            statement.executeUpdate();
        }
    }
	public List<Consultas> listarConsultas() {
        List<Consultas> consultas = new ArrayList<>();
        String sql = "SELECT id_consulta, id_paciente, id_medico, data_consulta, tipo_consulta, observacoes FROM tb_consultas";

        try (PreparedStatement statement = connection.prepareStatement(sql);
             ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                int idConsulta = resultSet.getInt("id_consulta");
                int idPaciente = resultSet.getInt("id_paciente");
                int idMedico = resultSet.getInt("id_medico");
                Date dataConsulta = resultSet.getDate("data_consulta");
                String tipoConsulta = resultSet.getString("tipo_consulta");
                String observacoes = resultSet.getString("observacoes");

                Consultas consulta = new Consultas(idConsulta, idPaciente, idMedico, dataConsulta, tipoConsulta, observacoes);
                consultas.add(consulta);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return consultas;
    }
}
