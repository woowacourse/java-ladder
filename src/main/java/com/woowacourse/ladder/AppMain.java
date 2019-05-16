package com.woowacourse.ladder;

import com.woowacourse.ladder.domain.Ladder;
import com.woowacourse.ladder.domain.LadderResult;
import com.woowacourse.ladder.interfaces.InputView;
import com.woowacourse.ladder.interfaces.OutputView;
import com.woowacourse.ladder.view.ConsoleInputView;
import com.woowacourse.ladder.view.ConsoleOutputView;

import java.util.List;

public class AppMain {
    private static InputView inputView = new ConsoleInputView();
    private static OutputView outputView = new ConsoleOutputView();
    private static List<String> participants;
    private static List<String> destinations;

    public static void main(String[] args) {
        Ladder ladder = loopUntilLadderCreated();
        LadderResult result = ladder.explore(participants, destinations);
        outputView.printLadder(ladder, participants, destinations);

        String query = inputView.promptResultQuery();

        while (!query.isEmpty()) {
            handleQuery(result, query);
            query = inputView.promptResultQuery();
        }
    }

    private static Ladder loopUntilLadderCreated() {
        Ladder ladder = tryCreatingLadder();
        while (ladder == null) {
            outputView.printError("사다리를 생성할 수 없습니다. 입력값을 다시 확인해주세요.");
            ladder = tryCreatingLadder();
        }
        return ladder;
    }

    private static Ladder tryCreatingLadder() {
        try {
            return createLadder();
        } catch (IllegalArgumentException | IllegalStateException e) {
            return null;
        }
    }

    private static Ladder createLadder() {
        participants = inputView.promptNames();
        destinations = inputView.promptDestinations();
        int height = inputView.promptLadderHeight();
        return LadderController.createLadder(
            participants,
            destinations,
            height
        );
    }

    private static void handleQuery(LadderResult result, String query) {
        if (!tryQuery(result, query)) {
            outputView.printError("올바르지 않은 입력입니다");
        }
    }

    /**
     * 결과 조회 쿼리를 실행하고 처리 여부를 반환
     *
     * @param result
     * @param query
     * @return 쿼리가 정상적으로 처리된 경우 true, 예외가 발생한 경우 false
     */
    private static boolean tryQuery(LadderResult result, String query) {
        try {
            outputView.printResult(LadderController.executeResultQuery(result, query, participants));
            return true;
        } catch (IllegalArgumentException e) {
            return false;
        }
    }
}
