package com.example.tp1.model;

/**
 * Classe Déplaceur, permet de déplacer la balle
 */
public class Deplaceur {

    /**
     * Unique méthode permettant de tester la balle pour faire en sorte que la balle ne sorte pas de l'écran et que l'on puisse créer un game over
     * @param jeu il est nécessaire d'avoir accès aux éléments du jeu pour pouvoir y déplacer ses objets
     */
    public void moveImage(Jeu jeu) {

        if ( jeu.getCurrentX() < 0 ) { //si le x actuel est inférieur à 0
            jeu.setCurrentX(0); //alors on met le x à 0 pour éviter que la balle sorte de l'écran

            if(jeu.getPopup() !=0) { //même condition à chaque fois, cela créer la popup de game over pour l'utilisateur
                jeu.creaPopUp();
                jeu.setPopup(0);
            }

        } else if ( jeu.getCurrentX() + jeu.getImageWidth() > jeu.getWidth() ){ //on regarde si la balle ne sort pas de l'acran par rapport à sa taille vers la droite
            jeu.setCurrentX(jeu.getWidth() - jeu.getImageWidth()); //alors on définit le x à la plus grande valeur possible sans sortir de l'écran
            if(jeu.getPopup() !=0) {
                jeu.creaPopUp();
                jeu.setPopup(0);
            }
        }

        if ( jeu.getCurrentY() < 0 ) {//si le y actuel est inférieur à 0
            jeu.setCurrentY(0);//alors on met le y à 0 pour éviter que la balle sorte de l'écran
            if(jeu.getPopup() !=0) {
                jeu.creaPopUp();
                jeu.setPopup(0);
            }
        }

        else if ( jeu.getCurrentY() + jeu.getImageHeight() > jeu.getHeight() ){//on regarde si la balle ne sort pas de l'acran par rapport à sa taille vers le haut
            jeu.setCurrentY( jeu.getHeight() - jeu.getImageHeight());//alors on définit le y à la plus grande valeur possible sans sortir de l'écran
            if(jeu.getPopup() !=0) {
                jeu.creaPopUp();
                jeu.setPopup(0);
            }
        }
    }

}
