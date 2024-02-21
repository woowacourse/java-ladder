package view;

import java.util.List;
import model.Step;
import model.dto.LayerSteps;
import model.dto.ParticipantName;

public class OutputView {
    public void printErrorMessage(String message) {
        System.out.println("[ERROR] " + message);
    }

    public void printParticipantsName(List<ParticipantName> participantsNames) {
        List<String> formattedParticipantsName = participantsNames.stream()
                .map(m -> String.format("%5s", m.name()))
                .toList();
        System.out.println(String.join(" ", formattedParticipantsName));
    }

    public void printLadder(List<LayerSteps> layerSteps) {
        layerSteps.stream().forEach(this::printEachLayer);
    }

    private void printEachLayer(LayerSteps layerSteps) {
        List<String> steps = layerSteps.steps().stream()
                .map(Step::valueOfStep)
                .map(Step::getOutput)
                .toList();
        System.out.print("   |");
        System.out.print(String.join("|", steps));
        System.out.println("|");
    }
}
