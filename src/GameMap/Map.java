package GameMap;

import Animal.Hunter;
import Character.GameCharacter;
import Game.Game;
import Item.Barrier;
import Bomb.Bomb;

public class Map {
  public static int[][] matrix = { 
    { 3, 0, 0, 2, 0, 0, 0, 0, 0, 0, 0, 4 }, 
    { 1, 0, 2, 0, 1, 0, 2, 0, 1, 0, 1, 1 },
    { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0 }, 
    { 1, 0, 2, 0, 1, 0, 2, 0, 1, 0, 1, 0 },
    { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1 }, 
    { 1, 0, 2, 0, 1, 0, 2, 0, 1, 0, 1, 0 },
    { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0 }, 
    { 1, 0, 2, 0, 1, 0, 2, 0, 1, 0, 1, 0 },
    { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0 }, 
    { 1, 0, 2, 0, 1, 0, 2, 0, 1, 0, 1, 0 },
    { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0 }, 
    { 1, 0, 2, 0, 1, 0, 2, 0, 1, 0, 1, 0 } };

  public Map(Game g) {
    for (int i = 0; i < 12; i++) {
      for (int j = 0; j < 12; j++) {
        if (matrix[i][j] == 0) {
          continue;
        }
        switch (matrix[i][j]) {
          case GameCharacter.BRICK: {
            g.addItems(new Barrier(j * Game.SCALE, i * Game.SCALE, matrix[i][j]));
            break;
          }
          case GameCharacter.ROCK: {
            g.addItems(new Barrier(j * Game.SCALE, i * Game.SCALE, matrix[i][j]));
            break;
          }
          case GameCharacter.HUNTER1: {
            Hunter hunter1 = new Hunter(j * Game.SCALE, i * Game.SCALE, Game.SCALE, matrix[i][j]);
            // g.addItems(hunter);
            g.setPlayer1(hunter1);
            matrix[j][i] = 0;
            break;
          }
          case GameCharacter.HUNTER2: {
            Hunter hunter2 = new Hunter(j * Game.SCALE, i * Game.SCALE, Game.SCALE, matrix[i][j]);
            // g.addItems(hunter);
            g.setPlayer2(hunter2);
            matrix[i][j] = 0;
            break;
          }
          // case GameCharacter.MONTER: {
          // g.addItems(new Monter(i*Game.SCALE, j*Game.SCALE));
          // break;
          // }
          case GameCharacter.BOMB: {
            Bomb bomb = new Bomb(j * Game.SCALE, i * Game.SCALE);
            g.addItems(bomb);
            break;
          }
          case GameCharacter.FIRE_CENTER: {
            // g.addItems(new FireCenter(i*Game.SCALE, j*Game.SCALE));
            break;
          }
          case GameCharacter.FIRE_UP_BODY: {
            // g.addItems(new FireUpBody(i*Game.SCALE, j*Game.SCALE));
            break;
          }
          case GameCharacter.FIRE_UP_END: {
            // g.addItems(new FireUpEnd(i*Game.SCALE, j*Game.SCALE));
            break;
          }
          case GameCharacter.FIRE_DOWN_BODY: {
            // g.addItems(new FireDownBody(i*Game.SCALE, j*Game.SCALE));
            break;
          }
          case GameCharacter.FIRE_DOWN_END: {
            // g.addItems(new FireDownEnd(i*Game.SCALE, j*Game.SCALE));
            break;
          }
          case GameCharacter.FIRE_LEFT_BODY: {
            // g.addItems(new FireLeftBody(i*Game.SCALE, j*Game.SCALE));
            break;
          }
          case GameCharacter.FIRE_LEFT_END: {
            // g.addItems(new FireLeftEnd(i*Game.SCALE, j*Game.SCALE));
            break;
          }
          case GameCharacter.FIRE_RIGHT_BODY: {
            // g.addItems(new FireRightBody(i*Game.SCALE, j*Game.SCALE));
            break;
          }
          case GameCharacter.FIRE_RIGHT_END: {
            // g.addItems(new FireRightEnd(i*Game.SCALE, j*Game.SCALE));
            break;
          }
        }
        // g.addItems(new ItemGame(i*Game.SCALE, j*Game.SCALE, matrix[i][j]));
      }
    }
  }

  public int[][] getMatrix() {
    return matrix;
  }

  public void setMatrix(int i, int j, int newValue) {
    matrix[i][j] = newValue;
  }
}