package ru.dexsys.entity;


public class Wine extends Alcohol {
    public Wine(double alcoholByVolume2) {
        super(alcoholByVolume2);
    }


    @Override
    public String toString() {
        return "It's wine! Tasty))";
    }
}
