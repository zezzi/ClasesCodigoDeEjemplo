package app.preuabclase12.zezzi.com.pruebalistado;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;


public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ListView listado_de_cosas=(ListView)findViewById(R.id.libros);

        ArrayList<String> libros_por_leer=new ArrayList<String>();
        libros_por_leer.add("Narnia");
        libros_por_leer.add("Harry Potter");
        libros_por_leer.add("The Hunger Games");
        libros_por_leer.add("Divergence");
        libros_por_leer.add("The Maze runner");

        listado_de_cosas.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, libros_por_leer));

        listado_de_cosas.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent nueva_pantalla=new Intent(getApplicationContext(), Detalle.class);
                final String item=(String)parent.getItemAtPosition(position);
                nueva_pantalla.putExtra("nombre",item);
                startActivity(nueva_pantalla);
            }
        });

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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
