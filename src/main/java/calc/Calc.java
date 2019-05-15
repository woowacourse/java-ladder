package calc;

import java.util.List;

public class Calc {

    static int sum(String input){
        List<Integer> tokens = Expression.getTokens(input);
        if (tokens.isEmpty()) {
            throw new RuntimeException();
        }
        return tokens.stream().reduce(0, (x, y) -> x + y);
    }
}