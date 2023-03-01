package techcourse.jcf.mission;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

class SimpleArrayListTest {

    @Test
    void simpleArrayList() {
        final SimpleList values = new SimpleArrayList();
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
    @DisplayName("설정한 용량을 넘어가도 리스트에 원소를 추가한다.")
    void add_element_exceed_capacity() {
        final SimpleList values = new SimpleArrayList(10);

        for (int i = 0; i < 20; i++) {
            values.add(String.valueOf(i));
        }

        assertThat(values.size()).isEqualTo(20);
    }

    @Test
    @DisplayName("원하는 위치에 원소를 추가한다.")
    void add_element_at_index() {
        final SimpleList values = new SimpleArrayList();

        values.add("first");
        values.add("second");
        values.add("third");

        values.add(3, "fourth");

        assertThat(values.size()).isEqualTo(4);
        assertThat(values.get(3)).isEqualTo("fourth");
    }

    @ParameterizedTest(name = "인덱스: {0}")
    @ValueSource(ints = {-1, 3})
    @DisplayName("원소를 추가할 때 위치가 음수이거나 크기를 벗어나면 예외를 던진다.")
    void throw_exception_invalid_index_when_add(final int index) {
        final SimpleList values = new SimpleArrayList();

        values.add("first");
        values.add("second");

        assertThatThrownBy(() -> values.add(index, "value"))
                .isInstanceOf(IndexOutOfBoundsException.class);
    }

    @Test
    @DisplayName("원하는 위치의 값을 변경한다.")
    void set_element_at_index() {
        final SimpleList values = new SimpleArrayList();

        values.add("first");
        values.add("second");

        values.set(1, "two");

        assertThat(values.size()).isEqualTo(2);
        assertThat(values.get(1)).isEqualTo("two");
    }

    @ParameterizedTest(name = "인덱스: {0}")
    @ValueSource(ints = {-1, 2})
    @DisplayName("원소를 변경할 때 위치가 음수이거나 크기를 벗어나면 예외를 던진다.")
    void throw_exception_invalid_index_when_set(final int index) {
        final SimpleList values = new SimpleArrayList();

        values.add("first");
        values.add("second");

        assertThatThrownBy(() -> values.set(index, "value"))
                .isInstanceOf(IndexOutOfBoundsException.class);
    }

    @ParameterizedTest(name = "인덱스: {0}")
    @ValueSource(ints = {-1, 1})
    @DisplayName("원소를 가져올 때 음수이거나 크기를 벗어나면 예외를 던진다.")
    void throw_exception_invalid_index_when_get(final int index) {
        final SimpleList values = new SimpleArrayList();

        values.add("first");

        assertThatThrownBy(() -> values.get(index))
                .isInstanceOf(IndexOutOfBoundsException.class);
    }

    @ParameterizedTest(name = "원소: {0}, 포함 여부: {1}")
    @CsvSource(value = {"first:true", "third:false"}, delimiter = ':')
    @DisplayName("원소가 포함되어 있는지 여부를 확인한다.")
    void check_element_contain(final String value, final boolean result) {
        final SimpleList values = new SimpleArrayList();

        values.add("first");
        values.add("second");

        assertThat(values.contains(value)).isEqualTo(result);
    }

    @Test
    @DisplayName("포함되어 있는 원소는 인덱스를 반환한다.")
    void index_of_element_contain() {
        final SimpleList values = new SimpleArrayList();

        values.add("first");
        values.add("second");

        assertThat(values.indexOf("second")).isEqualTo(1);
    }

    @Test
    @DisplayName("포함되지 않은 원소는 -1을 반환한다.")
    void index_of_element_not_contain() {
        final SimpleList values = new SimpleArrayList();

        values.add("first");
        values.add("second");

        assertThat(values.indexOf("third")).isEqualTo(-1);
    }

    @Test
    @DisplayName("리스트가 비어있으면 true를 반환한다.")
    void is_empty_when_list_empty() {
        final SimpleList values = new SimpleArrayList();

        assertThat(values.isEmpty()).isTrue();
    }

    @Test
    @DisplayName("리스트가 비어있지 않다면 false를 반환한다.")
    void is_empty_when_list_not_empty() {
        final SimpleList values = new SimpleArrayList();

        values.add("first");

        assertThat(values.isEmpty()).isFalse();
    }

    @Test
    @DisplayName("존재하는 원소라면 리스트에서 삭제한다.")
    void remove_element_when_exist() {
        final SimpleList values = new SimpleArrayList();

        values.add("first");
        final boolean result = values.remove("first");

        assertThat(result).isTrue();
        assertThat(values.size()).isEqualTo(0);
    }

    @Test
    @DisplayName("존재하지 않는 원소라면 리스트에서 삭제하지 않는다.")
    void remove_element_when_not_exist() {
        final SimpleList values = new SimpleArrayList();

        values.add("first");
        final boolean result = values.remove("second");

        assertThat(result).isFalse();
        assertThat(values.size()).isEqualTo(1);
    }

    @Test
    @DisplayName("유효한 인덱스라면 리스트에서 삭제한다.")
    void remove_element_valid_index() {
        final SimpleList values = new SimpleArrayList();

        values.add("first");

        final String element = values.remove(0);

        assertThat(values.size()).isEqualTo(0);
        assertThat(element).isEqualTo("first");
    }

    @ParameterizedTest(name = "인덱스: {0}")
    @ValueSource(ints = {-1, 1})
    @DisplayName("유효하지 않은 인덱스라면 예외를 던진다.")
    void throw_exception_invalid_index(final int index) {
        final SimpleList values = new SimpleArrayList();

        values.add("first");

        assertThatThrownBy(() -> values.remove(index))
                .isInstanceOf(IndexOutOfBoundsException.class);
    }

    @Test
    @DisplayName("리스트를 비우면 크기가 0이 된다.")
    void clear_list() {
        final SimpleList values = new SimpleArrayList();

        values.add("first");
        values.add("second");

        values.clear();

        assertThat(values.size()).isEqualTo(0);
    }
}
