package ladder.view;

import ladder.dto.LadderDto;
import ladder.dto.LineDto;
import ladder.dto.PlayersDto;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class OutputView {
    private static final String ERROR_PREFIX = "[ERROR]";
    private static final String LADDER_RUNG_EMPTY = "     ";
    private static final String LADDER_RUNG_EXIST = "-----";
    private static final String LADDER_SIDE_RAIL = "|";

    public void printLadderResultMessage() {
        System.out.println();
        System.out.println("사다리 결과");
    }

    public void printPlayerNames(final PlayersDto playersDto) {
        final List<String> playerNames = playersDto.playerNames();

        System.out.println();
        System.out.println(generateResultsMessage(playerNames));
    }

    private String generateResultsMessage(final List<String> sources) {
        return sources.stream()
                .map(this::generateResultMessage)
                .collect(Collectors.joining());
    }

    private String generateResultMessage(final String input) {
        return String.format("%6s", input);
    }

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

    public void printPrizes(final List<String> prizes) {
        System.out.println(generateResultsMessage(prizes));
    }

    public void printResult(final Map<String, String> result, final String name) {
        System.out.println();
        System.out.println("실행 결과");

        final String message = generateMessage(result, name);
        System.out.println(message);
    }

    private String generateMessage(final Map<String, String> result, final String name) {
        if (name.equals("all")) {
            return generateAllMessage(result);
        }
        return result.get(name);
    }

    private String generateAllMessage(final Map<String, String> result) {
        return result.keySet()
                .stream()
                .map(key -> generateMessage(key, result.get(key)))
                .collect(Collectors.joining(System.lineSeparator()));
    }

    private String generateMessage(final String name, final String prize) {
        return name + " : " + prize;
    }

    public void printErrorMessage(String message) {
        System.out.printf("%s %s%n", ERROR_PREFIX, message);
    }
}
