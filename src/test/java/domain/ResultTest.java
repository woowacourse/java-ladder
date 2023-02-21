package domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ResultTest {
    private Result result;

    @BeforeEach
    void init() {
        Users users = Users.from(List.of("aa", "bb", "cc"));

        Items items = Items.of(List.of("1", "2", "3"), users);

        Queue<Boolean> randomNumber = new LinkedList<>(Arrays.asList(false, true, true, true));
        Ladders ladders = Ladders.of(users.getCount(), Height.from(3), new CustomRandomGenerator(randomNumber));

        this.result = new Result(users, items, ladders);
    }

    @DisplayName("사다리 게임이 정상적으로 동작하는지 테스트")
    @Test
    void getItem() {
        assertThat(result.getItem(new User("cc"))).isEqualTo(new LinkedHashMap<>(Map.of(new User("cc"), new Item("2"))));
    }

    @DisplayName("사다리게임에 등록되지 않은 유저를 입력시 예외 발생")
    @Test
    void getItemFailTest() {
        assertThatThrownBy(() -> result.getItem(new User("dd"))).isInstanceOf(IllegalArgumentException.class);
    }
}
