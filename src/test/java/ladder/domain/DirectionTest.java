package ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

public class DirectionTest {

    @Test
    @DisplayName("createFirst()는 오른쪽 바가 랜덤값을 받아 생성된다.")
    void test_1() {
        // given, when
        Direction direction = Direction.createFirst(() -> true);

        // then
        assertAll(
                () -> assertThat(direction.isExistLeftBar()).isFalse(),
                () -> assertThat(direction.isExistRightBar()).isTrue()
        );
    }

    @Test
    @DisplayName("createMiddle()는 이전 바의 오른쪽 값으로 false를 받았을때 랜덤값으로 오른쪽 바를 생성한다.")
    void test_2() {
        // given, when
        Direction direction = Direction.createMiddle(new Bar(() -> false), () -> true);

        // then
        assertAll(
                () -> assertThat(direction.isExistLeftBar()).isFalse(),
                () -> assertThat(direction.isExistRightBar()).isTrue()
        );
    }

    @Test
    @DisplayName("createMiddle()는 이전 바의 오른쪽 값으로 true를 받았을때 오른쪽 값으로 무조건 false를 갖는다.")
    void test_3() {
        // given, when
        Direction direction = Direction.createMiddle(new Bar(() -> true), () -> true);

        // then
        assertAll(
                () -> assertThat(direction.isExistLeftBar()).isTrue(),
                () -> assertThat(direction.isExistRightBar()).isFalse()
        );
    }

    @Test
    @DisplayName("createMiddle()는 이전 바의 오른쪽 값으로 true를 받았을때 오른쪽 값으로 무조건 false를 갖는다.")
    void test_4() {
        // given, when
        Direction direction = Direction.createFinal(new Bar(() -> true));

        // then
        assertAll(
                () -> assertThat(direction.isExistLeftBar()).isTrue(),
                () -> assertThat(direction.isExistRightBar()).isFalse()
        );
    }
}
