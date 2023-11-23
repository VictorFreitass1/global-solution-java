package pamv.com.banco;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import pamv.com.dominio.Crianca;

public class CriancaDAO {
    private Connection connection;
    
    public CriancaDAO() {
        this.connection = new ConnectionFactory().getConnection();
    }
    
    public void cadastrarCrianca(Crianca crianca) {
        String sql = "INSERT INTO tb_crianca (nome_crianca, idade) VALUES (?, ?)";
        
        try (PreparedStatement stmt = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            stmt.setString(1, crianca.getNomeCrianca());
            stmt.setInt(2, crianca.getIdade());
       
            stmt.executeUpdate();
            System.out.println("Criança cadastrada com sucesso!");
        } catch (SQLException e) {
        	System.err.println("Erro ao cadastrar criança: " + e.getMessage());
        } finally {
            try {
            	connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    
    public void atualizarCrianca(Crianca crianca) {
        String sql = "UPDATE tb_crianca SET nome_crianca = ?, idade = ? WHERE id_crianca = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, crianca.getNomeCrianca());
            stmt.setInt(2, crianca.getIdade());
            stmt.setInt(3, crianca.getIdCrianca());

            int linhasAfetadas = stmt.executeUpdate();

            if (linhasAfetadas == 0) {
                throw new SQLException("Falha ao atualizar a criança, nenhum registro foi modificado.");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void deletarCrianca(int idCrianca) {
        String sql = "DELETE FROM tb_crianca WHERE id_crianca = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, idCrianca);

            int linhasAfetadas = stmt.executeUpdate();

            if (linhasAfetadas == 0) {
                throw new SQLException("Falha ao excluir a criança, nenhum registro foi modificado.");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Crianca> listarCriancas() {
        List<Crianca> listaCriancas = new ArrayList<>();
        String sql = "SELECT id_crianca, nome_crianca, idade FROM tb_crianca";

        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            ResultSet resultSet = stmt.executeQuery();

            while (resultSet.next()) {
                Crianca crianca = new Crianca();
                crianca.setIdCrianca(resultSet.getInt("id_crianca"));
                crianca.setNomeCrianca(resultSet.getString("nome_crianca"));
                crianca.setIdade(resultSet.getInt("idade"));

                listaCriancas.add(crianca);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return listaCriancas;
    }
    
}