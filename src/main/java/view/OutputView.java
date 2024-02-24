package view;

import java.util.List;
import model.Step;
import model.dto.LayerSteps;
import model.dto.ParticipantName;

public class OutputView {
    private static final String NAME_FORMAT = "%5s";
    private static final String LADDER_BASE = "|";
    private static final String LEFT_LADDER_BASE = "   |";
    private static final String STEP_EXIST_BASE = "-";
    private static final int STEP_BASE_LENGTH = 5;

    public void printErrorMessage(String message) {
        System.out.println("[ERROR] " + message);
    }

    public void printParticipantsName(List<ParticipantName> participantsNames) {
        List<String> formattedParticipantsName = participantsNames.stream()
                .map(participantName -> String.format(NAME_FORMAT, participantName.name()))
                .toList();
        System.out.println(String.join(" ", formattedParticipantsName));
    }

    public void printLadder(List<LayerSteps> layerSteps) {
        layerSteps.forEach(this::printEachLayer);
    }

    private void printEachLayer(LayerSteps layerSteps) {
        List<String> steps = layerSteps.steps().stream()
                .map(step -> printStepOutput(step.getDoesExist()))
                .toList();
        String joinedSteps = String.join(LADDER_BASE, steps);
        System.out.println(LEFT_LADDER_BASE + joinedSteps + LADDER_BASE);
    }

    private String printStepOutput(boolean doesExist) {
        if (doesExist) {
            return STEP_EXIST_BASE.repeat(STEP_BASE_LENGTH);
        }
        return " ".repeat(STEP_BASE_LENGTH);
    }
}
