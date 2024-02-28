package domain;

import domain.line.RowLine;
import domain.line.RowLineGenerator;
import domain.name.Names;

import java.util.ArrayList;
import java.util.List;

public class Ladder {

    private final List<RowLine> lines;

    private Ladder(List<RowLine> lines, Prizes prizes) {
        this.lines = lines;
    }

    public static Ladder createFrom(RowLineGenerator rowLineGenerator, Names names, Height height, Prizes prizes) {
        validatePersonPrizesCount(names, prizes);
        List<RowLine> lines = new ArrayList<>();
        for (int i = 0; i < height.getHeight(); i++) {
            lines.add(rowLineGenerator.generate(names.getNameCount()));
        }
        return new Ladder(lines, prizes);
    }

    private static void validatePersonPrizesCount(Names names, Prizes prizes) {
        if (prizes.getPrizeCount() != names.getNameCount()) {
            throw new IllegalArgumentException("[ERROR] 상품의 수는 참여자 수와 일치해야 합니다.");
        }
    }

    public List<RowLine> getLines() {
        return List.copyOf(lines);
    }
}
