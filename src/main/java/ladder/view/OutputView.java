package ladder.view;

import java.util.List;
import ladder.domain.Name;
import ladder.domain.dto.BuiltLadderDto;
import ladder.domain.dto.ResultLadderDto;

public class OutputView {

    public void printResult(ResultLadderDto resultLadderDto, List<Name> names) {
        List<BuiltLadderDto> builtLadderDtos = resultLadderDto.resultLadder();

        for (Name name : names) {
            System.out.printf("%6s", name.getName());
        }
        System.out.println();
        for (BuiltLadderDto builtLadderDto : builtLadderDtos) {
            System.out.println("    |" + String.join("|", builtLadderDto.builtLadder()));
        }
    }
}
