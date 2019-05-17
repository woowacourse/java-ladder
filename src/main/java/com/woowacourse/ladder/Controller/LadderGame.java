package com.woowacourse.ladder.Controller;

import com.woowacourse.ladder.InputValidator;
import com.woowacourse.ladder.domain.*;
import com.woowacourse.ladder.view.InputVIew;
import com.woowacourse.ladder.view.OutputView;

public class LadderGame {

    public static void main(String[] args) {
        PlayerList playerList = InputVIew.promptPlayerNames();
        ResultItems resultItems = InputVIew.promptExecuteResults(playerList);
        Height height = InputVIew.promptHeight();

        Ladder ladder = PartGenerator.generateLadder(playerList.getNames().size(), height.getHeight());

        OutputView.printLadder(playerList, resultItems, ladder);
        ResultQuery resultQuery = InputVIew.promptResultQuery(playerList);
        String resultQueryName = resultQuery.toString();

        printResult(playerList, resultItems, ladder, resultQueryName);
    }

    private static void printResult(PlayerList playerList, ResultItems resultItems, Ladder ladder,
                                    String resultQueryName) {
        if (!InputValidator.isNotAll(resultQueryName)) { // all일 때
            OutputView.executePrintResult(playerList, ladder, resultItems);
            return;
        }
        Result result = OutputView.executeOneResult(playerList, ladder, resultQueryName, resultItems);
        OutputView.printResult(result);
    }




}
