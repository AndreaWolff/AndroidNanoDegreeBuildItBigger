package com.udacity.gradle.builditbigger;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ProgressBar;

import com.andrea.punchline.PunchLineActivity;

import static android.view.View.VISIBLE;

@SuppressWarnings("unchecked")
public class MainActivity extends AppCompatActivity {

    private static final String EXTRAS_JOKE = "JOKE";

    private ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        progressBar = findViewById(R.id.progressBar);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        return id == R.id.action_settings || super.onOptionsItemSelected(item);
    }

    @SuppressLint("StaticFieldLeak")
    public void tellJoke(View view) {
        progressBar.setVisibility(VISIBLE);

        new EndpointsAsyncTask() {
            @Override
            protected void onPostExecute(String result) {
                progressBar.setVisibility(View.GONE);

                Intent intent = new Intent(getApplicationContext(), PunchLineActivity.class);
                intent.putExtra(EXTRAS_JOKE, result);
                getApplicationContext().startActivity(intent);
            }
        }.execute();
    }

}
