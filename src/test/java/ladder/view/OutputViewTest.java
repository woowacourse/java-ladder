package ladder.view;

import ladder.domain.LadderRow;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

public class OutputViewTest {


    @Test
    public void 사다리_한줄_출력_문자열() {

        OutputView view = new OutputView();
        LadderRow row = new LadderRow(Arrays.asList(1, -1, 0, 1, -1));
        view.print(row);
        assertEquals("|-----|     |     |-----|", view.line(row));

    }

    @Test
    public void 사다리_한줄_출력_문자열2() {
        OutputView view = new OutputView();
        LadderRow row = new LadderRow(Arrays.asList(0, 0, 0, 0, 0));
        view.print(row);
        assertEquals("|     |     |     |     |", view.line(row));

    }
}
