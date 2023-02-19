package ladder;

import ladder.controller.LadderController;
import ladder.service.LadderService;
import ladder.service.RandomLineStrategy;
import ladder.view.LadderView;

public class Application {
    public static void main(String[] args) {
        LadderService ladderService = new LadderService(new RandomLineStrategy());
        LadderView ladderView = new LadderView();
        LadderController ladderController = new LadderController(ladderService, ladderView);
        ladderController.run();
    }
}
