package com.example.manuelalejandro.ejemplo1;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import android.support.v7.widget.Toolbar;

/**
 * Created by Sergio on 20/11/2015.
 */
public class MainActivity extends AppCompatActivity {
    Button botonProximidad;
    Button botonMagnetico;
    Button botonHumedad;

    /**
     * Constructor de la clase Activity,
     * @param savedInstanceState guarda una instancia de la actividad pasada por parametro
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        /**
         * Se declara boton para el sensor proximidad
         */
        botonProximidad = (Button) findViewById(R.id.button);
        botonProximidad.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {
                proximidad(v);
            }
        });

        /**
         * Se declara el boton para el sensor magnetico
         */

        botonMagnetico = (Button) findViewById(R.id.button2);
        botonMagnetico.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {
                magnometro(v);
            }
        });

        /**
         * Se declara el boton para el sensor humedad
         */
        botonHumedad = (Button) findViewById(R.id.button3);
        botonHumedad.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {
                humedad(v);
            }
        });
    }

    /**
     * Añade elementos a la barra de acción si está presente
     * @param menu
     * @return true
     */
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    /**
     * Coge el id , comprueba si está en los ajustes, si está return true, si no, retorna el item seleccionado en las opciones
     * @param item
     * @return
     */
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    /**
     * Función que crea el intent con la actividad del sensor proximidad y la inicia.
     * Se espera modificar cambios (Probando commits con jira...)
     * @param view
     */
    public void proximidad(View view) {
        Intent i = new Intent(this, ProximidadActivity.class);
        startActivity(i);
    }

    /**
     * Función que crea el intent con la actividad del sensor magnometro y la inicia.
     * @param view
     */
    public void magnometro(View view) {
        Intent i = new Intent(this, MagnometroActivity.class);
        startActivity(i);
    }

    public void humedad(View view) {
        Intent i = new Intent(this, HumedadActivity.class);
        startActivity(i);
    }
}