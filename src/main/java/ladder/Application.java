package ladder;

import ladder.controller.LadderController;
import ladder.repository.PlayerRepository;
import ladder.repository.PlayerResultsRepository;
import ladder.repository.PrizeRepository;
import ladder.service.LadderService;
import ladder.service.RandomLineStrategy;
import ladder.view.LadderView;

public class Application {
    public static void main(String[] args) {
        RandomLineStrategy lineStrategy = new RandomLineStrategy();
        PlayerRepository playerRepository = new PlayerRepository();
        PrizeRepository prizeRepository = new PrizeRepository();
        PlayerResultsRepository playerResultsRepository = new PlayerResultsRepository();
        LadderService ladderService = new LadderService(lineStrategy, playerRepository, prizeRepository,
                playerResultsRepository);
        LadderView ladderView = new LadderView();
        LadderController ladderController = new LadderController(ladderService, ladderView);
        ladderController.run();
    }
}
