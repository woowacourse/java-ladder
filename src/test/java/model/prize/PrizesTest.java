package model.prize;

import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PrizesTest {
    @DisplayName("실행 결과들을 저장하는 객체를 생성한다.")
    @Test
    void createPrizesTest() {
        List<String> names = List.of("꽝", "5000", "꽝", "3000");
        Assertions.assertThatCode(() -> {
            Prizes.of(names, 4);
        }).doesNotThrowAnyException();
    }

    @DisplayName("인덱스를 기반으로 실행 결과를 조회한다.")
    @Test
    void getPrizeByIndex() {
        int index = 3;
        List<String> names = List.of("꽝", "5000", "꽝", "3000");
        Prizes prizes = Prizes.of(names, 4);
        Prize prize = prizes.getPrizeByIndex(index);
        Assertions.assertThat(prize).isEqualTo(new Prize("3000"));
    }

    @DisplayName("입력된 실행 결과의 개수와 참여 인원의 수가 맞지 않아 객체 생성이 실패한다.")
    @Test
    void failCreateTest() {
        List<String> names = List.of("꽝", "5000", "꽝", "3000");
        Assertions.assertThatCode(() -> {
            Prizes.of(names, 6);
        }).isInstanceOf(IllegalArgumentException.class);
    }
}
