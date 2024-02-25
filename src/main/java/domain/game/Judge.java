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
    // TODO: 존재하지 않는 사용자 고려
    public Prize getPrize(final String name) {
        int from = this.names.getSequence(name); // TODO: 여러 가지 타입 고려
        int to = this.result.getOne(from);
        return this.prizes.prizes().get(to);
    }
}
