package domain.result;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class SearchTest {
    @Nested
    @DisplayName("검색 이름 형식 검증 테스트")
    class SearchNameFormatTest {
        @DisplayName("검색하는 이름이 저장되지 않은 이름이면 실패한다.")
        @Test
        void shouldFailUnsavedName() {
            String searchName = "abc";
            assertThatThrownBy(() -> new Search(searchName, List.of("test", "mango", "toney"))).isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining(Search.SEARCH_NAME_ERROR_MESSAGE);
        }

        @DisplayName("검색하는 이름이 저장된 이름이면 성공한다.")
        @Test
        void shouldSuccessSavedName() {
            String searchName = "mango";
            assertDoesNotThrow(() -> new Search(searchName, List.of("test", "mango", "toney")));
        }

        @DisplayName("검색하는 이름이 all이면 성공한다.")
        @Test
        void shouldSuccessWithAll() {
            String searchName = "all";
            assertDoesNotThrow(() -> new Search(searchName, List.of("test", "mango", "toney")));
        }
    }
}
