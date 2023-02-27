package laddergame.view;

import laddergame.ladder.Foothold;

import java.util.List;
import java.util.Map;

import static java.util.stream.Collectors.joining;

public class ResultView {
    private static final String FOOTHOLD_DELIMITER = "|";

    public void printLadderInformationTitle() {
        System.out.println("사다리 결과");
    }

    public void printPlayersName(List<String> playerNames) {
        printNames(playerNames);
    }

    public void printLadder(List<List<Foothold>> footholdsMap) {
        footholdsMap.stream()
                    .map(this::toRowFormat)
                    .forEach(System.out::println);
    }

    private String toRowFormat(List<Foothold> footholds) {
        return footholds.stream()
                        .map(Foothold::getFormat)
                        .collect(joining(FOOTHOLD_DELIMITER, "     " + FOOTHOLD_DELIMITER, FOOTHOLD_DELIMITER));
    }

    public void printPrizes(List<String> prizeNames) {
        printNames(prizeNames);
    }

    private void printNames(List<String> names) {
        for (String name : names) {
            System.out.printf("%6s", name);
        }
        System.out.print(System.lineSeparator());
    }

    public void printResultOfOnePerson(String result) {
        printGameResultTitle();
        System.out.println(result);
    }

    public void printResultOfAll(Map<String, String> allResults) {
        printGameResultTitle();
        System.out.println(formatResultOfAll(allResults));
    }

    private void printGameResultTitle() {
        System.out.println("실행 결과");
    }

    private String formatResultOfAll(Map<String, String> resultForAll) {
        return resultForAll.entrySet()
                           .stream()
                           .map(this::formatResult)
                           .collect(joining(System.lineSeparator()));
    }

    private String formatResult(Map.Entry<String, String> result) {
        StringBuilder formatBuilder = new StringBuilder();

        formatBuilder.append(result.getKey())
                     .append(" : ")
                     .append(result.getValue());

        return formatBuilder.toString();
    }
}
