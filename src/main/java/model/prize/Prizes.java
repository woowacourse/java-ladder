package model.prize;

import dto.PrizeName;
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
            throw new IllegalArgumentException("결과의 갯수는 참여한 사람 수와 같아야한다.");
        }
    }

    public Prize getPrizeByIndex(int index) {
        return prizes.get(index);
    }

    public List<PrizeName> convertToPrizesName() {
        return prizes.stream().map(PrizeName::new).toList();
    }
}
