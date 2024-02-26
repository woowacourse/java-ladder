package model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class HeightTest {

    @Test
    @DisplayName("사다리는 높이를 가진다.")
    void heightTest() {
        //given
        Height height = new Height("1");

        //when & then
        assertThat(height.getHeight()).isEqualTo(1);
    }

    @Test
    @DisplayName("숫자가 아닌 값 입력시 사전에 정의한 메세지를 출력한다. ")
    void illegalNumberFormatTest() {
        assertThatThrownBy(() -> new Height("프람"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("사다리의 높이는 숫자만 입력해주세요.");
     }

    @Test
    @DisplayName("사다리의 높이가 음수일 경우 예외를 발생시킨다.")
    void heightNegativeInputTest() {
        assertThatThrownBy(() -> new Height("0"))
                .isInstanceOf(IllegalArgumentException.class);

    }

}
