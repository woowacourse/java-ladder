package laddergame.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

import java.util.List;
import laddergame.domain.strategy.LineBuildStrategy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("라인")
public class LineTest {
    @Test
    @DisplayName("랜덤값이 true일 경우 특정 위치에서 다리를 건설한다.")
    public void buildBridgeTest() {
        //given
        final int personCount = 4;
        final int position = 1;

        LineBuildStrategy lineBuildStrategy = new LineBuildStrategy() {
            @Override
            public List<Boolean> apply(int count) {
                return List.of(true, false, true);
            }
        };
        lineBuildStrategy.apply(personCount);

        //when
        Line line = Line.buildOf(lineBuildStrategy, personCount);

        //then
        assertFalse(line.isBuilt(position));
    }
}

