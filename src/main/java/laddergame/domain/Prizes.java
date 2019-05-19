package laddergame.domain;

import java.util.*;

public class Prizes {
    private List<Prize> prizes = new ArrayList<>();

    public Prizes(int width, String prizes) {
        List<String> prizeCollections = new ArrayList<>(Arrays.asList(prizes.split(",")));
        PrizesValidator.checkConditions(prizeCollections, width);
        for (String currentPrize : prizeCollections) {
            this.prizes.add(new Prize(currentPrize));
        }
    }

    public List<Prize> getPrizes() {
        return prizes;
    }
}
