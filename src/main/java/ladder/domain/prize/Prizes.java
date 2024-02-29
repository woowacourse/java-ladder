package ladder.domain.prize;

import java.util.List;
import java.util.stream.Collectors;

public class Prizes {

    private final List<Prize> prizes;

    public Prizes(List<Prize> prizes, int size) {
        this.prizes = prizes;
        validateSameSize(size);
    }

    public void validateSameSize(int size) {
        if (this.prizes.size() != size) {
            throw new IllegalArgumentException("[ERROR] 실행 결과의 수가 사용자의 수와 동일하지 않습니다.");
        }
    }

    public List<String> getPrizesNames() {
        return this.prizes.stream()
                .map(Prize::getPrizeName)
                .collect(Collectors.toList());
    }
}
