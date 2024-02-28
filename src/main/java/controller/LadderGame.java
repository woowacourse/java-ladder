package controller;

import static message.ErrorMessage.INVALID_LADDER_HEIGHT_LANGUAGE_EXCEPTION;

import domain.Height;
import domain.Ladder;
import domain.Player;
import domain.Players;
import domain.RandomLegGenerateStrategy;
import domain.Rewards;
import java.util.Map;
import view.InputView;
import view.OutputView;

public class LadderGame {

    public void run() {
        Players players = readPlayers();
        Rewards rewards = readReward();
        Height ladderHeight = readHeight();
        int ladderWidth = players.getPlayers().size() - 1;
        Ladder ladder = Ladder.createLadderWithLines(new RandomLegGenerateStrategy(), ladderHeight, ladderWidth);

        OutputView.printLadder(players, ladder, rewards);

        showResult(ladder, players, rewards);
    }

    private Players readPlayers() {
        return new Players(InputView.readPlayers());
    }

    private Rewards readReward() {
        return new Rewards(InputView.readRewards());
    }

    private Height readHeight() {
        return new Height(InputView.readLadderHeight());
    }

    private void showResult(Ladder ladder, Players players, Rewards rewards) {
        String name;
        while (!(name = InputView.getWantedResultName()).equals("all")) {
            String result = ladder.findPlayerReward(players.getPlayerOrderNumber(name), rewards);
            OutputView.printPlayerResult(result);
        }
        Map<Player, String> result = ladder.findAllPlayerReward(players, rewards);
        OutputView.printAllPlayerResult(result);
    }
}
