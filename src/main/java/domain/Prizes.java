package domain;

import java.util.List;

public class Prizes {

    private final List<String> prizes;

    public Prizes(List<String> prizes, Names names) {
        validate(prizes, names);
        this.prizes = prizes;
    }

    private void validate(List<String> prizes, Names names) {
        if (prizes.size() != names.size()) {
            throw new IllegalArgumentException("실행 결과 수는 사람 수와 동일해야합니다.");
        }
    }
}
