package fr.sae.game.cinematiques;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

import fr.sae.game.Global;

public class IntroGame extends BasicGameState {
	
	public IntroGame(int stateID) {
	}

	@Override
	public void init(GameContainer arg0, StateBasedGame arg1) throws SlickException {
		
		Global.inCinematique=true;
		Global.InitializeGame(); //Initialise les variables sur leurs valeur par default
		
	}

	@Override
	public void render(GameContainer arg0, StateBasedGame arg1, Graphics arg2) throws SlickException {
		
	}

	@Override
	public void update(GameContainer arg0, StateBasedGame arg1, int arg2) throws SlickException {
		
	}

	@Override
	public int getID() {
		return 5;
	}

}
