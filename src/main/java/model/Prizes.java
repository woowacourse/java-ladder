package model;

import java.util.List;

public class Prizes {
    private final List<Prize> prizes;

    public Prizes(List<String> prizeNames, int numberOfParticipants) {
        validatePrizeNamesSize(prizeNames, numberOfParticipants);
        this.prizes = prizeNames.stream()
                .map(Prize::new)
                .toList();
    }

    private void validatePrizeNamesSize(List<String> names, int numberOfParticipants) {
        if (names.size() != numberOfParticipants) {
            throw new IllegalArgumentException("참여할 사람은 두명 이상이어야한다.");
        }
    }
}
