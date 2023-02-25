package ladder.client.view;

import ladder.domain.LadderGame;

/**
 * 이 클래스는 사다리 게임을 실행하는 클라이언트 클래스입니다
 * <p>
 * 이 클래스는 사다리 게임에서 필요한 데이터를 입력 받는 과정에서 발생하는 에러를 잡아서 다시 입력을 받습니다
 * <p>
 * LadderGame 클래스를 통해서 사다리 게임을 실행하고, 사용자와 출력해주는 책임을 가지고 있습니다
 */
public class LadderGameClient {

    private final InputView inputView;
    private final LadderGame ladderGame;

    public LadderGameClient(InputView inputView, LadderGame ladderGame) {
        this.inputView = inputView;
        this.ladderGame = ladderGame;
    }

    public void play() {
        initializeLadderGame();
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

    private void repeatIfError(Runnable runnable) {
        try {
            runnable.run();
        } catch (IllegalArgumentException e) {
            OutputView.printError(e);
            repeatIfError(runnable);
        }
    }
}
