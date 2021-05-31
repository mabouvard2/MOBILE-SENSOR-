package com.example.tp1.data.sauveur;

import com.example.tp1.model.Cases;

import java.io.OutputStream;
//C'est une interface Sauveur il nous permet de sauvegarder les données
public interface Sauveur {
    void save(OutputStream fichier, Cases cases);
}
