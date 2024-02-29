package domain;

import java.util.List;

public class Prizes {

    private static final String PRIZE_SPLIT_DELIMITER = ",";

    private final List<String> prizes;

    public Prizes(String prizes, int participantsCount) {
        validateResultsLength(prizes, participantsCount);
        this.prizes = List.of(prizes.split(PRIZE_SPLIT_DELIMITER));
    }

    private void validateResultsLength(String results, int participantsCount) {
        if (results.split(PRIZE_SPLIT_DELIMITER).length != participantsCount) {
            throw new IllegalArgumentException("실행 결과의 수는 참가자 수와 동일해야 합니다.");
        }
    }

    public String getPrizeByPosition(int position) {
        return prizes.get(position);
    }

    public List<String> getPrizes() {
        return prizes;
    }
}
