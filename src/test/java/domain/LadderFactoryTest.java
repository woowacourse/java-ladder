package domain;

import static domain.Direction.*;
import static org.assertj.core.api.Assertions.*;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LadderFactoryTest {
    @Test
    @DisplayName("주어진 가로 길이와 세로 길이의 랜덤 사다리를 생성한다.")
    void createRandomLadder() {
        final Ladder ladder = LadderFactory.createRandomLadder(5, 10);

        assertAll(
                () -> assertThat(ladder.height()).isEqualTo(5),
                () -> assertThat(ladder.width()).isEqualTo(10)
        );
    }
}
