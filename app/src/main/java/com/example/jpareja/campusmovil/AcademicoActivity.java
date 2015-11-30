package com.example.jpareja.campusmovil;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;


public class AcademicoActivity extends ActionBarActivity {

    private Button btnVerMaterias;

    private Long idEstudiante;

    public static final String ID_ESTUDIANTE = "idEstudiante";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_academico);

        btnVerMaterias = (Button) findViewById(R.id.btnnotasactuales);

        idEstudiante = getIntent().getLongExtra(ID_ESTUDIANTE, 0l);

        btnVerMaterias.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                verMaterias();
            }
        });
    }

    private void verMaterias() {
        Intent i = new Intent(this, NotasActActivity.class);
        i.putExtra(NotasActActivity.ID_ESTUDIANTE, idEstudiante);
        startActivity(i);
    }

public void selectSemestre (View view){

    Intent semestre = new Intent(this,SelectSemestre.class);
    startActivity(semestre);








}
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_academico, menu);
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
