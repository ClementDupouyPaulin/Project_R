package fr.sae.game;

import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;

public class DialogueBox {
    private String[] messages;
    private int currentIndex;
    private boolean visible;
    private boolean isWaitingForInput;

    public DialogueBox(String[] messages) {
        this.messages = messages;
        this.currentIndex = 0;
        this.visible = false;
        this.isWaitingForInput = false;
    }

    public void render(Graphics g) {
        if (visible) {
            g.setColor(Color.black);
            g.fillRect(50, 450, 700, 100);
            g.setColor(Color.white);
            g.drawString(this.messages[this.currentIndex], 100, 470);
        }
    }

    public void update(Input input) {
        if (visible && isWaitingForInput && input.isKeyPressed(Input.KEY_SPACE)) {
            nextMessage();
        }
    }

    public void nextMessage() {
        if (this.currentIndex < this.messages.length - 1) {
            this.currentIndex++;
            this.isWaitingForInput = true;
        } else {
            this.currentIndex = 0;
            this.visible = false;
        }
    }

    public void setVisible(boolean visible) {
        this.visible = visible;
        this.isWaitingForInput = true;
    }

    public boolean isVisible() {
        return this.visible;
    }
}
