package controller;

import controller.dto.LadderResponse;
import controller.dto.PlayersResponse;
import domain.LadderGame;
import domain.ladder.Ladder;
import domain.ladder.PointGenerator;
import domain.players.Players;
import view.InputView;
import view.OutputView;

import java.util.List;

public class LadderGameController {

    private final InputView inputView;
    private final OutputView outputView;
    private final PointGenerator pointGenerator;
    private LadderGame ladderGame;

    public LadderGameController(final InputView inputView, final OutputView outputView, final PointGenerator pointGenerator) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.pointGenerator = pointGenerator;
    }

    public void play() {
        ready();
        printGeneratedLadder();
    }

    private void ready() {
        List<String> playerNames = inputView.readPlayerNames();
        Players players = Players.valueOf(playerNames);
        List<String> prizes = inputView.readPrizes();
        int ladderHeight = inputView.readLadderHeight();
        ladderGame = new LadderGame(players, ladderHeight, prizes, pointGenerator);
    }

    private void printGeneratedLadder() {
        Ladder ladder = ladderGame.getLadder();
        Players players = ladderGame.getPlayers();
        LadderResponse ladderResponse = LadderResponse.from(ladder);
        PlayersResponse playersResponse = PlayersResponse.from(players);
        outputView.printGeneratedLadder(playersResponse, ladderResponse);
    }

}
