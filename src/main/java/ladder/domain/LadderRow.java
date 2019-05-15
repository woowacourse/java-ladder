package ladder.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class LadderRow {
    TempInput tempInput;
    private List<Integer> row;
    private int width;

    public LadderRow() {
        this(0);
    }

    public LadderRow(int width) {
        row = new ArrayList<>();
        this.width = width;
    }

    public int draw(boolean isDraw) {
        if (isDraw) {
            row.add(1);
            row.add(-1);
            return 2;
        }
        row.add(0);
        return 1;
    }


    public List<Integer> status() {
        return row;
    }

    public void makeRow() {
        TempInput tempInput = new TempInput();
        tempInput.get();
        this.tempInput = tempInput;
        while (this.width > 0) {
            if (this.width == 1) {
                this.width -= draw(false);
                break;
            }
            this.width -= draw(getRandomFlag());
        }
    }

    private boolean getRandomFlag() {
//        Random random = new Random();
        String a = tempInput.getElement();
        return a.equals("1");
    }
}
