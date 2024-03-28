package fr.sae.main;

import org.newdawn.slick.*;
import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

import fr.sae.game.DialogueBox;
import fr.sae.game.EntityAnimations;
import fr.sae.game.Global;
import fr.sae.game.Warp;
import fr.sae.game.cinematiques.IntroGame;
import fr.sae.game.maps.Foret;
import fr.sae.menus.ClassesSelect;
import fr.sae.menus.MainMenu;
import fr.sae.menus.OptionMenu;
import fr.sae.menus.SetCharacterName;

public class Main  {
    
    public static void main(String[] args) {
        try {
            // Création de la fenêtre de jeu
            AppGameContainer app = new AppGameContainer(new StateBasedGame("RPG") {
            	
                @Override
                public void initStatesList(GameContainer gc) throws SlickException {
                	// Initialisation des différents états du jeu
                	
                	//Menus
                    this.addState(new MainMenu(1));
                    this.addState(new SetCharacterName(2));
                    this.addState(new OptionMenu(3));
                    this.addState(new ClassesSelect(4));
                    
                    //Cinématiques
                    this.addState(new IntroGame(5));
                    
                    //Maps
                    this.addState(new Foret(6));
                }
            });
            
            // Configuration de la fenêtre de jeu
            app.setShowFPS(false); // Désactiver l'affichage des FPS
            app.setIcons(new String[] {"data/image.png"}); // Définir l'icône de la fenêtre
            
            // Récupération de la résolution de l'écran
            Global.width= app.getScreenWidth();
            Global.height= app.getScreenHeight();
            
            // Définir le mode d'affichage de la fenêtre (plein écran)
            app.setDisplayMode(Global.width, Global.height, true);
            //app.setDisplayMode(800, 600, false); // Mode fenêtré (optionnel)
            
            // Démarrer le jeu
            app.start(); 
            
        } catch (SlickException e) {
            e.printStackTrace();
        }
    }   
}
