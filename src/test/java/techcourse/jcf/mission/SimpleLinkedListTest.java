package techcourse.jcf.mission;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

class SimpleLinkedListTest {

    @Test
    public void linkedList() {
        SimpleList values = new SimpleLinkedList();
        values.add("first");
        values.add("second");

        assertThat(values.add("third")).isTrue(); // 세 번째 값을 추가한다.
        assertThat(values.size()).isEqualTo(3); // list의 크기를 구한다.
        assertThat(values.get(0)).isEqualTo("first"); // 첫 번째 값을 찾는다.
        assertThat(values.contains("first")).isTrue(); // "first" 값이 포함되어 있는지를 확인한다.
        assertThat(values.remove(0)).isEqualTo("first"); // 첫 번째 값을 삭제한다.
        assertThat(values.size()).isEqualTo(2); // 값이 삭제 됐는지 확인한다.

        // TODO values에 담긴 모든 값을 출력한다.
    }

    @Test
    @DisplayName("값을 정상적으로 추가한다.")
    void add_element() {
        final SimpleLinkedList simpleLinkedList = new SimpleLinkedList();

        simpleLinkedList.add("pobi");
        simpleLinkedList.add("crong");

        assertThat(simpleLinkedList.size()).isEqualTo(2);
        assertThat(simpleLinkedList.get(0)).isEqualTo("pobi");
        assertThat(simpleLinkedList.get(1)).isEqualTo("crong");
    }

    @ParameterizedTest(name = "입력: {0}")
    @ValueSource(ints = {-1, 3})
    @DisplayName("유효하지 않은 인덱스에 값을 추가하면 예외를 던진다.")
    void throw_exception_add_invalid_index(final int index) {
        final SimpleLinkedList simpleLinkedList = new SimpleLinkedList();

        simpleLinkedList.add("pobi");
        simpleLinkedList.add("crong");

        assertThatThrownBy(() -> simpleLinkedList.add(index, "honux"))
                .isInstanceOf(IndexOutOfBoundsException.class);
    }

    @Test
    @DisplayName("첫 인덱스에 값을 추가한다.")
    void add_element_first_index() {
        final SimpleLinkedList simpleLinkedList = new SimpleLinkedList();

        simpleLinkedList.add("pobi");
        simpleLinkedList.add(0, "crong");

        assertThat(simpleLinkedList.size()).isEqualTo(2);
        assertThat(simpleLinkedList.get(0)).isEqualTo("crong");
        assertThat(simpleLinkedList.get(1)).isEqualTo("pobi");
    }

    @Test
    @DisplayName("해당 인덱스에 값을 추가한다.")
    void add_element_valid_index() {
        final SimpleLinkedList simpleLinkedList = new SimpleLinkedList();

        simpleLinkedList.add("pobi");
        simpleLinkedList.add("crong");
        simpleLinkedList.add("honux");

        simpleLinkedList.add(1, "jk");

        assertThat(simpleLinkedList.size()).isEqualTo(4);
        assertThat(simpleLinkedList.get(0)).isEqualTo("pobi");
        assertThat(simpleLinkedList.get(1)).isEqualTo("jk");
        assertThat(simpleLinkedList.get(2)).isEqualTo("crong");
        assertThat(simpleLinkedList.get(3)).isEqualTo("honux");
    }

    @Test
    @DisplayName("마지막 인덱스에 값을 추가한다.")
    void add_element_last_index() {
        final SimpleLinkedList simpleLinkedList = new SimpleLinkedList();

        simpleLinkedList.add("pobi");
        simpleLinkedList.add(1, "crong");

        assertThat(simpleLinkedList.size()).isEqualTo(2);
        assertThat(simpleLinkedList.get(0)).isEqualTo("pobi");
        assertThat(simpleLinkedList.get(1)).isEqualTo("crong");
    }

    @ParameterizedTest(name = "입력: {0}")
    @ValueSource(ints = {-1, 2})
    @DisplayName("유효하지 않은 인덱스의 값을 변경하면 예외를 던진다.")
    void throw_exception_set_invalid_index(final int index) {
        final SimpleLinkedList simpleLinkedList = new SimpleLinkedList();

        simpleLinkedList.add("pobi");
        simpleLinkedList.add("crong");

        assertThatThrownBy(() -> simpleLinkedList.set(index, "honux"))
                .isInstanceOf(IndexOutOfBoundsException.class);
    }

    @Test
    @DisplayName("해당 인덱스의 값을 변경한다.")
    void set_element_valid_index() {
        final SimpleLinkedList simpleLinkedList = new SimpleLinkedList();

        simpleLinkedList.add("pobi");

        simpleLinkedList.set(0, "crong");

        assertThat(simpleLinkedList.size()).isEqualTo(1);
        assertThat(simpleLinkedList.get(0)).isEqualTo("crong");
    }

