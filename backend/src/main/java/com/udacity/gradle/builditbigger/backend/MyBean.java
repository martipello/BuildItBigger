package com.udacity.gradle.builditbigger.backend;

import java.util.ArrayList;

/** The object model for the data we are sending through endpoints */
public class MyBean {

    private String joke;
    private ArrayList<String> jokes;

    public String getData() {
        return joke;
    }

    public void setData(String data) {
        joke = data;
    }

    public ArrayList<String> getAllData() {
        return jokes;
    }

    public void setAllData(ArrayList<String> data) {
        jokes = data;
    }
}