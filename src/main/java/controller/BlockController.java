package controller;

import java.util.List;
import model.Ladder;
import game.LadderGame;
import model.Players;
import strategy.PassGenerator;
import view.InputView;
import view.OutputView;

public class BlockController {

    private final InputView inputView;
    private final OutputView outputView;
    private final PassGenerator passGenerator;

    public BlockController(InputView inputView, OutputView outputView, PassGenerator passGenerator) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.passGenerator = passGenerator;
    }

    public void run() {
        Players players = inputPlayers();
        List<String> results = inputResults();
        int height = inputHeight();
        LadderGame ladderGame = buildLadder(players, results, height);
        printLadderInfo(results, ladderGame);
    }

    private void printLadderInfo(List<String> results, LadderGame ladderGame) {
        outputView.noticeResultTarget();
        ladderGame.calculateFinalPosition();
        String targetName = inputView.inputTargetName();
        printWinningInfo(results, ladderGame, targetName);
    }

    private void printWinningInfo(List<String> results, LadderGame ladderGame, String targetName) {
        outputView.printWinningInfo(ladderGame.getFinalPlayerResult(targetName), results);
    }

    private LadderGame buildLadder(Players players, List<String> results, int height) {
        Ladder ladder = new Ladder(height, players, passGenerator);
        LadderGame ladderGame = new LadderGame(results, ladder);
        outputView.noticeLadderResult();
        outputView.printLadder(players.getPlayersName(), ladder.getLadder(), results);
        return ladderGame;
    }

    private int inputHeight() {
        outputView.noticeInputHeightOfLadder();
        return inputView.inputHeightOfLadder();
    }

    private List<String> inputResults() {
        outputView.noticeInputResults();
        return inputView.inputResult();
    }

    private Players inputPlayers() {
        outputView.noticeInputParticipants();
        return new Players(inputView.inputNameOfParticipants());
    }
}
