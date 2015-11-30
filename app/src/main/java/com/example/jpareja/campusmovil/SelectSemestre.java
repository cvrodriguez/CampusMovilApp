package com.example.jpareja.campusmovil;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;


public class SelectSemestre extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_semestre);
        cargaSemestre();

    }

    public void cargaSemestre(){
        final  String[] semestres = new  String[]{"SELECIONE SEMESTRE","Primer Semestre","Segundo Semestre","Tercer Semestre", "Cuarto Semestre","Quinto Semestre",
        "Sexto Semestre", "Septimo Semestre","Octavo Semestre", "Noveno Semestre", "Decimo Semestre"};

        ArrayAdapter adapter = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,semestres);
        Spinner semestreSp =  (Spinner)findViewById(R.id.spnsemestre);


        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        semestreSp.setAdapter(adapter);
        semestreSp.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if(position != 0) {
                    cargarMateriaSemestre(position);
                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }

        });
    }

    public void cargarMateriaSemestre(int semestre){

        Intent intent =  new Intent(SelectSemestre.this, ListaMateriasActivity.class);
        intent.putExtra(ListaMateriasActivity.SEMESTRE_EXTRA, semestre);
        startActivity(intent);




    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_select_semestre, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
