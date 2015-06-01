package com.example.jpareja.campusmovil;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;
import com.example.jpareja.campusmovil.adapter.MateriasAdapter;
import com.example.jpareja.campusmovil.clientes.MateriaCliente;
import com.example.jpareja.campusmovil.dto.RespuestaMateria;
import com.example.jpareja.campusmovil.utils.Constants;
import retrofit.RestAdapter;

import java.util.List;


public class NotasActActivity extends ActionBarActivity {

    private ListView listaMaterias;

    public static final String ID_ESTUDIANTE = "idEstudiante";
    private long idEstudiante;
    private MateriaCliente materiaCliente;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notas_act);

        listaMaterias = (ListView) findViewById(R.id.lstMaterias);

        idEstudiante = getIntent().getLongExtra(ID_ESTUDIANTE, 0L);

        RestAdapter restAdapter = new RestAdapter.Builder()
                .setEndpoint(Constants.END_POINT)
                .build();

        materiaCliente = restAdapter.create(MateriaCliente.class);

        listaMaterias.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                consultarNotas(id);
            }
        });

        cargarNotas();
    }

    private void consultarNotas(long idMateria) {
        Intent i = new Intent(this, NotasMateriaActivity.class);
        i.putExtra(NotasMateriaActivity.ESTUDIANTE, idEstudiante);
        i.putExtra(NotasMateriaActivity.MATERIA, idMateria);
        startActivity(i);
    }

    private void cargarNotas(){
        AsyncTask<Long, Void, List<RespuestaMateria>> asyncTask = new AsyncTask<Long, Void, List<RespuestaMateria>>() {
            ProgressDialog dialog;

            @Override
            protected void onPreExecute() {
                dialog = ProgressDialog.show(NotasActActivity.this, null, "Cargando materias...");
            }

            @Override
            protected List<RespuestaMateria> doInBackground(Long... params) {
                Long idEstudiante = params[0];
                return materiaCliente.listarMaterias(idEstudiante);
            }

            @Override
            protected void onPostExecute(final List<RespuestaMateria> respuestaMateria) {

                listaMaterias.setAdapter(new MateriasAdapter(listaMaterias.getContext()) {
                    @Override
                    public List<RespuestaMateria> getLista() {
                        return respuestaMateria;
                    }
                });

                dialog.dismiss();
            }
        };

        asyncTask.execute(idEstudiante);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_notas_act, menu);
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
