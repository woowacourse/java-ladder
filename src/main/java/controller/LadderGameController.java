package controller;

import controller.dto.LadderResponse;
import controller.dto.PlayersResponse;
import domain.LadderGame;
import domain.ladder.Ladder;
import domain.players.Players;
import view.InputView;
import view.OutputView;

import java.util.List;

public class LadderGameController {

    private final InputView inputView;
    private final OutputView outputView;
    private LadderGame ladderGame;

    public LadderGameController(final InputView inputView, final OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void play() {
        ready();
        printGeneratedLadder();
    }

    private void ready() {
        List<String> playerNames = inputView.readPlayerNames();
        int ladderHeight = inputView.readLadderHeight();
        Players players = Players.valueOf(playerNames);
        ladderGame = new LadderGame(players, ladderHeight);
    }

    private void printGeneratedLadder() {
        Ladder ladder = ladderGame.getLadder();
        Players players = ladderGame.getPlayers();
        LadderResponse ladderResponse = LadderResponse.from(ladder);
        PlayersResponse playersResponse = PlayersResponse.from(players);
        outputView.printGeneratedLadder(playersResponse, ladderResponse);
    }

}
