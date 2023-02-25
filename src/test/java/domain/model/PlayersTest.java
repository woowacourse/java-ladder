package domain.model;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class PlayersTest {

    @Test
    @DisplayName("적절한 크기가 아닌 이름들이 들어왔을 때를 테스트")
    public void testValidateSizeFailureTest() {
        //given
        List<String> names = new ArrayList<>();
        for (int i = 0; i < 101; i++) {
            names.add(i + "t");
        }

        //when
        //then
        assertThatThrownBy(() -> new Players(names))
            .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> new Players(new ArrayList<>()))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest(name = "적절한 크가인 이름들이 들어왔을 때를 테스트")
    @ValueSource(ints = {2, 100})
    public void testValidateSizeSuccessTest(int size) {
        //given
        List<String> names = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            names.add(i + "t");
        }

        //when
        //then
        assertDoesNotThrow(() -> new Players(names));
    }

    @Test
    @DisplayName("중복된 이름들이 들어왔을 때를 테스트")
    public void testValidateDuplicateFailureTest() {
        //given
        List<String> names = new ArrayList<>();
        names.add("test");
        names.add("test");

        //when
        //then
        assertThatThrownBy(() -> new Players(names))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("중복되지 않은 이름들이 들어왔을 때를 테스트")
    public void testValidateDuplicateSuccessTest() {
        //given
        List<String> names = new ArrayList<>();
        names.add("test");
        names.add("test1");

        //when
        //then
        assertDoesNotThrow(() -> new Players(names));
    }
}