package ladder.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RandomLadderGenerator {
    private static final Random random = new Random();
    private final Width width;
    private final Height height;

    public RandomLadderGenerator(Width width, Height height){
        this.width = width;
        this.height = height;
    }
    
    public Ladder generateLadder() {
        List<Row> rows = generateNoStepRows();
        addRandomStepBetweenColumn(rows);
        for(Row row : rows){
            addRandomSteps(row);
        }
        return new Ladder(rows);
    }

    private List<Row> generateNoStepRows() {
        List<Row> rows = new ArrayList<>();
        for (int i = 0; i < height.getHeight(); i++) {
            List<Step> row = new ArrayList<>();
            addNoStepRow(row);
            rows.add(Row.of(row));
        }
        return rows;
    }

    private void addNoStepRow(List<Step> row) {
        for (int i = 0; i < width.getWidth(); i++) {
            row.add(Step.N);
        }
    }


    private void addRandomStepBetweenColumn(List<Row> rows) {
        for (int widthIndex = 0; widthIndex < width.getWidth(); widthIndex++) {
            Row row = getOneStepRow(getStepPossibleRow(rows, widthIndex), widthIndex);
        }
    }

    private Row getOneStepRow(Row row, int index){
        List<Step> steps = row.getRow();
        steps.set(index, Step.Y);
        return Row.of(steps);
    }

    private void addRandomSteps(Row row){
        List<Step> steps = row.getRow();
        for(int i = 0; i< width.getWidth(); i++){
            if(row.isPossibleInstallStep(i)){
                steps.set(i, Step.from(random.nextBoolean()));
            }
        }
    }

    private Row getStepPossibleRow(List<Row> rows, int widthIndex) {
        Row choice = rows.get(random.nextInt(rows.size()));
        if (!choice.isPossibleInstallStep(widthIndex)) {
            return getStepPossibleRow(rows, widthIndex);
        }
        return choice;
    }
}
