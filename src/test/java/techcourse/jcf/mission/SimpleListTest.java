package techcourse.jcf.mission;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class SimpleListTest {
    SimpleList list;

    @BeforeEach
    void initList() {
        // 구현한 구현체로 바꾸기
        list = new SimpleArrayList(new String[]{"0", "1"});
    }

    @Test
    void get() {
        assertThat(list.get(0)).isEqualTo("first");
    }

    @Test
    void addWithOnlyValue() {
        assertThat(list.add("third")).isTrue();
        assertThat(list.get(2)).isEqualTo("third");
    }

    @Test
    void addManyValuesWithNoException() {
        assertDoesNotThrow(() -> {
            for (int i = 2; i < 50; i++) {
                list.add(String.format("%d", i));
            }
        });
    }

    @Test
    void addWithVIndexValue() {
        list.add(1, "third");
        assertThat(list.get(1)).isEqualTo("third");
    }

    @Test
    void addWithVIndexValueThrowException() {
        assertThatThrownBy(() -> list.add(3, "third"))
                .isInstanceOf(IndexOutOfBoundsException.class);
    }

    @Test
    void set() {
        assertThat(list.set(1, "third")).isEqualTo("second");
        assertThat(list.get(1)).isEqualTo("third");
    }

    @Test
    void setThrowException() {
        assertThatThrownBy(() -> list.set(2, "third"))
                .isInstanceOf(IndexOutOfBoundsException.class);
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
        assertThat(list.get(0)).isEqualTo("second");
    }

    @Test
    void removeFailWithValue() {
        assertThat(list.remove("third")).isFalse();
    }

    @Test
    void removeWithIndex() {
        assertThat(list.remove(0)).isEqualTo("first");
        assertThat(list.get(0)).isEqualTo("second");
    }

    @Test
    void clear() {
        assertThat(list.size()).isEqualTo(2);
        list.clear();
        assertThat(list.size()).isEqualTo(0);
    }
}