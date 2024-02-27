package domain;

import java.util.HashMap;
import java.util.Map;

public class PrizeResults {

    private static final String GET_ALL_RESULT_OPERATOR = "all";
    private final Map<Player, Prize> results;

    private PrizeResults(Map<Player, Prize> results) {
        this.results = results;
    }

    public static PrizeResults of(Players players, Prizes prizes) {
        validateRange(players, prizes);
        Map<Player, Prize> results = new HashMap<>();
        return new PrizeResults(results);
    }

    private static void validateRange(Players players, Prizes prizes) {
        if (players.getSize() != prizes.getSize()) {
            throw new IllegalArgumentException(String.format("실행 결과는 참여자와 같은 갯수를 입력해주세요. 입력 : %d개", prizes.getSize()));
        }
    }

    public boolean checkOperate(String op) {
        validateOperate(op);
        if (op.equals(GET_ALL_RESULT_OPERATOR)) {
            return false;
        }
        return true;
    }
    
    private void validateOperate(String op) {
        if (!GET_ALL_RESULT_OPERATOR.equals(op) && !results.keySet().contains(op)) {
            throw new IllegalArgumentException(String.format("보고 싶은 결과는 all 또는 사용자 이름으로 입력해주세요. 입력 : %s", op));
        }
    }

}
