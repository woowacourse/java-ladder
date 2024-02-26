package domain;

import java.util.List;

public class Winnings{

    private final List<Winning> winnings;

    public Winnings (List<String> winnings) {
        validateNumber(winnings);
        this.winnings = winnings.stream()
                .map(Winning::new)
                .toList();
    }

    private void validateNumber(List<String> winnings) {
        if (winnings.size() < 2 || winnings.size() > 10){
            throw new IllegalArgumentException("실행결과의 수는 2이상 10이하여야 합니다.");
        }
    }
}
