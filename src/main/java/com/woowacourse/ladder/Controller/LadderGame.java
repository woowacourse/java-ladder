package com.woowacourse.ladder.Controller;

import com.woowacourse.ladder.InputValidator;
import com.woowacourse.ladder.domain.*;
import com.woowacourse.ladder.view.InputVIew;
import com.woowacourse.ladder.view.OutputView;

import java.util.ArrayList;
import java.util.List;

public class LadderGame {

    public static void main(String[] args) {
        PlayerList playerList = getPlayerList();
        ResultItems resultItems = getResultItems(playerList);
        Height height = getHeight();

        Ladder ladder = LadderGenerator.generateLadder(playerList.getNames().size(), height.getHeight());
        OutputView.printLadder(playerList, resultItems, ladder);

        ResultQuery resultQuery = getResultQuery(playerList);
        findResults(playerList, resultItems, ladder, resultQuery);

    }

    private static void findResults(PlayerList playerList, ResultItems resultItems, Ladder ladder,
                                    ResultQuery resultQuery) {
        List<Result> results = new ArrayList<>();
        if (resultQuery.isAll("all")) {
            List<Integer> answer = ladder.takeAllLadder();
            for (int i = 0; i < answer.size(); i++) {
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
        return ResultGenerator.generateResult(playerList.getNames().get(index), executeResult);
    }

    private static ResultQuery getResultQuery(PlayerList playerList) {
        String inputResultQuery = InputVIew.promptResultQuery();

        while ((InputValidator.isNotAll(inputResultQuery) && playerList.isNotContain(inputResultQuery))
                || InputValidator.isEmptyString(inputResultQuery)) {
            System.out.println("결과를 보고 싶은 사람을 올바르게 입력해주세요.");
            inputResultQuery = InputVIew.promptResultQuery();
        }
        return new ResultQuery(inputResultQuery);
    }

    private static Height getHeight() {
        String inputHeight = InputVIew.promptHeight();
        while (InputValidator.isNotValidHeight(inputHeight)) {
            System.out.println("올바른 사다리 높이를 입력해주세요.");
            inputHeight = InputVIew.promptHeight();
        }

        return new Height(inputHeight);
    }

    private static ResultItems getResultItems(PlayerList playerList) {
        List<String> executeResults = InputVIew.promptExecuteResults();
        while (InputValidator.isNotValidDestinationsInput(executeResults) || executeResults.size() != playerList.getSize()) {
            System.out.println("올바른 실행결과를 입력해주세요.");
            executeResults = InputVIew.promptExecuteResults();
        }

        return new ResultItems(executeResults);
    }

    private static PlayerList getPlayerList() {
        List<String> playerNames = InputVIew.promptPlayerNames();

        while (InputValidator.isNotValidNamesInput(playerNames)) {
            System.out.println("올바른 사람 이름을 입력하세요.(all이란 이름은 금지입니다.)");
            playerNames = InputVIew.promptPlayerNames();
        }
        return new PlayerList(playerNames);
    }
}
