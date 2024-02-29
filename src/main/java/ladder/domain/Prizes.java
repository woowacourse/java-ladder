package ladder.domain;

import java.util.List;

public class Prizes {
    private final List<Prize> prizes;

    public Prizes(List<String> names, int personCount) {
        validatePrizesCount(names, personCount);
        this.prizes = initializePrizes(names);
    }

    public Prizes(List<Prize> prizes) {
        this.prizes = prizes;
    }

    private void validatePrizesCount(List<String> names, int personCount) {
        if (names.size() != personCount) {
            throw new IllegalArgumentException(
                    "상품의 개수(" + names.size() + "개)와 참여자 인원수(" + personCount + "명)는 일치해야 합니다.");
        }
    }

    private List<Prize> initializePrizes(List<String> names) {
        return names.stream()
                .map(Prize::new)
                .toList();
    }


    public List<Prize> getPrizes() {
        return prizes;
    }

    public Prize getPrizeByIndex(int index) {
        return prizes.get(index);
    }
}
