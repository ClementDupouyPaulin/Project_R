package fr.sae.game;

import org.newdawn.slick.Graphics;
import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.state.BasicGameState;

public class Warp {
    private float startX; // Coordonnée x du point de départ du warp
    private float startY; // Coordonnée y du point de départ du warp
    private float destinationX; // Coordonnée x de la destination du warp
    private float destinationY; // Coordonnée y de la destination du warp
    private int width; // Largeur du warp
    private int height; // Hauteur du warp

    // Constructeur de la classe Warp
    public Warp(float startX, float startY, int width, int height, float destinationX, float destinationY) {
        this.startX = startX;
        this.startY = startY;
        this.destinationX = destinationX;
        this.destinationY = destinationY;
        this.width = width;
        this.height = height;
    }

    // Vérifie si un rectangle entre en collision avec le warp
    public boolean collidesWith(float x, float y, float objectWidth, float objectHeight) {
        return x < this.startX + this.width && x + objectWidth > this.startX &&
               y < this.startY + this.height && y + objectHeight > this.startY;
    }
    
    // Téléporte un rectangle vers la destination du warp
    public void teleport(Rectangle rectangle) {
        rectangle.setX(this.destinationX);
        rectangle.setY(this.destinationY);
    }
    
    // Dessine le warp sur l'écran
    public void draw(Graphics g) {
        g.drawRect(this.startX, this.startY, this.width, this.height);
    }

    // Getters et setters pour les variables privées
    public float getStartX() {
        return startX;
    }

    public void setStartX(float startX) {
        this.startX = startX;
    }

    public float getStartY() {
        return startY;
    }

    public void setStartY(float startY) {
        this.startY = startY;
    }

    public float getDestinationX() {
        return destinationX;
    }

    public void setDestinationX(float destinationX) {
        this.destinationX = destinationX;
    }

    public float getDestinationY() {
        return destinationY;
    }

    public void setDestinationY(float destinationY) {
        this.destinationY = destinationY;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

	// Méthode pour changer de carte en fonction de la classe fournie
	public BasicGameState setNewMap(Class<? extends BasicGameState> mapClass) {
	    try {
	        return mapClass.getDeclaredConstructor().newInstance();
	    } catch (Exception e) {
	        e.printStackTrace();
	        return null;
	    }
	}
}
