package ladder.client;

import ladder.client.view.InputView;
import ladder.client.view.OutputView;
import ladder.domain.LadderGame;
import ladder.dto.PlayerResultDto;

/**
 * 이 클래스는 사다리 게임을 실행하는 클라이언트 클래스입니다
 * <p>
 * 이 클래스는 사다리 게임에서 필요한 데이터를 입력 받는 과정에서 발생하는 에러를 잡아서 다시 입력을 받습니다
 * <p>
 * LadderGame 클래스를 통해서 사다리 게임을 실행하고, OutputView 를 통해서 출력해주는 책임을 가지고 있습니다
 */
public class LadderGameClient {

    private static final String ALL_RESULT = "all";

    private final InputView inputView;
    private final LadderGame ladderGame;

    public LadderGameClient(InputView inputView, LadderGame ladderGame) {
        this.inputView = inputView;
        this.ladderGame = ladderGame;
    }

    public void play() {
        initializeLadderGame();
        OutputView.printLadder(ladderGame.getLadderInfo());
        PlayerResultDto ladderGameResult = ladderGame.calculateResult();
        printResult(ladderGameResult);
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

    private void printResult(PlayerResultDto ladderGameResult) {
        String targetPlayerName;
        do {
            targetPlayerName = inputView.inputPlayerResult();
            printResult(ladderGameResult, targetPlayerName);
        } while (!ALL_RESULT.equals(targetPlayerName));
    }

    private void printResult(PlayerResultDto ladderGameResult, String targetPlayerName) {
        if (ALL_RESULT.equals(targetPlayerName)) {
            OutputView.printResults(ladderGameResult.getPlayerResults());
            return;
        }
        OutputView.printResult(ladderGameResult.getPlayerResults()
                .get(targetPlayerName));
    }

    private void repeatIfError(Runnable runnable) {
        try {
            runnable.run();
        } catch (IllegalArgumentException e) {
            OutputView.printError(e);
            repeatIfError(runnable);
        }
    }
}
