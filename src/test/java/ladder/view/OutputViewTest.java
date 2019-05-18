package ladder.view;

import ladder.domain.LadderRow;
import ladder.domain.PlayerResult;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class OutputViewTest {

    @Test
    public void 사다리_한줄_출력_문자열() {

        OutputView view = new OutputView();
        LadderRow row = new LadderRow(Arrays.asList(1, -1, 0, 1, -1));
        view.print(row);
        assertEquals("   |-----|     |     |-----|", view.line(row));

    }

    @Test
    public void 사다리_한줄_출력_문자열2() {
        OutputView view = new OutputView();
        LadderRow row = new LadderRow(Arrays.asList(0, 0, 0, 0, 0));
        view.print(row);
        assertEquals("   |     |     |     |     |", view.line(row));

    }

    @Test
    public void 결과_출력_문자열() {
        PlayerResult playerResult = new PlayerResult("a", "꽝");
        OutputView outputView = new OutputView();
        assertEquals("꽝", outputView.result(playerResult));
    }

    @Test
    public void 결과_전체_출력_문자열() {
        List<PlayerResult> playerResults = new ArrayList<>();
        playerResults.add(new PlayerResult("a", "꽝"));
        playerResults.add(new PlayerResult("b", "꽝"));
        playerResults.add(new PlayerResult("c", "3000"));
        playerResults.add(new PlayerResult("d", "5000"));

        OutputView outputView = new OutputView();
        assertEquals("a : 꽝\nb : 꽝\nc : 3000\nd : 5000\n", outputView.result(playerResults));
    }
}
