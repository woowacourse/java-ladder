package domain.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

class ConsequencesTest {
    @Test
    @DisplayName("결과가 사람 수와 동일하지 않으면 에러를 발생한다.")
    void checkConsequencesSize() {
        assertThatThrownBy(()->new Consequences(List.of("10","20","30"),2))
                .isInstanceOf(IllegalArgumentException.class);
    }
    
    @ParameterizedTest
    @CsvSource({
            "0,100",
            "1,꽝",
            "2,200"
    })
    @DisplayName("순서에 알맞는 결과를 반환한다")
    void getConsequenceNameByOrder(int order,String expected) {
        //given
        Consequences consequences=new Consequences(List.of("100","꽝","200"),3);
        //when
        Consequence actual=consequences.getConsequenceByOrder(order);
        //then
        assertThat(expected).isEqualTo(actual.getValue());
    }
}
