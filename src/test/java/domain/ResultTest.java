package domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import static org.assertj.core.api.Assertions.assertThat;

class ResultTest {
    private Result result;

    @BeforeEach
    void init() {
        Users users = new Users(List.of(new User("aa"), new User("bb"), new User("cc")));

        Items items = new Items(List.of(new Item("1"), new Item("2"), new Item("3")), users);

        Queue<Boolean> randomNumber = new LinkedList<>();
        Arrays.asList(false, true, true, true).forEach(randomNumber::add);
        Ladders ladders = new Ladders(users.getCount(), new Height(3), new CustomRandomGenerator(randomNumber));

        this.result = new Result(users, items, ladders);
    }

    @Test
    void getItem() {
        assertThat(result.getItem(new User("cc"))).isEqualTo("2");
    }
}
