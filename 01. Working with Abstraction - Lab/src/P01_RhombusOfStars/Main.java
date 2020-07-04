package P01_RhombusOfStars;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        printFigure(Integer.parseInt(console.nextLine()));

    }

    private static void printFigure(int n) {
        StringBuilder out = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            out.append(generateRow(n - i, i));
        }
        for (int i = 1; i < n; i++) {
            out.append(generateRow(i, n - i));
        }
        System.out.println(out);
    }

    private static String generateRow(int i, int n) {
        return repeatString(" ", i) +
                repeatString("* ", n) +
                System.lineSeparator();
    }

    private static String repeatString(String str, int n) {
        return str.repeat(n);
    }
}
