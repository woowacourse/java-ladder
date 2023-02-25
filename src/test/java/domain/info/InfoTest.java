package domain.info;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import java.util.Arrays;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class InfoTest {
    private static final String SPLIT_DELIMITER = ",";

    @DisplayName("사용자의 이름의 수와 보상의 수는 같다.")
    @ParameterizedTest
    @CsvSource(value = {"a,b:A,B", "a,b,c:A,B,C", "a,b,c,d:A,B,C,D"}, delimiter = ':')
    void validTest(String nameInput, String rewardInput) {
        Names names = new Names(
                Arrays.asList(nameInput.split(SPLIT_DELIMITER))
        );
        Rewards rewards = new Rewards(
                Arrays.asList(rewardInput.split(SPLIT_DELIMITER))
        );

        assertDoesNotThrow(() -> new Info(names, rewards));
    }

    @DisplayName("사용자의 이름의 수와 보상의 수가 다르면 예외처리한다.")
    @ParameterizedTest
    @CsvSource(value = {"a,b:A,B,C", "a,b,c:A,B", "a,b,c:A,B,C,D"}, delimiter = ':')
    void invalidTest(String nameInput, String rewardInput) {
        Names names = new Names(
                Arrays.asList(nameInput.split(SPLIT_DELIMITER))
        );
        Rewards rewards = new Rewards(
                Arrays.asList(rewardInput.split(SPLIT_DELIMITER))
        );

        assertThatIllegalArgumentException()
                .isThrownBy(() -> new Info(names, rewards))
                .withMessageContaining("[ERROR] 이름의 수와 보상의 수는 같아야 합니다.");
    }
}
