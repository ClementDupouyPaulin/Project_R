package fr.sae.menus;

import java.awt.Font;

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.TrueTypeFont;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

public class MainMenu extends BasicGameState {
    private TrueTypeFont titleFont;
    private TrueTypeFont menuFont;
    private int selectedItemIndex;
    private String[] menuItems = {"Start Game", "Options", "Exit"};

    public MainMenu(int stateID) {
    }

    @Override
    public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {
        Font font = new Font("Verdana", Font.BOLD, 24);
        titleFont = new TrueTypeFont(font, true);
        font = new Font("Verdana", Font.PLAIN, 20);
        menuFont = new TrueTypeFont(font, true);
        selectedItemIndex = 0;
    }

    @Override
    public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {
        g.setColor(Color.white);
        g.setFont(titleFont);
        g.drawString("Main Menu", 300, 100);

        for (int i = 0; i < menuItems.length; i++) {
            if (i == selectedItemIndex) {
                g.setColor(Color.red);
            } else {
                g.setColor(Color.white);
            }
            g.setFont(menuFont);
            g.drawString(menuItems[i], 300, 200 + i * 50);
        }
    }

    @Override
    public void update(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException {
        // Implement menu navigation logic here
    }

    @Override
    public void keyPressed(int key, char c) {
        if (key == Input.KEY_UP) {
            selectedItemIndex = (selectedItemIndex - 1 + menuItems.length) % menuItems.length;
        } else if (key == Input.KEY_DOWN) {
            selectedItemIndex = (selectedItemIndex + 1) % menuItems.length;
        } else if (key == Input.KEY_ENTER) {
            // Perform action based on selected item
            switch (selectedItemIndex) {
                case 0:
                    // Start Game
                    break;
                case 1:
                    // Options
                    break;
                case 2:
                    // Exit
                    System.exit(0);
                    break;
            }
        }
    }

    @Override
    public int getID() {
        return 0;
    }
}