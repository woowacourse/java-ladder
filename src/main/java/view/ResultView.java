package view;

import java.util.Map;

public class ResultView {
    private static final String RESULT_PRINT_GUIDE_MESSAGE = "\n실행결과";
    private static final String NON_EXIST_USER_GUIDE_MESSAGE = "존재하지 않는 유저이름 입니다.";
    private static final String PRINT_ALL_RESULT_DELIMITER = " : ";
    public void printUserResult(String result) {
        System.out.println(RESULT_PRINT_GUIDE_MESSAGE);
        System.out.println(result);
    }

    public void printAllResult(Map<String, String> result) {
        System.out.println(RESULT_PRINT_GUIDE_MESSAGE);
        for (String user : result.keySet()) {
            System.out.println(user + PRINT_ALL_RESULT_DELIMITER + result.get(user));
        }
    }

    public void printNonExistUser() {
        System.out.println(NON_EXIST_USER_GUIDE_MESSAGE);
    }
}
