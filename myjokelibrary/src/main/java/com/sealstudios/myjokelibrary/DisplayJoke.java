package com.sealstudios.myjokelibrary;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.sealstudios.myjokelibrary.Utils.Constants;

/**
 * Created by marti on 27/07/2018.
 */

public class DisplayJoke extends AppCompatActivity {
    String joke;
    TextView jokeTextView;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.display_joke_layout);
        Bundle data = getIntent().getExtras();
        jokeTextView = findViewById(R.id.joke_text);
        if (data != null){
            joke = data.getString(Constants.JOKE_INTENT);
            jokeTextView.setText(joke);
        }
    }
}
