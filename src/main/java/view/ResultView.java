package view;

import domain.WinningResult;

import java.util.Map;

public class ResultView {
    private static final String RESULT_PRINT_GUIDE_MESSAGE = "\n실행결과";
    private static final String NON_EXIST_USER_GUIDE_MESSAGE = "존재하지 않는 유저이름 입니다.\n";
    private static final String PRINT_ALL_RESULT_DELIMITER = " : ";
    private static final String GAME_EXIT_MESSAGE = "모든 결과를 출력하고 종료합니다.";

    public void printNonExistUser() {
        System.out.println(NON_EXIST_USER_GUIDE_MESSAGE);
    }

    public void printResult(final Map<String, WinningResult> result) {
        System.out.println(RESULT_PRINT_GUIDE_MESSAGE);
        for (Map.Entry<String, WinningResult> gameResult : result.entrySet()) {
            System.out.println(gameResult.getKey() + PRINT_ALL_RESULT_DELIMITER + gameResult.getValue().getWinningResult());
        }
    }

    public void printGameExitMessage() {
        System.out.println(GAME_EXIT_MESSAGE);
    }
}
