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
            throw new IllegalArgumentException(String.format("%d는 올바른 사람 이름 수가 아닙니다. 사람 이름과 같은 개수를 입력하여야 합니다.", players.getPlayersNumber()));
        }
    }

    private void validateNumber(List<String> winnings) {
        if (winnings.size() < MIN_WINNING || winnings.size() > MAX_WINNING) {
            throw new IllegalArgumentException(String.format("%d는 올바른 실행결과의 수가 아닙니다. 실행결과의 수는 %d이상 %d이하여야 합니다.", winnings.size(), MIN_WINNING, MAX_WINNING));
        }
    }

    public List<Winning> getWinnings() {
        return winnings;
    }
}
