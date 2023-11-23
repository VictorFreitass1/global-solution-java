package pamv.com.service;

import pamv.com.dominio.Exercicios;
import pamv.com.banco.ExerciciosDAO;
import java.util.List;

public class ExerciciosService {
    private ExerciciosDAO exerciciosDAO;

    public ExerciciosService() {
        this.exerciciosDAO = new ExerciciosDAO();
    }

    public void cadastrarExercicio(Exercicios exercicio) {
        try {
            exerciciosDAO.cadastrarExercicios(exercicio);
        } catch (Exception e) {
            throw new RuntimeException("Erro ao cadastrar exercício: " + e.getMessage(), e);
        }
    }

    public void atualizarExercicio(Exercicios exercicio) {
        try {
            exerciciosDAO.atualizarExercicio(exercicio);
        } catch (Exception e) {
            throw new RuntimeException("Erro ao atualizar exercício: " + e.getMessage(), e);
        }
    }

    public void deletarExercicio(int idExercicio) {
        try {
            exerciciosDAO.deletarExercicio(idExercicio);
        } catch (Exception e) {
            throw new RuntimeException("Erro ao deletar exercício: " + e.getMessage(), e);
        }
    }

    public List<Exercicios> listarExercicios() {
        try {
            return exerciciosDAO.listarExercicios();
        } catch (Exception e) {
            throw new RuntimeException("Erro ao listar exercícios: " + e.getMessage(), e);
        }
    }
}