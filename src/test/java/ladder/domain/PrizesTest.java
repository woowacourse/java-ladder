package ladder.domain;

import org.junit.jupiter.api.Test;

import java.util.List;

class PrizesTest {
    Prizes prizes = Prizes.from(List.of(
            "0",
            "1",
            "2"
    ));

    @Test
    void should_상품을반환한다_when_위치를넣으면() {
        // given
        prizes.get(new Position(0));

        // when

        //then
    }

}