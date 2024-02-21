package view;

import java.util.List;

public class OutputView {

    public void printLadder(List<String> ladder) {
        System.out.println(String.join("\n", ladder));
    }
}
