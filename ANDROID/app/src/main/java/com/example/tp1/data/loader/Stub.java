package com.example.tp1.data.loader;

import com.example.tp1.data.loader.Loader;
import com.example.tp1.model.Cases;

import java.io.InputStream;

//Il s'agit d'un stub, il contient des données fixes pour tester l'affichage des joueurs
public class Stub implements Loader {

    //appel du chargement du monde
    public Object load(InputStream fichier)
    {
        //on créer une liste d'avis qui contient les différentes rubriques
        Cases mesAvis = new Cases();

        mesAvis.addAvis("Ce jeu est drôle");
        mesAvis.addAvis("Ce jeu est amusant");
        mesAvis.addAvis("Ce jeu est reposant");
        mesAvis.addAvis("Ce jeu est énervant");
        mesAvis.addAvis("Ce jeu est ennuyeux");
        mesAvis.addAvis("Ce jeu est sans intêret");

        return mesAvis;

    }
}
