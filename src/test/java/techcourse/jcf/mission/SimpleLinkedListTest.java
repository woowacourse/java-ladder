package techcourse.jcf.mission;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class SimpleLinkedListTest {

    private SimpleList list;

    @BeforeEach
    void init() {
        list = new SimpleLinkedList();
    }

    @Test
    void addTest() {
        assertThat(list.add("first")).isTrue();
        assertThat(list.get(0)).isEqualTo("first");
    }

    @Test
    void addTest2() {
        list.add("first");
        list.add("second");
        assertThat(list.get(0)).isEqualTo("first");
        assertThat(list.get(1)).isEqualTo("second");
    }

    @Test
    void addTest3() {
        list.add(0, "first");
        list.add(0, "second");
        assertThat(list.get(0)).isEqualTo("second");
        assertThat(list.get(1)).isEqualTo("first");
    }

    @Test
    void addTest4() {
        list.add(0, "first");
        list.add(0, "second");
        list.add(1, "third");
        assertThat(list.get(0)).isEqualTo("second");
        assertThat(list.get(1)).isEqualTo("third");
        assertThat(list.get(2)).isEqualTo("first");
    }

    @ParameterizedTest
    @CsvSource({"-1", "2"})
    void getTest(int index) {
        list.add("first");
        list.add("second");
        assertThatThrownBy(() -> list.get(index))
                .isInstanceOf(IndexOutOfBoundsException.class)
                .hasMessage("인덱스가 벗어나면 예외를 발생시킨다.");
    }

    @Test
    void getTest2() {
        assertThatThrownBy(() -> list.get(0))
                .isInstanceOf(IndexOutOfBoundsException.class)
                .hasMessage("인덱스가 벗어나면 예외를 발생시킨다.");
    }

    @Test
    void setTest() {
        list.add("first");
        list.add("second");
        list.set(0, "third");
        list.set(1, "fourth");
        assertThat(list.get(0)).isEqualTo("third");
        assertThat(list.get(1)).isEqualTo("fourth");
    }

    @Test
    void setTest2() {
        list.add("first");
        list.set(0, "second");
        list.add("third");
        list.add(0, "fourth");
        list.set(1, "fifth");
        assertThat(list.get(0)).isEqualTo("fourth");
        assertThat(list.get(1)).isEqualTo("fifth");
        assertThat(list.get(2)).isEqualTo("third");
    }

    @Test
    void containsTest() {
        list.add("first");
        list.add("second");
        assertThat(list.contains("first")).isTrue();
        assertThat(list.contains("thrid")).isFalse();
    }

    @Test
    void indexOfTest() {
        list.add("first");
        list.add("second");
        assertThat(list.indexOf("first")).isEqualTo(0);
        assertThat(list.indexOf("second")).isEqualTo(1);
        assertThat(list.indexOf("thrird")).isEqualTo(-1);
    }

    @Test
    void sizeTest() {
        list.add("first");
        list.add("second");
        assertThat(list.size()).isEqualTo(2);
    }

    @Test
    void sizeTest2() {
        assertThat(list.size()).isEqualTo(0);
    }

    @Test
    void isEmptyTest() {
        assertThat(list.isEmpty()).isTrue();
        list.add("first");
        assertThat(list.isEmpty()).isFalse();
    }

    @Test
    void removeTest() {
        list.add("first");
        list.add("second");
        assertThat(list.remove(0)).isEqualTo("first");
        assertThat(list.get(0)).isEqualTo("second");
    }

    @Test
    void removeTest2() {
        list.add("first");
        list.add("second");
        assertThat(list.remove("first")).isTrue();
        assertThat(list.remove("first")).isFalse();
        assertThat(list.get(0)).isEqualTo("second");
        assertThat(list.remove("second")).isTrue();
        assertThat(list.isEmpty()).isTrue();
    }
}
