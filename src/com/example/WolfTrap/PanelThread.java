package com.example.WolfTrap;

import android.graphics.Canvas;
import android.view.SurfaceHolder;

/**
 * Created with IntelliJ IDEA.
 * User: Siamek
 * Date: 8/2/13
 * Time: 6:37 PM
 * To change this template use File | Settings | File Templates.
 */


  class PanelThread extends Thread {
  private SurfaceHolder surfaceHolder;
  private DrawingPanel panel;
  private boolean run = false;


  public PanelThread(SurfaceHolder surfaceHolder, DrawingPanel panel) {
    this.surfaceHolder = surfaceHolder;
    this.panel = panel;
  }


  public void setRunning(boolean run) { //Allow us to stop the thread
    this.run = run;
  }


  @Override
  public void run() {
    Canvas c;
    while (run) {     //When setRunning(false) occurs, run is
      c = null;      //set to false and loop ends, stopping thread
      try {
        c = surfaceHolder.lockCanvas(null);
        synchronized (surfaceHolder) {
          //Insert methods to modify positions of items in onDraw()
          panel.postInvalidate();
        }
      } finally {
        if (c != null) {
          surfaceHolder.unlockCanvasAndPost(c);
        }
      }
    }
  }
}
