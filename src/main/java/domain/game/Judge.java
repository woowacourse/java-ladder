package domain.game;

import domain.db.Names;
import domain.db.Prize;
import domain.db.Prizes;

public class Judge {
    private final Names names;
    private final Prizes prizes;
    private final PathMapper pathMapper;

    public Judge(final Names names, final Prizes prizes, final PathMapper pathMapper) {
        this.names = names;
        this.prizes = prizes;
        this.pathMapper = pathMapper;
    }

    public Prize getPrize(final String name) throws IllegalArgumentException {
        final int departure = getDeparture(name);
        return getPrize(departure);
    }

    private int getDeparture(final String name) {
        final int departure = this.names.getSequence(name);
        if (departure == -1) {
            throw new IllegalArgumentException("존재하지 않는 이름입니다.");
        }
        return departure;
    }

    private Prize getPrize(final int departure) {
        try {
            final int arrival = this.pathMapper.find(departure);
            return this.prizes.prizes().get(arrival);
        } catch (ArrayIndexOutOfBoundsException e) {
            throw new IllegalArgumentException("상품이 존재하지 않습니다.");
        }
    }
}
