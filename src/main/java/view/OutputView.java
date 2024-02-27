package view;

import java.util.List;
import java.util.Map;

public class OutputView {
    public static void printLadder(List<String> results) {
        System.out.println();
        System.out.println("사다리 결과");
        System.out.println();
        results.forEach(System.out::println);
    }

    public static void printResultByPerson(String result) {
        System.out.println();
        System.out.println("실행 결과");
        System.out.println(result);
    }

    public static void printResultByAll(Map<String, String> results) {
        System.out.println();
        System.out.println("실행 결과");
        for (Map.Entry<String, String> entry : results.entrySet()) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }
    }

    public static void printErrorMessage(Exception e) {
        System.out.println(e.getMessage());
    }
}
