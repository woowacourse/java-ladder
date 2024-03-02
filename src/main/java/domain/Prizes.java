package domain;

import java.util.List;

public class Prizes {
    private final List<Prize> prizes;

    private Prizes(List<Prize> prizes) {
        this.prizes = prizes;
    }

    public static Prizes of(List<String> prizeNames, int playerCount) {
        validateRange(prizeNames, playerCount);
        List<Prize> prizes = prizeNames.stream()
                .map(Prize::new)
                .toList();
        return new Prizes(prizes);
    }

    private static void validateRange(List<String> prizeNames, int playerCount) {
        if (playerCount != prizeNames.size()) {
            throw new IllegalArgumentException(String.format("실행 결과는 참여자와 같은 갯수를 입력해주세요. 입력 : %d개", prizeNames.size()));
        }
    }

    public Prize get(int index) {
        return prizes.get(index);
    }

    public List<String> getPrizeNames() {
        return prizes.stream()
                .map(Prize::getName)
                .toList();
    }
}
