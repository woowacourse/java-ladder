package calculator;

import java.util.Scanner;

public class CalculatorApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(Calculator.sumString(Calculator.splitString(scanner.nextLine())));
    }
}
