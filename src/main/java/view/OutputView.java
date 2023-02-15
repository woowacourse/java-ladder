package view;

import java.util.List;

public class OutputView {

    public static void printUserNames(List<String> userNames) {
        String parsedUserNames = String.join(" ", userNames);
        System.out.println(parsedUserNames);
    }
}
