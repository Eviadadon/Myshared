package com.example.myshared;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

public class credits extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_credits);
    }

    /**
     *  creates the menu
     */

    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.main,menu);
        return true;
    }

    /**
     * this method get working the menu and moves to the main activity.
     * @param item - the choices item
     */

    public boolean onOptionsItemSelected(MenuItem item){
        String st=item.getTitle().toString();
        if (st.equals("back")){
            finish();
        }
        return true;

    }
}