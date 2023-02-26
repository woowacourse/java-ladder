package domain;

import java.util.ArrayList;
import java.util.List;

public class Prizes {

    private static final String ITEM_SIZE_NOT_MATCH = "[ERROR] 결과의 개수는 사용자의 인원과 일치해야합니다.";

    private final List<Prize> prizes;

    public Prizes(final List<Prize> prizes, final Names names) {
        validateItemSize(prizes, names);
        this.prizes = prizes;
    }

    private void validateItemSize(final List<Prize> prizes, final Names names) {
        if (prizes.size() != names.size()) {
            throw new IllegalArgumentException(ITEM_SIZE_NOT_MATCH);
        }
    }

    public List<Prize> getPrizes() {
        return new ArrayList<>(prizes);
    }

    public Prize getPrizeByIndex(final int index) {
        return prizes.get(index);
    }
}
