package domain;

import java.util.List;

public class Winnings {

    private static final int MIN_WINNING = 2;
    private static final int MAX_WINNING = 10;

    private final List<Winning> winnings;

    public Winnings (List<String> winnings) {
        validateNumber(winnings);
        this.winnings = winnings.stream()
                .map(Winning::new)
                .toList();
    }

    public void isSameNumberWithPlayers(Players players) {
        if (winnings.size() != players.getPlayersNumber()) {
            throw new IllegalArgumentException("사람 이름과 같은 개수를 입력하여야 합니다.");
        }
    }

    private void validateNumber(List<String> winnings) {
        if (winnings.size() < MIN_WINNING || winnings.size() > MAX_WINNING) {
            throw new IllegalArgumentException(String.format("실행결과의 수는 %d이상 %d이하여야 합니다.", MIN_WINNING, MAX_WINNING));
        }
    }

    public List<Winning> getWinnings() {
        return winnings;
    }
}
