package com.example.myshared;


import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    TextView count;
    int x=0;
    int z;
    EditText ed;
    String name;
    Intent si;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        count=(TextView) findViewById(R.id.count);
        ed=(EditText) findViewById(R.id.ed);

        SharedPreferences settings= getSharedPreferences("prefs_name", MODE_PRIVATE);
        z=settings.getInt("z", -10);
        name=settings.getString("name", "");
        ed.setText(name);
        if(z==-10)
            Toast.makeText(this, "an error was found in the shared files", Toast.LENGTH_SHORT).show();
        else {
            count.setText("this is click number:"+z);
            x=z;
        }
    }

    /**
     * creates the menu.
     */
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    /**
     * when the credits button will be clicked , it will jump the credits activity.
     */
    public boolean onOptionsItemSelected(MenuItem item) {
        String st = item.getTitle().toString();
        if (st.equals("credits")) {
            si = new Intent(this, credits.class);
            startActivity(si);
        }
        return true;
    }

    public void count(View view) {
        x++;
        count.setText("this is click number:"+x);
    }

    public void reset(View view) {
        x=0;
        count.setText("click's count");
    }

    public void exit(View view) {
        String name=ed.getText().toString();
        SharedPreferences settings= getSharedPreferences("prefs_name", MODE_PRIVATE);
        SharedPreferences.Editor editor= settings.edit();
        editor.putInt("z", x);
        editor.putString("name",name);
        editor.commit();
        finish();
    }
}