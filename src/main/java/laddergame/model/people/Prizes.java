package laddergame.model.people;

import java.util.List;
import java.util.stream.Collectors;

public class Prizes {
    private final List<Prize> prizes;

    private Prizes(List<Prize> prizes) {
        this.prizes = prizes;
    }

    public static Prizes from(List<String> prizes, People people) {
        validatePrizesSize(prizes, people);
        return new Prizes(prizes.stream()
                .map(Prize::new)
                .collect(Collectors.toList()));
    }

    private static void validatePrizesSize(List<String> prizes, People people) {
        if (prizes.size() != people.size()) {
            throw new IllegalArgumentException("입력된 실행 결과의 수는 참여자의 수와 같아야 합니다.");
        }
    }

    public List<Prize> getPrizes() {
        return prizes;
    }

    public Prize getPrize(int i) {
        return prizes.get(i);
    }
}
