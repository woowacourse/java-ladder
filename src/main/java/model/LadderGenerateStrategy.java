package model;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.function.BiFunction;
import java.util.function.Function;

public class LadderGenerateStrategy implements BiFunction<Integer, Integer, List<List<Boolean>>> {

    @Override
    public List<List<Boolean>> apply(Integer rowCount, Integer columnCount) {
        List<List<Boolean>> rows = new ArrayList<>();
        for (int i = 0; i < columnCount; i++) {
            rows.add(createRow(rowCount));
        }
        return rows;
    }

    private List<Boolean> createRow(int rowCount){
        List<Boolean> row = new ArrayList<>();
        for (int i = 0; i < rowCount ; i++) {
            row.add(new Random().nextBoolean());
        }
        return row;
    }
}
