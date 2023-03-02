package ladder.controller;

import java.util.function.Supplier;
import ladder.domain.Height;
import ladder.domain.Ladder;
import ladder.domain.LadderGame;
import ladder.domain.LadderResult;
import ladder.domain.Players;
import ladder.domain.Prizes;
import ladder.util.generator.RandomDirectionGenerator;
import ladder.view.InputView;
import ladder.view.OutputView;

public class LadderController {

    private static final String ALL_COMMAND = "all";

    private final InputView inputView;
    private final OutputView outputView;

    public LadderController(final InputView inputView, final OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run() {
        final Players players = createInstance(() -> Players.from(inputView.readPlayerNames()));
        final Prizes prizes = createInstance(() -> Prizes.from(inputView.readPrizeNames(), players));
        final Height height = createInstance(() -> new Height(inputView.readHeight()));
        final Ladder ladder = Ladder.of(new RandomDirectionGenerator(), players, height);
        outputView.printLadderGame(players, ladder, prizes);

        final LadderGame ladderGame = new LadderGame(players, ladder, prizes);
        final LadderResult ladderResult = ladderGame.getResult();
        final String target = createInstance(() -> readTarget(inputView.readTarget(), ladderResult));
        printResult(target, ladderResult);
    }

    /**
     * 도메인 생성 시 IllegalArgumentException 발생할 수 있으면 해당 메서드를 사용한다.
     */
    private <T> T createInstance(final Supplier<T> supplier) {
        int count = 5;
        while (count-- > 0) {
            try {
                return supplier.get();
            } catch (IllegalArgumentException e) {
                outputView.printErrorMessage(e.getMessage());
            }
        }
        throw new IllegalStateException("재입력 횟수를 초과하였습니다.");
    }

    private String readTarget(final String target, final LadderResult ladderResult) {
        if (target.equals(ALL_COMMAND) || ladderResult.exist(target)) {
            return target;
        }
        throw new IllegalArgumentException("결과를 확인할 수 없는 대상입니다. 존재하는 대상: " + ladderResult.getValue().keySet());
    }

    private void printResult(final String target, final LadderResult ladderResult) {
        if (target.equals(ALL_COMMAND)) {
            outputView.printResult(ladderResult);
            return;
        }
        outputView.printResult(ladderResult.extract(target));
    }
}
