package com.woowacourse.ladder;

import com.woowacourse.ladder.domain.Ladder;
import com.woowacourse.ladder.domain.LadderBuilder;
import com.woowacourse.ladder.domain.RandomBooleanGenerator;
import com.woowacourse.ladder.interfaces.InputView;
import com.woowacourse.ladder.interfaces.OutputView;
import com.woowacourse.ladder.view.ConsoleInputView;
import com.woowacourse.ladder.view.ConsoleOutputView;

import java.util.List;

public class AppMain {
    private static InputView inputView;
    private static OutputView outputView;

    public static void main(String[] args) {
        inputView = new ConsoleInputView();
        outputView = new ConsoleOutputView();

        Ladder<String, String> ladder = new LadderBuilder<String, String>()
            .withParticipants(inputView.promptNames())
            .withDestinations(inputView.promptDestinations())
            .withGenerator(new RandomBooleanGenerator())
            .withHeight(inputView.promptLadderHeight())
            .build();

        outputView.printLadder(ladder);

        List<String> resultQuery = inputView.promptNamesToQuery();
        while(!shouldExit(resultQuery)) {
            handleResultQuery(ladder, resultQuery);
            resultQuery = inputView.promptNamesToQuery();
            checkAndPrintAllResult(ladder, resultQuery);
        }
    }

    private static boolean shouldExit(List<String> queryTokens) {
        return queryTokens.size() == 1 && queryTokens.get(0).isEmpty();
    }

    private static void checkAndPrintAllResult(Ladder<String, String> ladder, List<String> queryTokens) {
        if (shouldPrintAllResult(queryTokens)) {
            outputView.printMultipleResult(ladder.getResult(), queryTokens);
        }
    }

    private static boolean shouldPrintAllResult(List<String> queryTokens) {
        return queryTokens.size() == 1 && queryTokens.get(0).equals("all");
    }

    private static void handleResultQuery(Ladder<String, String> ladder, List<String> query) {
        if (query.size() == 1) {
            outputView.printSingleResult(ladder.getResult().matchResult(query.get(0)));
            return;
        }

    }
}
