package ladder.repository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import ladder.domain.Prize;

public class PrizeRepository {
    private final List<Prize> prizes = new ArrayList<>();

    public void saveAll(List<Prize> prizes) {
        this.prizes.addAll(prizes);
    }

    public List<Prize> findAll() {
        return Collections.unmodifiableList(prizes);
    }

    public Prize findByIndex(int index) {
        if (isProperIndex(index)) {
            throw new IllegalArgumentException("[ERROR] 인덱스 범위를 초과했습니다.");
        }
        return prizes.get(index);
    }

    private boolean isProperIndex(int index) {
        return index < 0 || index >= prizes.size();
    }
}
