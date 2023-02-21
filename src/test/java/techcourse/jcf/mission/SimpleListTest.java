package techcourse.jcf.mission;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class SimpleListTest {
    List<String> list;

    @BeforeEach
    void initList() {
        // 구현한 구현체로 바꾸기
        list = new ArrayList<>(Arrays.asList("first", "second"));
    }

    @Test
    void addWithOnlyValue() {
        assertThat(list.add("third")).isTrue();
        assertThat(list).containsExactly("first", "second", "third");
    }

    @Test
    void addWithVIndexValue() {
        list.add(1, "third");
        assertThat(list).containsExactly("first", "third", "second");
    }

    @Test
    void addWithVIndexValueThrowException() {
        assertThatThrownBy(() -> list.add(3, "third"))
                .isInstanceOf(IndexOutOfBoundsException.class);
    }

    @Test
    void set() {
        assertThat(list.set(1, "third")).isEqualTo("second");
        assertThat(list).containsExactly("first", "third");
    }

    @Test
    void setThrowException() {
        assertThatThrownBy(() -> list.set(2, "third"))
                .isInstanceOf(IndexOutOfBoundsException.class);
    }

    @Test
    void get() {
        assertThat(list.get(0)).isEqualTo("first");
    }

    @Test
    void getThrowException() {
        assertThatThrownBy(() -> list.get(2))
                .isInstanceOf(IndexOutOfBoundsException.class);
    }

    @Test
    void contains() {
        assertThat(list.contains("first")).isTrue();
        assertThat(list.contains("third")).isFalse();
    }

    @Test
    void indexOf() {
        assertThat(list.indexOf("first")).isEqualTo(0);
        assertThat(list.indexOf("third")).isEqualTo(-1);
    }

    @Test
    void size() {
        assertThat(list.size()).isEqualTo(2);
    }

    @Test
    void isEmpty() {
        assertThat(list.isEmpty()).isFalse();
        list.clear();
        assertThat(list.isEmpty()).isTrue();
    }

    @Test
    void removeWithValue() {
        assertThat(list.remove("first")).isTrue();
        assertThat(list).containsExactly("second");
    }

    @Test
    void removeWithIndex() {
        assertThat(list.remove(0)).isEqualTo("first");
        assertThat(list).containsExactly("second");
    }

    @Test
    void clear() {
        list.clear();
        assertThat(list).hasSize(0);
    }
}