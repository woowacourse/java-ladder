package view;

import java.util.List;

public class OutputView {

    public static void printLadder(List<String> results) {
        System.out.println();
        System.out.println("사다리 결과");
        System.out.println();
        results.forEach(System.out::println);
    }

    public static void printResult(List<String> results) {
        System.out.println();
        System.out.println("실행 결과");
        results.forEach(System.out::println);
    }

    public static void printError(String errorMessage) {
        System.out.println(errorMessage);
    }
}
