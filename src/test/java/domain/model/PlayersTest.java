package domain.model;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

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

    @Test
    @DisplayName("최소 최대 인원 성공 테스트")
    public void validateSizeSuccessTest() {
        //given
        List<String> mockStrings1 = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            mockStrings1.add(i + "t");
        }
        List<String> mockStrings2 = new ArrayList<>();
        mockStrings2.add("t");

        //when
        //then
        assertDoesNotThrow(() -> new Players(mockStrings1));
        assertDoesNotThrow(() -> new Players(mockStrings2));
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