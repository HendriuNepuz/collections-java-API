package set.Ordenacao;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class GerenciadorAlunos {
    Set<Aluno> alunoSet;

    public GerenciadorAlunos() {
        this.alunoSet = new HashSet<>();
    }

    public void adicionarAluno(String nome, Long matricula, double media){
        alunoSet.add(new Aluno(nome, matricula, media));
    }

    public void removerAluno(long matricula){
         Aluno alunoParaRemover = null;
         for(Aluno a : alunoSet){
            if (a.getMatricula() == matricula) {
                alunoParaRemover = a;
                break;
            }
         }
         if (alunoParaRemover == null) {
            System.out.println("Aluno não existe");
         }
         else {
            alunoSet.remove(alunoParaRemover);
         }
    }

    public Set<Aluno> exibirAlunosPorNome(){
        Set<Aluno> alunosPorNome = new TreeSet<>(alunoSet);
        return alunosPorNome;
    }

    public Set<Aluno> exibirAlunosPorNota(){
        Set<Aluno> alunosPorNota = new TreeSet<>(new ComparatorPorNota());
        alunosPorNota.addAll(alunoSet);
        return alunosPorNota;
    }
    
    public void exibirAlunos(){
        System.out.println(alunoSet);
    }
    
    public static void main(String[] args) {
        GerenciadorAlunos gerenciadorAlunos = new GerenciadorAlunos();
        
        gerenciadorAlunos.adicionarAluno("João", 001L, 7.0);
        gerenciadorAlunos.adicionarAluno("Pedro", 002L, 8.0);
        gerenciadorAlunos.adicionarAluno("André", 003L, 5.0);
        gerenciadorAlunos.adicionarAluno("Wesley", 004L, 6.0);

        gerenciadorAlunos.exibirAlunos();
        System.out.println(gerenciadorAlunos.exibirAlunosPorNome());
        System.out.println(gerenciadorAlunos.exibirAlunosPorNota());

        gerenciadorAlunos.removerAluno(003L);

        gerenciadorAlunos.exibirAlunos();

    }

}
