package fr.sae.game;

import java.util.Random;

public class Global {
	
	 public static int random(int min, int max) {
	        if (min >= max) {
	            throw new IllegalArgumentException("Le minimum doit être inférieur au maximum");
	        }

	        Random rand = new Random();
	        return rand.nextInt((max - min) + 1) + min;
	    }
	}
