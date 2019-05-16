package ladder;

import ladder.domain.Ladder;
import ladder.domain.LadderBuilder;
import ladder.domain.LadderGame;
import ladder.domain.LadderGenerator;
import ladder.view.InputView;
import ladder.view.OutputView;

import java.util.List;
import java.util.Map;

public class Application {
    public static void main(String[] args) {
        List<String> names = InputView.inputNames();
        List<String> items = InputView.inputItems(names.size());
        int height = InputView.inputHeight();

        Ladder ladder = LadderGenerator.generate(height, names.size());

        LadderBuilder ladderBuilder = new LadderBuilder(ladder);
        ladder = ladderBuilder.build();

        OutputView.printNames(names);
        OutputView.printLadder(ladder);
        OutputView.printItems(items);

        Map<String, String> result = LadderGame.play(ladder, names, items);

        String participant;

        do {
            participant = InputView.inputParticipant(names);
            OutputView.printResult(result, participant);
        } while (!participant.equals("all"));
    }
}
