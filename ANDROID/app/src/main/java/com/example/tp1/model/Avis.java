package com.example.tp1.model;

import java.io.Serializable;
//Classe avis
public class Avis implements Serializable {
//composée d'un nom et d'un coche (savoir si l'avis est selectionné)
    private final String nom;
    private boolean coche = false;

    /**
     *  Constructeur d'un avis
     * @param nom nom de l'avis
     */
    public Avis(String nom){
        this.nom = nom;
    }

    /**
     *  getter de nom
     * @return String retourne le nom
     */
    public String getNom() {
        return nom;
    }
    /**
     *  getter de coche
     * @return boolean retourne si la cases est cochée ou non
     */

    public boolean isCoche(){
        return coche;
    }

    /**
     *  setter de coche
     * @param coche set la cases en cochée ou non cochée
     */
    public void setCoche(boolean coche){
        this.coche=coche;
    }
}
