package ladder.view;

import ladder.domain.Ladder;
import ladder.domain.LadderRow;
import org.junit.Test;

import static org.junit.Assert.*;

import java.util.Arrays;

public class OutputViewTest {


    @Test
    public void 사다리_한줄_출력_문자열() {

        OutputView view = new OutputView();
        LadderRow row = new LadderRow(Arrays.asList(1, -1, 0, 1, -1));
        System.out.println(view.print(row));
        assertEquals("|-----|     |     |-----|", view.print(row));

    }

    @Test
    public void 사다리_한줄_출력_문자열2() {
        OutputView view = new OutputView();
        LadderRow row = new LadderRow(Arrays.asList(0, 0, 0, 0, 0));
        System.out.println(view.print(row));
        assertEquals("|     |     |     |     |", view.print(row));

    }
}
