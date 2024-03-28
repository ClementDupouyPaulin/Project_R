package fr.sae.game;

import org.newdawn.slick.Animation;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class EntityAnimations {
    
    // Définition des animations pour les déplacements vers la gauche, la droite, le haut et le bas
    private Animation leftAnimation;
    private Animation rightAnimation;
    private Animation upAnimation;
    private Animation downAnimation;

    // Constructeur de la classe EntityAnimations
    public EntityAnimations(Image layoutImage) throws SlickException {
        
        // Création des animations à partir de l'image fournie
        leftAnimation = new Animation();
        leftAnimation.addFrame(layoutImage.getSubImage(0, 250, 24, 24), 300); // Sous-image pour le déplacement vers la gauche

        rightAnimation = new Animation();
        rightAnimation.addFrame(layoutImage.getSubImage(48, 200, 24, 24), 300); // Sous-image pour le déplacement vers la droite

        upAnimation = new Animation();
        upAnimation.addFrame(layoutImage.getSubImage(0, 172, 28, 26), 300); // Sous-image pour le déplacement vers le haut

        downAnimation = new Animation();
        downAnimation.addFrame(layoutImage.getSubImage(24, 98, 24, 32), 300); // Sous-image pour le déplacement vers le bas
    }

    // Getters pour les animations
    public Animation getLeftAnimation() {
        return leftAnimation;
    }

    public Animation getRightAnimation() {
        return rightAnimation;
    }

    public Animation getUpAnimation() {
        return upAnimation;
    }

    public Animation getDownAnimation() {
        return downAnimation;
    }
}
