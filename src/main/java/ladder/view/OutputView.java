package ladder.view;

import java.util.List;
import java.util.Map;
import ladder.controller.dto.FloorResponseDto;
import ladder.controller.dto.LadderResponseDto;
import ladder.controller.dto.ParticipantsResponseDto;
import ladder.controller.dto.PrizesResponseDto;
import ladder.domain.Prize;
import ladder.domain.participant.Name;

public class OutputView {

    private static final String LADDERS_PREFIX = "    |";
    private static final String LADDER_STICK_SYMBOL = "|";

    public void printLadderResult(ParticipantsResponseDto participantsResponseDto,
                                  LadderResponseDto ladderResponseDto,
                                  PrizesResponseDto prizesResponseDto) {
        List<String> participantNames = participantsResponseDto.participantNames();
        List<FloorResponseDto> floorResponseDtos = ladderResponseDto.ladderResult();
        List<String> prizeNames = prizesResponseDto.prizeNames();

        printParticipantsNames(participantNames);
        printBuiltLadders(floorResponseDtos);
        printPrizes(prizeNames);
    }

    private void printParticipantsNames(List<String> participantsNames) {
        System.out.println("\n사다리 결과\n");
        for (String name : participantsNames) {
            System.out.printf("%6s", name);
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

    private void printPrizes(List<String> prizeNames) {
        for (String name : prizeNames) {
            System.out.printf("%6s", name);
        }
        System.out.println();
    }

    public void printNameMatchResult(Map<Name, Prize> gameResult, Name nameSearch) {
        System.out.println("\n실행 결과");
        System.out.println(gameResult.get(nameSearch).name());
    }

    public void printAllMatchResult(Map<Name, Prize> gameResult) {
        System.out.println("\n실행 결과");
        for (Name name : gameResult.keySet()) {
            System.out.println(name.getName() + " : " + gameResult.get(name).name());
        }
    }

    public void printError(IllegalArgumentException e) {
        System.out.println(e.getMessage());
    }
}
