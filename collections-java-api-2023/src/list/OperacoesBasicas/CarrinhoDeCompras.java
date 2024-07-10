package list.OperacoesBasicas;

import java.util.ArrayList;
import java.util.List;

public class CarrinhoDeCompras {
    //atributo
    private List<Item> itemList;

    public CarrinhoDeCompras(){
        this.itemList = new ArrayList<>();
    }

    public void adicionarItem(String nome, double preco, int quantidade){
        itemList.add(new Item(nome, preco, quantidade));
    }

    public void removerItem(String nome){
        List<Item> itensParaRemover = new ArrayList<>();
        for(Item i : itemList){
            if(i.getNome().equalsIgnoreCase(nome)){
                itensParaRemover.add(i);
            }
        }
        itemList.removeAll(itensParaRemover);
    }

    public double calculaValorTotal(){
        double total = 0;
        for(Item i : itemList){
            total += i.getPreco();
            System.out.println("O valor parcial do carrinho é " + total);
        }
        System.out.println("O valor Total do carrinho é " + total);
        return total;
    }

    public void exibirItens(){
        System.out.println(itemList);
    }

    public static void main(String[] args) {
        CarrinhoDeCompras carrinhoDeCompras = new CarrinhoDeCompras();
        carrinhoDeCompras.exibirItens();

        carrinhoDeCompras.adicionarItem("Arroz", 32, 5);
        carrinhoDeCompras.adicionarItem("Feijão", 12.00, 1);
        carrinhoDeCompras.adicionarItem("Carne", 36.90, 1);
        carrinhoDeCompras.adicionarItem("Arroz", 21.40, 3);

        double valorCarrinho = 0;
        valorCarrinho = carrinhoDeCompras.calculaValorTotal();

        System.out.println("O valor TOTAL é " + valorCarrinho);

        carrinhoDeCompras.exibirItens();

        carrinhoDeCompras.removerItem("Arroz");

        carrinhoDeCompras.exibirItens();
        valorCarrinho = carrinhoDeCompras.calculaValorTotal();

    }

}
