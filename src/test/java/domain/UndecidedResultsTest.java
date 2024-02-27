package domain;

import domain.name.Names;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class UndecidedResultsTest {

    private final Names names = Names.from(List.of("a", "b", "c"));

    @DisplayName("결과의 수와 참여자 수가 같으면 생성 검증에 성공한다.")
    @Test
    void testCreateWithSameResultNumbers() {
        List<String> results = List.of("100", "200", "300");
        Assertions.assertThatCode(() -> new UndecidedResults(names, results)).doesNotThrowAnyException();
    }

    @DisplayName("결과의 수와 참여자 수가 다르면 생성 검증에 실패한다.")
    @Test
    void testCreateWithDifferentResultNumbers() {
        List<String> results = List.of("100", "200", "300", "400");
        assertThatThrownBy(() -> new UndecidedResults(names, results))
                .isInstanceOf(IllegalArgumentException.class).hasMessage("[ERROR] 결과의 수는 참여자 수와 일치해야 합니다.");
    }
}
