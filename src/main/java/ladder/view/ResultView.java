package ladder.view;

import ladder.domain.Foothold;

import java.util.List;

import static java.util.stream.Collectors.joining;

public class ResultView {
    private static final String ERROR_MESSAGE_HEADER = "[ERROR] ";

    public void printPlayersName(List<String> names) {
        for (String name : names) {
            System.out.printf("%6s", name);
        }
        System.out.println();
    }

    public void printLadder(List<List<Foothold>> footholdsMap) {
        footholdsMap.stream()
                    .map(this::toFormattedRow)
                    .forEach(System.out::println);
    }

    private String toFormattedRow(List<Foothold> footholds) {
        return footholds.stream()
                        .map(Foothold::getFormat)
                        .collect(joining("|", "     |", "|"));
    }

    public void printErrorMessage(String message) {
        System.out.println(ERROR_MESSAGE_HEADER + message);
    }
}
