package controller;

import domain.*;
import domain.ladder.Ladder;
import domain.ladder.attribute.Height;
import domain.common.Name;
import domain.player.Names;
import domain.player.Player;
import domain.player.Players;
import domain.result.PlayerResult;
import domain.result.Results;
import util.RandomDirectionGenerator;
import view.InputView;
import view.LadderCommand;
import view.OutputView;

import java.util.List;

public class GameController {

    public void execute() {
        Players players = createPlayers();
        Results results = Results.from(InputView.inputRewards(), players.getPlayerCount());
        Height height = new Height(InputView.inputHeight());
        Ladder ladder = new Ladder(height, players.getPlayerCount(), new RandomDirectionGenerator());
        GameBoard gameBoard = new GameBoard(players, ladder, results);
        OutputView.printGameBoard(gameBoard);
        processGame(gameBoard);
    }

    private Players createPlayers() {
        Names names = Names.from(InputView.inputPlayerNames());
        return new Players(names);
    }

    private void processGame(GameBoard gameBoard) {
        final String playerName = InputView.inputResultPlayer();
        if (LadderCommand.isAllCommand(playerName)) {
            processAllPlayers(gameBoard);
            return;
        }
        processSinglePlayer(gameBoard, playerName);
        processGame(gameBoard);
    }

    private void processAllPlayers(GameBoard gameBoard) {
        List<PlayerResult> playerResults = gameBoard.playGameAllPlayer();
        OutputView.printResult(playerResults);
    }

    private void processSinglePlayer(GameBoard gameBoard, String playerName) {
        Name name = new Name(playerName);
        Player player = gameBoard.findPlayerWithName(name);
        PlayerResult playerResult = gameBoard.playGameOnePlayer(player);
        OutputView.printResult(playerResult);
    }


}
