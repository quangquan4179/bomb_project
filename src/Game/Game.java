package Game;

import java.util.ArrayList;

import javax.sound.sampled.Clip;
import javax.swing.JFrame;

import Animal.Hunter;
import Sound.Sound;

import java.awt.event.*;

import Character.GameCharacter;
import DrawObj.DrawObj;
import GameMap.Map;

public class Game extends JFrame {
  public static final int SCREEN_WIDTH = 800;
  public static final int SCREEN_HEIGHT = 650;
  public static final int SCALE = (int) ((SCREEN_HEIGHT - 50) / 12);

  private Map map;
  private ArrayList<GameCharacter> items = new ArrayList<GameCharacter>();
  private Sound sound;
  private Hunter player1;
  private Hunter player2;
  private Clip clip;
  // private Bomb bomb;
  Game that = this;
  // private Explosion explosion;

  public Game() {
    map = new Map(this);
    
   clip= sound.getSound();
   clip.start();
    add(new DrawObj(this));
    this.addKeyListener(new Handler());
    init();
    
    
  }

  public Hunter getPlayer1() {
    return player1;
  }

  public void setPlayer1(Hunter player) {
    this.player1 = player;
  }

  public Hunter getPlayer2() {
    return player2;
  }

  public void setPlayer2(Hunter player) {
    this.player2 = player;
  }

  public ArrayList<GameCharacter> getItems() {
    return items;
  }

  public void init() {
    setTitle("Bomb Game");
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setSize(Game.SCREEN_WIDTH, Game.SCREEN_HEIGHT);
    setLocationRelativeTo(null);
    setVisible(true);
  }

  public void setItems() {
    for (int i = 0; i < items.size(); i++) {
      if (!items.get(i).isLiving) {
        items.remove(i);
      }
    }
  }

  public void addItems(GameCharacter newItem) {
    items.add(newItem);
  }

  public class Handler implements KeyListener {
    public void keyTyped(KeyEvent e) {
    }

    public void keyPressed(KeyEvent e) {
      switch (e.getKeyCode()) {
        case 37: {
          player1.move(Hunter.LEFT);
          break;
        }
        case 38: {
          player1.move(Hunter.UP);
          break;
        }
        case 39: {
          player1.move(Hunter.RIGHT);
          break;
        }
        case 40: {
          player1.move(Hunter.DOWN);
          break;
        }
        case 16: { // shift
          player1.putBomb(that);
          break;
        }

        case 65: {
          player2.move(Hunter.LEFT);
          break;
        }
        case 87: {
          player2.move(Hunter.UP);
          break;
        }
        case 68: {
          player2.move(Hunter.RIGHT);
          break;
        }
        case 83: {
          player2.move(Hunter.DOWN);
          break;
        }
        case 32: {
          player2.putBomb(that);
          break;
        }
      }
    }

    public void keyReleased(KeyEvent e) {
    }
  }
}