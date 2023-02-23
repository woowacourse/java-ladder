package controller;

import domain.*;
import view.InputView;
import view.OutputView;

import java.util.List;

public class Controller {
    private final InputView inputView;
    private final OutputView outputView;
    private final BooleanCreator booleanCreator;

    public Controller(InputView inputView, OutputView outputView, BooleanCreator booleanCreator) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.booleanCreator = booleanCreator;
    }

    public void run() {
        PlayerNames playerNames = new PlayerNames(inputView.readPlayerNames(), inputView);
        Players players = new Players(playerNames);

        Rewards rewards = new Rewards(inputView.readRewards(), players.getPlayersSize(), inputView);
        int ladderHeight = new LadderHeight(inputView.readLadderHeight(), inputView).getLadderHeight();
        Ladder ladder = new Ladder(ladderHeight, players, booleanCreator);
        List<Line> ladderList = ladder.getLadder();

        outputView.printResult(players, ladderList, rewards);

        String selectedPlayerName = inputView.readSelectPlayer();
        ladder.getRewardsForPlayers(players, rewards);
    }
}
