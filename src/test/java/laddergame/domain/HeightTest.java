package laddergame.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

@DisplayName("사다리 높이")
public class HeightTest {
    @Test
    @DisplayName("객체가 생성되는지 확인한다.")
    public void heightCreateTest() {
        //given
        String actualHeight = "5";
        int expectedHeight = Integer.parseInt(actualHeight);

        //when
        Height height = new Height(actualHeight);

        //then
        assertEquals(height.getHeight(), expectedHeight);

    }

    @ParameterizedTest
    @ValueSource(strings = {"-1", "0", "2.3", "", " "})
    @DisplayName("사다리의 높이가 자연수가 아닐 경우 예외가 발생한다.")
    public void heightNaturalNumberTest(final String height) {
        //given & when & then
        assertThrows(IllegalArgumentException.class, () -> new Height(height));
    }

    @Test
    @DisplayName("최댓값을 제한한다.")
    public void maxHeightLimitTest() {
        //given
        String height = "10";

        //when & then
        assertThrows(IllegalArgumentException.class, () -> new Height(height));
    }
}
