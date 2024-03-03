package view;

import java.util.List;

public class LadderGameOperatorInputView {
    public static String getOperator(String rawString, List<String> playerNames) {
        validateOperator(rawString, playerNames);
        return rawString;
    }

    private static void validateOperator(String rawString, List<String> playerNames) {
        if (!playerNames.contains(rawString) && !rawString.equals("all")) {
            throw new IllegalArgumentException("없는 참가자 입니다.");
        }
    }
}
