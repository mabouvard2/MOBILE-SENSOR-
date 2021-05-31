package com.example.tp1.view;


import android.app.Activity;
import android.content.Intent;
import android.graphics.Canvas;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.example.tp1.R;
import com.example.tp1.model.Jeu;

/**
 * Classe JeuMain, permet de lancer le jeu et de gérer le cycle de vie de l'application
 */
public class JeuMain extends AppCompatActivity{

    private Jeu jeu;
    private SensorManager sensorManager = null;
    Integer integer;

    /**
     * Méthode appelée lors de la création
     * @param savedInstanceState il s'agit de l'état de l'instance
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent intent = getIntent();
        if (intent != null) {
            integer = 20;
            if (intent.hasExtra("vitesse")) {
                integer = intent.getIntExtra("vitesse",20 );
            }
        }
        jeu = new Jeu( this ,integer);
        setContentView(jeu);

        sensorManager = (SensorManager) getSystemService( SENSOR_SERVICE );

    }

    /**
     * Méthode appelée lorsque l'application est dans l'état de reprise
     */
    @Override
    protected void onResume() {
        super.onResume();
        sensorManager.registerListener(
                jeu,
                sensorManager.getDefaultSensor( Sensor.TYPE_ACCELEROMETER ),
                SensorManager.SENSOR_DELAY_GAME);
    }

    /**
     * Méthode appelée lorsque le jeu est mit en pause
     */
    @Override
    protected void onPause() {
        super.onPause();
        sensorManager.unregisterListener( jeu );
    }

}