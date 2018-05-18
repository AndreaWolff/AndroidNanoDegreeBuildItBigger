package com.andrea.punchline;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.andrea.jokes.Jokes;

public class PunchLineActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_punch_line);

        TextView textView = findViewById(R.id.textview);

        Jokes jokes = new Jokes();
        textView.setText(jokes.getJoke());
    }
}
