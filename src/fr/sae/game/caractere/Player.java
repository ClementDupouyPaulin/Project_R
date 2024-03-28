package fr.sae.game.caractere;

import org.newdawn.slick.Image;

public abstract class Player extends Entity { // A mettre en abstract et lui faire heriter 
	
	public Player(String name, int level, Image sprite) {
		super(name, level, sprite);
		
	}
	

}
