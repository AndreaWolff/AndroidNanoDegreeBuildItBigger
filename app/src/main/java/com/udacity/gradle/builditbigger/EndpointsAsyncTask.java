package com.udacity.gradle.builditbigger;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.AsyncTask;
import android.util.Pair;

import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.extensions.android.json.AndroidJsonFactory;
import com.google.api.client.googleapis.services.AbstractGoogleClientRequest;
import com.google.api.client.googleapis.services.GoogleClientRequestInitializer;
import com.udacity.gradle.builditbigger.backend.jokeApi.JokeApi;

import java.io.IOException;

@SuppressLint("StaticFieldLeak")
public class EndpointsAsyncTask extends AsyncTask<Pair<Context, String>, Void, String> {

    private JokeApi jokeApiService = null;

    @SafeVarargs
    @Override
    protected final String doInBackground(Pair<Context, String>... params) {
        if (jokeApiService == null) {
            JokeApi.Builder builder = new JokeApi.Builder(AndroidHttp.newCompatibleTransport(),
                    new AndroidJsonFactory(), null)
                    // options for running against local devappserver
                    // - 10.0.2.2 is localhost's IP address in Android emulator
                    // - turn off compression when running against local devappserver
                    .setRootUrl("http://10.0.2.2:8080/_ah/api/")
                    .setGoogleClientRequestInitializer(new GoogleClientRequestInitializer() {
                        @Override
                        public void initialize(AbstractGoogleClientRequest<?> abstractGoogleClientRequest) {
                            abstractGoogleClientRequest.setDisableGZipContent(true);
                        }
                    });

            jokeApiService = builder.build();
        }

        try {
            return jokeApiService.getJoke().execute().getJoke();
        } catch (IOException e) {
            return e.getMessage();
        }
    }
}
