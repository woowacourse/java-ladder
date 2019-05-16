package ladder.view;

import java.util.List;

public class OutputView {
    public static void printLadder(List<String> ladder, String names, String resultCandidate) {
        printNames(names);
        for (String s : ladder) {
            System.out.println(s);
        }
        printResultCandidate(resultCandidate);
    }

    private static void printNames(String names) {
        System.out.println(names);
    }

    private static void printResultCandidate(String resultCandidate) {
        System.out.println(resultCandidate);
    }
}
