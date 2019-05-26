package calculator;

import java.util.Scanner;

public class CalculatorApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] values = Calculator.splitString(scanner.nextLine());

        Calculator.checkCorrectValue(values);

        System.out.println(Calculator.sumValues(values));
    }
}
