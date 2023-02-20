package ladder.view;

import ladder.domain.Foothold;

import java.util.List;
import java.util.stream.Collectors;
import ladder.domain.Row;

public class ResultView {
    private static final String ERROR_MESSAGE_HEADER = "[ERROR] ";

    public void printNames(List<String> names) {
        for (String name : names) {
            System.out.print(String.format("%6s", name));
        }
        System.out.println();
    }

    public void printLadder(List<Row> ladder) {
        ladder.stream()
                .map(Row::getRow)
                .map(this::generateRow)
                .forEach(System.out::println);
    }

    protected String generateRow(List<Foothold> row) {
        return row.stream()
                .map(Foothold::getMark)
                .collect(Collectors.joining("|", "     |", "|"));
    }

    public void printErrorMessage(String message) {
        System.out.println(ERROR_MESSAGE_HEADER + message);
    }
}
