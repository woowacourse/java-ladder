package com.woowacourse.ladder.Controller;

import com.woowacourse.ladder.InputValidator;
import com.woowacourse.ladder.domain.*;
import com.woowacourse.ladder.view.InputView;
import com.woowacourse.ladder.view.OutputView;

import java.util.ArrayList;
import java.util.List;

public class LadderGame {

    public static void main(String[] args) {
        PlayerList playerList = getPlayerList();
        ResultItems resultItems = getResultItems(playerList);
        Height height = getHeight();

        Ladder ladder = LadderGenerator.generateLadder(playerList.getSize(), height);
        OutputView.printLadder(playerList, resultItems, ladder);

        ResultQuery resultQuery = getResultQuery(playerList);
        findResults(playerList, resultItems, ladder, resultQuery);

    }

    private static PlayerList getPlayerList() {
        List<String> playerNames = InputView.promptPlayerNames();

        while (InputValidator.isNotValidNamesInput(playerNames)) {
            System.out.println("올바른 사람 이름을 입력하세요.(all이란 이름은 금지입니다.)");
            playerNames = InputView.promptPlayerNames();
        }
        return new PlayerList(playerNames);
    }

    private static ResultItems getResultItems(PlayerList playerList) {
        List<String> executeResults = InputView.promptExecuteResults();
        while (InputValidator.isNotValidDestinationsInput(executeResults) || executeResults.size() != playerList.getSize()) {
            System.out.println("올바른 실행결과를 입력해주세요.");
            executeResults = InputView.promptExecuteResults();
        }

        return new ResultItems(executeResults);
    }

    private static Height getHeight() {
        String inputHeight = InputView.promptHeight();
        while (InputValidator.isNotValidHeight(inputHeight)) {
            System.out.println("올바른 사다리 높이를 입력해주세요.");
            inputHeight = InputView.promptHeight();
        }

        return new Height(inputHeight);
    }

    private static ResultQuery getResultQuery(PlayerList playerList) {
        String inputResultQuery = InputView.promptResultQuery();

        while ((InputValidator.isNotAll(inputResultQuery) && playerList.isNotContain(inputResultQuery))
                || InputValidator.isEmptyString(inputResultQuery)) {
            System.out.println("결과를 보고 싶은 사람을 올바르게 입력해주세요.");
            inputResultQuery = InputView.promptResultQuery();
        }
        return new ResultQuery(inputResultQuery);
    }

    private static void findResults(PlayerList playerList, ResultItems resultItems, Ladder ladder,
                                    ResultQuery resultQuery) {
        List<Result> results = new ArrayList<>();
        if (resultQuery.isAll("all")) {
            for (int i = 0; i < playerList.getSize(); i++) {
                results.add(findResult(playerList, resultItems, ladder, i));
            }
            OutputView.printResults(results);
            return;
        }
        int playerOrder = playerList.findPlayer(resultQuery.toString());
        OutputView.printResult(findResult(playerList, resultItems, ladder, playerOrder));
    }

    private static Result findResult(PlayerList playerList, ResultItems resultItems, Ladder ladder, int index) {
        int answer = ladder.takeLadder(index);
        String executeResult = resultItems.getResult(answer);
        return ResultGenerator.generateResult(playerList.getName(index), executeResult);
    }


}
