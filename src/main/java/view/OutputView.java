package view;

import java.util.List;
import java.util.StringJoiner;

public class OutputView {

    private static final String NAME_DELIMITER = " ";
    public void printPlayers(List<String> names) {
        StringJoiner nameJoiner = new StringJoiner(NAME_DELIMITER);
        for (final String name : names) {
            nameJoiner.add(String.format("%5s", name));
        }
        System.out.println(nameJoiner);
    }
}
