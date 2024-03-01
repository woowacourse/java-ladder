package view;

import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class PlayersInputViewTest {

    @Test
    @DisplayName("참여자 이름을 구분자로 잘 자르는지 검증")
    void getPlayerNames() {
        List<String> playerNames = PlayersInputView.getPlayerNames("robin,phobi,12345,test1");
        Assertions.assertThat(playerNames)
                .containsExactlyElementsOf(List.of("robin", "phobi", "12345", "test1"));
    }

    @Test
    @DisplayName("연속된 구분자가 입력된 경우 실행 안되는지 검증")
    void validateDuplicateSeparator() {
        Assertions.assertThatThrownBy(() -> PlayersInputView.getPlayerNames("robin,,a"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("입력에 구분자가 연속으로 등장하면 안됩니다.");
    }

    @ParameterizedTest
    @ValueSource(strings = {",robin,phobi", "robin,phobi,"})
    @DisplayName("구분자로 시작하거나 끝나도록 입력된 경우 실행 안되는지 검증")
    void validateStartOrEndWithSeparator(String input) {
        Assertions.assertThatThrownBy(() -> PlayersInputView.getPlayerNames(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("입력이 구분자로 시작하거나 끝나면 안됩니다.");
    }
}
