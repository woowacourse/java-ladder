package view;

import java.util.List;
import java.util.Scanner;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);

    public static List<String> getNames() {
        printNameInputGuide();
        String input = scanner.nextLine();
        return Parser.split(input);
    }

    private static void printNameInputGuide() {
        System.out.println("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");
    }

    public static int getHeight() {
        printHeightInputGuide();
        String input = scanner.nextLine();
        return Parser.parseHeight(input);
    }

    private static void printHeightInputGuide() {
        System.out.println();
        System.out.println("최대 사다리 높이는 몇 개인가요?");
    }

    public static List<String> getResults() {
        printResultsInputGuide();
        String input = scanner.nextLine();
        return Parser.split(input);
    }

    private static void printResultsInputGuide() {
        System.out.println();
        System.out.println("실행 결과를 입력하세요. (결과는 쉼표(,)로 구분하세요)");
    }
}
