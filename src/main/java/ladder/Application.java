package ladder;

import ladder.domain.Ladder;
import ladder.domain.LadderBuilder;
import ladder.domain.LadderGenerator;
import ladder.view.InputView;
import ladder.view.OutputView;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        List<String> names = InputView.inputNames();
        List<String> items = InputView.inputItems();
        int height = InputView.inputHeight();

        Ladder ladder = LadderGenerator.generate(height, names.size());

        LadderBuilder ladderBuilder = new LadderBuilder(ladder);
        ladder = ladderBuilder.build();

        OutputView.printNames(names);
        OutputView.printLadder(ladder);
    }
}
