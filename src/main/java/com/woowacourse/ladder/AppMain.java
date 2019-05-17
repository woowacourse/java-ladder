package com.woowacourse.ladder;

import com.woowacourse.ladder.domain.LadderResult;
import com.woowacourse.ladder.domain.LadderState;
import com.woowacourse.ladder.domain.MatchPair;
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
    private static LadderState state;
    private static LadderResult result;
    private static int height;

    public static void main(String[] args) {
        result = createAndExploreLadder();
        outputView.printLadder(state, participants, destinations);

        String query = inputView.promptResultQuery();
        while(!query.isEmpty()) {
            checkMatchPairsAndPrint(tryHandleQuery(query));
            query = inputView.promptResultQuery();
        }
    }

    private static LadderResult createAndExploreLadder() {
        getInputForCreateLadder();
        state = tryCreateState();
        LadderResult result = tryMatchLadder();
        while (result == null || state == null) {
            getInputForCreateLadder();
            state = tryCreateState();
            result = tryMatchLadder();
        }
        return result;
    }

    private static void getInputForCreateLadder() {
        participants = inputView.promptNames();
        destinations = inputView.promptDestinations();
        height = inputView.promptLadderHeight();
    }

    private static LadderState tryCreateState() {
        try {
            return createLadderState();
        } catch (IllegalArgumentException e) {
            outputView.printError("잘못된 높이입니다.");
        }
        return null;
    }

    private static LadderState createLadderState() {
        return LadderController.createLadderState(participants.size(), height);
    }

    private static LadderResult tryMatchLadder() {
        try {
            return LadderController.matchLadder(
                state,
                participants,
                destinations);
        } catch (IllegalArgumentException e) {
            outputView.printError("참가자와 결과의 수가 다릅니다.");
        } catch (IllegalStateException e) {
            outputView.printError("참가자 또는 결과가 비어있습니다.");
        }
        return null;
    }

    private static List<MatchPair> tryHandleQuery(String query) {
        try {
            return LadderController.executeResultQuery(result, query, participants);
        } catch (IllegalArgumentException e) {
            outputView.printError("올바르지 않은 입력입니다");
        }
        return null;
    }

    private static void checkMatchPairsAndPrint(List<MatchPair> matchPairs) {
        if (matchPairs == null) {
            return;
        }
        outputView.printResult(matchPairs);
    }
}
