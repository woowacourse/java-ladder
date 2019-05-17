package laddergame.controller;

import laddergame.domain.ladder.Ladder;
import laddergame.domain.ladder.LadderHeight;
import laddergame.domain.player.PlayersBuilder;
import laddergame.domain.player.Players;
import laddergame.domain.result.DestinationsBuilder;
import laddergame.domain.result.Destinations;
import laddergame.view.InputView;
import laddergame.view.OutputView;

public class LadderGameController {

    private Players players;
    private Destinations destinations;
    private Ladder ladder;

    public LadderGameController() {
        init();
    }

    private void init() {
        this.players = assignPlayers();
        this.destinations = assignResults(players);
        LadderHeight ladderHeight = assignLadderHeight();
        this.ladder = new Ladder(ladderHeight.getLadderHeight(), players.getNumberOfPlayers());
        this.ladder.connectBridgesRandomly(ladderHeight.getLadderHeight() * players.getNumberOfPlayers());
    }


    private Players assignPlayers() {
        try {
            return new PlayersBuilder(InputView.inputPlayers()).buildPlayers();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return assignPlayers();
        }
    }

    private Destinations assignResults(Players players) {
        try {
            Destinations destinations = new DestinationsBuilder(InputView.inputResults()).buildDestinations();
            checkPlayersWithResults(players, destinations);
            return destinations;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return assignResults(players);
        }
    }


    private LadderHeight assignLadderHeight() {
        try {
            return new LadderHeight(InputView.inputLadderHeight());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return assignLadderHeight();
        }
    }

    private void checkPlayersWithResults(Players players, Destinations destinations) {
        if (destinations.matchPlayersCount(players.getNumberOfPlayers())) {
            throw new IllegalArgumentException("개수가 같아야됩니다(플레이어, 결과)");
        }
    }

    public void printLadderScreen() {
        OutputView.showPlayers(this.players);
        OutputView.showLadder(this.ladder);
        OutputView.showDestinations(this.destinations);
    }

    public void proceedGame() {
        String command;
        do {
            command = InputView.inputCommand();
        } while (proceedWithCommand(command));
        OutputView.showAllResult(this.players, this.destinations, this.ladder);
    }

    private boolean proceedWithCommand(String command) {
        try {
            if (command.equals("all")) {
                return false;
            }
            OutputView.showResult(destinations.getDestination
                    (ladder.findDestinationPosition(players.getIndexOfName(command))));
            return true;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return true;
        }
    }
}
