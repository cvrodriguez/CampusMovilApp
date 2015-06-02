package com.example.jpareja.campusmovil;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import com.example.jpareja.campusmovil.clientes.LoginCliente;
import com.example.jpareja.campusmovil.dto.RespuestaLogin;

import com.example.jpareja.campusmovil.utils.Constants;

import retrofit.RestAdapter;


public class LoginActivity extends ActionBarActivity {

    private EditText txtUsuario;
    private EditText txtContrasena;
    private Button btnIngresar;
    private Button btnCancelar;
    ImageButton olvido;

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
        RestAdapter restAdapter = new RestAdapter.Builder().setEndpoint(Constants.END_POINT).build();

        loginCliente = restAdapter.create(LoginCliente.class);
    }


    private void cancelar() {

        txtContrasena.getText().clear();
        txtUsuario.getText().clear();
    }

    private void ingresar() {
        AsyncTask<String, Void, RespuestaLogin> asyncTask = new AsyncTask<String, Void, RespuestaLogin>() {
            ProgressDialog dialog;

            @Override
            protected void onPreExecute() {
                dialog = ProgressDialog.show(LoginActivity.this, null, "Autenticando...");
            }

            @Override
            protected RespuestaLogin doInBackground(String... parametros) {
                String usu = parametros[0];
                String clv = parametros[1];

                return loginCliente.login(usu, clv);
            }

            @Override
            protected void onPostExecute(RespuestaLogin respuestaLogin) {
                if (respuestaLogin.getIngresar()) {
                    Intent i = new Intent(LoginActivity.this, DatosActivity.class);
                    i.putExtra(DatosActivity.INFO_USUARIO, respuestaLogin);
                    startActivity(i);
                }

                dialog.dismiss();
                Toast.makeText(LoginActivity.this, respuestaLogin.getMensaje(), Toast.LENGTH_LONG).show();
            }
        };

        String usuario = txtUsuario.getText().toString();
        String clave = txtContrasena.getText().toString();

        olvido = (ImageButton) findViewById(R.id.imgBtnOlvidoUsuario);

        olvido.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                olvido();
            }
        });

        asyncTask.execute(usuario, clave);
    }

    private void olvido() {
        Intent i = new Intent(this, ReasignarActivity.class);

        startActivity(i);
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
