package com.example.misbahulard.bottomnavigationexample.model;

/**
 * Created by Faza Zulfika P P on 9/20/2017.
 */

public class SegitigaSamaKaki extends Segitiga {

    private double sisiMiring;

    public SegitigaSamaKaki() {
        super();
    }

    public SegitigaSamaKaki(double alas, double tinggi) {
        this(alas, tinggi, Math.sqrt(Math.pow((alas / 2), 2) + Math.pow(tinggi, 2)));
    }

    public SegitigaSamaKaki(double alas, double tinggi, double sisiMiring) {
        super(alas, tinggi);
        this.sisiMiring = sisiMiring;
    }

    public double getSisiMiring() {
        return sisiMiring;
    }

    public void setSisiMiring(double sisiMiring) {
        this.sisiMiring = sisiMiring;
    }

    @Override
    public double keliling() {
        return getAlas() + (sisiMiring * 2);
    }

    @Override
    public double luas() {
        return (getAlas() * getTinggi()) / 2;
    }
}
