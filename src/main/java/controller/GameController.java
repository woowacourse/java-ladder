package controller;

import domain.*;
import domain.ladder.Ladder;
import domain.ladder.attribute.Height;
import domain.common.Name;
import domain.player.Names;
import domain.player.Player;
import domain.player.Players;
import domain.reward.Result;
import domain.reward.Rewards;
import util.RandomDirectionGenerator;
import view.InputView;
import view.OutputView;

import java.util.List;

public class GameController {
    private static final String ALL_COMMAND = "all";

    public void execute() {
        Players players = createPlayers();
        Rewards rewards = Rewards.from(InputView.inputRewards(), players.getPlayerCount());
        Height height = new Height(InputView.inputHeight());
        Ladder ladder = new Ladder(height, players.getPlayerCount(), new RandomDirectionGenerator());
        GameBoard gameBoard = new GameBoard(players, ladder, rewards);
        OutputView.printGameBoard(gameBoard);

        processGameResults(gameBoard);
    }

    private Players createPlayers() {
        Names names = Names.from(InputView.inputPlayerNames());
        return new Players(names);
    }

    private void processGameResults(GameBoard gameBoard) {
        while (true) {
            String playerName = InputView.inputResultPlayer();
            if (playerName.equals(ALL_COMMAND)) {
                processAllPlayers(gameBoard);
                break;
            }
            processSinglePlayer(gameBoard, playerName);
        }
    }

    private void processAllPlayers(GameBoard gameBoard) {
        List<Result> results = gameBoard.playGameAllPlayer();
        OutputView.printResult(results);
    }

    private void processSinglePlayer(GameBoard gameBoard, String playerName) {
        Name name = new Name(playerName);
        Player player = gameBoard.findPlayerWithName(name);
        Result result = gameBoard.playGameOnePlayer(player);
        OutputView.printResult(result);
    }


}
