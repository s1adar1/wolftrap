package com.example.WolfTrap;

/**
 * Created with IntelliJ IDEA.
 * User: Siamek
 * Date: 8/2/13
 * Time: 7:11 PM
 * To change this template use File | Settings | File Templates.
 */
public class Tile {

  int x;
  int y;
  int numberOfSheep;
  boolean wolf;

  public Tile(int x, int y) {
    this.x = x;
    this.y = y;
    numberOfSheep = 0;
  }

  public boolean isSheep() {
    return numberOfSheep > 0;
  }

  public void removeSheep() {
    numberOfSheep--;
  }

  public void addSheep() {
    numberOfSheep++;
  }

  public void setNumberOfSheep(int numberOfSheep) {
    this.numberOfSheep = numberOfSheep;
  }

  public boolean isWolf() {
    return wolf;
  }

  public void setWolf(boolean wolf) {
    this.wolf = wolf;
  }

  public boolean isEmpty() {
    return !isWolf() && !isSheep();
  }

  public int getX() {
    return x;
  }

  public int getY() {
    return y;
  }
}
