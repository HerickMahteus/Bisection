import java.util.Scanner;

public class Gauss {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.print("Linhas/colunas: ");
        int length = scanner.nextInt();
        double[][] a = new double[length][length];

        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a.length; j++) {
                System.out.print("a" + i + "" + j + " = ");
                a[i][j] = scanner.nextDouble();
            }
        }
    }
}
