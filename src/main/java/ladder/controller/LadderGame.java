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

    /**
     * 사다리게임 진행 로직
     */
    public void play() {
        final Ladder ladder = RandomLadderGenerator.generate(Players.NUM_OF_PLAYERS, ladderHeight);
        final Engine engine = new Engine(ladder, players);
        players = engine.playLadderGame();
        OutputView.printPlayerNames(players);
        OutputView.printLadder(ladder);
        OutputView.printRewards(rewards);
        processQueries();
    }

    /**
     * 쿼리를 분석해 결과를 출력하는 메소드
     */
    private void processQueries() {
        final QueryProcessor queryProcessor = new QueryProcessor(players, rewards);
        PlayerName name;
        while (!(name = InputView.getPlayerName(players)).getName().equals("all")) {
            OutputView.printReward(queryProcessor.getRewardOf(name));
        }
        OutputView.printResults(queryProcessor.getResults());
    }
}
