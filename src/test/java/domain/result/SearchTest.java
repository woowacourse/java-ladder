package domain.result;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class SearchTest {
    @Nested
    @DisplayName("검색 이름 형식 검증 테스트")
    class NameFormatTest {
        @DisplayName("검색하는 이름이 저장되지 않은 이름이면 실패한다.")
        @Test
        void shouldFailUnsavedName() {
            String searchName = "abc";
            assertThatThrownBy(() -> new Search(searchName, List.of("test", "mango", "toney"))).isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining("[ERROR] 등록되지 않은 유저입니다.");
        }
    }
}
