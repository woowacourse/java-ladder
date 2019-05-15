package com.woowacourse.ladder;

import com.woowacourse.ladder.domain.*;
import com.woowacourse.ladder.interfaces.InputView;
import com.woowacourse.ladder.interfaces.OutputView;
import com.woowacourse.ladder.view.ConsoleInputView;
import com.woowacourse.ladder.view.ConsoleOutputView;

import java.util.List;
import java.util.stream.Collectors;

import static com.woowacourse.ladder.LadderController.executeResultQuery;

public class AppMain {
    private static InputView inputView;
    private static OutputView outputView;

    public static void main(String[] args) {
        inputView = new ConsoleInputView();
        outputView = new ConsoleOutputView();

        Ladder<String, String> ladder = LadderController.createLadder(
            inputView.promptNames(),
            inputView.promptDestinations(),
            inputView.promptLadderHeight()
        );

        outputView.printLadder(ladder);

        String query = inputView.promptResultQuery();

        while(!query.isEmpty()) {
            outputView.printResult(LadderController.executeResultQuery(ladder, query));
            query = inputView.promptResultQuery();
        }
    }

}
