package ladder.domain;

import java.util.List;

public class Prizes {
    private final List<String> name;

    public Prizes(List<String> name, int personCount) {
        validatePrizesCount(name, personCount);
        this.name = name;
    }

    private void validatePrizesCount(List<String> name, int personCount) {
        if (name.size() != personCount) {
            throw new IllegalArgumentException("상품의 개수는 참여자 인원수와 일치해야 합니다.");
        }
    }

    public List<String> name() {
        return name;
    }
}
