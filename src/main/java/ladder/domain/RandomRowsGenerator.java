package ladder.domain;

import javax.swing.*;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RandomRowsGenerator {
    private static Random random = new Random();

    public Row generateRow(int size) {
        List<Boolean> row = new ArrayList<>();
        Row ret;
        try {
            for (int i = 0; i < size; i++) {
                row.add(random.nextBoolean());
            }
            ret = Row.of(row, size);
        } catch (IllegalArgumentException e) {
            return generateRow(size);
        }
        return ret;
    }

    public Rows generateRows(int width, int height) {
        List<Row> rows = new ArrayList<>();
        for(int i = 0; i<height; i++){
            rows.add(generateRow(width));
        }
        return new Rows(rows);
    }
}
