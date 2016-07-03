package com.inja.inja2.activities.main;

import android.location.Location;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

import com.inja.inja2.InjaApplication;
import com.inja.inja2.R;
import com.inja.inja2.model.InjaSpot;
import com.inja.inja2.modules.SpotService;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.inject.Inject;


public class MainActivity extends AppCompatActivity implements ISpotCrud {

    /**
     * Holder for the main fragment.
     */
    private SpotsFragment spotsFragment;

    @Inject
    SpotService spotService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        InjaApplication.ComponentSingleton.getGraphComponent().inject(this);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        if ( spotsFragment == null ){
            spotsFragment = new SpotsFragment();
        }
        getSupportFragmentManager().beginTransaction().add(R.id.fragment_holder, spotsFragment).commit();
    }

    @Override
    protected void onPostResume() {
        super.onPostResume();
    }

    @Override
    protected void onDestroy() {
//        getSupportFragmentManager().beginTransaction().remove(mainActivityFragment).commit();
        super.onDestroy();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void addInjaSpot(InjaSpot spot) {
        
    }

    @Override
    public void getSpots(Location location) {
        //spotService.getSpots(convertLocation(location));
    }

    private Map<String, String> convertLocation(Location location) {
        return null;
    }

    @Override
    public void voteUp(InjaSpot spot) {

    }
}
