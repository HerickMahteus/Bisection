package com.example.bisection.service;

import java.util.Scanner;

public class Bisection {
    static Scanner scanner = new Scanner(System.in);

    static double a, b, c, prec;
    static int exp;

    static double f(double x) {
        return Math.pow((a * x), exp) + (b * x) + c;
    }

    public static void main(String[] args) {
        System.out.print("a = ");
        a = scanner.nextDouble();
        System.out.print("b = ");
        b = scanner.nextDouble();
        System.out.print("c = ");
        c = scanner.nextDouble();
        System.out.print("Expoente = ");
        exp = scanner.nextInt();
        System.out.print("Precisão = ");
        prec = scanner.nextDouble();

        System.out.println("\nFunção: f(x) = " + a + "x^" + exp + " + " + b + "x + " + c + "\n");

        System.out.print("Limite inferior = ");
        double li = scanner.nextDouble();
        System.out.print("Limite superior = ");
        double ls = scanner.nextDouble();

        System.out.println("\nf(" + li + ") = " + f(li));
        System.out.println("f(" + ls + ") = " + f(ls));

        if (f(li) * f(ls) >= 0) {
            System.out.println("\nErro: f(a) e f(b) têm o mesmo sinal.");
            return;
        }

        System.out.println("\nIterações:");
        double xa = li;
        double xb = ls;
        double erro = xb - xa;
        int iter = 1;

        while (erro > prec) {
            double xn = (xa + xb) / 2;
            double fa = f(xa);
            double fn = f(xn);

            System.out.println(iter + ") Xa = " + xa + " | f(a) = " + fa +
                    " | Xb = " + xb + " | f(b) = " + f(xb) +
                    " | Xn = " + xn + " | f(n) = " + fn +
                    " | Erro: " + erro);

            if (fa * fn < 0) {
                xb = xn;
            } else {
                xa = xn;
            }

            erro = xb - xa;
            iter++;
        }

        double raiz = (xa + xb) / 2;
        System.out.println("\nAproximação da raiz: " + raiz);
        System.out.println("Erro final: " + erro);
    }
}
