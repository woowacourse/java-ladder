package ladder.view;

import java.util.List;
import ladder.domain.Name;
import ladder.domain.dto.BuiltLadderDto;
import ladder.domain.dto.ResultLadderDto;

public class OutputView {

    private static final String LADDERS_PREFIX = "    |";
    private static final String LADDER_STICK_SYMBOL = "|";

    public void printResult(ResultLadderDto resultLadderDto, List<Name> names) {
        List<BuiltLadderDto> builtLadderDtos = resultLadderDto.resultLadder();

        printParticipantsNames(names);
        printBuiltLadders(builtLadderDtos);
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

    public void printError(IllegalArgumentException e) {
        System.out.println(e.getMessage());
    }


}
