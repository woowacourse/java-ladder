package domain;

import java.util.List;

public class Prizes {

    public static final int MIN_LENGTH = 1;
    public static final int MAX_LENGTH = 10;
    public static final String INVALID_COUNT_MESSAGE = "상품의 수는 참여할 사람 수와 같아야합니다";
    public static final String NAME_LENGTH_FORMAT = "상품의 이름은 %d자 이상 %d자 이하여야 합니다";

    private final List<String> prizes;

    public Prizes(List<String> prizes, int peopleCount) {
        validatePrizeCount(prizes, peopleCount);
        validatePrizesName(prizes);
        this.prizes = prizes;
    }

    private void validatePrizeCount(List<String> prizes, int peopleCount) {
        if (prizes.size() != peopleCount) {
            throw new IllegalArgumentException(INVALID_COUNT_MESSAGE);
        }
    }

    private void validatePrizesName(List<String> prizes) {
        prizes.forEach(this::validatePrizeName);
    }

    private void validatePrizeName(String prizeName) {
        if (prizeName.isBlank() || prizeName.length() > MAX_LENGTH) {
            throw new IllegalArgumentException(
                String.format(NAME_LENGTH_FORMAT, MIN_LENGTH, MAX_LENGTH));
        }
    }

    public String getPrize(int index) {
        return prizes.get(index);
    }

    public List<String> getPrizes() {
        return prizes;
    }
}
