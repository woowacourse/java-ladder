package ladder.view;

import ladder.domain.LadderRow;
import ladder.domain.PlayerResult;
import ladder.util.RowInputGenerator;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class OutputViewTest {

    @Test
    public void 사다리_한줄_출력_문자열() {
        RowInputGenerator rowInputGenerator = new RowInputGenerator(Arrays.asList(1, 0, 1));
        LadderRow ladderRow = new LadderRow(5, rowInputGenerator);
        ladderRow.makeRow();
        assertEquals("   |-----|     |     |-----|", OutputView.line(ladderRow));
    }

    @Test
    public void 사다리_한줄_출력_문자열2() {
        RowInputGenerator rowInputGenerator = new RowInputGenerator(Arrays.asList(0, 0, 0, 0, 0));
        LadderRow ladderRow = new LadderRow(5, rowInputGenerator);
        ladderRow.makeRow();
        assertEquals("   |     |     |     |     |", OutputView.line(ladderRow));

    }

    @Test
    public void 결과_출력_문자열() {
        PlayerResult playerResult = new PlayerResult("a", "꽝");
        assertEquals("꽝", OutputView.result(playerResult));
    }

    @Test
    public void 결과_전체_출력_문자열() {
        List<PlayerResult> playerResults = new ArrayList<>();
        playerResults.add(new PlayerResult("a", "꽝"));
        playerResults.add(new PlayerResult("b", "꽝"));
        playerResults.add(new PlayerResult("c", "3000"));
        playerResults.add(new PlayerResult("d", "5000"));

        assertEquals("a : 꽝\nb : 꽝\nc : 3000\nd : 5000\n", OutputView.result(playerResults));
    }
}
