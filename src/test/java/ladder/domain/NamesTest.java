package ladder.domain;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import ladder.error.ErrorMessage;

class NamesTest {

    @ParameterizedTest(name = "사람 수는 2명 이상 100명 이하여야 한다.")
    @ValueSource(ints = {1, 101})
    void createNamesFailTest(int size) {
        List<String> userNames = createUserNamesBySize(size);

        assertThatThrownBy(() -> new Names(userNames))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage(ErrorMessage.INVALID_PEOPLE_COUNT.getMessage());
    }

    @ParameterizedTest(name = "사람 수는 2명 이상 100명 이하여야 한다.")
    @ValueSource(ints = {2, 100})
    void createNamesSuccessTest(int size) {
        List<String> userNames = createUserNamesBySize(size);

        assertDoesNotThrow(() -> new Names(userNames));
    }

    public List<String> createUserNamesBySize(int size) {
        List<String> userNames = new ArrayList<>();

        for (int i = 0; i < size; i++) {
            userNames.add(String.valueOf(i));
        }

        return userNames;
    }
}
