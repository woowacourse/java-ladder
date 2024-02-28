package controller;

import domain.Height;
import domain.Ladder;
import domain.PlayerName;
import domain.Players;
import domain.RandomLegGenerateStrategy;
import domain.Rewards;
import java.util.Map;
import view.InputView;
import view.OutputView;

public class LadderGame {

    private static final String SHOW_RESULT_BREAK_WORD = "all";

    public void run() {
        Players players = new Players(InputView.readPlayers());
        Rewards rewards = new Rewards(InputView.readRewards());
        Height ladderHeight = new Height(InputView.readLadderHeight());

        int ladderWidth = players.getPlayersNames().size() - 1;
        Ladder ladder = Ladder.createLadderWithLines(new RandomLegGenerateStrategy(), ladderHeight, ladderWidth);

        OutputView.printLadder(players, ladder, rewards);

        showResult(ladder, players, rewards);
    }

    private void showResult(Ladder ladder, Players players, Rewards rewards) {
        String name;
        while (!(name = InputView.getWantedResultName()).equals(SHOW_RESULT_BREAK_WORD)) {
            String result = ladder.findPlayerReward(players.getPlayerNameOrderNumber(name), rewards);
            OutputView.printPlayerResult(result);
        }
        Map<PlayerName, String> result = ladder.findAllPlayerReward(players, rewards);
        OutputView.printAllPlayerResult(result);
    }
}
