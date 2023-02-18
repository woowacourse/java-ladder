package controller;

import domain.Game;
import domain.Height;
import domain.Ladder;
import domain.LadderResults;
import domain.Lines;
import domain.Player;
import domain.Players;
import java.util.List;
import view.InputView;
import view.OutputView;

public class LadderGameController {

    private final InputView inputView;
    private final OutputView outputView;

    public LadderGameController() {
        this.inputView = new InputView();
        this.outputView = new OutputView();
    }

    public void run() {
        Players players = makePlayers();

        // Todo: players의 참여자 수에 의존하는 문제.. (추후 리팩토링)
        LadderResults ladderResults = makeLadderResults(players.findNumberOfPlayers());
        Ladder ladder = makeLadder(players.findNumberOfPlayers());

        outputView.printLadderGameStatus(players, ladder, ladderResults);

        Game game = new Game(ladder, players, ladderResults);
        printResultOfPlayer(players);
    }

    private void printResultOfPlayer(Players players) {
        while (true) {
            String command = makeCommand();

            if (command.equals("all")) {
                for (Player player : players.getPlayers()) {
                    System.out.println(player.getName() + " " + player.getResult());
                }
                return;
            }

            System.out.println("\n실행 결과");
            Player player = players.findPlayer(command);
            System.out.println(player.getName() + " " + player.getResult());
        }
    }

    private Players makePlayers() {
        try {
            List<String> playerNames = inputView.readPlayerNames();
            return new Players(playerNames);
        } catch (IllegalArgumentException exception) {
            System.out.println(exception.getMessage());
            return makePlayers();
        }
    }

    private LadderResults makeLadderResults(int numberOfPlayer) {
        try {
            List<String> ladderResults = inputView.readLadderResults();
            return new LadderResults(ladderResults, numberOfPlayer);
        } catch (IllegalArgumentException exception) {
            System.out.println(exception.getMessage());
            return makeLadderResults(numberOfPlayer);
        }
    }

    private Ladder makeLadder(final int numberOfPlayers) {
        try {
            int ladderHeight = inputView.readHeight();
            Ladder ladder = new Ladder(new Lines(numberOfPlayers, ladderHeight), new Height(ladderHeight));
            return ladder;
        } catch (IllegalArgumentException exception) {
            System.out.println(exception.getMessage());
            return makeLadder(numberOfPlayers);
        }
    }

    private String makeCommand() {
        try {
            String command = inputView.readCommand();
            return command;
        } catch (IllegalArgumentException exception) {
            System.out.println(exception.getMessage());
            return makeCommand();
        }
    }
}
