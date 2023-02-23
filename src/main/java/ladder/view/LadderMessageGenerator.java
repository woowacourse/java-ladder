package ladder.view;

import static java.util.stream.Collectors.joining;

import java.util.List;
import ladder.domain.Line;
import ladder.domain.LineStatus;

class LadderMessageGenerator {

    private static final String NEXT_LINE = System.lineSeparator();
    private static final String CONNECTED_SYMBOL = "-";
    private static final String DISCONNECTED_SYMBOL = " ";
    private static final String EMPTY_SYMBOL = " ";
    private static final String LINE_STATUS_MESSAGE_FORMAT = "%s|";

    public static String generate(final int maxNameLength, final List<Line> lines) {
        return lines.stream()
                .map(line -> generateLineMessage(maxNameLength, line))
                .collect(joining(NEXT_LINE));
    }

    private static String generateLineMessage(final int maxNameLength, final Line line) {
        final String initialMessage = generateRepeatedLineStatusMessage(EMPTY_SYMBOL, maxNameLength);
        final String ladderMessage = line.getLine().stream()
                .map(lineStatus -> generateLineStatusMessage(maxNameLength, lineStatus))
                .collect(joining());
        return initialMessage + ladderMessage;
    }

    private static String generateRepeatedLineStatusMessage(final String symbol, final int count) {
        return String.format(LINE_STATUS_MESSAGE_FORMAT, symbol.repeat(count));
    }

    private static String generateLineStatusMessage(final int maxNameLength, final LineStatus lineStatus) {
        if (lineStatus.isConnected()) {
            return generateRepeatedLineStatusMessage(CONNECTED_SYMBOL, maxNameLength);
        }
        return generateRepeatedLineStatusMessage(DISCONNECTED_SYMBOL, maxNameLength);
    }
}
