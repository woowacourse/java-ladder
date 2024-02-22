package controller;

import domain.*;
import domain.ladder.Ladder;
import domain.ladder.common.Height;
import domain.player.Names;
import domain.player.Player;
import util.RandomDirectionGenerator;
import view.InputView;
import view.OutputView;

import java.util.List;

public class GameController {
    public void execute() {
        Names names = new Names(InputView.inputPlayerNames());
        Height height = new Height(InputView.inputHeight());

        List<Player> players = names.getValue()
                                    .stream()
                                    .map(Player::new)
                                    .toList();
        RandomDirectionGenerator randomDirectionGenerator = new RandomDirectionGenerator();
        Ladder ladder = new Ladder(height, players.size(), randomDirectionGenerator);
        GameBoard gameBoard = new GameBoard(players, ladder);

        for (int i = 0; i < height.getHeight(); i++) {
            gameBoard.getDirectionAtHorizontalIndex(i)
                     .forEach(OutputView::printDirection);
            System.out.println();
        }
    }

}
