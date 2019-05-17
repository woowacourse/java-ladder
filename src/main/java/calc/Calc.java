package calc;

import java.util.List;

public class Calc {
    static int sum(String input) throws RuntimeException {
        List<Integer> tokens = Expression.getTokens(input);
        if (tokens.isEmpty()) {
            throw new RuntimeException("입력이 잘못되었습니다.");
        }
        return tokens.stream().reduce(0, (x, y) -> x + y);
    }
}