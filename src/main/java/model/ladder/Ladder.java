package model.ladder;

import dto.LayerSteps;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import model.generator.StepExistenceGenerator;
import model.participant.Participant;
import model.participant.Participants;
import model.prize.Prize;
import model.prize.Prizes;
import model.result.GameResults;

public class Ladder {
    private final List<Layer> layers;

    public Ladder(List<Layer> layers) {
        this.layers = layers;
    }

    public static Ladder of(Height height, int numberOfParticipants) {
        List<Layer> layers = generateLayers(height, numberOfParticipants);
        return new Ladder(layers);
    }

    private static List<Layer> generateLayers(Height height, int numberOfParticipants) {
        List<Layer> layers = new ArrayList<>();
        for (int i = 0; i < height.value(); i++) {
            layers.add(new Layer(StepExistenceGenerator.generate(numberOfParticipants)));
        }
        return layers;
    }

    public GameResults climbDownAll(Participants participants, Prizes prizes) {
        Map<Participant, Prize> results = new LinkedHashMap<>();
        for (int i = 0; i < participants.size(); i++) {
            Participant participant = participants.findParticipantByIndex(i);
            Prize assignedPrize = prizes.getPrizeByIndex(climbDownEach(i));
            results.put(participant, assignedPrize);
        }
        return new GameResults(results);
    }

    private int climbDownEach(int startIndex) {
        int currentIndex = startIndex;
        for (Layer layer : layers) {
            currentIndex = layer.move(currentIndex);
        }
        return currentIndex;
    }

    public List<LayerSteps> convertToLayerSteps() {
        return layers.stream().map(LayerSteps::new).toList();
    }
}
