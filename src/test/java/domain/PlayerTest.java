package domain;

import helper.StubPossiblePointGenerator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class PlayerTest {

    @Test
    @DisplayName("이름에 6글자 이상 입력시 예외 발생")
    void validateNameLength(){
        assertThatThrownBy(() -> new Player("123456", 0))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 이름 길이는 5자를 넘길 수 없습니다.");
    }

    @ParameterizedTest
    @ValueSource(strings = {""," ","   "})
    @DisplayName("이름에 공백 입력시 예외 발생")
    void validateBlankName(String blankName){
        assertThatThrownBy(() -> new Player(blankName, 0))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 빈 문자열 입니다.");
    }

    @Test
    @DisplayName("결과가 잘 나오는지 확인")
    void calculateResult() {
        int startIndex = 0;
        String result = "2";
        Player player = new Player("pobi", startIndex);
        Ladder ladder = new Ladder(5, 4, new StubPossiblePointGenerator());

        assertThat(player.calculateResult(ladder, new Results(4, List.of("1", "2", "3", "4"))))
                .isEqualTo(result);
    }
}
