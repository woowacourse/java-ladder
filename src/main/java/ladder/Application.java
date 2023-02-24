package ladder;

import ladder.controller.LadderController;
import ladder.domain.ladder.Results;
import ladder.domain.people.Names;
import ladder.view.InputView;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        Names names = InputView.repeat(() -> new Names(InputView.inputPeopleNames()));
        List<String> namesList = names.getNames();

        Results results = InputView.repeat(() -> new Results(InputView.inputResults(), namesList.size()));
        List<String> resultsList = results.getResults();

        int ladderHeight = InputView.repeat(InputView::inputLadderHeight);

        LadderController ladderController = new LadderController();
        ladderController.run(namesList, resultsList, ladderHeight);
    }
}
