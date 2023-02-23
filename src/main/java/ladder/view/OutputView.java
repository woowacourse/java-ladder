package ladder.view;

import static java.util.stream.Collectors.joining;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import ladder.domain.Line;

public class OutputView {
    private static final int EMPTY_NAME_LENGTH = 0;
    private static final String NEXT_LINE = System.lineSeparator();
    private static final String LADDER_RESULT_MESSAGE = NEXT_LINE + "사다리결과" + NEXT_LINE;
    private static final String NAME_MESSAGE_FORMAT = " %%%ds";
    private static final String ERROR_MESSAGE = "[ERROR] ";
    private static final int SINGLE_GAME_RESULT_SIZE = 1;
    private static final String SINGLE_RESULT_MESSAGE_FORMAT = "%s";
    private static final String LADDER_GAME_RESULT_MESSAGE = NEXT_LINE + "실행 결과";
    private static final String LADDER_GAME_RESULT_MESSAGE_FORMAT = "%s : %s";

    public void printLadderResult(final List<String> players, final List<Line> ladder, final List<String> items) {
        System.out.println(LADDER_RESULT_MESSAGE);
        final int maxNameLength = calculateMaxNameLength(List.of(players, items));
        System.out.println(generateNameMessages(players, maxNameLength));
        System.out.println(LadderMessageGenerator.generate(maxNameLength, ladder));
        System.out.println(generateNameMessages(items, maxNameLength));
    }

    private int calculateMaxNameLength(final List<List<String>> names) {
        return names.stream()
                .flatMap(Collection::stream)
                .map(String::length)
                .max(Integer::compareTo)
                .orElse(EMPTY_NAME_LENGTH);
    }

    private String generateNameMessages(final List<String> names, final int maxNameLength) {
        return names.stream()
                .map(name -> generateNameMessage(name, maxNameLength))
                .collect(joining());
    }

    private String generateNameMessage(final String name, int maxNameLength) {
        final String nameSizeFormat = String.format(NAME_MESSAGE_FORMAT, maxNameLength);
        return String.format(nameSizeFormat, name);
    }

    public void printLadderGameResult(final Map<String, String> result) {
        System.out.println(LADDER_GAME_RESULT_MESSAGE);
        System.out.println(generateLadderGameResultMessage(result));
    }

    private String generateLadderGameResultMessage(final Map<String, String> result) {
        if (isSingleLadderGameResult(result)) {
            return generateSingleLadderGameResultMessage(result);
        }
        return generateMultipleLadderGameResultMessage(result);
    }

    private boolean isSingleLadderGameResult(final Map<String, String> result) {
        return result.size() == SINGLE_GAME_RESULT_SIZE;
    }

    private String generateSingleLadderGameResultMessage(final Map<String, String> result) {
        final String itemName = result.values().stream()
                .findAny()
                .orElse(NEXT_LINE);
        return String.format(SINGLE_RESULT_MESSAGE_FORMAT, itemName);
    }

    private String generateMultipleLadderGameResultMessage(final Map<String, String> result) {
        return result.keySet().stream()
                .map(player -> String.format(LADDER_GAME_RESULT_MESSAGE_FORMAT, player, result.get(player)))
                .collect(joining(NEXT_LINE));
    }

    public void printError(final String message) {
        System.out.println(ERROR_MESSAGE + message);
    }
}
