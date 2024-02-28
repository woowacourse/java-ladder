package controller;

import domain.Height;
import domain.Ladder;
import domain.LadderGame;
import domain.PlayerName;
import domain.Players;
import domain.RandomLegGenerateStrategy;
import domain.Rewards;
import java.util.Map;
import view.InputView;
import view.OutputView;

public class LadderController {
    private static final String SHOW_RESULT_BREAK_WORD = "all";

    public void run() {
        Players players = new Players(InputView.readPlayers());
        Rewards rewards = new Rewards(InputView.readRewards(), players.getPlayersNames().size());
        Height ladderHeight = new Height(InputView.readLadderHeight());

        int ladderWidth = players.getPlayersNames().size() - 1;
        Ladder ladder = Ladder.createLadderWithLines(new RandomLegGenerateStrategy(), ladderHeight, ladderWidth);
        OutputView.printLadder(players, ladder, rewards);

        LadderGame ladderGame = new LadderGame(ladder, players, rewards);
        showResult(ladderGame);
    }

    private void showResult(LadderGame ladderGame) {
        String name;
        while (!(name = InputView.getWantedResultName()).equals(SHOW_RESULT_BREAK_WORD)) {
            OutputView.printPlayerResult(ladderGame.getPlayerResult(name));
        }
        Map<PlayerName, String> result = ladderGame.getAllPlayerResult();
        OutputView.printAllPlayerResult(result);
    }
}
