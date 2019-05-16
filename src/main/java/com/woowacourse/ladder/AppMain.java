package com.woowacourse.ladder;

import com.woowacourse.ladder.domain.Ladder;
import com.woowacourse.ladder.interfaces.InputView;
import com.woowacourse.ladder.interfaces.OutputView;
import com.woowacourse.ladder.view.ConsoleInputView;
import com.woowacourse.ladder.view.ConsoleOutputView;

public class AppMain {
    private static InputView inputView;
    private static OutputView outputView;

    public static void main(String[] args) {
        inputView = new ConsoleInputView();
        outputView = new ConsoleOutputView();
        Ladder<String, String> ladder = loopUntilLadderCreated();
        outputView.printLadder(ladder);

        String query = inputView.promptResultQuery();

        while (!query.isEmpty()) {
            handleQuery(ladder, query);
            query = inputView.promptResultQuery();
        }
    }

    private static void handleQuery(Ladder<String, String> ladder, String query) {
        if (!tryQuery(ladder, query)) {
            outputView.printError("올바르지 않은 입력입니다");
        }
    }

    private static Ladder<String, String> loopUntilLadderCreated() {
        Ladder<String, String> ladder;
        while ((ladder = tryCreatingLadder()) == null) {
            outputView.printError("사다리를 생성할 수 없습니다. 입력값을 다시 확인해주세요.");
        }
        return ladder;
    }

    private static Ladder<String, String> tryCreatingLadder() {
        try {
            return createLadder();
        } catch (IllegalArgumentException | IllegalStateException e) {
            return null;
        }
    }

    private static Ladder<String, String> createLadder() {
        return LadderController.createLadder(
            inputView.promptNames(),
            inputView.promptDestinations(),
            inputView.promptLadderHeight()
        );
    }

    /**
     * 결과 조회 쿼리를 실행하고 처리 여부를 반환
     *
     * @param ladder
     * @param query
     * @return 쿼리가 정상적으로 처리된 경우 true, 예외가 발생한 경우 false
     */
    private static boolean tryQuery(Ladder<String, String> ladder, String query) {
        try {
            outputView.printResult(LadderController.executeResultQuery(ladder, query));
            return true;
        } catch (IllegalArgumentException e) {
            return false;
        }
    }
}
