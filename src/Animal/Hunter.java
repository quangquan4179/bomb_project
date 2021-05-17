package Animal;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.awt.event.*;

import javax.imageio.ImageIO;

import Character.GameCharacter;
import Game.Game;
import Bomb.Bomb;
import GameMap.Map;
public class Hunter extends GameCharacter{
	public static final int UP = 3;
	  public static final int DOWN = 0;
	  public static final int LEFT = 1;
	  public static final int RIGHT = 2;

	  private int direction = RIGHT;
	  private int scale;
	  private BufferedImage images[] = { null, null, null, null };

	  public Hunter(int posX, int posY, int scale, int value) {
	    super(posX, posY);
	    this.scale = scale;
	    setting(value);
	  }

	  private void setting(int value) {
	    switch (value) {
	      case GameCharacter.HUNTER1: {
	        try {
	          images[UP] = ImageIO.read(new File("images/hunter1/ht" + UP + ".png"));
	          images[DOWN] = ImageIO.read(new File("images/hunter1/ht" + DOWN + ".png"));
	          images[LEFT] = ImageIO.read(new File("images/hunter1/ht" + LEFT + ".png"));
	          images[RIGHT] = ImageIO.read(new File("images/hunter1/ht" + RIGHT + ".png"));
	        } catch (IOException e) {
	          e.printStackTrace();
	        }
	        break;
	      }
	      case GameCharacter.HUNTER2: {
	        try {
	          images[UP] = ImageIO.read(new File("images/hunter1/ht" + UP + ".png"));
	          images[DOWN] = ImageIO.read(new File("images/hunter1/ht" + DOWN + ".png"));
	          images[LEFT] = ImageIO.read(new File("images/hunter1/ht" + LEFT + ".png"));
	          images[RIGHT] = ImageIO.read(new File("images/hunter1/ht" + RIGHT + ".png"));
	        } catch (IOException e) {
	          e.printStackTrace();
	        }
	        break;
	      }
	    }
	    this.setImage(images[direction]);
	  }

	  public void move(int d) {
	    direction = d;
	    int newX = this.getX();
	    int newY = this.getY();

	    switch (d) {
	      case UP: {
	        newY = this.getY() - this.scale;
	        break;
	      }
	      case DOWN: {
	        newY = this.getY() + this.scale;
	        break;
	      }
	      case LEFT: {
	        newX = this.getX() - this.scale;
	        break;
	      }
	      case RIGHT: {
	        newX = this.getX() + this.scale;
	        break;
	      }
	    }

	    if (!touchBarrier(newX, newY)) {
	      this.setX(newX);
	      this.setY(newY);
	    }
	    setImage(images[direction]);
	  }

	  public void putBomb(Game g) {
	    int xPos = this.getX();
	    int yPos = this.getY();

	    Bomb bomb = new Bomb(xPos, yPos);
	    g.addItems(bomb);
	    Map.matrix[yPos / Game.SCALE][xPos / Game.SCALE] = 5;
	  }

	  public boolean touchBarrier(int xPos, int yPos) {
	    xPos = xPos / Game.SCALE;
	    yPos = yPos / Game.SCALE;

	    if (Map.matrix[yPos][xPos] != 0) {
	      return true;
	    }
	    return false;
	  }

}
