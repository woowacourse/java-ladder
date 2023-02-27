package controller;

import java.util.List;
import model.Ladder;
import model.LadderGame;
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
        List<String> players = inputPlayers();
        List<String> results = inputResults();
        int height = inputHeight();
        LadderGame ladderGame = new LadderGame(results, players);
        Ladder ladder = new Ladder(height, ladderGame.numberOfPlayer(), passGenerator);
        printLadderInfo(ladder, results, ladderGame);
        outputView.noticeResultTarget();
        printWinningInfo(ladder, ladderGame);
    }

    private void printLadderInfo(Ladder ladder, List<String> results, LadderGame ladderGame) {
        outputView.noticeLadderResult();
        outputView.printLadder(ladderGame.getPlayers(), ladder.getLadder(), results);
    }

    private void printWinningInfo(Ladder ladder, LadderGame ladderGame) {
        outputView.noticeResultTarget();
        String targetName = inputView.inputTargetName();
        outputView.printWinningInfo(ladderGame.gameResult(ladder), targetName);
    }

    private int inputHeight() {
        outputView.noticeInputHeightOfLadder();
        return inputView.inputHeightOfLadder();
    }

    private List<String> inputResults() {
        outputView.noticeInputResults();
        return inputView.inputResult();
    }

    private List<String> inputPlayers() {
        outputView.noticeInputParticipants();
        return inputView.inputNameOfParticipants();
    }
}
