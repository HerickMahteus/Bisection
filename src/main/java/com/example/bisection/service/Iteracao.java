package com.example.bisection.service;

public class Iteracao {
    private int numero;
    private double xa;
    private double fa;
    private double xb;
    private double fb;
    private double xn;
    private double fn;
    private double erro;

    public Iteracao(int numero, double xa, double fa, double xb, double fb, double xn, double fn, double erro) {
        this.numero = numero;
        this.xa = xa;
        this.fa = fa;
        this.xb = xb;
        this.fb = fb;
        this.xn = xn;
        this.fn = fn;
        this.erro = erro;
    }

    public int getNumero() { return numero; }
    public double getXa() { return xa; }
    public double getFa() { return fa; }
    public double getXb() { return xb; }
    public double getFb() { return fb; }
    public double getXn() { return xn; }
    public double getFn() { return fn; }
    public double getErro() { return erro; }
}
