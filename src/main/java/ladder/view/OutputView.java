package ladder.view;

import java.util.List;

public class OutputView {
    public static void printLadder(List<String> ladder) {
        for (String s : ladder) {
            System.out.println(s);
        }
    }

    public static void printNames(String names) {
        System.out.println(names);
    }
}
