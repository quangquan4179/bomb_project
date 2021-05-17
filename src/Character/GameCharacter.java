package Character;
import java.awt.image.*;
public class GameCharacter {
	 private int ident;
	 private int x, y;
	  private BufferedImage image;

	  public boolean isLiving;

	  public static final int BRICK = 1;
	  public static final int ROCK = 2;
	  public static final int HUNTER1 = 3;
	  public static final int HUNTER2 = 4;
	  public static final int BOMB = 5;
	  public static final int FIRE_CENTER = 6;
	  public static final int FIRE_UP_BODY = 7;
	  public static final int FIRE_UP_END = 8;
	  public static final int FIRE_DOWN_BODY = 9;
	  public static final int FIRE_DOWN_END = 10;
	  public static final int FIRE_LEFT_BODY = 11;
	  public static final int FIRE_LEFT_END = 12;
	  public static final int FIRE_RIGHT_BODY = 13;
	  public static final int FIRE_RIGHT_END = 14;

	  public GameCharacter(int posX, int posY) {
	    isLiving = true;
	    x = posX;
	    y = posY;
	  }

	  public void destroy() {
	    isLiving = false;
	  }

	  public int getIdent() {
	    return ident;
	  }

	  public void setIdent(int ident) {
	    this.ident = ident;
	  }

	  public int getX() {
	    return x;
	  }

	  public void setX(int x) {
	    this.x = x;
	  }

	  public int getY() {
	    return y;
	  }

	  public void setY(int y) {
	    this.y = y;
	  }

	  public BufferedImage getImage() {
	    return image;
	  }

	  public void setImage(BufferedImage image) {
	    this.image = image;
	  }

}
