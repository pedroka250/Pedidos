package devandroid.kauamatheus.listadepedidos.Controller;

import java.util.ArrayList;
import java.util.List;

import devandroid.kauamatheus.listadepedidos.Model.Pedido;

public class ListaItensController {

    private List listaItens;

    public List getListaItens() {
        listaItens = new ArrayList<Pedido>();

        listaItens.add(new Pedido("Sabão em pó", 25.50));
        listaItens.add(new Pedido("Achocolatado", 9.90));
        listaItens.add(new Pedido("Maça", 2.5));
        listaItens.add(new Pedido("Ervilha", 6.49));

        return listaItens;
    }
    public ArrayList<String> itens_spinner(){
        ArrayList<String> itens = new ArrayList<>();

        for (int i = 0; i < getListaItens().size();i++){
            Pedido objeto = (Pedido) getListaItens().get(i);

            itens.add(objeto.getNome());
            itens.add(String.valueOf(objeto.getPreco()));

        }
        return itens;
    }

}
