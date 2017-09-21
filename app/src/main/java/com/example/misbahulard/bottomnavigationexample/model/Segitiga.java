package com.example.misbahulard.bottomnavigationexample.model;

/**
 * Created by Faza Zulfika P P on 9/20/2017.
 */

public abstract class Segitiga extends Bangun {

    private double alas, tinggi;

    public Segitiga() {}

    public Segitiga(double alas, double tinggi) {
        this.alas = alas;
        this.tinggi = tinggi;
    }

    public double getAlas() {
        return alas;
    }

    public void setAlas(double alas) {
        this.alas = alas;
    }

    public double getTinggi() {
        return tinggi;
    }

    public void setTinggi(double tinggi) {
        this.tinggi = tinggi;
    }
}
