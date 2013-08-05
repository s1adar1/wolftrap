package com.example.WolfTrap;

import android.app.Activity;
import android.os.Bundle;

/**
 * Created with IntelliJ IDEA.
 * User: Siamek
 * Date: 8/2/13
 * Time: 6:26 PM
 * To change this template use File | Settings | File Templates.
 */
public class GameActivity extends Activity {

  public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    DrawingPanel drawingPanel = new DrawingPanel(this);
    setContentView(drawingPanel);
  }




}