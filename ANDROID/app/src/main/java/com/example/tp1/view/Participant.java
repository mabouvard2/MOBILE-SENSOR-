package com.example.tp1.view;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.tp1.R;
import com.example.tp1.data.loader.FileLoader;
import com.example.tp1.data.sauveur.FileSauveur;
import com.example.tp1.data.loader.Loader;
import com.example.tp1.data.sauveur.Sauveur;
import com.example.tp1.data.loader.Stub;
import com.example.tp1.model.Cases;
import com.example.tp1.view.adapter.MonAdaptateur;

import java.io.FileNotFoundException;

public class Participant extends AppCompatActivity {

    public static final String DIFFICULTE_CHOISIE = "difficulte";

    private Cases cases;
    private final Sauveur leSauveur = new FileSauveur();

    /**
     * Méthode appelée lors l'arret ou la rotation de l'application permet de sauvegarder
     */
    @Override
    protected void onStop() {
        try{
            leSauveur.save(openFileOutput(DIFFICULTE_CHOISIE,MODE_PRIVATE),cases);
        } catch (FileNotFoundException e) {

            e.printStackTrace();
        }
        super.onStop();
    }

    /**
     * Méthode appelée lors de la création
     * @param savedInstanceState il s'agit de l'état de l'instance
     */
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_participant_recycler);

        Loader leLoader = new FileLoader();

        try{
            cases = (Cases) leLoader.load(openFileInput(DIFFICULTE_CHOISIE));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        if (cases == null) {
            leLoader = new Stub();
            cases = (Cases) leLoader.load(null);
        }

        RecyclerView laListView = findViewById(R.id.laListView);
        laListView.setLayoutManager(new LinearLayoutManager(this));
        laListView.setAdapter(new MonAdaptateur(cases.getMesAvis()));
  }


}