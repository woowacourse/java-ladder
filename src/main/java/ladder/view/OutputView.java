package ladder.view;

import java.util.List;
import ladder.domain.Name;
import ladder.domain.dto.BuiltLadderDto;
import ladder.domain.dto.ResultLadderDto;

public class OutputView {

    private static final String LADDERS_PREFIX = "    |";
    private static final String LADDER_STICK_SYMBOL = "|";

    public void printResult(ResultLadderDto resultLadderDto, List<Name> names, List<String> gamePrizes) {
        List<BuiltLadderDto> builtLadderDtos = resultLadderDto.resultLadder();

        printParticipantsNames(names);
        printBuiltLadders(builtLadderDtos);
        printPrizes(gamePrizes);
    }

    public void printSingleResult(String prize) {
        System.out.println("\n실행 결과");
        System.out.println(prize);
    }

    public void printAllResult(List<Name> names, List<String> prizes) {
        System.out.println("\n실행 결과");

        for (int i = 0; i < names.size(); i++) {
            System.out.println(names.get(i).getName() + " : " + prizes.get(i));
        }
    }

    private void printParticipantsNames(List<Name> names) {
        for (Name name : names) {
            System.out.printf("%6s", name.getName());
        }
        System.out.println();
    }

    private void printBuiltLadders(List<BuiltLadderDto> builtLadderDtos) {
        for (BuiltLadderDto builtLadderDto : builtLadderDtos) {
            System.out.println(LADDERS_PREFIX + String.join(LADDER_STICK_SYMBOL, builtLadderDto.builtLadder()));
        }
    }

    private void printPrizes(List<String> gamePrizes) {
        for (String prize : gamePrizes) {
            System.out.printf("%6s", prize);
        }
        System.out.println();
    }

    public void printError(IllegalArgumentException e) {
        System.out.println(e.getMessage());
    }


}
