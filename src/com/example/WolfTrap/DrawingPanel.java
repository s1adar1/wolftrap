package com.example.WolfTrap;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import static com.example.WolfTrap.GameGrid.*;

/**
 * Created with IntelliJ IDEA.
 * User: Siamek
 * Date: 8/2/13
 * Time: 6:33 PM
 * To change this template use File | Settings | File Templates.
 */
public class DrawingPanel extends SurfaceView implements SurfaceHolder.Callback {

  PanelThread thread;
  Bitmap bitmap;
  Paint paint;
  GameGrid gameGrid;
  private Bitmap wolf;
  private Bitmap sheep;

  public DrawingPanel(Context context) {
    super(context);
    getHolder().addCallback(this);
  }


  @Override
  public void onDraw(Canvas canvas) {
    //do drawing stuff here.
    canvas.drawBitmap(bitmap, 0, 0, paint);
    Tile[][] gridMap = gameGrid.getGridMap();
    drawMap(canvas, gridMap);
  }

  private void drawMap(Canvas canvas, Tile[][] gridMap) {
    for(int i = 0; i < HORIZONTAL_TILES; i++){
      for(int j = 0; j < VERTICAL_TILES; j++){
        Tile tile = gridMap[i][j];
        if (tile.isWolf()) {
          canvas.drawBitmap(wolf, tile.getX(), tile.getY(), paint);
        }
        else if(tile.isSheep()){
          canvas.drawBitmap(sheep, tile.getX(), tile.getY(), paint);
        }

      }
    }
  }

  @Override
  public void surfaceCreated(SurfaceHolder holder) {
    init();

    setWillNotDraw(false); //Allows us to use invalidate() to call onDraw()

    thread = new PanelThread(getHolder(), this); //Start the thread that
    thread.setRunning(true);                     //will make calls to 
    thread.start();                              //onDraw()
  }

  private void init() {

    paint = new Paint();
    gameGrid = new GameGrid(480, 800);
    initBitmaps();
    bitmap =  BitmapFactory.decodeResource(getResources(), R.drawable.grass);
    bitmap = Bitmap.createScaledBitmap(bitmap, 480, 800, true);
  }

  private void initBitmaps() {
    wolf =  BitmapFactory.decodeResource(getResources(), R.drawable.wolf);
    wolf = Bitmap.createScaledBitmap(wolf, 50, 50, true);
    sheep =  BitmapFactory.decodeResource(getResources(), R.drawable.sheep);
    sheep = Bitmap.createScaledBitmap(sheep, 50, 50, true);
  }


  @Override
  public void surfaceDestroyed(SurfaceHolder holder) {
    try {
      thread.setRunning(false);                //Tells thread to stop
      thread.join();                           //Removes thread from mem.
    } catch (InterruptedException e) {}
  }

  @Override
  public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {
    //To change body of implemented methods use File | Settings | File Templates.
  }


}



