package ladder.view;

import java.util.List;
import java.util.stream.Collectors;
import ladder.dto.LadderDto;
import ladder.dto.LineDto;
import ladder.dto.PlayersDto;

public class OutputView {
    private static final String ERROR_PREFIX = "[ERROR]";
    private static final String LADDER_RUNG_EMPTY = "     ";
    private static final String LADDER_RUNG_EXIST = "-----";
    private static final String LADDER_SIDE_RAIL = "|";

    public void printLadderResultMessage() {
        System.out.println();
        System.out.println("실행결과");
    }

    public void printPlayerNames(PlayersDto playersDto) {
        List<String> playerNames = playersDto.playerNames();

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

    public void printLadder(LadderDto ladderDto) {
        String ladderMessage = generateLadderMessage(ladderDto.lineDtos());
        System.out.println(ladderMessage);
    }

    private String generateLadderMessage(List<LineDto> lineDtos) {
        return lineDtos.stream()
                .map(lineDto -> generateLadderLine(lineDto.rungsExist()))
                .collect(Collectors.joining(System.lineSeparator()));
    }

    private String generateLadderLine(List<Boolean> rungsExist) {
        String message = rungsExist.stream()
                .map(this::generateRungMessage)
                .collect(Collectors.joining(LADDER_SIDE_RAIL, LADDER_SIDE_RAIL, LADDER_SIDE_RAIL));

        return LADDER_RUNG_EMPTY.concat(message);
    }

    private String generateRungMessage(boolean rungExist) {
        if (rungExist) {
            return LADDER_RUNG_EXIST;
        }
        return LADDER_RUNG_EMPTY;
    }


    public void printErrorMessage(String message) {
        System.out.printf("%s %s%n", ERROR_PREFIX, message);
    }
}
