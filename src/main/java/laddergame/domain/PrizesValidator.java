package laddergame.domain;

import java.util.List;

public class PrizesValidator {
    public static void checkConditions(List<String> inputs, int numOfPlayers) {
        if (inputs.size() != numOfPlayers) {
            throw new IllegalArgumentException("상품의 수가 올바르지 않습니다.\n다시 입력하세요.");
        }
    }
}
