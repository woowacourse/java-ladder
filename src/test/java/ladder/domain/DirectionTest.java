package ladder.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

public class DirectionTest {
    private Direction firstDirectionFalse;
    private Direction firstDirectionTrue;
    private Direction middleDirectionTrue;
    private Direction middleDirectionFalse;

    @BeforeEach
    void setUp() {
        firstDirectionFalse = Direction.createFirst(() -> false);
        firstDirectionTrue = Direction.createFirst(() -> true);
        middleDirectionTrue = firstDirectionFalse.createNext(() -> true);
        middleDirectionFalse = firstDirectionFalse.createNext(() -> false);
    }

    @Test
    @DisplayName("createFirst()는 오른쪽 바가 랜덤값을 받아 생성된다.")
    void test_1() {
        // then
        assertAll(
                () -> assertThat(firstDirectionFalse.isExistLeftBar()).isFalse(),
                () -> assertThat(firstDirectionFalse.isExistRightBar()).isFalse()
        );
    }

    @Test
    @DisplayName("createNext()는 이전 바의 오른쪽 값으로 false를 받았을때 랜덤값으로 오른쪽 바를 생성한다.")
    void test_2() {
        // given, when
        Direction direction = firstDirectionFalse.createNext(() -> false);

        // then
        assertAll(
                () -> assertThat(direction.isExistLeftBar()).isFalse(),
                () -> assertThat(direction.isExistRightBar()).isFalse()
        );
    }

    @Test
    @DisplayName("createNext()는 이전 바의 오른쪽 값으로 true를 받았을때 오른쪽 값으로 무조건 false를 갖는다.")
    void test_3() {
        // given, when
        Direction direction = firstDirectionTrue.createNext(() -> true);

        // then
        assertAll(
                () -> assertThat(direction.isExistLeftBar()).isTrue(),
                () -> assertThat(direction.isExistRightBar()).isFalse()
        );
    }

    @Test
    @DisplayName("createFinal()는 이전 바의 오른쪽 값으로 false를 받았을때 오른쪽 값으로 무조건 false를 갖는다.")
    void test_4() {
        // given, when
        Direction direction = middleDirectionFalse.createFinal();

        // then
        assertAll(
                () -> assertThat(direction.isExistLeftBar()).isFalse(),
                () -> assertThat(direction.isExistRightBar()).isFalse()
        );
    }

    @Test
    @DisplayName("createFinal()는 이전 바의 오른쪽 값으로 true를 받았을때 오른쪽 값으로 무조건 false를 갖는다.")
    void test_5() {
        // given, when
        Direction direction = middleDirectionTrue.createFinal();

        // then
        assertAll(
                () -> assertThat(direction.isExistLeftBar()).isTrue(),
                () -> assertThat(direction.isExistRightBar()).isFalse()
        );
    }
}
