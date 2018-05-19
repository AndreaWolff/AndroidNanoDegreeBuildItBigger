package com.udacity.gradle.builditbigger;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ProgressBar;

import com.andrea.punchline.PunchLineActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

import static android.view.View.GONE;
import static android.view.View.VISIBLE;

@SuppressWarnings("unchecked")
public class MainActivity extends AppCompatActivity {

    private static final String EXTRAS_JOKE = "JOKE";

    @BindView(R.id.progressBar) ProgressBar progressBar;

    @SuppressLint("StaticFieldLeak")
    @OnClick(R.id.tellAJoke_button)
    public void onTellAJokeSelected() {
        progressBar.setVisibility(VISIBLE);

        new EndpointsAsyncTask() {
            @Override
            protected void onPostExecute(String result) {
                progressBar.setVisibility(GONE);

                Intent intent = new Intent(getApplicationContext(), PunchLineActivity.class);
                intent.putExtra(EXTRAS_JOKE, result);
                getApplicationContext().startActivity(intent);
            }
        }.execute();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);
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
}
