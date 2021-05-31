package com.example.tp1.data.loader;

import java.io.File;
import java.io.InputStream;
//C'est une interface Loader il nous permet de charger les données
public interface Loader {
    Object load(InputStream fichier);
}
