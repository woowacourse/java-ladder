package model;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import strategy.PassGenerator;

public class Ladder {

    private final List<Line> lines = new ArrayList<>();

    public Ladder(int height, Names names, PassGenerator passGenerator) {
        validateMinHeight(height);
        while (height-- > 0) {
            lines.add(new Line(names.getNames().size(), passGenerator));
        }
    }

    private void validateMinHeight(int height) {
        if (height < 1) {
            throw new IllegalArgumentException("높이는 최소 1 이상이어야 합니다");
        }
    }

    public List<List<String>> getLadderString() {
        return lines.stream()
            .map(Line::getLineBlockPass)
            .collect(Collectors.toList());
    }

}
