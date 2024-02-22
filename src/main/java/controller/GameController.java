package controller;

import domain.*;
import domain.ladder.Ladder;
import domain.ladder.common.Height;
import domain.player.Name;
import domain.player.Names;
import domain.player.Player;
import util.RandomDirectionGenerator;
import view.InputView;
import view.OutputView;

import java.util.List;
import java.util.stream.IntStream;

public class GameController {
    public void execute() {
        Names names = new Names(InputView.inputPlayerNames());
        Height height = new Height(InputView.inputHeight());

        List<Player> players = createPlayers(names);
        Ladder ladder = new Ladder(height, players.size(), new RandomDirectionGenerator());
        GameBoard gameBoard = new GameBoard(players, ladder);

        printResult(gameBoard);
    }

    private void printResult(GameBoard gameBoard) {
        OutputView.printPlayerNames(extractPlayerNames(gameBoard.getPlayers()));
        IntStream.range(0, gameBoard.getLadderHeight())
                 .mapToObj(gameBoard::getDirectionAtHorizontalIndex)
                 .forEach(OutputView::printDirections);
    }

    private List<Name> extractPlayerNames(List<Player> players) {
        return players.stream()
                      .map(Player::getName)
                      .toList();
    }

    private List<Player> createPlayers(Names names) {
        return names.getValue()
                    .stream()
                    .map(Player::new)
                    .toList();
    }

}
