package view;

import java.util.Map;

public class ResultView {
    private static final String RESULT_PRINT_GUIDE_MESSAGE = "\n실행결과";
    private static final String NON_EXIST_USER_GUIDE_MESSAGE = "존재하지 않는 유저이름 입니다.";
    private static final String PRINT_ALL_RESULT_DELIMITER = " : ";
    private static final String GAME_EXIT_MESSAGE = "모든 결과를 출력하고 종료합니다.";
    public void printUserResult(final String result) {
        System.out.println(RESULT_PRINT_GUIDE_MESSAGE);
        System.out.println(result);
    }

    public void printAllResult(final Map<String, String> result) {
        System.out.println(RESULT_PRINT_GUIDE_MESSAGE);
        for (String user : result.keySet()) {
            System.out.println(user + PRINT_ALL_RESULT_DELIMITER + result.get(user));
        }
        System.out.println(GAME_EXIT_MESSAGE);
    }

    public void printNonExistUser() {
        System.out.println(NON_EXIST_USER_GUIDE_MESSAGE);
    }
}
