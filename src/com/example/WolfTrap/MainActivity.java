package com.example.WolfTrap;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import static com.example.WolfTrap.R.*;

public class MainActivity extends Activity {

  /**
   * Called when the activity is first created.
   */
  @Override
  public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(layout.main);
    getActionBar().setDisplayShowTitleEnabled(false);
  }

  @Override
  public boolean onCreateOptionsMenu(Menu menu) {
    MenuInflater inflater = getMenuInflater();
    inflater.inflate(R.menu.main_menu, menu);
    return true;
  }

  public void newGame(MenuItem menuItem){
    //handle new game button click
    System.out.println("NEW GAME");
    Intent intent = new Intent(this, NewGameActivity.class);
    startActivity(intent);
  }

  @Override
  public boolean onOptionsItemSelected(MenuItem item) {
    System.out.println("OPTIONS SELECTED");
    if(item.getTitle().equals(getString(string.new_game))){
      newGame(item);
    }

    return true;
  }
}
