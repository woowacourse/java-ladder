package domain;

import domain.line.RowLine;
import domain.line.RowLinesGenerator;
import domain.name.Names;
import domain.prize.Prizes;

import java.util.List;

public class Ladder {

    private static final int LAST_POINT = 1;

    private final List<RowLine> lines;

    private Ladder(List<RowLine> lines) {
        this.lines = lines;
    }

    public static Ladder createFrom(RowLinesGenerator rowLinesGenerator, Names names, Height height, Prizes prizes) {
        validatePersonPrizesCount(names, prizes);
        List<RowLine> lines = rowLinesGenerator.generateLines(names.getNameCount(), height.getHeight());
        return new Ladder(lines);
    }

    private static void validatePersonPrizesCount(Names names, Prizes prizes) {
        if (prizes.getSize() != names.getNameCount()) {
            throw new IllegalArgumentException("[ERROR] 상품의 수는 참여자 수와 일치해야 합니다.");
        }
    }

    public List<RowLine> getLines() {
        return List.copyOf(lines);
    }

    public int countStartingPoints() {
        return lines.get(0).getSize() + LAST_POINT;
    }
}
