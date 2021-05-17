package Item;

import java.awt.image.*;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import Character.GameCharacter;

public class Barrier extends GameCharacter {

    public Barrier(int posX, int posY, int value) {
        super(posX, posY);
        setting(value);
    }
    
    private void setting(int v) {
        BufferedImage image = null;
        switch(v) {
            case GameCharacter.BRICK: {
                try {
                    image = ImageIO.read(new File("images/brick.png"));
                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;
            }
            case GameCharacter.ROCK: {
                try {
                    image = ImageIO.read(new File("images/rock.png"));
                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;
            }
        }
        this.setImage(image);
    }
}