package ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

class CommandTest {

    @Test
    @DisplayName("실행결과가 참여자의 개수보다 많으면 예외가 발생한다.")
    void input_result_exception_if_over_names_count() {
        //given
        List<String> names = List.of("dochi", "vero", "dogi", "ddd");
        List<String> results = List.of("꽝", "lucky", "dadad", "mmm", "ada", "qweq");
        int height = 5;

        assertThatThrownBy(() -> {
            new Command(names, results, height);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessage("실행 결과의 개수는 참여자의 개수 이하이어야 합니다.");
    }

    @Test
    @DisplayName("실행결과 개수가 참여자 개수보다 적으면, 나머지는 꽝으로 채운다.")
    void result_fill_꽝_if_below_names_count() {
        //given
        List<String> names = List.of("dochi", "vero", "dogi", "ddd");
        List<String> results = List.of("lucky", "dadad");
        int height = 5;

        //when
        Command command = new Command(names, results, height);

        //then
        assertThat(command.getResults()).containsExactly("lucky", "dadad", "꽝", "꽝");
    }
}
