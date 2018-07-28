package com.sealstudios.javalib;

import java.util.ArrayList;
import java.util.Random;

public class myClass {

    private ArrayList<String> jokes;
    private Random random;

    public myClass() {
        jokes = new ArrayList<>();
        jokes.add("Venisons deer isn't it");
        jokes.add("2 Sausages in a frying pan, one turns to the other and says \"Cor its hot in here\" the other says \"Oh my god a talking sausage!\"");
        jokes.add("Q : Where does a king keep his armies? \nA : Up his sleevies");
        random = new Random();
    }

    public ArrayList<String> getJokesList() {
        return jokes;
    }

    public String getRandomJoke() {
        Random r = new Random();
        int Low = 0;
        int High = 2;
        final int Result = r.nextInt(High-Low) + Low;
        return jokes.get(Result);
    }

}
