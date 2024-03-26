package fr.sae.main;

import org.newdawn.slick.*;
import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

import fr.sae.game.DialogueBox;
import fr.sae.game.EntityAnimations;
import fr.sae.game.Warp;
import fr.sae.menus.MainMenu;

public class Main extends BasicGameState {

    private Rectangle player;
    private Image backgroundImage;
    private Image playerImage;
    private int mapWidth;
    private int mapHeight;
    private Image layoutImage;
    private Rectangle obstacle;
    protected int taille;
    private DialogueBox dialogueBox;
    private Rectangle triggerZone;
    private Warp warpZone;
    private boolean dialogueTriggered;

    private EntityAnimations entityAnimations;

    private boolean left = false;
    private boolean right = false;
    private boolean up = false;
    private boolean down = false;


    public Main(int state) {
    }

    @Override
    public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {
        mapWidth = 800;  
        mapHeight = 600; 

        String backgroundImagePath = "data/battle-scene.png";
        backgroundImage = new Image(backgroundImagePath);

        String playerImagePath = "data/link.png";
        layoutImage = new Image(playerImagePath);
        entityAnimations = new EntityAnimations(layoutImage);


        taille=0;
        playerImage = layoutImage.getSubImage(0, taille, 24, 24);
        
        float playerX = (mapWidth - playerImage.getWidth()) / 2;
        float playerY = (mapHeight - playerImage.getHeight()) / 2;

        player = new Rectangle(playerX, playerY, playerImage.getWidth(), playerImage.getHeight());
        
        float obstacleX = mapWidth / 2 - 300;
        float obstacleY = mapHeight / 2 - 200; 
        float obstacleWidth = 600; 
        float obstacleHeight = 400; 
        
        obstacle = new Rectangle(obstacleX, obstacleY, obstacleWidth, obstacleHeight);
        
        dialogueBox = new DialogueBox(new String[]{"Bonjour !", "Comment ça va ?", "Au revoir !"});
        triggerZone = new Rectangle(200, 200, 100, 100);
        dialogueTriggered = false;
        
        warpZone = new Warp(680, 490, 20, 10, (mapWidth / 2 - 300), (mapHeight / 2 - 200));

    }

    @Override
    public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {
        backgroundImage.draw(0, 0, mapWidth, mapHeight);
        
        if (left) {
        	entityAnimations.getLeftAnimation().draw(player.getX(), player.getY());
        	left=false;
        	
        }else if(right){
        	
        	entityAnimations.getRightAnimation().draw(player.getX(), player.getY());
        	right=false;
        	
        }else if(up){
        	
        	entityAnimations.getUpAnimation().draw(player.getX(), player.getY());
        	up=false;
        	
        }else if(down){
        	
        	entityAnimations.getDownAnimation().draw(player.getX(), player.getY());
        	down=false;
        	
        }else {
        	playerImage.draw(player.getX(), player.getY());
        }
        
        g.setColor(Color.red);
        g.draw(triggerZone);
        warpZone.draw(g);
        g.draw(obstacle);
        
        if (dialogueTriggered) {
            dialogueBox.render(g);
        }
    }
    

    @Override
    public void update(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException {
        Input input = gc.getInput();
        float speed = 0.2f * delta;
        
        if (player.intersects(triggerZone)) {
        	triggerZone.setCenterY(-50);
            dialogueTriggered = true;
        }

        if (warpZone.collidesWith(player.getX(), player.getY(), player.getWidth(), player.getHeight())) {
        	
            warpZone.teleport(player);
        }
        

        if (input.isKeyDown(Input.KEY_LEFT) && player.getX() > 0 && (player.getX() - 1 < obstacle.getMaxX()) && (player.getX() > obstacle.getX())
        		) {

               player.setX(player.getX() - speed);
               taille=48;
               playerImage = layoutImage.getSubImage(0, taille, 24, 24);
            }
        if (input.isKeyDown(Input.KEY_RIGHT) && player.getX() + player.getWidth() < mapWidth && (player.getMaxX() + 1 > obstacle.getX()) && (player.getMaxX() < obstacle.getMaxX())) 
        {

            player.setX(player.getX() + speed);
            taille =72;
            playerImage = layoutImage.getSubImage(0, taille, 24, 24); 
            
        }

        if (input.isKeyDown(Input.KEY_UP) && player.getY() > 0 && (player.getY() - 1 < obstacle.getMaxY()) && (player.getY() > obstacle.getY())
        		) {

                player.setY(player.getY() - speed);
                taille=24;
                playerImage = layoutImage.getSubImage(0, taille, 24, 24); 
            
        }
        if (input.isKeyDown(Input.KEY_DOWN) && player.getY() + player.getHeight() < mapHeight && (player.getMaxY() + 1 > obstacle.getY()) && (player.getMaxY() < obstacle.getMaxY())
        		) {

                player.setY(player.getY() + speed);
                taille=0;
                playerImage = layoutImage.getSubImage(0, taille, 24, 24);
            
        }
        
        if (input.isMouseButtonDown(Input.MOUSE_LEFT_BUTTON)) {
            if (taille == 48) { // Left
            	left=true;
            	
            } else if (taille == 72) { // Right
            	right=true;
            	
            } else if (taille == 24) { // Up
            	up=true;

            } else { // Down
            	down=true;
            }
       
        }
        
        if (input.isKeyPressed(Input.KEY_SPACE)) {
            dialogueBox.nextMessage();
            
            if (!dialogueBox.isVisible()) {
            	dialogueTriggered=false;
            }
        }
        
    }

    @Override
    public int getID() {
        return 1; // Identifiant unique de l'état de jeu
    }

    public static void main(String[] args) {
        try {
        	
            AppGameContainer app = new AppGameContainer(new StateBasedGame("RPG") {
            	
                @Override
                public void initStatesList(GameContainer gc) throws SlickException {
                	
                    addState(new MainMenu(1));

                }
            });
            app.setIcons(new String[] {"data/image.png"});
            
            app.setDisplayMode(800, 600, false);
            app.start(); 
            
        } catch (SlickException e) {
            e.printStackTrace();
        }
    }
    
}
