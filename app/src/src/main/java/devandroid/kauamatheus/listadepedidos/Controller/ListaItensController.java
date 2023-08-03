package devandroid.kauamatheus.listadepedidos.Controller;

import java.util.ArrayList;
import java.util.List;

import devandroid.kauamatheus.listadepedidos.Model.Item;

public class ListaItensController {

    private List listaItens;

    public List getListaItens() {
        listaItens = new ArrayList<Item>();

        listaItens.add(new Item("Sabão em pó", 25.50,""));
        listaItens.add(new Item("Achocolatado", 9.90,""));
        listaItens.add(new Item("Maça", 2.5,""));
        listaItens.add(new Item("Ervilha", 6.49,""));

        return listaItens;
    }
    public ArrayList<String> itens_spinner(){
        ArrayList<String> itens = new ArrayList<>();

        for (int i = 0; i < getListaItens().size();i++){
            Item objeto = (Item) getListaItens().get(i);

            itens.add(objeto.getNome());
            itens.add(String.valueOf(objeto.getPreco()));

        }
        return itens;
    }

}
