package controller;

import domain.*;
import domain.ladder.Ladder;
import domain.ladder.common.Height;
import domain.player.Name;
import domain.player.Names;
import domain.player.Player;
import domain.player.Players;
import util.RandomDirectionGenerator;
import view.InputView;
import view.OutputView;

import java.util.List;
import java.util.stream.IntStream;

public class GameController {
    private static final String ALL_COMMAND = "all";

    public void execute() {
        Players players = createPlayers();
        Rewards rewards = Rewards.from(InputView.inputRewards(), players.getPlayerCount());
        Height height = new Height(InputView.inputHeight());
        Ladder ladder = new Ladder(height, players.getPlayerCount(), new RandomDirectionGenerator());
        GameBoard gameBoard = new GameBoard(players, ladder, rewards);

        printGameBoard(gameBoard);
        processGameResults(gameBoard);
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

    private Players createPlayers() {
        Names names = Names.from(InputView.inputPlayerNames());
        return new Players(names);
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


    private void printGameBoard(GameBoard gameBoard) {
        printPlayer(gameBoard.getPlayers());
        printLadder(gameBoard.getLadder(), gameBoard.getLadderHeight());
        printReward(gameBoard.getRewards());

    }

    private void printPlayer(Players players) {
        OutputView.printPlayerNames(players.getPlayerNames());
    }

    private void printLadder(Ladder ladder, int height) {
        IntStream.range(0, height)
                 .mapToObj(ladder::getDirectionAtHorizontalIndex)
                 .forEach(OutputView::printDirections);
    }

    private void printReward(Rewards rewards) {
        OutputView.printRewards(rewards.getValue());
    }
}