    @ParameterizedTest(name = "입력: {0}, 결과: {1}")
    @CsvSource(value = {"pobi:true", "crong:false"}, delimiter = ':')
    @DisplayName("값이 포함되어 있는지 여부를 확인한다.")
    void contain_element(final String value, final boolean result) {
        final SimpleLinkedList simpleLinkedList = new SimpleLinkedList();

        simpleLinkedList.add("pobi");

        assertThat(simpleLinkedList.contains(value)).isEqualTo(result);
    }

    @Test
    @DisplayName("값이 존재하면 인덱스를 반환한다.")
    void index_exist_value() {
        final SimpleLinkedList simpleLinkedList = new SimpleLinkedList();

        simpleLinkedList.add("pobi");

        int index = simpleLinkedList.indexOf("pobi");

        assertThat(index).isEqualTo(0);
    }

    @Test
    @DisplayName("값이 존재하지 않으면 -1을 반환한다.")
    void index_not_exist_value() {
        final SimpleLinkedList simpleLinkedList = new SimpleLinkedList();

        int index = simpleLinkedList.indexOf("pobi");

        assertThat(index).isEqualTo(-1);
    }

    @Test
    @DisplayName("비어 있으면 true 반환한다.")
    void check_empty() {
        final SimpleLinkedList simpleLinkedList = new SimpleLinkedList();

        boolean result = simpleLinkedList.isEmpty();

        assertThat(result).isTrue();
    }

    @Test
    @DisplayName("비어있지 않으면 false 반환한다.")
    void check_not_empty() {
        final SimpleLinkedList simpleLinkedList = new SimpleLinkedList();

        simpleLinkedList.add("pobi");

        boolean result = simpleLinkedList.isEmpty();

        assertThat(result).isFalse();
    }

    @Test
    @DisplayName("해당 값을 삭제한다.")
    void remove_element() {
        final SimpleLinkedList simpleLinkedList = new SimpleLinkedList();

        simpleLinkedList.add("pobi");

        boolean result = simpleLinkedList.remove("pobi");

        assertThat(result).isTrue();
        assertThat(simpleLinkedList.size()).isEqualTo(0);
    }

    @Test
    @DisplayName("해당 값이 존재하지 않으면 삭제하지 않는다.")
    void remove_not_exist_element() {
        final SimpleLinkedList simpleLinkedList = new SimpleLinkedList();

        simpleLinkedList.add("pobi");

        boolean result = simpleLinkedList.remove("crong");

        assertThat(result).isFalse();
        assertThat(simpleLinkedList.size()).isEqualTo(1);
    }

    @ParameterizedTest(name = "입력: {0}")
    @ValueSource(ints = {-1, 2})
    @DisplayName("유효하지 않은 인덱스의 값을 삭제하면 예외를 던진다.")
    void throw_exception_remove_invalid_index(final int index) {
        final SimpleLinkedList simpleLinkedList = new SimpleLinkedList();

        simpleLinkedList.add("pobi");
        simpleLinkedList.add("crong");

        assertThatThrownBy(() -> simpleLinkedList.remove(index))
                .isInstanceOf(IndexOutOfBoundsException.class);
    }

    @Test
    @DisplayName("첫 번째 인덱스의 값을 삭제한다.")
    void remove_first_index() {
        final SimpleLinkedList simpleLinkedList = new SimpleLinkedList();

        simpleLinkedList.add("pobi");
        simpleLinkedList.add("crong");

        simpleLinkedList.remove(0);

        assertThat(simpleLinkedList.size()).isEqualTo(1);
        assertThat(simpleLinkedList.get(0)).isEqualTo("crong");
    }

    @Test
    @DisplayName("해당 인덱스의 값을 삭제한다.")
    void remove_index() {
        final SimpleLinkedList simpleLinkedList = new SimpleLinkedList();

        simpleLinkedList.add("pobi");
        simpleLinkedList.add("crong");
        simpleLinkedList.add("honux");

        simpleLinkedList.remove(1);

        assertThat(simpleLinkedList.size()).isEqualTo(2);
        assertThat(simpleLinkedList.get(0)).isEqualTo("pobi");
        assertThat(simpleLinkedList.get(1)).isEqualTo("honux");
    }

    @Test
    @DisplayName("마지막 인덱스의 값을 삭제한다.")
    void remove_last_index() {
        final SimpleLinkedList simpleLinkedList = new SimpleLinkedList();

        simpleLinkedList.add("pobi");
        simpleLinkedList.add("crong");

        simpleLinkedList.remove(1);

        assertThat(simpleLinkedList.size()).isEqualTo(1);
        assertThat(simpleLinkedList.get(0)).isEqualTo("pobi");
    }

    @Test
    @DisplayName("리스트를 비운다.")
    void clear() {
        final SimpleLinkedList simpleLinkedList = new SimpleLinkedList();

        simpleLinkedList.add("pobi");
        simpleLinkedList.add("crong");
        simpleLinkedList.add("honux");

        simpleLinkedList.clear();

        assertThat(simpleLinkedList.size()).isEqualTo(0);
    }
}
