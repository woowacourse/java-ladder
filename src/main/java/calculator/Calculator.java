package calculator;


public class Calculator {
    public static void main(String[] args) {
        String inputNumber = "1,2:4,3";
        StringCalculator stringCalculator = new StringCalculator();

        int resultNumber = stringCalculator.add(inputNumber);
        System.out.println(resultNumber);
    }
}
