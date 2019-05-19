package laddergame.domain;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class LadderMapGeneratorTest {
    static final int WIDTH = 4;
    static final int HEIGHT = 5;

    @Test
    void ladderMap의_사이즈확인_테스트() {
        List<Line> ladderMap = LadderMapGenerator.fillLadder(4, 5);
        boolean isValid = (ladderMap.size() == HEIGHT);

        for (int i = 0; i < ladderMap.size() && isValid; i++) {
            isValid = (ladderMap.get(i).getWidth() == WIDTH - 1);
        }

        assertThat(isValid).isTrue();
    }
}
