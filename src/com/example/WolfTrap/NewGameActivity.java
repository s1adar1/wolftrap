package com.example.WolfTrap;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
//import android.support.v4.app.NavUtils;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

/**
 * Created with IntelliJ IDEA.
 * User: Siamek
 * Date: 7/19/13
 * Time: 9:53 PM
 * To change this template use File | Settings | File Templates.
 */
public class NewGameActivity extends Activity {
  public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.new_game);

    //use app icon as back button - profit?
    ActionBar actionBar = getActionBar();
    actionBar.setDisplayHomeAsUpEnabled(true);
    actionBar.setDisplayShowTitleEnabled(false);
  }

  @Override
  public boolean onCreateOptionsMenu(Menu menu) {
    MenuInflater inflater = getMenuInflater();
    inflater.inflate(R.menu.new_game_menu, menu);
    return true;
  }

  @Override
  public boolean onOptionsItemSelected(MenuItem item) {

    if(item.getTitle().equals(getString(R.string.new_game))){
      newGame(item);
    }
    return super.onOptionsItemSelected(item);
  }

  private void newGame(MenuItem item) {
    System.out.println("NEW GAME");
    Intent intent = new Intent(this, GameActivity.class);
    startActivity(intent);
  }


}