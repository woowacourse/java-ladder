package laddergame.domain.gameelements;

import java.util.List;

public class Prizes {

    private final List<Name> prizeNames;

    public Prizes(List<String> prizeNames, int playerNumber) {
        validateSameLength(prizeNames.size(), playerNumber);
        this.prizeNames = prizeNames.stream()
                .map(Name::new)
                .toList();
    }

    private void validateSameLength(int prizeNumber, int playerNumber) {
        if (prizeNumber != playerNumber) {
            throw new IllegalArgumentException("보상의 개수는 참여자의 수와 같아야 합니다.");
        }
    }

    public List<Name> getPrizeNames() {
        return prizeNames;
    }
}
