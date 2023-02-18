package ladder.domain;

import java.util.List;
import java.util.stream.Collectors;

public class Prizes {

    private final List<Prize> prizes;

    public Prizes(List<String> prizeNames, Users users) {

        validateEqualSize(prizeNames, users);
        this.prizes = prizeNames.stream()
                .map(Prize::new)
                .collect(Collectors.toList());
    }

    private void validateEqualSize(List<String> prizeNames, Users users) {
        if (prizeNames.size() != users.getSize()) {
            throw new IllegalArgumentException("prizes와 users 컬렉션의 크기는 같아야 합니다.");
        }
    }

    public List<Prize> getPrizes() {
        return prizes;
    }

    public int getSize() {
        return prizes.size();
    }
}
