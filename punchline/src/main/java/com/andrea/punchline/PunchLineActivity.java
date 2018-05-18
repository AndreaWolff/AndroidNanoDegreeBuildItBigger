package com.andrea.punchline;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class PunchLineActivity extends AppCompatActivity {

    private static final String EXTRAS_JOKE = "JOKE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_punch_line);

        TextView textView = findViewById(R.id.textview);

        Bundle extras = getIntent().getExtras();

        if (extras != null) {
            String joke = extras.getString(EXTRAS_JOKE);
            textView.setText(joke);
        } else {
            finish();
        }
    }

}
