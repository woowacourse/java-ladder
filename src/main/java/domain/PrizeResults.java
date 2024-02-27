package domain;

import java.util.HashMap;
import java.util.Map;

public class PrizeResults {
    private final Map<Player, Prize> results;

    private PrizeResults(Map<Player, Prize> results) {
        this.results = results;
    }

    public static PrizeResults of(Players players, Prizes prizes) {
        validate(players, prizes);
        Map<Player, Prize> results = new HashMap<>();
        return new PrizeResults(results);
    }

    private static void validate(Players players, Prizes prizes) {
        if (players.getSize() != prizes.getSize()) {
            throw new IllegalArgumentException(String.format("실행 결과는 참여자와 같은 갯수를 입력해주세요. 입력 : %d개", prizes.getSize()));
        }
    }

}
