package view;

import java.util.List;

public class OutputView {

    public void printNames(List<String> names) {
        for (String name : names) {
            System.out.printf("%5s ", name);
        }
        System.out.println();
    }
}
