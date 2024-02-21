package ladder.view.console;

import java.util.List;
import java.util.stream.Collectors;
import ladder.dto.LadderDto;
import ladder.dto.LineDto;
import ladder.dto.PlayersDto;
import ladder.view.OutputView;

public class ConsoleOutputView implements OutputView {
    private static final String LADDER_RUNG_EMPTY = "     ";
    private static final String LADDER_RUNG_EXIST = "-----";
    private static final String LADDER_SIDE_RAIL = "|";

    @Override
    public void printErrorMessage(String errorMessage) {
        System.out.println(errorMessage);
    }

    @Override
    public void printLadderResultMessage() {
        System.out.println();
        System.out.println("실행결과");
    }

    @Override
    public void printPlayerNames(final PlayersDto playersDto) {
        final List<String> playerNames = playersDto.playerNames();

        System.out.println();
        System.out.println(generatePlayerNamesMessage(playerNames));
    }

    private String generatePlayerNamesMessage(final List<String> playerNames) {
        return playerNames.stream()
                .map(this::generatePlayerNameMessage)
                .collect(Collectors.joining());
    }

    private String generatePlayerNameMessage(final String playerName) {
        return String.format("%5s ", playerName);
    }

    @Override
    public void printLadder(final LadderDto ladderDto) {
        final String ladderMessage = generateLadderMessage(ladderDto.lineDtos());
        System.out.println(ladderMessage);
    }

    private String generateLadderMessage(final List<LineDto> lineDtos) {
        return lineDtos.stream()
                .map(lineDto -> generateLadderLine(lineDto.rungsExist()))
                .collect(Collectors.joining(System.lineSeparator()));
    }

    private String generateLadderLine(final List<Boolean> rungsExist) {
        final String message = rungsExist.stream()
                .map(this::generateRungMessage)
                .collect(Collectors.joining(LADDER_SIDE_RAIL, LADDER_SIDE_RAIL, LADDER_SIDE_RAIL));

        return LADDER_RUNG_EMPTY.concat(message);
    }

    private String generateRungMessage(final boolean rungExist) {
        if (rungExist) {
            return LADDER_RUNG_EXIST;
        }
        return LADDER_RUNG_EMPTY;
    }
}
