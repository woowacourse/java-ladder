package calculator;

import java.util.Scanner;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);

    public static String inputFormula(){
        System.out.println("수식을 입력하세요 : ");
        return scanner.nextLine();
    }
}
