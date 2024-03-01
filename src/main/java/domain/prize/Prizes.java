package domain.prize;

import domain.ColumnPosition;
import java.util.List;

public class Prizes {

    private final List<Prize> prizes;

    public Prizes(List<Prize> prizes) {
        this.prizes = prizes;
    }

    public int getPrizeCount() {
        return prizes.size();
    }

    public Prize getPrize(ColumnPosition columnPosition) {
        return prizes.get(columnPosition.getColumnPosition());
    }

    public List<Prize> getPrizes() {
        return prizes;
    }
}
