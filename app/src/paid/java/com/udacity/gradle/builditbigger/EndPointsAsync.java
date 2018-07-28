package com.udacity.gradle.builditbigger;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v4.util.Pair;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.extensions.android.json.AndroidJsonFactory;
import com.sealstudios.javalib.myClass;
import com.sealstudios.myjokelibrary.DisplayJoke;
import com.udacity.gradle.builditbigger.Utils.Constants;
import com.udacity.gradle.builditbigger.backend.myApi.MyApi;

import java.io.IOException;

/**
 * Created by marti on 28/07/2018.
 */
class EndPointsAsync extends AsyncTask<Context, Void, String> {
    private static MyApi myApiService = null;
    private Context mContext;
    private String mResult;
    private ProgressBar mProgressBar;

    public EndPointsAsync(Context context, ProgressBar progressBar) {
        this.mContext = context;
        this.mProgressBar = progressBar;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        if (mProgressBar != null) {
            mProgressBar.setVisibility(View.VISIBLE);
        }
    }

    @Override
    protected String doInBackground(Context... params) {
        if (myApiService == null) {
            MyApi.Builder builder = new MyApi.Builder(AndroidHttp.newCompatibleTransport(),
                    new AndroidJsonFactory(), null)
                    .setRootUrl("http://10.0.2.2:8080/_ah/api/");
            myApiService = builder.build();
        }
        try {
            //return myApiService.sayHi(name).execute().getData();
            return myApiService.setJoke().execute().getData();
        } catch (IOException e) {
            return e.getMessage();
        }
    }

    @Override
    protected void onPostExecute(String result) {
        super.onPostExecute(result);
        mResult = result;
        mProgressBar.setVisibility(View.GONE);
        startJokeActivity(mResult);
    }

    private void startJokeActivity(String joke) {
        Toast.makeText(mContext,joke,Toast.LENGTH_SHORT).show();
        Intent i = new Intent(mContext, DisplayJoke.class);
        Bundle b = new Bundle();
        b.putString(Constants.JOKE_INTENT,joke);
        i.putExtras(b);
        mContext.startActivity(i);
    }

}
