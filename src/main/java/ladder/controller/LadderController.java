package ladder.controller;

import ladder.domain.ladder.Height;
import ladder.domain.ladder.Ladder;
import ladder.domain.laddergame.LadderGame;
import ladder.domain.laddergame.LadderGameResult;
import ladder.domain.linegenerator.impl.RandomLineGenerator;
import ladder.domain.player.Players;
import ladder.domain.reward.Rewards;
import ladder.view.InputView;
import ladder.view.OutputView;

public class LadderController {
    private static final String ALL = "all";
    private static final String SEPARATOR = ",";

    public static void main(String[] args) {
        Players players = new Players(splitComponent(InputView.inputNames()));
        Height height = new Height(InputView.inputHeight());
        Rewards rewards = new Rewards(splitComponent(InputView.inputRewards()));

        Ladder ladder = new Ladder(new RandomLineGenerator(players.size()), height);
        LadderGame ladderGame = new LadderGame(ladder);
        LadderGameResult ladderGameResult = ladderGame.play(players, rewards);

        OutputView.printPlayers(players);
        OutputView.printLadder(ladder);
        OutputView.printRewards(rewards);

        showLadderGameResult(ladderGameResult);
    }

    private static void showLadderGameResult(LadderGameResult ladderGameResult) {
        String inputPlayerForReward;
        do{
            inputPlayerForReward = InputView.inputPlayerForResult(ladderGameResult.keySet());
            OutputView.printLadderGameResult(ladderGameResult, inputPlayerForReward);
        }while(!ALL.equals(inputPlayerForReward));

    }

    public static String[] splitComponent(String input) {
        return input.split(SEPARATOR);
    }
}
