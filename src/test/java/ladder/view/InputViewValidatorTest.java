package ladder.view;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class InputViewValidatorTest {

    @Test
    @DisplayName("참여자의 수가 10000명을 넘으면 예외를 던진다.")
    void exceedMaxPlayerCountTest() {
        int count = 10001;

        assertThrows(IllegalArgumentException.class,
                () ->  InputViewValidator.validateNamesCount(count))
                .getMessage().equals("[ERROR] 참여자의 수는 10000명 이하여야합니다.");
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
