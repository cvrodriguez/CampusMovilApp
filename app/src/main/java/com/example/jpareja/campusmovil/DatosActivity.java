package com.example.jpareja.campusmovil;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import com.example.jpareja.campusmovil.dto.RespuestaLogin;


public class DatosActivity extends ActionBarActivity {

    private ImageButton imgBtnAcademico;

    private TextView edtCedula;
    private TextView edtNombre;
    private TextView edtApellidos;
    private TextView edtCarrera;
    private Long idUsuario;

    public static final String INFO_USUARIO = "info";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_datos);

        RespuestaLogin respuestaLogin = (RespuestaLogin) getIntent().getSerializableExtra(INFO_USUARIO);

        idUsuario = respuestaLogin.getIdestudiante();

        imgBtnAcademico = (ImageButton) findViewById(R.id.imgBtnAcademico);
        edtCedula = (TextView) findViewById(R.id.edtCedula);
        edtNombre = (TextView) findViewById(R.id.edtNombre);
        edtApellidos = (TextView) findViewById(R.id.edtApellidos);
        edtCarrera = (TextView) findViewById(R.id.edtCarrera);

        imgBtnAcademico.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                irAcademico();
            }
        });

        edtCedula.setText(respuestaLogin.getIdentificacion());
        edtNombre.setText(respuestaLogin.getNombre());
        edtApellidos.setText(respuestaLogin.getApellido());
        edtCarrera.setText("Ingenieria de Sistemas");
    }

    private void irAcademico() {
        Intent i = new Intent(this, AcademicoActivity.class);
        i.putExtra(AcademicoActivity.ID_ESTUDIANTE, idUsuario);
        startActivity(i);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_datos, menu);
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
