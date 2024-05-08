package com.example.babycarev1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AdapterView;
import android.widget.ListView;
import java.util.ArrayList;

public class PrintActivity extends AppCompatActivity {

    //DECLARACION
    protected ListView lista1;
    protected DataBaseSQL db;
    private Intent pasarPantalla;
    private ArrayList<String> usuarios = new ArrayList<String>();
    private ArrayAdapter<String> adaptador;
    private ArrayList<String> usuario;
    private String contenidoItem;
    private String[] partes;
    private int identificador = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_print);

        //BASE DE DATOS Y REFERENCIAS
        db = new DataBaseSQL(this);
        lista1 = (ListView) findViewById(R.id.lista1_listado);

        //MOSTRAR NOTAS EN LISTA
        usuarios = db.consultarUsuarios();
        adaptador = new ArrayAdapter<String>(PrintActivity.this, android.R.layout.simple_list_item_1, usuarios);
        lista1.setAdapter(adaptador);

        //CLICK DE ITEM DE LISTA
        lista1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                contenidoItem = parent.getItemAtPosition(position).toString();
                partes = contenidoItem.split(".-"); //Separar id y texto
                //Cambio de pantalla y paquetes
                //pasarPantalla = new Intent(PrintActivity.this, VerNotaActivity.class);
                pasarPantalla.putExtra("ID", partes[0]);
                pasarPantalla.putExtra("TITULO", partes[1]);
                finish();
                startActivity(pasarPantalla);
            }
        });
    }

    /*//MENU
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection.
        switch (item.getItemId()) {
            case R.id.item_crear_listado: //CREAR: PASA PANTALLA A CREARNOTA
                pasarPantalla = new Intent(ListadoActivity.this, CrearNotaActivity.class);
                finish();
                startActivity(pasarPantalla);
                return true;
            case R.id.item_opciones_listado: //BORRAR: PASA PANTALLA A BORRARNOTAS
                pasarPantalla = new Intent(ListadoActivity.this, BorrarNotasActivity.class);
                finish();
                startActivity(pasarPantalla);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }*/
}