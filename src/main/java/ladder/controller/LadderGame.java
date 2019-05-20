package ladder.controller;

import ladder.domain.*;
import ladder.view.InputView;
import ladder.view.OutputView;

public class LadderGame {
    private Players players;
    private final Rewards rewards;
    private final LadderHeight ladderHeight;

    public LadderGame() {
        this.players = InputView.getPlayers();
        this.rewards = InputView.getRewards();
        this.ladderHeight = InputView.getLadderHeight();
    }

    public void play() {
        Ladder ladder = RandomLadderGenerator.generate(Players.NUM_OF_PLAYERS, ladderHeight);
        Engine engine = new Engine(ladder, players);
        players = engine.playLadderGame();
        OutputView.printPlayerNames(players);
        OutputView.printLadder(ladder);
        OutputView.printRewards(rewards);
        processQueries();
    }

    private void processQueries() {
        QueryProcessor queryProcessor = new QueryProcessor(players, rewards);
        PlayerName name;

        while(!(name = InputView.getPlayerName(players)).getName().equals("all")) {
            OutputView.printReward(queryProcessor.getRewardOf(name));
        }
        OutputView.printResults(queryProcessor.getResults());
    }
}
