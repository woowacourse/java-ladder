package ladder.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class LadderGenerator {
    private static final Random random = new Random();
    private final Width width;
    private final Height height;

    public LadderGenerator(Width width, Height height) {
        this.width = width;
        this.height = height;
    }

    public Ladder generateLadder() {
        List<Row> rows = generateNoStepRows();
        addStepBetweenAllColumn(rows);
        for (Row row : rows) {
            addRandomSteps(row);
        }
        return new Ladder(rows);
    }

    private List<Row> generateNoStepRows() {
        List<Row> rows = new ArrayList<>();
        int heightSize = height.getHeight();
        for (int i = 0; i < heightSize; i++) {
            List<Step> row = new ArrayList<>();
            addNoStepRow(row);
            rows.add(Row.of(row));
        }
        return rows;
    }

    private void addNoStepRow(List<Step> row) {
        int widthSize = width.getWidth();
        for (int i = 0; i < widthSize; i++) {
            row.add(Step.N);
        }
    }

    private void addStepBetweenAllColumn(List<Row> rows) {
        int widthSize = width.getWidth();
        for (int widthIndex = 0; widthIndex < widthSize; widthIndex++) {
            addStep(getCreatableStepRow(rows, widthIndex), widthIndex);
        }
    }

    private void addStep(Row row, int index) {
        List<Step> steps = row.getRow();
        steps.set(index, Step.Y);
    }

    private void addRandomSteps(Row row) {
        int widthSize = width.getWidth();
        for (int i = 0; i < widthSize; i++) {
            addRandomStep(row, i);
        }
    }

    private void addRandomStep(Row row, int index) {
        List<Step> steps = row.getRow();
        if (row.isPossibleInstallStep(index)) {
            steps.set(index, Step.from(random.nextBoolean()));
        }
    }

    private Row getCreatableStepRow(List<Row> rows, int widthIndex) {
        Row choice = rows.get(random.nextInt(rows.size()));
        if (!choice.isPossibleInstallStep(widthIndex)) {
            return getCreatableStepRow(rows, widthIndex);
        }
        return choice;
    }
}
