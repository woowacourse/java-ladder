package laddergame.domain;

import java.util.*;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class LadderTest {
    @Test
    void 규칙에_맞게_라인이_생성되는지_테스트() {
        Line line = new Line(3);
        boolean previousValue = false;
        for (int index = 0; index < line.getLineSize(); index++) {
            checkPreviousValue(line, previousValue, index);
            previousValue = line.getBooleanValue(index);
        }
    }

    private void checkPreviousValue(Line line, boolean previousValue, int index) {
        if (previousValue) {
            assertThat(line.getBooleanValue(index)).isFalse();

        }
    }

    @Test
    void 사다리_유효성_높이_테스트() {
        assertThrows(IllegalArgumentException.class, ()-> new Ladder(4, "0"));
    }

    @Test
    void ladderInformationAsTrueFalse_사이즈확인_테스트() {
        int width = 4;
        String height = "5";
        Ladder ladder = new Ladder(4,"5");
        boolean isValid = (ladder.getLadderInformationAsTrueFalse().size() == Integer.parseInt(height));
        assertThat(isValid).isTrue();
        for (int i = 0; i< ladder.getLadderInformationAsTrueFalse().size(); i++) {
            isValid = (ladder.getLadderInformationAsTrueFalse().get(i).getLineSize() == width -1);
            assertThat(isValid).isTrue();
        }

    }

    @Test
    void 게임_로직_제대로_돌아가는지_테스트() {
        Players players = new Players("a,b,c,d");
        Line line1 = new Line(Arrays.asList(true,false,true));
        Line line2 = new Line(Arrays.asList(false, true, false));
        Line line3 = new Line(Arrays.asList(true, false, true));
        List<Line> lines = Arrays.asList(line1, line2, line3);
        Ladder testLadder = new Ladder(lines, 4, 3);

        Players testPlayers = testLadder.makeThePlayersClimbDownTheLadder(players);
        assertThat(testPlayers).isEqualTo(new Players("d,b,c,a"));
    }
}
