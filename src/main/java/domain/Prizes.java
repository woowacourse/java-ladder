package domain;

import java.util.List;

public class Prizes {

    private final List<Prize> prizes;

    public Prizes(List<String> prizes, Names names) {
        validate(prizes, names);
        this.prizes = prizes.stream()
                .map(Prize::new)
                .toList();
    }

    private void validate(List<String> prizes, Names names) {
        if (prizes.size() != names.size()) {
            throw new IllegalArgumentException("실행 결과 수는 사람 수와 동일해야합니다.");
        }
    }

    public Prize findByIndex(int index) {
        if (index < 0 || index >= prizes.size()) {
            throw new IllegalArgumentException("범위를 벗어난 index 입니다.");
        }
        return prizes.get(index);
    }

    public List<Prize> getPrizes() {
        return prizes;
    }
}
