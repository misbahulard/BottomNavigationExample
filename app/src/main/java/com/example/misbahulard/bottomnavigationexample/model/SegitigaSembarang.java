package com.example.misbahulard.bottomnavigationexample.model;

/**
 * Created by Faza Zulfika P P on 9/20/2017.
 */

public class SegitigaSembarang extends Segitiga {

    private double sisiKanan, sisiKiri;

    public SegitigaSembarang() {
        super();
    }

    public SegitigaSembarang(double sisiKanan, double sisiKiri, double alas, double tinggi) {
        super(alas, tinggi);

        this.sisiKanan = sisiKanan;
        this.sisiKiri = sisiKiri;
    }

    public double getSisiKanan() {
        return sisiKanan;
    }

    public void setSisiKanan(double sisiKanan) {
        this.sisiKanan = sisiKanan;
    }

    public double getSisiKiri() {
        return sisiKiri;
    }

    public void setSisiKiri(double sisiKiri) {
        this.sisiKiri = sisiKiri;
    }

    @Override
    public double keliling() {
        return sisiKanan + sisiKiri + getAlas();
    }

    @Override
    public double luas() {
        double s = keliling() / 2;
        return Math.sqrt(s * (s - getAlas()) * (s - sisiKanan) * (s - sisiKiri));
    }
}
