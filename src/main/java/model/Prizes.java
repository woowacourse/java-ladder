package model;

import java.util.List;

public class Prizes {
    private final List<Prize> prizes;

    public Prizes(List<Prize> prizes, int peopleCount) {
        validateInputSize(prizes);
        validatePrizesSize(prizes, peopleCount);
        this.prizes = prizes;
    }

    private void validatePrizesSize(List<Prize> prizes, int peopleCount) {
        if (prizes.size() != peopleCount) {
            throw new IllegalArgumentException("[ERROR] 참여자 수와 실행 결과 수가 일치하지 않는다.");
        }
    }

    private void validateInputSize(List<Prize> prizes) {
        if (prizes == null || prizes.isEmpty()) {
            throw new IllegalArgumentException("[ERROR] 실행 결과는 null일 수 없다.");
        }
    }

    public int getSize() {
        return prizes.size();
    }

    public List<Prize> getPrizes() {
        return prizes;
    }
}
