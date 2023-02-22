package ladder.view;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class InputViewValidatorTest {

    @Test
    @DisplayName("참여자의 수가 2보다 작으면 예외를 던진다.")
    void doNotReachMinPlayerCountTest() {
        int count = 1;

        assertThrows(IllegalArgumentException.class,
                () -> InputViewValidator.validateNamesCount(count))
                .getMessage().equals("[ERROR] 참여자의 수는 2명 이상이여야합니다.");
    }

    @Test
    @DisplayName("참여자의 수가 10000명을 넘으면 예외를 던진다.")
    void exceedMaxPlayerCountTest() {
        int count = 10001;

        assertThrows(IllegalArgumentException.class,
                () -> InputViewValidator.validateNamesCount(count))
                .getMessage().equals("[ERROR] 참여자의 수는 10000명 이하여야합니다.");
    }

    @Test
    @DisplayName("참여자의 이름이 all이면 예외를 던진다.")
    void playerNameTest() {
        String playerName = "all";

        assertThrows(IllegalArgumentException.class,
                () -> InputViewValidator.validateNameIsAll(playerName))
                .getMessage().equals("[ERROR] 참여자의 이름은 all일 수 없습니다.");
    }

    @Test
    @DisplayName("참여자의 이름이 중복되면 예외를 던진다.")
    void playerNamesDuplicateTest() {
        List<String> playerNames = List.of("hardy", "hello", "hardy");

        assertThrows(IllegalArgumentException.class,
                () -> InputViewValidator.validateDuplicatedNames(playerNames))
                .getMessage().equals("[ERROR] 참여자의 이름은 중복될 수 없습니다.");
    }

    @Test
    @DisplayName("사다리의 높이는 숫자여아한다.")
    void ladderHeightIsNumericTest() {
        String ladderHeight = "abc";

        assertThrows(IllegalArgumentException.class,
                () -> InputViewValidator.validateNumeric(ladderHeight))
                .getMessage().equals("[ERROR] 숫자만 입력해야합니다.");
    }
}
