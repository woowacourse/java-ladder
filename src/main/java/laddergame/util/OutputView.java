package laddergame.util;

import laddergame.domain.*;

public class OutputView {
    public static void outputMessage(String message) {
        System.out.println(message);
    }

    public static void outputLadderGame(Ladder ladder, Players players, Rewards rewards) {
        System.out.println("사다리 결과");
        System.out.println(players);
        System.out.print(ladder);
        System.out.println(rewards);
    }

    public static void outputLadderGameResult(String name, LadderGameResult ladderGameResult) {
        System.out.println("실행 결과");
        if ("all".equals(name)) {
            System.out.println(ladderGameResult);
            return;
        }
        System.out.println(ladderGameResult.result(name).toString().trim());
    }

    public static void outputErrorMessage(String message) {
        if (message == null) {
            message = "에러가 발생했습니다.";
        }
        System.err.println(message);
    }
}
