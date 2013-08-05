package com.example.WolfTrap;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;

/**
 * Created with IntelliJ IDEA.
 * User: Siamek
 * Date: 8/2/13
 * Time: 7:04 PM
 * To change this template use File | Settings | File Templates.
 */
public class GameGrid {

  enum GAMEMODE {
    CLASSIC, SUPERDUPER, HARDCORE;
  }

  //classic gamegrid is 5x5
  public static final int HORIZONTAL_TILES = 5;
  public static final int VERTICAL_TILES = 5;


  int screenWidth;
  int screenHeight;

  Tile[][] gridMap;


  public GameGrid(int screenWidth, int screenHeight) {
    this.screenWidth = screenWidth;
    this.screenHeight = screenHeight;

    initGrid();
    populateGrid();
  }



  private void initGrid() {
    int widthOfTile = screenWidth/HORIZONTAL_TILES;
    int heightOfTile = screenHeight/VERTICAL_TILES;
    gridMap = new Tile[HORIZONTAL_TILES][VERTICAL_TILES];

    for(int i = 0; i < HORIZONTAL_TILES; i++){
      for(int j = 0; j < VERTICAL_TILES; j++){
        gridMap[i][j] = new Tile(widthOfTile*i, heightOfTile*j);
      }
    }

  }

  private void populateGrid() {
    for(int i = 0; i < HORIZONTAL_TILES; i++){
      for(int j = 0; j < VERTICAL_TILES; j++){
        Tile tile = gridMap[i][j];
        if (i == 4) {
          tile.setNumberOfSheep(4);
        }
        else if (i == 3 && (j == 0 || j == 4)) {
          tile.setWolf(true);
        }
      }
    }
  }

  private void populateClassicGrid() {

  }

  public Tile getTile(int xPos, int yPos) {
    return null;
  }


  public Tile[][] getGridMap() {
    return gridMap;
  }


}
