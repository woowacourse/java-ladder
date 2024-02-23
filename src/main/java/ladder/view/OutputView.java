package ladder.view;

import java.util.List;
import java.util.stream.Collectors;
import ladder.dto.response.LadderResponse;
import ladder.dto.response.LineResponse;
import ladder.dto.response.PlayerResponse;
import ladder.dto.response.PlayersResponse;

public class OutputView {
    private static final String LADDER_LEFT_MARGIN = "    ";
    private static final String LADDER_RUNG_EMPTY = "     ";
    private static final String LADDER_RUNG_EXIST = "-----";
    private static final String LADDER_SIDE_RAIL = "|";
    private static final String ERROR_PREFIX = "[ERROR]";

    public void printErrorMessage(String message) {
        System.out.printf("%s %s%n", ERROR_PREFIX, message);
    }

    public void printLadderResultMessage() {
        System.out.println();
        System.out.println("실행결과");
    }

    public void printPlayerNames(PlayersResponse playersResponse) {
        List<String> playerNames = playersResponse.playerResponses().stream()
                .map(PlayerResponse::name)
                .toList();

        System.out.println();
        System.out.println(generatePlayerNamesMessage(playerNames));
    }

    private String generatePlayerNamesMessage(List<String> playerNames) {
        return playerNames.stream()
                .map(this::generatePlayerNameMessage)
                .collect(Collectors.joining());
    }

    private String generatePlayerNameMessage(String playerName) {
        return String.format("%5s ", playerName);
    }

    public void printLadder(LadderResponse ladderResponse) {
        String ladderMessage = generateLadderMessage(ladderResponse.lineResponses());
        System.out.println(ladderMessage);
    }

    private String generateLadderMessage(List<LineResponse> lineResponses) {
        return lineResponses.stream()
                .map(lineDto -> generateLadderLine(lineDto.rungsExist()))
                .collect(Collectors.joining(System.lineSeparator()));
    }

    private String generateLadderLine(List<Boolean> rungsExist) {
        String message = rungsExist.stream()
                .map(this::generateRungMessage)
                .collect(Collectors.joining(LADDER_SIDE_RAIL, LADDER_SIDE_RAIL, LADDER_SIDE_RAIL));

        return LADDER_LEFT_MARGIN.concat(message);
    }

    private String generateRungMessage(boolean rungExist) {
        if (rungExist) {
            return LADDER_RUNG_EXIST;
        }
        return LADDER_RUNG_EMPTY;
    }
}
