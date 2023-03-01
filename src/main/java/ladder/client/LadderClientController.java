package ladder.client;

import java.util.Map;
import ladder.client.view.InputView;
import ladder.client.view.OutputView;
import ladder.domain.LadderGameController;

/**
 * 이 클래스는 사다리 게임을 실행하는 클라이언트 클래스입니다
 * <p>
 * 이 클래스는 사다리 게임에서 필요한 데이터를 입력 받는 과정에서 발생하는 에러를 잡아서 다시 입력을 받습니다
 * <p>
 * LadderGame 클래스를 통해서 사다리 게임을 실행하고, OutputView 를 통해서 출력해주는 책임을 가지고 있습니다
 */
public class LadderClientController {

    private static final String ALL_RESULT = "all";

    private final InputView inputView;
    private final OutputView outputView;
    private final LadderGameController ladderGame;

    public LadderClientController(InputView inputView, OutputView outputView, LadderGameController ladderGame) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.ladderGame = ladderGame;
    }

    public void play() {
        initializeLadderGame();
        printLadderInfo();
        printResult(ladderGame.calculateResult());
    }


    private void initializeLadderGame() {
        repeatIfError(this::initializePlayers);
        repeatIfError(this::initializeResults);
        repeatIfError(this::initializeLadder);
    }

    private void initializePlayers() {
        ladderGame.initializePlayers(inputView.inputPlayerNames());
    }

    private void initializeResults() {
        ladderGame.initializeResults(inputView.inputResultNames());
    }

    private void initializeLadder() {
        ladderGame.initializeLadder(inputView.inputHeight());
    }

    private void printLadderInfo() {
        outputView.printLadderTitle();
        outputView.printPlayerNames(ladderGame.getPlayerNames());
        outputView.printLadderRows(ladderGame.getLadderRows());
        outputView.printResultNames(ladderGame.getResultNames());
    }


    private void printResult(Map<String, String> ladderGameResult) {
        String targetPlayerName;
        do {
            targetPlayerName = inputView.inputPlayerResult();
            printResult(ladderGameResult, targetPlayerName);
        } while (!ALL_RESULT.equals(targetPlayerName));
    }

    private void printResult(Map<String, String> ladderGameResult, String targetPlayerName) {
        if (ALL_RESULT.equals(targetPlayerName)) {
            outputView.printResults(ladderGameResult);
            return;
        }
        outputView.printResult(ladderGameResult.get(targetPlayerName));
    }

    private void repeatIfError(Runnable runnable) {
        try {
            runnable.run();
        } catch (IllegalArgumentException e) {
            outputView.printError(e);
            repeatIfError(runnable);
        }
    }
}
