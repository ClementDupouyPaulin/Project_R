package fr.sae.game.caractere;

import org.newdawn.slick.Image;

public abstract class Entity 	  {
	
	protected String name;
	protected int level;
	protected Image sprite;
	

	public Entity(String n, int l,Image s) {
		this.name = n;
		this.level = l;
		this.sprite = s;
	}
	
}
