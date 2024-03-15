
/*
Online Java - IDE, Code Editor, Compiler

Online Java is a quick and easy tool that helps you to build, compile, test your programs online.
*/

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите число a: ");
        double a = scanner.nextDouble();

        System.out.print("Введите число b: ");
        double b = scanner.nextDouble();

        double max = Math.max(a, b);
        double min = Math.min(a, b);

        double sqrtMax = Math.sqrt(max);

        double numerator = min - 2 * sqrtMax;
        double denominator = 1 + (max / min);

        double d = numerator / denominator;

        System.out.println("Наибольшее число: " + max);
        System.out.println("Наименьшее число: " + min);
        System.out.println("Значение дроби d: " + d);

        scanner.close();
    }
}