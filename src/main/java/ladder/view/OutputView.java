package ladder.view;

import java.util.ArrayList;
import java.util.List;
import ladder.domain.dto.MadeLadderDto;
import ladder.domain.dto.StepStatusDto;
import ladder.domain.ladder.Step;
import ladder.domain.participant.Name;
import ladder.view.util.LadderStepSymbol;

public class OutputView {

    private static final String LADDERS_PREFIX = "    |";
    private static final String LADDER_STICK_SYMBOL = "|";

    public void printMadeLadder(MadeLadderDto resultLadderDto, List<Name> names, List<String> gamePrizes) {
        List<StepStatusDto> stepStatusDtos = resultLadderDto.stepStatusDtos();

        printParticipantsNames(names);
        printBuiltLadders(stepStatusDtos);
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

    private void printBuiltLadders(List<StepStatusDto> resultStepsDto) {
        for (StepStatusDto stepStatus : resultStepsDto) {
            System.out.println(LADDERS_PREFIX + String.join(LADDER_STICK_SYMBOL, changeToViewSymbol(stepStatus)));
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

    public List<String> changeToViewSymbol(StepStatusDto stepStatus) {
        List<String> builtLadder = new ArrayList<>();

        for (Step step : stepStatus.builtStep()) {
            builtLadder.add(LadderStepSymbol.changeStatusToSymbol(step.getBuildStatus()));
        }

        return builtLadder;
    }
}
