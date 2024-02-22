package view;

import java.util.List;

public class OutputView {

    public static void printResult(List<String> results) {
        System.out.println("실행결과");
        System.out.println();
        results.forEach(System.out::println);
    }
}
