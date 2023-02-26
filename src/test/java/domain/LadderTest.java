package domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import util.RandomBooleanGenerator;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("사다리는 ")
class LadderTest {
    @Nested
    @DisplayName("다리를 만들 때 ")
    class GenerateLineCase {
        @Nested
        @DisplayName(" 원하는 모양대로 만들 수 있다.")
        class ShapeCase {
            private Ladder ladder;

            @BeforeEach
            void setUp() {
                ladder = new LadderGenerator(new RandomBooleanGenerator()).build(5, 3);
            }

            @Test
            @DisplayName(" 주어진 사람 수만큼 다리의 폭이 생성된다.")
            void givenThree_thenGenerateThreeWidth() {
                assertThat(ladder.getWidth()).isEqualTo(3);
            }

            @Test
            @DisplayName(" 주어진 다리 높이만큼 다리가 생성된다.")
            void givenThreeHeight_thenGenerateThreeHeight() {
                assertThat(ladder.getLineHeight()).isEqualTo(5);
            }

            @Test
            @DisplayName(" 주어진 정보에 맞는 개수의 디딤돌이 생성된다.")
            void givenInformation_thenGenerateLadder() {
                assertThat(getLadderArea()).isEqualTo(15);
            }

            private int getLadderArea() {
                return ladder.getLineHeight() * ladder.getWidth();
            }
        }
    }
}
