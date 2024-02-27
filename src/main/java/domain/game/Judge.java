package domain.game;

import domain.db.Names;
import domain.db.Prize;
import domain.db.Prizes;

public class Judge {
    private final Names names;
    private final Prizes prizes;
    private final Result result;

    public Judge(final Names names, final Prizes prizes, final Result result) {
        this.names = names;
        this.prizes = prizes;
        this.result = result;
    }

    // TODO: 캐싱 고려
    public Prize getPrize(final String name) throws IllegalArgumentException {
        final int from = getSequenceByName(name);
        return getPrize(from);
    }

    private int getSequenceByName(final String name) {
        try {
            return this.names.getSequence(name);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("존재하지 않는 이름입니다.");
        }
    }

    private Prize getPrize(final int from) {
        try {
            final int to = this.result.getOne(from);
            return this.prizes.prizes().get(to);
        } catch (ArrayIndexOutOfBoundsException e) {
            throw new IllegalArgumentException("상품이 존재하지 않습니다.");
        }
    }

}
