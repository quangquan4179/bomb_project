package DrawObj;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

import javax.swing.JPanel;

import Animal.Hunter;
import Character.GameCharacter;
import Game.Game;

public class DrawObj extends JPanel implements Runnable {

  private Game game;

  public DrawObj(Game g) {
    new Thread(this).start();
    game = g;
  }

  @Override
  public void paint(Graphics g) {
    g.setColor(Color.LIGHT_GRAY);
    g.fillRect(0, 0, Game.SCALE * 12, Game.SCALE * 12 + 10);
    drawItems(g);
    drawHunter1(g);
    drawHunter2(g);
  }

  public void drawItems(Graphics g) {
    ArrayList<GameCharacter> items = game.getItems();
    int len = items.size();

    for (int i = 0; i < len; i++) {
      g.drawImage(items.get(i).getImage(), items.get(i).getX(), items.get(i).getY(), Game.SCALE, Game.SCALE, this);
    }
  }

  public void drawHunter1(Graphics g) {
    Hunter hunter = game.getPlayer1();
    g.drawImage(game.getPlayer1().getImage(), hunter.getX(), hunter.getY(), Game.SCALE, Game.SCALE, this);
  }

  public void drawHunter2(Graphics g) {
    Hunter hunter = game.getPlayer2();
    g.drawImage(game.getPlayer2().getImage(), hunter.getX(), hunter.getY(), Game.SCALE, Game.SCALE, this);
  }

  @Override
  public void run() {
    while (true) {
      try {
        Thread.sleep(1);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
      repaint();
    }
  }
}