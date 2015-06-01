package com.example.jpareja.campusmovil;

import android.os.AsyncTask;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.jpareja.campusmovil.clientes.LoginCliente;
import com.example.jpareja.campusmovil.dto.RespuestaLogin;

import retrofit.RestAdapter;


public class LoginActivity extends ActionBarActivity {

    private EditText txtUsuario;
    private EditText txtContrasena;
    private Button btnIngresar;
    private Button btnCancelar;

    // Cliente de conexion al WS Rest
    private LoginCliente loginCliente;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        txtUsuario = (EditText) findViewById(R.id.edtUsuario);
        txtContrasena = (EditText) findViewById(R.id.edtContrasena);
        btnCancelar = (Button) findViewById(R.id.btnCancelar);
        btnIngresar = (Button) findViewById(R.id.btnIngresar);

        btnCancelar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cancelar();
            }
        }
        );


        btnIngresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ingresar();
            }
        });


        // crear cliente para conexion al ws rest
        RestAdapter restAdapter = new RestAdapter.Builder().setEndpoint("http://192.168.1.50:8080/movilCampus/campusmovil/").build();

        loginCliente=restAdapter.create(LoginCliente.class);
    }


    private void cancelar() {

        txtContrasena.getText().clear();
        txtUsuario.getText().clear();
    }

    private void ingresar() {
        AsyncTask<String, Void, RespuestaLogin> asyncTask = new AsyncTask<String, Void, RespuestaLogin>() {
            @Override
            protected RespuestaLogin doInBackground(String... parametros) {
                String usu = parametros[0];
                String clv = parametros[1];

                return loginCliente.login(usu, clv);
            }

            @Override
            protected void onPostExecute(RespuestaLogin respuestaLogin) {
                if (respuestaLogin.getIngresar()) {
                    Toast.makeText(LoginActivity.this, "Pa' Entro", Toast.LENGTH_LONG).show();
                }else{
                    Toast.makeText(LoginActivity.this, "Mamola", Toast.LENGTH_LONG).show();
                }

                Toast.makeText(LoginActivity.this, respuestaLogin.getMensaje(), Toast.LENGTH_LONG).show();
            }
        };

        String usuario = txtUsuario.getText().toString();
        String clave = txtContrasena.getText().toString();

        asyncTask.execute(usuario, clave);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_login, menu);
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
