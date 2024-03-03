package laddergame.domain.gameelements;

import java.util.ArrayList;
import java.util.List;

public class Prizes {

    private final List<Prize> prizes;

    public Prizes(List<String> prizeNames, int playerNumber) {
        validateSameLength(prizeNames.size(), playerNumber);

        this.prizes = new ArrayList<>();

        for (int i = 0; i < prizeNames.size(); i++) {
            Name prizeName = new Name(prizeNames.get(i));
            Position position = new Position(i);

            this.prizes.add(new Prize(prizeName, position));
        }
    }

    private void validateSameLength(int prizeNumber, int playerNumber) {
        if (prizeNumber != playerNumber) {
            throw new IllegalArgumentException("보상의 개수는 참여자의 수와 같아야 합니다.");
        }
    }

    public List<Prize> getPrizes() {
        return prizes;
    }
}
