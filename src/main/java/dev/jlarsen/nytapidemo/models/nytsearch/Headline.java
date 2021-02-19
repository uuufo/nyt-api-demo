package dev.jlarsen.nytapidemo.models.nytsearch;

public class Headline {

    private String main;

    public Headline(String main) {
        this.main = main;
    }

    public String getMain() {
        return main;
    }

    public void setMain(String main) {
        this.main = main;
    }
}
