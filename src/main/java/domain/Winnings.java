package domain;

import java.util.Collections;
import java.util.List;

public class Winnings {

    private final List<Name> winnings;

    public Winnings(List<String> names, int playersNumber) {
        validateNumber(names, playersNumber);
        this.winnings = names.stream()
                .map(Name::new)
                .toList();
    }

    private void validateNumber(List<String> names, int playersNumber) {
        if (names.size() != playersNumber) {
            throw new IllegalArgumentException("보상의 수는 이름의 수와 같아야 합니다.");
        }
    }

    public List<Name> getWinnings() {
        return Collections.unmodifiableList(this.winnings);
    }
}
