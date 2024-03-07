package ladder.domain.item;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@DisplayName("사다리 아이템")
public class LadderItemsTest {
    @DisplayName("생성 테스트")
    @Test
    void createTest() {
        // given
        People people = new People(List.of("pobi", "nak", "neo"));
        WinningItems winningItems = new WinningItems(List.of("1등", "2등", "3등"));

        // when & then
        assertThatCode(() -> new LadderItems(people, winningItems))
                .doesNotThrowAnyException();
    }


    @DisplayName("사람의 수와 당첨 아이템의 개수가 동일하지 않으면 예외를 발생시킨다.")
    @Test
    void countNotSameTest() {
        // given
        People people = new People(List.of("pobi", "nak", "neo"));
        WinningItems winningItems = new WinningItems(List.of("1등", "2등", "3등", "4등"));

        // when & then
        assertThatThrownBy(() -> new LadderItems(people, winningItems))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("사람의 수와 당첨 아이템의 개수는 동일해야 합니다.");
    }
}
