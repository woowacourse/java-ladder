package controller;

import domain.Command;
import domain.Height;
import domain.Player;
import domain.Players;
import domain.Results;
import domain.Reward;
import domain.Rewards;
import domain.ladder.Ladder;
import domain.ladder.LadderGame;
import util.RandomNumberGenerator;
import view.InputView;
import view.OutputView;

public class LadderGameController {

    private final InputView inputView;
    private final OutputView outputView;
    private final RandomNumberGenerator randomNumberGenerator;

    public LadderGameController(RandomNumberGenerator randomNumberGenerator) {
        this.inputView = new InputView();
        this.outputView = new OutputView();
        this.randomNumberGenerator = randomNumberGenerator;
    }

    public void run() {
        Players players = Players.from(inputView.requestPlayerNames());
        Rewards rewards = Rewards.from(players.getSize(), inputView.requestRewards());
        Height height = new Height(inputView.requestLadderHeight());

        Ladder ladder = Ladder.of(players, height, randomNumberGenerator);
        ladder.buildBridges();
        LadderGame ladderGame = new LadderGame(ladder, players, rewards);
        printLadderInitialState(players, ladder, rewards);
        printResult(ladderGame);
    }

    private void printResult(LadderGame ladderGame) {
        while (true) {
            Command command = new Command(inputView.requestCommand());
            Results results = ladderGame.getResults(command);
            outputView.printResult(results);
        }
    }

    private void printLadderInitialState(Players players, Ladder ladder, Rewards rewards) {
        outputView.printLadderResultPrefix();
        outputView.printNames(players.getPlayers(), Player::getName);
        outputView.printLadder(ladder);
        outputView.printNames(rewards.getRewards(), Reward::getName);
    }

    public void printError(Exception exception) {
        outputView.printError(exception);
    }

}
