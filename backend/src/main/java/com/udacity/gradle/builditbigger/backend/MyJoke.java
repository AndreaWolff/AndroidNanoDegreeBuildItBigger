package com.udacity.gradle.builditbigger.backend;

import com.andrea.jokelib.Joke;

/** The object model for the data we are sending through endpoints */
public class MyJoke {

    MyJoke() {
    }

    public String getJoke() {
        return new Joke().getLaughs();
    }
}