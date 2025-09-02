package com.example.bisection.controller;

import com.example.bisection.service.Iteracao;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
public class BisectionController {

    @GetMapping("/bissecao")
    public String index() {
        return "bisection-form";
    }

    @PostMapping("/calcular")
    public String calcular(@RequestParam double a,
                           @RequestParam double b,
                           @RequestParam double c,
                           @RequestParam int exp,
                           @RequestParam double li,
                           @RequestParam double ls,
                           @RequestParam double prec,
                           Model model) {

        double xa = li, xb = ls;
        double erro = xb - xa;
        int iter = 1;
        List<Iteracao> iteracoes = new ArrayList<>();

        while (erro > prec) {
            double xn = (xa + xb) / 2;
            double fa = f(a, b, c, exp, xa);
            double fb = f(a, b, c, exp, xb);
            double fn = f(a, b, c, exp, xn);

            iteracoes.add(new Iteracao(iter, xa, fa, xb, fb, xn, fn, erro));

            if (fa * fn < 0) xb = xn; else xa = xn;

            erro = xb - xa;
            iter++;
        }

        model.addAttribute("raiz", (xa + xb) / 2);
        model.addAttribute("iteracoes", iteracoes);
        return "bisection-result";
    }

    private double f(double a, double b, double c, int exp, double x) {
        return Math.pow((a * x), exp) + (b * x) + c;
    }
}
