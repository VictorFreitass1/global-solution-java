package pamv.com.banco;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import pamv.com.dominio.Exercicios;

public class ExerciciosDAO {
    private Connection connection;
    
    public ExerciciosDAO() {
    	this.connection = new ConnectionFactory().getConnection();
    }
        
        public void cadastrarExercicios(Exercicios exercicio) {
            String sql = "INSERT INTO tb_exercicios (id_paciente, data_exercicio, tipo_exercicio, duracao_em_minutos) VALUES (?, ?, ?, ?)";
            
            try (PreparedStatement preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
                preparedStatement.setInt(1, exercicio.getIdPaciente());
                preparedStatement.setDate(2, new java.sql.Date(exercicio.getDataExercicio().getTime()));
                preparedStatement.setString(3, exercicio.getTipoExercicio());
                preparedStatement.setInt(4, exercicio.getDuracaoEmMinutos());

                preparedStatement.executeUpdate();

            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
    }
        
        public void atualizarExercicio(Exercicios exercicio) {
            String sql = "UPDATE tb_exercicios SET id_paciente = ?, data_exercicio = ?, tipo_exercicio = ?, duracao_em_minutos = ? WHERE id_exercicio = ?";
            
            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

                preparedStatement.setInt(1, exercicio.getIdPaciente());
                preparedStatement.setDate(2, new java.sql.Date(exercicio.getDataExercicio().getTime()));
                preparedStatement.setString(3, exercicio.getTipoExercicio());
                preparedStatement.setInt(4, exercicio.getDuracaoEmMinutos());
                preparedStatement.setInt(5, exercicio.getIdExercicio());

                preparedStatement.executeUpdate();

                System.out.println("Exercício atualizado com sucesso!");

            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        
        public void deletarExercicio(int idExercicio) {
            String sql = "DELETE FROM tb_exercicios WHERE id_exercicio = ?";
            
            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

                preparedStatement.setInt(1, idExercicio);

                preparedStatement.executeUpdate();

                System.out.println("Exercício deletado com sucesso!");

            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        
        public List<Exercicios> listarExercicios() {
            List<Exercicios> exercicios = new ArrayList<>();

            String sql = "SELECT * FROM tb_exercicios";

            try (PreparedStatement preparedStatement = connection.prepareStatement(sql);
                 ResultSet resultSet = preparedStatement.executeQuery()) {

                while (resultSet.next()) {
                    int idExercicio = resultSet.getInt("id_exercicio");
                    int idPaciente = resultSet.getInt("id_paciente");
                    Date dataExercicio = resultSet.getDate("data_exercicio");
                    String tipoExercicio = resultSet.getString("tipo_exercicio");
                    int duracaoEmMinutos = resultSet.getInt("duracao_em_minutos");

                    Exercicios exercicio = new Exercicios(idExercicio, idPaciente, dataExercicio, tipoExercicio, duracaoEmMinutos);
                    exercicios.add(exercicio);
                }

            } catch (SQLException e) {
                throw new RuntimeException(e);
            }

            return exercicios;
        }
}
