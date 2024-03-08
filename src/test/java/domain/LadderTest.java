package domain;

import domain.line.CustomLinesGenerator;
import domain.line.RandomLinesGenerator;
import domain.name.Names;
import domain.prize.Prizes;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static domain.ConnectionStatus.CONNECTED;
import static domain.ConnectionStatus.DISCONNECTED;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class LadderTest {
    @DisplayName("입력된 상품 개수와 참여자의 수가 같지 않으면 생성 검증에 실패한다")
    @Test
    void testCreateLadderInvalidAmount() {
        Names names = Names.from(List.of("a", "b", "c", "d"));
        Prizes prizes = Prizes.from(List.of("1", "2", "3"));
        Assertions.assertThatThrownBy(() ->
                        Ladder.createFrom(new RandomLinesGenerator(), names, new Height(1), prizes))
                .isInstanceOf(IllegalArgumentException.class).hasMessage("[ERROR] 상품의 수는 참여자 수와 일치해야 합니다.");
    }

    @DisplayName("입력된 상품 개수와 참여자의 수가 같으면 생성 검증에 성공한다")
    @Test
    void testCreateLadderValidAmount() {
        Names names = Names.from(List.of("a", "b", "c"));
        Prizes prizes = Prizes.from(List.of("1", "2", "3"));
        Assertions.assertThatCode(() ->
                        Ladder.createFrom(new RandomLinesGenerator(), names, new Height(1), prizes))
                .doesNotThrowAnyException();
    }

    @DisplayName("시작점에 맞는 끝점을 반환한다.")
    @Test
    void findPrizeIndexTest() {
        Ladder ladder = Ladder.createFrom(new CustomLinesGenerator(List.of(
                        List.of(CONNECTED, DISCONNECTED, CONNECTED),
                        List.of(DISCONNECTED, CONNECTED, DISCONNECTED),
                        List.of(CONNECTED, DISCONNECTED, CONNECTED))),
                Names.from(List.of("a", "b", "c", "d")),
                new Height(5),
                Prizes.from(List.of("1", "2", "3", "4")));

        ladder.matchLadderPoints();
        org.junit.jupiter.api.Assertions.assertAll(
                () -> assertEquals(ladder.findPrizeIndex(0), 3),
                () -> assertEquals(ladder.findPrizeIndex(1), 1),
                () -> assertEquals(ladder.findPrizeIndex(2), 2),
                () -> assertEquals(ladder.findPrizeIndex(3), 0)
        );
    }
}
