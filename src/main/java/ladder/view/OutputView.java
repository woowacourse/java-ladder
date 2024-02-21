package ladder.view;

import java.util.List;
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
        for (String playerName : playerNames) {
            System.out.printf("%5s ", playerName);
        }
        System.out.println();
    }


    public void printLadder(LadderDto ladderDto) {
        List<LineDto> lineDtos = ladderDto.lineDtos();
        StringBuilder ladderBuilder = new StringBuilder();

        for (LineDto lineDto : lineDtos) {
            List<Boolean> rungsExist = lineDto.rungsExist();
            printLadderLine(rungsExist, ladderBuilder);
            ladderBuilder.append("\n");
        }
        System.out.println(ladderBuilder);
    }

    private void printLadderLine(List<Boolean> rungsExist, StringBuilder ladderBuilder) {
        ladderBuilder.append(LADDER_RUNG_EMPTY).append(LADDER_SIDE_RAIL);

        for (Boolean rungExist : rungsExist) {
            String rungMessage = generateRungMessage(rungExist);
            ladderBuilder.append(rungMessage).append(LADDER_SIDE_RAIL);
        }
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
