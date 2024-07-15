package set.Pesquisa;

import java.util.HashSet;
import java.util.Set;

public class ListaTarefas {
    //atributos

    private Set<Tarefa> tarefaSet;

    public ListaTarefas() {
        this.tarefaSet = new HashSet<>();
    }

    public void adicionarTarefa(String descricao){
        tarefaSet.add(new Tarefa(descricao, false));
    }

    public void removerTarefa(String descricao){
        Tarefa tarefaParaRemover = null;
        for(Tarefa t : tarefaSet){
            if (t.getDescricao().equalsIgnoreCase(descricao)) {
                tarefaParaRemover = t;
                break;
            }
        }
        tarefaSet.remove(tarefaParaRemover);
    }

    public void exibirTarefas(){
        System.out.println(tarefaSet);
    }

    public int contarTarefas(){
        return tarefaSet.size(); 
    }

    public Set<Tarefa> obterTarefasConcluidas(){
        Set<Tarefa> tarefasConcluidas = new HashSet<>();
        for(Tarefa t : tarefaSet){
            if (t.isFeito()) {
                tarefasConcluidas.add(t);
            }
        }
        return tarefasConcluidas;
    }

    public Set<Tarefa> obterTarefasPendentes(){
        Set<Tarefa> tarefasPendentes = new HashSet<>();
        for(Tarefa t : tarefaSet){
            if (!t.isFeito()) {
                tarefasPendentes.add(t);
            }
        }
        return tarefasPendentes;
    }

    public Tarefa marcarTarefaConcluida(String descricao){
        Tarefa tarefaConcluida = null;
        for(Tarefa t : tarefaSet){
            if(t.getDescricao().equalsIgnoreCase(descricao)){
                t.setFeito(true);
                tarefaConcluida = t;
                break;
            }
        }
        return tarefaConcluida;
    }

    public Tarefa marcarTarefaPendente(String descricao){
        Tarefa tarefaPendente = null;
        for(Tarefa t : tarefaSet){
            if (t.getDescricao().equalsIgnoreCase(descricao)) {
                t.setFeito(false);
                tarefaPendente = t;
                break;
            }
        }
        return tarefaPendente;
    }

    public void limparListaTarefas(){
        tarefaSet.removeAll(tarefaSet);
    }

    public static void main(String[] args) {
        ListaTarefas listaTarefas = new ListaTarefas();

        listaTarefas.adicionarTarefa("Varrer");
        listaTarefas.adicionarTarefa("Limpar");
        listaTarefas.adicionarTarefa("Lavar");

        listaTarefas.exibirTarefas();
        System.out.println("A Lista tem " + listaTarefas.contarTarefas() + " tarefas.");

        //listaTarefas.removerTarefa("Limpar");

        //listaTarefas.exibirTarefas();

        //System.out.println("A Lista tem " + listaTarefas.contarTarefas() + " tarefas.");
        
        System.out.println(listaTarefas.marcarTarefaConcluida("Limpar"));
        System.out.println(listaTarefas.marcarTarefaConcluida("Varrer"));
        listaTarefas.exibirTarefas();

        System.out.println(listaTarefas.obterTarefasConcluidas());
        System.out.println(listaTarefas.obterTarefasPendentes());

        System.out.println(listaTarefas.marcarTarefaPendente("Limpar"));
        listaTarefas.exibirTarefas();

        listaTarefas.limparListaTarefas();
        listaTarefas.exibirTarefas();

    
    }


}
