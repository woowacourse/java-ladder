package domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import javax.sound.sampled.Line;
import java.util.List;

/**
 * @author 베베
 * @version 1.0.0
 * @Created by 베베 on 2023. 02. 18.
 */
public class LineTest {

    private final List<Boolean> line;

    @BeforeEach
    void init() {
        this.line = new Line(3);
    }

    @DisplayName("이전 가로가 True면 다음 가로는 무조건 False이다.")
    @Test
    void 사다리_순서를_계산한다() {
        for (int i = 0; i < line.size() - 1; i++) {
            if (line.get(i) == true) {
                Assertions.assertThat(line.get(i + 1)).isFalse();
            }
        }
    }
}
