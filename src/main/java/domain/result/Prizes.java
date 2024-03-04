package domain.result;

import domain.participant.Participants;
import java.util.List;
import java.util.stream.Collectors;

public class Prizes {

    public static final int MAX_OF_PRIZE_LENGTH = 5;

    private final List<Prize> prizes;

    public Prizes(List<String> prizes, Participants participants) {
        validatePrizeSize(prizes, participants);
        this.prizes = prizes.stream()
                .map(Prize::new)
                .collect(Collectors.toList());
    }

    public String getParticipantPrize(int finalPosition) {
        return prizes.get(finalPosition).toString();
    }

    private void validatePrizeSize(List<String> prizes, Participants participants) {
        if (!participants.isMatchCount(prizes.size())) {
            throw new IllegalArgumentException("[ERROR] 실행 결과의 개수는 참가자 수와 일치해야 합니다.");
        }
    }

    public List<Prize> getPrizes() {
        return prizes;
    }
}
