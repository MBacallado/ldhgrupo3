package com.example.manuelalejandro.ejemplo1;

import android.app.Activity;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.widget.TextView;

import java.util.List;

/**
 * Created by ManuelAlejandro on 30/11/2015.
 */
public class MagnometroActivity extends Activity implements SensorEventListener{
    TextView magneticView;
    Sensor s;
    SensorManager sensorM;
    List<Sensor> sensores;

    /**
     *       Primero se le especifica a la clase MainActivity que implemente el SensorEventListener, esto
     *  se hace para manipular los eventos del sensor y ejecutar nuestro código cuando cambie.
     *  @param savedInstanceState
     *
     */

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_magnometro);
        this.magneticView = (TextView) findViewById(R.id.magnetic);

        sensorM = (SensorManager) getSystemService(SENSOR_SERVICE);
        sensores = sensorM.getSensorList(Sensor.TYPE_MAGNETIC_FIELD);
        if (!sensores.isEmpty()){
            s = sensores.get(0);
            sensorM.registerListener(this,s,sensorM.SENSOR_DELAY_UI);
        }
    }
    /**
     *      El evento que interesa es OnSensorChanged, el código escrito en este evento se ejecuta cada vez que algún valor
     * de distancia cambia. Primero se captura en forma de número flotante el valor de proximidad del sensor. Si el número
     * que devuelve es menor o igual que 2.5 se activa la App cambiando el fondo de la misma a un color aleatorio,
     * en caso contrario se deja el color negro en la pantalla.
     *
     * @param evento
     */

    @Override
    public void onSensorChanged(SensorEvent evento) {
        this.magneticView.setText(String.format("Coordenada X: %f\nCoordenada Y: %f\nCoordenada Z %f", new Object[]{evento.values[0],evento.values[1],evento.values[2]}));
    }


    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }
}
