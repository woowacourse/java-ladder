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
    @DisplayName("최소 최대 인원 실패 테스트")
    public void validateSizeFailureTest() {
        //given
        List<String> mockStrings = new ArrayList<>();
        for (int i = 0; i < 101; i++) {
            mockStrings.add(i + "t");
        }

        //when
        //then
        assertThatThrownBy(() -> new Players(mockStrings))
            .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> new Players(new ArrayList<>()))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest(name = "최소 최대 인원 성공 테스트")
    @ValueSource(ints = {2, 100})
    public void validateSizeSuccessTest(int size) {
        //given
        List<String> mockStrings = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            mockStrings.add(i + "t");
        }

        //when
        //then
        assertDoesNotThrow(() -> new Players(mockStrings));
    }

    @Test
    @DisplayName("중복 이름 검사 실패 테스트")
    public void validateDuplicateFailureTest() {
        //given
        List<String> mockStrings = new ArrayList<>();
        mockStrings.add("test");
        mockStrings.add("test");

        //when
        //then
        assertThatThrownBy(() -> new Players(mockStrings))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("중복 이름 검사 성공 테스트")
    public void validateDuplicateSuccessTest() {
        //given
        List<String> mockStrings = new ArrayList<>();
        mockStrings.add("test");
        mockStrings.add("test1");

        //when
        //then
        assertDoesNotThrow(() -> new Players(mockStrings));
    }
}