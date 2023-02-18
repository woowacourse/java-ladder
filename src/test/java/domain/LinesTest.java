package domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

/**
 * @author 베베
 * @version 1.0.0
 * @Created by 베베 on 2023. 02. 18.
 */
public class LinesTest {

    private Lines lines;

    @BeforeEach
    void init() {
        this.lines = new Lines();
    }

    @DisplayName("사다리 라인들을 생성할 수 있다.")
    @ParameterizedTest
    @ValueSource(ints = {5})
    void 사다리_높이만큼_라인_생성(int height) {
        List<Line> lineList = lines.createLines(height);
        Assertions.assertThat(lineList.size()).isEqualTo(height);
    }
}
