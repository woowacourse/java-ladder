package ladder.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class UserDestinationTest {
    @DisplayName("동일한 이름인 경우 true를, 다른 이름인 경우 false를 반환한다.")
    @CsvSource(value = {"liv:true", "kelly:false"}, delimiter = ':')
    @ParameterizedTest
    void checkSameName(String name, boolean expected) {
        UserDestination userDestination = new UserDestination(new UserName("liv"), new Destination("3000"));

        assertThat(userDestination.isSameName(name)).isEqualTo(expected);
    }
}
