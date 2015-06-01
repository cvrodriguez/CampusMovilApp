package com.example.jpareja.campusmovil;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import com.example.jpareja.campusmovil.clientes.NotaCliente;
import com.example.jpareja.campusmovil.dto.RespuestaNotas;
import com.example.jpareja.campusmovil.utils.Constants;
import retrofit.RestAdapter;

import java.util.List;


public class NotasMateriaActivity extends ActionBarActivity {

    public static final String MATERIA = "MATERIA";
    public static final String ESTUDIANTE = "ESTUDIANTE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notas_materia);

        final TextView pparcial = (TextView) findViewById(R.id.txtNotaPParcial);
        final TextView sparcial = (TextView) findViewById(R.id.txtNotaSParcial);
        final TextView tparcial = (TextView) findViewById(R.id.txtNotaTParcial);
        final TextView notasvarias = (TextView) findViewById(R.id.txtNotaVarias);
        final TextView notaproyectos = (TextView) findViewById(R.id.txtNotaProyecto);

        AsyncTask<Long, Void, RespuestaNotas> asyncTask = new AsyncTask<Long, Void, RespuestaNotas>() {
            ProgressDialog dialog;

            @Override
            protected void onPreExecute() {
                dialog = ProgressDialog.show(NotasMateriaActivity.this, null, "Cargando notas...");
            }

            @Override
            protected RespuestaNotas doInBackground(Long... params) {
                Long est = params[0];
                Long mat = params[1];

                RestAdapter adapter = new RestAdapter.Builder().setEndpoint(Constants.END_POINT).build();

                NotaCliente notaCliente = adapter.create(NotaCliente.class);

                return notaCliente.verNotas(mat, est);
            }

            @Override
            protected void onPostExecute(final RespuestaNotas respuestaMateria) {
                pparcial.setText(respuestaMateria.getPrimerp().toString());
                sparcial.setText(respuestaMateria.getSegundop().toString());
                tparcial.setText(respuestaMateria.getTercerp().toString());
                notaproyectos.setText(respuestaMateria.getNotaproyecto().toString());
                notasvarias.setText(respuestaMateria.getNotasvarias().toString());

                dialog.dismiss();
            }
        };

        long idEstudiante = getIntent().getLongExtra(ESTUDIANTE, 0l);
        long idMateria = getIntent().getLongExtra(MATERIA, 0l);

        asyncTask.execute(idEstudiante, idMateria);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_notas_materia, menu);
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
