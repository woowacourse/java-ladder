package ladder.view;

import java.util.List;
import ladder.domain.dto.FloorResponseDto;
import ladder.domain.dto.LadderResponseDto;
import ladder.domain.participant.Name;

public class OutputView {

    private static final String LADDERS_PREFIX = "    |";
    private static final String LADDER_STICK_SYMBOL = "|";

    public void printResult(LadderResponseDto ladderResponseDto, List<Name> participantNames, List<String> prizeNames) {
        List<FloorResponseDto> floorResponseDtos = ladderResponseDto.ladderResult();

        printParticipantsNames(participantNames);
        printBuiltLadders(floorResponseDtos);
        printPrizes(prizeNames);
    }

    private void printParticipantsNames(List<Name> names) {
        for (Name name : names) {
            System.out.printf("%6s", name.getName());
        }
        System.out.println();
    }

    private void printBuiltLadders(List<FloorResponseDto> floorResponseDtos) {
        for (FloorResponseDto floorResponseDto : floorResponseDtos) {
            System.out.println(LADDERS_PREFIX + String.join(LADDER_STICK_SYMBOL,
                    RungSymbol.changeStatusListToSymbol(floorResponseDto.buildStatusList())
            ) + LADDER_STICK_SYMBOL);
        }
    }

    private void printPrizes(List<String> prizes) {
        for (String prizeName : prizes) {
            System.out.printf("%-6s", prizeName);
        }
    }

    public void printError(IllegalArgumentException e) {
        System.out.println(e.getMessage());
    }
}
