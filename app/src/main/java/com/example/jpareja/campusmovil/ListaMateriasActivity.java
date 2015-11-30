package com.example.jpareja.campusmovil;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;

import com.example.jpareja.campusmovil.adapter.MatriculaAdapter;
import com.example.jpareja.campusmovil.clientes.MatriculaCliente;
import com.example.jpareja.campusmovil.dto.RespuestaMatricula;
import com.example.jpareja.campusmovil.utils.Constants;

import java.util.List;

import retrofit.RestAdapter;


public class ListaMateriasActivity extends ActionBarActivity {

    public static final String SEMESTRE_EXTRA = "semestre_id";

    private ListView listaMateriasMatricula;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_materias);

        listaMateriasMatricula = (ListView) findViewById(R.id.lstVwmateriasX);

        int semestreId = getIntent().getIntExtra(SEMESTRE_EXTRA, 0);
        cargarListaMatricula(semestreId);
    }

    private void cargarListaMatricula(int semestreId) {
        AsyncTask<Integer, Void, List<RespuestaMatricula>> asyncTask = new AsyncTask<Integer, Void, List<RespuestaMatricula>>() {
            ProgressDialog dialog;

            @Override
            protected void onPreExecute() {
                dialog = ProgressDialog.show(ListaMateriasActivity.this, null, "Cargando...");
            }

            @Override
            protected List<RespuestaMatricula> doInBackground(Integer... params) {
                Integer idSemestre = params[0];

                // crear cliente para conexion al ws rest
                RestAdapter restAdapter = new RestAdapter.Builder().setEndpoint(Constants.END_POINT).build();
                MatriculaCliente matriculaCliente = restAdapter.create(MatriculaCliente.class);

                return matriculaCliente.verMateriaXSeme(idSemestre);
            }

            @Override
            protected void onPostExecute(List<RespuestaMatricula> respuestaMatriculas) {
                MatriculaAdapter matriculaAdapter = new MatriculaAdapter(ListaMateriasActivity.this, respuestaMatriculas);

                listaMateriasMatricula.setAdapter(matriculaAdapter);

                dialog.dismiss();
            }
        };

        asyncTask.execute(semestreId);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_lista_materias, menu);
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
