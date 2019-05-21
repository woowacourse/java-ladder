package laddergame.domain;

import java.util.*;

public class Prizes {
    private List<Prize> prizes = new ArrayList<>();

    public Prizes(int width, String prizes) {
        List<String> prizeCollections = new ArrayList<>(Arrays.asList(prizes.split(",")));
        checkConditions(prizeCollections, width);
        for (String currentPrize : prizeCollections) {
            this.prizes.add(new Prize(currentPrize));
        }
    }

    private static void checkConditions(List<String> inputs, int numOfPlayers) {
        if (inputs.size() != numOfPlayers) {
            throw new IllegalArgumentException("상품의 수가 올바르지 않습니다.\n다시 입력하세요.");
        }
    }

    public List<Prize> getPrizes() {
        return prizes;
    }
}
