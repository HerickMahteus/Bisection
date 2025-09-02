package com.example.bisection.controller;

import com.example.bisection.service.Gauss;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/gauss")
public class GaussController {

    @GetMapping
    public String form() {
        return "gauss-form";
    }

    @PostMapping
    public String solve(
            @RequestParam("n") int n,
            @RequestParam("matrix") String matrixInput,
            @RequestParam("vector") String vectorInput,
            Model model
    ) {
        double[][] A = new double[n][n];
        double[] B = new double[n];

        String[] rows = matrixInput.split(";");
        for (int i = 0; i < n; i++) {
            String[] values = rows[i].trim().split("\\s+");
            for (int j = 0; j < n; j++) {
                A[i][j] = Double.parseDouble(values[j]);
            }
        }

        String[] bValues = vectorInput.trim().split("\\s+");
        for (int i = 0; i < n; i++) {
            B[i] = Double.parseDouble(bValues[i]);
        }

        double[] solution = Gauss.solve(A, B);

        model.addAttribute("solution", solution);
        return "gauss-result";
    }
}
