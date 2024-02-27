package view;

import java.util.List;

public class OutputView {

    public static void printLadder(List<String> results) {
        System.out.println("사다리 결과");
        System.out.println();
        results.forEach(System.out::println);
    }
}
