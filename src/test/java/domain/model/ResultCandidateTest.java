package domain.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.assertj.core.api.FactoryBasedNavigableListAssert.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class ResultCandidateTest {
    @Test
    @DisplayName("결과가 사람 수와 동일하지 않으면 에러를 발생한다.")
    void checkResultCandidateSize() {
        assertThatThrownBy(()->new ResultCandidate(List.of("10","20","30"),2))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
