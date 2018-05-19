package com.andrea.jokelib;

import java.util.Random;

public class Joke {

    private final String[] jokes = {"Why do seagulls live by the sea?\n"+"Because if they lived by the bay they'd be bagels!",
                                    "My mom told me to follow my dreams, so I went back to sleep.",
                                    "My boss told me to have a good day.\n" + "So I went home."};

    public String getLaughs() {
        return jokes[new Random().nextInt(jokes.length)];
    }

}
