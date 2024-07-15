package set.OperacoesBasicas;

import java.util.HashSet;
import java.util.Set;

public class ConjuntoPalavrasUnicas {
    //atributos
    public Set<Palavra> palavraSet;

    public ConjuntoPalavrasUnicas() {
        this.palavraSet = new HashSet<>();
    }

    public void adicionarPalavra(String palavra){
        palavraSet.add(new Palavra(palavra));
    }

    public void removerPalavra(String palavra){
        Palavra palavraParaRemover = null;
        for(Palavra p : palavraSet){
            if (p.getPalavra().equalsIgnoreCase(palavra)) {
                palavraParaRemover = p;
                break;
            }
        }
        palavraSet.remove(palavraParaRemover);
    }

    public void verificarPalavra(String palavra){
        boolean c = false;
        for(Palavra p : palavraSet){
            if (p.getPalavra().equalsIgnoreCase(palavra)) {
                System.out.println("Palavra " + p.getPalavra() + " está no conjunto.");
                c = true;
                break;
            }
        }
        if (!c) {
            System.out.println("Palavra não econtrada!");
        }
    }

    public void exibirPalavrasUnicas(){
        System.out.println(palavraSet);
    }

    public static void main(String[] args) {
        ConjuntoPalavrasUnicas conjuntoPalavrasUnicas = new ConjuntoPalavrasUnicas();

        conjuntoPalavrasUnicas.adicionarPalavra("casa");
        conjuntoPalavrasUnicas.adicionarPalavra("carro");
        conjuntoPalavrasUnicas.adicionarPalavra("bicicleta");
        conjuntoPalavrasUnicas.adicionarPalavra("avião");
        conjuntoPalavrasUnicas.adicionarPalavra("casa");
        conjuntoPalavrasUnicas.adicionarPalavra("zebra");

        conjuntoPalavrasUnicas.exibirPalavrasUnicas();

        conjuntoPalavrasUnicas.verificarPalavra("avião");

        conjuntoPalavrasUnicas.removerPalavra("avião");

        conjuntoPalavrasUnicas.exibirPalavrasUnicas();

        conjuntoPalavrasUnicas.verificarPalavra("avião");
    }

}
