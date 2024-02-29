package model;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import model.line.Line;
import model.line.LinesGenerator;

public class Ladder {
    private final List<Line> lines;

    private Ladder(final List<Line> lines) {
        this.lines = lines;
    }

    public static Ladder from(final int height, final int personCount, final LinesGenerator linesGenerator) {
        validateHeight(height);
        int pathCount = personCount - 1;
        final List<Line> lines = linesGenerator.generate(height, pathCount);
        return new Ladder(lines);
    }

    private static void validateHeight(final int height) {
        if (height < 1) {
            throw new IllegalArgumentException("사다리의 높이는 1 이상이어야 합니다.");
        }
    }

    public int climb(final int startIndex) {
        int currentIndex = startIndex;
        for (Line line : lines) {
            currentIndex = line.move(currentIndex);
        }
        return currentIndex;
    }

    public List<Integer> climbAll() {
        List<Integer> resultIndexes = new ArrayList<>();
        int index = 0;
        while (index < findPersonCount()) {
            int resultIndex = climb(index);
            resultIndexes.add(resultIndex);
            index++;
        }
        return resultIndexes;
    }

    public Map<String, String> match(People people, Items items) {
        List<Integer> resultIndexes = climbAll();
        Map<String, String> personAndItemName = new LinkedHashMap<>();
        int personIndex = 0;
        for (int itemIndex : resultIndexes) {
            String personName = people.findNameBy(personIndex);
            String itemName = items.findNameBy(itemIndex);
            personAndItemName.put(personName, itemName);
            personIndex++;
        }
        return personAndItemName;
    }

    private int findPersonCount() {
        Line line = lines.get(0);
        return line.getPathsSize() + 1;
    }

    public List<Line> getLines() {
        return lines;
    }
}
