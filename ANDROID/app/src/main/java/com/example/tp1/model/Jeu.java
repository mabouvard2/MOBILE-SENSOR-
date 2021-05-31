package com.example.tp1.model;

import android.content.Context;

import android.content.DialogInterface;
import android.content.Intent;

import android.content.res.Resources;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.util.AttributeSet;
import android.view.View;

import androidx.appcompat.app.AlertDialog;

import com.example.tp1.R;
import com.example.tp1.view.ActivitePrincipale;
import com.example.tp1.view.JeuMain;

/**
 * La classe Jeu est la classe principale du programme.
 * Elle éttend View et implémente l'écouteur d'évènement par rapport au capteur
 * paint -> nécessaire pour dessiner des bitmaps
 * ballBitmap -> il s'agit du Bitmap de la balle que l'on joue
 * deplaceur -> instance de la classe Deplaceur, se chargera de déplacer la balle
 * imageWidth -> largeur de l'image
 * imageHeight -> longueur de l'image
 * currentX -> position X actuelle de la balle
 * currentY -> position Y actuelle de la balle
 * vitesse -> vitesse de la balle dans le jeu
 */
public class Jeu extends View implements SensorEventListener {

    private final Paint paint = new Paint();
    private Bitmap ballBitmap;
    private Integer vitesse;

    private int popup = 1;


    private int imageWidth;
    private int imageHeight;

    private int currentX;
    private int currentY;

    public int getCurrentX() {
        return currentX;
    }

    public void setCurrentX(int currentX) {
        this.currentX = currentX;
    }

    public int getCurrentY() {
        return currentY;
    }

    public void setCurrentY(int currentY) {
        this.currentY = currentY;
    }

    public int getImageWidth() {
        return imageWidth;
    }


    public int getImageHeight() {
        return imageHeight;
    }

    public int getPopup() {
        return popup;
    }

    public void setPopup(int popup) {
        this.popup = popup;
    }

    /**
     * Constructeur du jeu avec juste le contexte donné en paramètres et les extra de l'intent
     * @param context il s'agit du contexte de l'application
     * @param integer extra de l'intent renvoies la valeur choisie par l'utilisateur pour la vitesse
     */
    public Jeu(Context context, Integer integer ) {
        super( context );
        this.vitesse=integer;
        this.init( context );
    }


    /**
     *Methode initialisant les objets, ici la balle que l'on joue
     * @param context il s'agit du contexte de l'application
     */
    private void init( Context context ) {
        this.ballBitmap =
                BitmapFactory.decodeResource(getResources(), R.drawable.ballon);
        this.imageWidth = ballBitmap.getWidth();
        this.imageHeight = ballBitmap.getHeight();

    }

    /**
     *Une classe qui est appelée lorsque la taille du jeu est changée
     * @param w il s'agit de la nouvelle largeur
     * @param h il s'agit de la nouvelle hauteur
     * @param oldw il s'agit de l'ancienne largeur
     * @param oldh il s'agit de l'ancienne hauteur
     */
    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        this.currentX = (getWidth() - this.imageWidth) / 4;
        this.currentY = (getHeight() - this.imageHeight) / 4;
    }

    /**
     *Methode qui permet de "dessiner" le jeu
     * Une classe du Model n'est pas censé faire de onDraw, mais à cause de certains soucis nous avons du se rabattre sur cette solution pour que l'application soit fonctionnelle
     * @param canvas le canvas est ce sur quoi l'application va dessiner le jeu
     */
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        canvas.drawBitmap( this.ballBitmap, this.currentX, this.currentY, this.paint );
    }

    /**
     *Méthode qui permet de déplacer la balle
     * @param x valeur de x en px que l'on veut déplacer
     * @param y valeur de y en px que l'on veut déplacer
     */
    private void moveImage( float x, float y ) {
        this.currentX += (int) x ;
        this.currentY += (int) y;

        Deplaceur deplaceur = new Deplaceur();
        deplaceur.moveImage(this);
        this.invalidate();
    }


    /**
     * Méthode qui créer la popup de game over
     */
    protected void creaPopUp() {

        AlertDialog.Builder gameOver = new AlertDialog.Builder(getContext());
        gameOver.setTitle("GAME OVER");
        gameOver.setMessage("Rejouer");
        gameOver.setPositiveButton("Oui", new DialogInterface.OnClickListener() {
            @Override
            /**
             * Méthode appelée lorsque l'on veut continuer le jeu
             */
            public void onClick(DialogInterface dialog, int which) {
                Intent intent = new Intent(getContext(),JeuMain.class);
                getContext().startActivity(intent);
            }
        });
        gameOver.setNegativeButton("Non", new DialogInterface.OnClickListener() {
            @Override
            /**
             * Méthode appelée lorsque l'on veut arrêter de jouer et retourner à l'acceuil après avoir perdu
             */
            public void onClick(DialogInterface dialog, int which) {
                Intent intent = new Intent(getContext(),ActivitePrincipale.class);
                getContext().startActivity(intent);
            }
        });
        gameOver.show();
    }


    /**
     * Classe obligatoire lorsque l'on implémente SensorEventListener
     * Aurait pu servir par rapport à l'acceleromètre
     * @param arg0 il s'agit du capteur
     * @param arg1 il sagit de la vitesse
     */
    @Override
    public void onAccuracyChanged(Sensor arg0, int arg1) {
    }

    /**
     *Methode appelée lorsque la valeur du capteur est changée
     * @param event il s'agit de l'évènement relié au capteur
     */
    @Override
    public void onSensorChanged(SensorEvent event) {
        float x = event.values[0];
        float y = event.values[1];

        this.moveImage(-x * vitesse, y * vitesse); //plus la valeur est élevée plus l'image bougera vite
   }
}