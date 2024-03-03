package ladder.view;

import java.util.List;
import java.util.Map;
import ladder.domain.Direction;
import ladder.domain.Player;

import java.util.stream.Collectors;
import ladder.domain.ResultItem;

public class OutputView {

    private static final String NEW_LINE = "\n";
    private static final int MAX_NAME_LENGTH = 5;
    private static final String ONE_RESULT_FORMAT = "%s";
    private static final String ALL_RESULT_FORMAT = "%s : %s";

    public void printLadderResult(List<String> players, List<List<Direction>> ladder, List<String> resultItems) {
        System.out.println(NEW_LINE + "사다리 결과" + NEW_LINE);

        String formattedPlayers = makeTextsFormatted(players);
        System.out.println(formattedPlayers);

        String formattedLadder = makeLadderFormatted(ladder);
        System.out.println(formattedLadder);

        String formattedResultItems = makeTextsFormatted(resultItems);
        System.out.println(formattedResultItems);
    }

    private String makeTextsFormatted(List<String> texts) {
        return texts.stream()
                .map(this::makeTextFormatted)
                .collect(Collectors.joining(" "));
    }

    private String makeTextFormatted(String text) {
        if (text.length() == MAX_NAME_LENGTH) {
            return text;
        }
        int trailingSpaces = 1;
        int leadingSpaces = MAX_NAME_LENGTH - text.length() - trailingSpaces;
        return " ".repeat(leadingSpaces) + text + " ".repeat(trailingSpaces);
    }

    private String makeLadderFormatted(List<List<Direction>> ladder) {
        return ladder.stream()
                .map(this::makeLineFormatted)
                .collect(Collectors.joining("\n"));
    }

    private String makeLineFormatted(List<Direction> line) {
        return line.stream()
                .map(this::getSymbol)
                .collect(Collectors.joining("|", "    |", ""));
    }

    private String getSymbol(Direction direction) {
        if (direction.isForward()) {
            return "-".repeat(MAX_NAME_LENGTH);
        }
        return " ".repeat(MAX_NAME_LENGTH);
    }

    public void printExecutionResult(Map<Player, ResultItem> result) {
        System.out.println(NEW_LINE + "실행 결과");

        String formattedResult = makeResultFormatted(result);
        System.out.println(formattedResult);
    }

    private String makeResultFormatted(Map<Player, ResultItem> result) {
        if (result.size() == 1) {
            return makeOneResultFormatted(result);
        }
        return makeAllResultFormatted(result);
    }

    private String makeOneResultFormatted(Map<Player, ResultItem> result) {
        return result.values().stream()
                .map(resultItem -> String.format(ONE_RESULT_FORMAT, resultItem.getValue()))
                .collect(Collectors.joining("\n"));
    }

    private String makeAllResultFormatted(Map<Player, ResultItem> result) {
        return result.entrySet().stream()
                .map(entry -> String.format(ALL_RESULT_FORMAT, entry.getKey().getName(), entry.getValue().getValue()))
                .collect(Collectors.joining("\n"));
    }
}
