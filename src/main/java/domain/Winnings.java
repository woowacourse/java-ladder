package domain;

import java.util.Collections;
import java.util.List;

public class Winnings {

    private final List<Winning> winnings;

    public Winnings (List<String> winnings) {
        validateNumber(winnings);
        this.winnings = winnings.stream()
                .map(Winning::new)
                .toList();
    }

    public List<Winning> getWinnings() {
        return Collections.unmodifiableList(winnings);
    }

    public void isSameNumberWithPlayers(Players players) {
        if (winnings.size() != players.getPlayers().size()) {
            throw new IllegalArgumentException("사람 이름과 같은 개수를 입력하여야 합니다.");
        }
    }

    private void validateNumber(List<String> winnings) {
        if (winnings.size() < 2 || winnings.size() > 10){
            throw new IllegalArgumentException("실행결과의 수는 2이상 10이하여야 합니다.");
        }
    }
}
