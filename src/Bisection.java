import java.util.Scanner;

public class Bisection {
    static Scanner scanner = new Scanner(System.in);

    static double a, b, c;
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

        System.out.println("");
        System.out.println("f(x) = " + a + "x^" + exp + " + " + b + "x + " + c);
        System.out.println("");

        System.out.print("Limite inferior = ");
        double li = scanner.nextDouble();
        System.out.print("Limite superior = ");
        double ls = scanner.nextDouble();

        System.out.println("");

        System.out.println("f(" + li + ") = " + f(li));
        System.out.println("f(" + ls + ") = " + f(ls));

        System.out.println("");

        if (f(li) * f(ls) >= 0) {
            System.out.println("f(a) e f(b) têm sinais iguais.");
        }
    }
}
