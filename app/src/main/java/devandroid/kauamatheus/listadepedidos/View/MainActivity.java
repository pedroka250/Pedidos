package devandroid.kauamatheus.listadepedidos.View;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import java.util.List;

import devandroid.kauamatheus.listadepedidos.Controller.ListaItensController;
import devandroid.kauamatheus.listadepedidos.R;

public class MainActivity extends AppCompatActivity {

    List<String> itens;

    Spinner spinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ListaItensController listacontroller = new ListaItensController();

        listacontroller = new ListaItensController();
        itens = listacontroller.itens_spinner();
        listacontroller.getListaItens();

        spinner = findViewById(R.id.spinner);

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, listacontroller.itens_spinner());

        adapter.setDropDownViewResource(android.R.layout.simple_list_item_1);
        spinner.setAdapter(adapter);

        spinner.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, listacontroller.getListaItens()));

    }
}