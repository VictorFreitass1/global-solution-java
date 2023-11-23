package pamv.com.banco;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import pamv.com.dominio.FilhosPaciente;

public class FilhosPacienteDAO {
    private Connection connection;
    
    public FilhosPacienteDAO() {
    	this.connection = new ConnectionFactory().getConnection();
    }

    public FilhosPacienteDAO(Connection connection) {
        this.connection = connection;
    }

    public void cadastrar(FilhosPaciente filho) throws SQLException {
        String sql = "INSERT INTO tb_filhos_paciente (id_crianca, id_paciente) VALUES (?, ?)";

        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, filho.getIdCrianca());
            statement.setInt(2, filho.getIdPaciente());

            statement.executeUpdate();
        }
        System.out.println("Filho cadastrado com sucesso!");
    }

    public void atualizar(FilhosPaciente filho) throws SQLException {
        String sql = "UPDATE tb_filhos_paciente SET id_crianca = ? WHERE id_paciente = ?";

        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, filho.getIdCrianca());
            statement.setInt(2, filho.getIdPaciente());

            statement.executeUpdate();
        }
        System.out.println("Filho atualizado com sucesso!");
    }

    public void deletar(int idPaciente) throws SQLException {
        String sql = "DELETE FROM tb_filhos_paciente WHERE id_paciente = ?";

        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, idPaciente);

            statement.executeUpdate();
        }
        System.out.println("Filho deletado com sucesso!");
    }

    public List<FilhosPaciente> listar() throws SQLException {
        List<FilhosPaciente> listaFilhos = new ArrayList<>();
        String sql = "SELECT id_crianca, id_paciente FROM tb_filhos_paciente";

        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    int idCrianca = resultSet.getInt("id_crianca");
                    int idPaciente = resultSet.getInt("id_paciente");

                    FilhosPaciente filho = new FilhosPaciente(idCrianca, idPaciente);
                    listaFilhos.add(filho);
                }
            }
        }
        return listaFilhos;
    }
}