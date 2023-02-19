package ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class PlayerNamesTest {
    @Test
    @DisplayName("입력받은 이름들을 ,를 기준으로 나눈다.")
    void test_1() {
        // when
        PlayerNames playerNames = new PlayerNames("chech,abel");
        
        // then
        assertThat(playerNames.getNames())
                .contains("chech", "abel");
    }
    
    @Test
    @DisplayName("플레이어 이름이 5자를 초과할 시 예외가 발생한다.")
    void test_2() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new PlayerNames("abel,cheche"))
                .withMessage("입력된 플레이어들의 이름 형식이 올바르지 않습니다.");
    }
    
    @Test
    @DisplayName("플레이어 이름 개수가 2미만일 시 예외가 발생한다.")
    void test_3() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new PlayerNames("abel"))
                .withMessage("이름의 수가 2이상 100이하여야 합니다.");
    }
    
    @Test
    @DisplayName("플레이어 이름이 중복될 시 예외가 발생한다.")
    void test_4() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new PlayerNames("abel,abel"))
                .withMessage("중복된 이름은 입력할 수 없습니다.");
    }
}
