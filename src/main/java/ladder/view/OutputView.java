package ladder.view;

import static java.util.stream.Collectors.joining;

import java.util.Collection;
import java.util.List;
import ladder.domain.Line;

public class OutputView {
    private static final int EMPTY_NAME_LENGTH = 0;
    private static final String NEXT_LINE = System.lineSeparator();
    private static final String GAME_RESULT_MESSAGE = NEXT_LINE + "사다리결과" + NEXT_LINE;
    private static final String NAME_MESSAGE_FORMAT = " %%%ds";
    private static final String ERROR_MESSAGE = "[ERROR] ";

    public void printLadderResult(final List<String> players, final List<Line> ladder, final List<String> items) {
        System.out.println(GAME_RESULT_MESSAGE);
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

    public void printError(final String message) {
        System.out.println(ERROR_MESSAGE + message);
    }
}
