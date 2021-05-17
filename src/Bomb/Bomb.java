package Bomb;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.awt.event.*;

import javax.imageio.ImageIO;
import Character.GameCharacter;

public class Bomb extends GameCharacter {
  private BufferedImage bombImages;

  public Bomb(int xPos, int yPos) {
    super(xPos, yPos);
    this.setIdent(GameCharacter.BOMB);

    try {
      bombImages = ImageIO.read(new File("images/bomb.png"));
    } catch (IOException e) {
      e.printStackTrace();
    }

    this.setImage(bombImages);
  }
}