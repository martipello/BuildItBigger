package com.udacity.gradle.builditbigger;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v4.app.Fragment;
import android.support.v4.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ProgressBar;

/**
 * A placeholder fragment containing a simple view.
 */
public class MainActivityFragment extends Fragment {

    Button jokeButton;


    public MainActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_main, container, false);
        jokeButton = root.findViewById(R.id.jokeButton);
        jokeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ProgressBar progressBar = (ProgressBar) getActivity().findViewById(R.id.progress);
                String joke = new EndPointsAsync(getActivity().getApplicationContext(),progressBar).execute().get();
                startJokeActivity(joke);
            }
        });
        return root;
    }
    private void startJokeActivity(String joke) {
        Intent i = new Intent(getActivity(), DisplayJoke.class);
        Bundle b = new Bundle();
        b.putString(Constants.JOKE_INTENT,joke);
        i.putExtras(b);
        getActivity().getApplication().startActivity(i);
    }
}
