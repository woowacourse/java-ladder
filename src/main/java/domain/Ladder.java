package domain;

import domain.line.RowLine;
import domain.line.RowLineGenerator;
import domain.name.Names;
import domain.prize.Prizes;

import java.util.ArrayList;
import java.util.List;

public class Ladder {

    private static final int WIDTH_IDX = 1;

    private final List<RowLine> lines;

    private Ladder(List<RowLine> lines) {
        this.lines = lines;
    }

    public static Ladder createFrom(RowLineGenerator rowLineGenerator, Names names, Height height, Prizes prizes) {
        validatePersonPrizesCount(names, prizes);
        List<RowLine> lines = new ArrayList<>();
        for (int i = 0; i < height.getHeight(); i++) {
            lines.add(rowLineGenerator.generate(names.getNameCount()));
        }
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

    public int getWidthSize() {
        return lines.get(0).getSize() + WIDTH_IDX;
    }
}
