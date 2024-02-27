package domain;

import java.util.Collections;
import java.util.List;
import java.util.regex.Pattern;

public class Prizes {

    private static final Pattern NATURAL_NUMBER_FORMAT_REGEX = Pattern.compile("^[1-9][0-9]*$");
    private static final String LOSE = "꽝";

    private final List<String> prizes;

    public Prizes(List<String> prizes, int playerCount) {
        validateIsNotLoseOrNaturalNumber(prizes);
        validatePrizesLength(prizes, playerCount);
        this.prizes = prizes;
    }

    private void validateIsNotLoseOrNaturalNumber(List<String> prizes) {
        for (String prize : prizes) {
            if (!prize.equals(LOSE) && !NATURAL_NUMBER_FORMAT_REGEX.matcher(prize).matches()) {
                throw new IllegalArgumentException("실행 결과는 꽝 또는 자연수만 입력 가능합니다.");
            }
        }
    }

    private void validatePrizesLength(List<String> prizes, int columnLength) {
        if (prizes.size() != columnLength) {
            throw new IllegalArgumentException("실행 결과 개수는 참여자 수와 일치해야 합니다.");
        }
    }

    public String findPrizeByPosition(int position) {
        return prizes.get(position);
    }

    public List<String> getPrizes() {
        return Collections.unmodifiableList(prizes);
    }
}
