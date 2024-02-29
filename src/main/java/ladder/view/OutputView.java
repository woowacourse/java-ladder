package ladder.view;

import ladder.dto.LadderDto;
import ladder.dto.LineDto;
import ladder.dto.PlayersDto;

import java.util.List;
import java.util.Map;

public class OutputView {
    protected static final String NEWLINE = System.lineSeparator();
    private static final String ERROR_PREFIX = "[ERROR]";

    private final MessageGenerator messageGenerator;

    public OutputView(final MessageGenerator messageGenerator) {
        this.messageGenerator = messageGenerator;
    }

    public void printLadderResultMessage() {
        printMessageWithBlankLine("사다리 결과");
    }

    public void printPlayerNames(final PlayersDto playersDto) {
        final List<String> playerNames = playersDto.playerNames();
        final String message = messageGenerator.generateRightAlignedMessage(playerNames);

        printMessageWithBlankLine(message);
    }

    public void printLadder(final LadderDto ladderDto) {
        final List<LineDto> lines = ladderDto.lineDtos();
        final String ladderMessage = messageGenerator.generateLadderMessage(lines);

        System.out.println(ladderMessage);
    }

    public void printPrizes(final List<String> prizes) {
        final String message = messageGenerator.generateRightAlignedMessage(prizes);
        System.out.println(message);
    }

    public void printResult(final Map<String, String> result, final String name) {
        printMessageWithBlankLine("실행 결과");

        final String message = messageGenerator.generateResultMessage(result, name);
        System.out.println(message);
    }

    protected void printMessageWithBlankLine(final String message) {
        System.out.println(NEWLINE + message);
    }

    public void printErrorMessage(String message) {
        System.out.println(String.format("%s %s", ERROR_PREFIX, message));
    }
}
