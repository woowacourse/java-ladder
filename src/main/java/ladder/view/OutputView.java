package ladder.view;

import java.util.List;
import ladder.domain.dto.LadderResponseDto;
import ladder.domain.dto.LineResponseDto;
import ladder.domain.participant.Name;

public class OutputView {

    private static final String LADDERS_PREFIX = "    |";
    private static final String LADDER_STICK_SYMBOL = "|";

    public void printResult(LadderResponseDto ladderResponseDto, List<Name> names) {
        List<LineResponseDto> lineResponseDtos = ladderResponseDto.ladderResult();

        printParticipantsNames(names);
        printBuiltLadders(lineResponseDtos);
    }

    private void printParticipantsNames(List<Name> names) {
        for (Name name : names) {
            System.out.printf("%6s", name.getName());
        }
        System.out.println();
    }

    private void printBuiltLadders(List<LineResponseDto> lineResponseDtos) {
        for (LineResponseDto lineResponseDto : lineResponseDtos) {
            System.out.println(LADDERS_PREFIX + String.join(LADDER_STICK_SYMBOL,
                    RungSymbol.changeStatusListToSymbol(lineResponseDto.buildStatusList())
            ) + LADDER_STICK_SYMBOL);
        }
    }

    public void printError(IllegalArgumentException e) {
        System.out.println(e.getMessage());
    }
}
