package ladder.view;

import ladder.dto.LineDto;
import ladder.utils.Command;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class MessageGenerator {
    private static final String LADDER_RUNG_EMPTY = "     ";
    private static final String LADDER_RUNG_EXIST = "-----";
    private static final String LADDER_SIDE_RAIL = "|";
    private static final String RESULT_MESSAGE_DELIMITER = " : ";

    public String generateRightAlignedMessage(final List<String> sources) {
        return sources.stream()
                .map(this::toRightAlignMessage)
                .collect(Collectors.joining());
    }

    private String toRightAlignMessage(final String input) {
        return String.format("%6s", input);
    }

    public String generateLadderMessage(final List<LineDto> lines) {
        return lines.stream()
                .map(lineDto -> generateLineMessage(lineDto.rungsExist()))
                .collect(Collectors.joining(OutputView.NEWLINE));
    }

    private String generateLineMessage(final List<Boolean> rungsExist) {
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

    public String generateResultMessage(final Map<String, String> result, final String name) {
        if (Command.EXPRESSION_OF_ENTIRE_PLAYER.isMatch(name)) {
            return generateAllResultMessage(result);
        }
        return result.get(name);
    }

    private String generateAllResultMessage(final Map<String, String> result) {
        return result.keySet()
                .stream()
                .map(name -> generateResultMessageOf(name, result.get(name)))
                .collect(Collectors.joining(OutputView.NEWLINE));
    }

    private String generateResultMessageOf(final String name, final String prize) {
        return name + RESULT_MESSAGE_DELIMITER + prize;
    }
}
