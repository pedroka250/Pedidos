package devandroid.kauamatheus.listadepedidos.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.List;

import devandroid.kauamatheus.listadepedidos.Controller.ListaItensController;
import devandroid.kauamatheus.listadepedidos.Model.Adapter;
import devandroid.kauamatheus.listadepedidos.Model.Interface;
import devandroid.kauamatheus.listadepedidos.Model.Item;
import devandroid.kauamatheus.listadepedidos.Model.order_item;
import devandroid.kauamatheus.listadepedidos.R;

public class MainActivity extends AppCompatActivity implements Interface.ClickRecyclerView_Interface{

    List<String> itens;

    Spinner spinner;
    EditText editNome;
    EditText editQuantidade;

    private RecyclerView mRecyclerView;
    private RecyclerView.LayoutManager mLayoutManager;
    Adapter adapter;
    private List<Item> itemListas = new ArrayList<>();
    Button adc;

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setaRecyclerView();

        setaButtons();
        listenersButtons();

        ListaItensController listacontroller = new ListaItensController();

        listacontroller = new ListaItensController();
        itens = listacontroller.itens_spinner();
        listacontroller.getListaItens();

        spinner = findViewById(R.id.spinner);
        editNome = findViewById(R.id.editAdicionarItem);
        editQuantidade = findViewById(R.id.editQuantidade);

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, listacontroller.itens_spinner());

        adapter.setDropDownViewResource(android.R.layout.simple_list_item_1);
        spinner.setAdapter(adapter);

        spinner.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, listacontroller.getListaItens()));

    }


    public void setaRecyclerView(){

        //Aqui é instanciado o Recyclerview
        mRecyclerView = (RecyclerView) findViewById(R.id.RecyclerView);
        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);

        adapter = new Adapter(this, itemListas, this);
        mRecyclerView.setAdapter(adapter);
    }

    public void setaButtons(){

        adc = findViewById(R.id.idButtonAdicionar);

    }

    /**
     * Aqui é o método onde trata o clique em um item da lista
     */
    @Override
    public void onCustomClick(Object object) {

    }

    /**
     * Chama os listeners para os botões
     */
    public void listenersButtons() {

        adc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // Cria uma nova pessoa chamada Renan Teles
                Item itens = new Item();
                itens.setNome(editNome.getText().toString());
                itens.setQntd(Integer.parseInt(editQuantidade.getText().toString()));
//                itens.setNome(editNome.getText().toString());
//                itens.setQntd(Integer.parseInt(editQuantidade.getText().toString()));

                //Adiciona a pessoa1 e avisa o adapter que o conteúdo
                //da lista foi alterado
                itemListas.add(itens);
                adapter.notifyDataSetChanged();

            }
        });
    }
}

