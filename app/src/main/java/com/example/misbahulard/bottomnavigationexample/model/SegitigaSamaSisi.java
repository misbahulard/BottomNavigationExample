package com.example.misbahulard.bottomnavigationexample.model;

/**
 * Created by Faza Zulfika P P on 9/20/2017.
 */

public class SegitigaSamaSisi extends Segitiga {

    public SegitigaSamaSisi() {
        super();
    }

    public SegitigaSamaSisi(double alas, double tinggi) {
        super(alas, tinggi);
    }

    @Override
    public double keliling() {
        return getAlas() * 3;
    }

    @Override
    public double luas() {
        return (getAlas() * getTinggi()) / 2;
    }
}
