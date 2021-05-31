package com.example.tp1.data.sauveur;

import com.example.tp1.model.Cases;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
//c'est un FileSauveur il va permettre l'ecriture des données dans un fichier
public class FileSauveur implements Sauveur {
    @Override
    public void save(OutputStream fichier, Cases cases) {
        try (ObjectOutputStream oos = new ObjectOutputStream(fichier)){
            oos.writeObject(cases);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
