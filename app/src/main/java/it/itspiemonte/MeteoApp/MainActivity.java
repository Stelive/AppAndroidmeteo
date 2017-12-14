package it.itspiemonte.MeteoApp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {
    ArrayList articleNames = new ArrayList<>(Arrays.asList("Torino", "Milano", "Roma", "Trieste"));
    ArrayList stateList = new ArrayList<>(Arrays.asList("Piovoso", "Soleggiato", "Neve", "Tranquillo"));
    ArrayList tempMax = new ArrayList<>(Arrays.asList("9", "13", "10", "7"));
    ArrayList tempMin = new ArrayList<>(Arrays.asList("-3", "-7", "0", "-1"));

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recycler);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(linearLayoutManager);
        CompitinoAdapter adapter = new CompitinoAdapter(this, articleNames, stateList, tempMax, tempMin);
        recyclerView.setAdapter(adapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menu_item_1:
                Log.d("NEWS APP", "Hai premuto il primo tasto");
                return true;
            case R.id.menu_item_2:
                Log.d("NEWS APP", "Hai premuto il secondo tasto");
                return true;
            default:
                return  super.onOptionsItemSelected(item);
        }
    }
}
