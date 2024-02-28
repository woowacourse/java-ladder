package domain;

import domain.line.RowLine;
import domain.line.RowLineGenerator;

import java.util.ArrayList;
import java.util.List;

public class Ladder {

    private final List<RowLine> lines;
    private final Prizes prizes;

    private Ladder(List<RowLine> lines, Prizes prizes) {
        this.lines = lines;
        this.prizes = prizes;
    }

    public static Ladder createFrom(RowLineGenerator rowLineGenerator, Integer personCount, Height height, Prizes prizes) {
        validatePersonPrizesCount(personCount, prizes);
        List<RowLine> lines = new ArrayList<>();
        for (int i = 0; i < height.getHeight(); i++) {
            lines.add(rowLineGenerator.generate(personCount));
        }
        return new Ladder(lines, prizes);
    }

    private static void validatePersonPrizesCount(Integer personCount, Prizes prizes) {
        if (prizes.getPrizeCount() != personCount) {
            throw new IllegalArgumentException("[ERROR] 상품의 수는 참여자 수와 일치해야 합니다.");
        }
    }

    public List<RowLine> getLines() {
        return List.copyOf(lines);
    }
}
