package com.example.tp1.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
//class Cases
public class Cases implements Serializable {
//composée d'une List d'avis
    private final List<Avis> mesAvis = new ArrayList<>();

    /**
     *  getter des avis
     * @return List<Avis> retourne si la totalité des avis
     */
    public List<Avis> getMesAvis() {
        return Collections.unmodifiableList(mesAvis);
    }

    /**
     *  Ajout d'un avis
     * @param  nom ajoute un avis a mesAvis
     */
    public void addAvis(String nom)
    {
        mesAvis.add(new Avis(nom));
    }
}
