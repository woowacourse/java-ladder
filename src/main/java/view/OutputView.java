package view;

import dto.LayerSteps;
import dto.ParticipantName;
import dto.PrizeName;
import java.util.List;
import model.ladder.Step;
import utils.Constant;

public class OutputView {
    private static final String NAME_FORMAT = "%" + Constant.STEP_LENGTH + "s";
    private static final String PRIZE_FORMAT = "%" + Constant.STEP_LENGTH + "s";
    private static final String LADDER_BASE = "|";
    private static final String LEFT_LADDER_BASE = "   |";
    private static final String STEP_BASE = "-";
    private static final String EMPTY_STEP_BASE = " ";

    public void printErrorMessage(String message) {
        System.out.println("[ERROR] " + message);
    }

    public void printParticipantsName(List<ParticipantName> participantsNames) {
        System.out.println("\n사다리 결과\n");
        List<String> formattedParticipantsName = participantsNames.stream()
                .map(participantName -> String.format(NAME_FORMAT, participantName.name()))
                .toList();
        System.out.println(String.join(" ", formattedParticipantsName));
    }

    public void printLadder(List<LayerSteps> layerSteps) {
        layerSteps.forEach(this::printEachLayer);
    }

    public void printPrizeNames(List<PrizeName> prizeNames) {
        List<String> formattedParticipantsName = prizeNames.stream()
                .map(prizeName -> String.format(PRIZE_FORMAT, prizeName.prizeName()))
                .toList();
        System.out.println(String.join(" ", formattedParticipantsName));
    }

    private void printEachLayer(LayerSteps layerSteps) {
        List<String> steps = layerSteps.steps().stream()
                .map(this::printEachStep)
                .toList();
        String joinedSteps = String.join(LADDER_BASE, steps);
        System.out.println(LEFT_LADDER_BASE + joinedSteps + LADDER_BASE);
    }

    private String printEachStep(Step step) {
        if (step.equals(Step.EXIST)) {
            return STEP_BASE.repeat(Constant.STEP_LENGTH);
        }
        return EMPTY_STEP_BASE.repeat(Constant.STEP_LENGTH);
    }
}
