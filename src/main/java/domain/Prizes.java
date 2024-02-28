package domain;

import java.util.List;

public class Prizes {

    public static final int MAX_OF_PRIZE_LENGTH = 5;
    List<String> prizes;

    public Prizes(List<String> prizes, Participants participants) {
        validateNoPrize(prizes);
        validatePrizeLength(prizes);
        validatePrizeSize(prizes, participants);
        this.prizes = prizes;
    }

    private void validatePrizeLength(List<String> prizes) {
        prizes.stream()
                .filter(prize -> prize.length() > MAX_OF_PRIZE_LENGTH)
                .findFirst()
                .ifPresent(prize -> {
                    throw new IllegalArgumentException(
                            "[ERROR] 실행 결과의 길이는 " + MAX_OF_PRIZE_LENGTH + "글자를 초과할 수 없습니다.");
                });
    }

    private void validateNoPrize(List<String> prizes) {
        prizes.stream()
                .filter(prize -> prize == null || prize.isBlank())
                .findFirst()
                .ifPresent(prize -> {
                    throw new IllegalArgumentException("[ERROR] 실행 결과가 없습니다.");
                });
    }

    private void validatePrizeSize(List<String> prizes, Participants participants) {
        if (!participants.isMatchCount(prizes.size())) {
            throw new IllegalArgumentException("[ERROR] 실행 결과의 개수는 참가자 수와 일치해야 합니다.");
        }
    }

    public List<String> getPrizes() {
        return prizes;
    }
}
