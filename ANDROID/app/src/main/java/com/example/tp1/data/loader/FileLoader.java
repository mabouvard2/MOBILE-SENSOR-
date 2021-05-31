package com.example.tp1.data.loader;

import androidx.annotation.Nullable;

import com.example.tp1.model.Cases;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
//c'est un FileLoader il va permettre le lire les données d'un fichier
public class FileLoader implements Loader {
    @Nullable
    @Override
    public Object load(@Nullable InputStream fichier) {
        Object retour = null;
        try(ObjectInputStream ois = new ObjectInputStream((fichier))) {
            retour = (Cases)ois.readObject();
        } catch (IOException  e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
        e.printStackTrace();
        };
        return retour;
    }
}
