package com.example.manuelalejandro.ejemplo1;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

/**
 * Created by ManuelAlejandro on 16/11/2015.
 */
public class ProximidadActivity extends Activity{
    private TextView salida;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_proximidad);
    }
}
