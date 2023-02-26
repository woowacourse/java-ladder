package techcourse.jcf.mission;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.ArrayList;
import java.util.List;
import model.Name;
import model.Names;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator.ReplaceUnderscores;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

@DisplayNameGeneration(ReplaceUnderscores.class)
class SimpleArrayListTest {

    private SimpleList list;

    @BeforeEach
    void beforeEach() {
        list = new SimpleArrayList();

        list.add("a");
        list.add("b");
        list.add("c");
        list.add("d");
        list.add("e");
    }

    @Test
    void add_메소드는_추가할_요소를_전달하면_마지막_위치에_요소를_추가한다() {
        boolean actual = list.add("f");

        assertThat(actual).isTrue();
        assertThat(list.get(list.size() - 1)).isEqualTo("f");
    }

    @Test
    void add_메소드는_추가할_요소의_위치와_요소를_전달하면_지정한_위치에_요소를_추가한다() {
        list.add(2, "f");

        assertThat(list.get(0)).isEqualTo("a");
        assertThat(list.get(1)).isEqualTo("b");
        assertThat(list.get(2)).isEqualTo("f");
        assertThat(list.get(3)).isEqualTo("c");
        assertThat(list.get(4)).isEqualTo("d");
        assertThat(list.get(5)).isEqualTo("e");
    }

    @Test
    void set_메소드는_대체할_요소의_위치와_요소를_전달하면_해당_요소로_대체하고_이전_값을_반환한다() {
        String actual = list.set(2, "f");

        assertThat(actual).isEqualTo("c");
        assertThat(list.get(0)).isEqualTo("a");
        assertThat(list.get(1)).isEqualTo("b");
        assertThat(list.get(2)).isEqualTo("f");
        assertThat(list.get(3)).isEqualTo("d");
        assertThat(list.get(4)).isEqualTo("e");
    }

    @Test
    void get_메소드는_유효한_위치를_전달하면_그_위치의_요소를_반환한다() {
        assertThat(list.get(0)).isEqualTo("a");
        assertThat(list.get(1)).isEqualTo("b");
        assertThat(list.get(2)).isEqualTo("c");
        assertThat(list.get(3)).isEqualTo("d");
        assertThat(list.get(4)).isEqualTo("e");
    }

    @ParameterizedTest
    @ValueSource(ints = {-1, 5})
    void get_메소드는_유효하지_않은_위치를_전달하면_예외가_발생한다(int index) {
        assertThatThrownBy(() -> list.get(index))
                .isInstanceOf(ArrayIndexOutOfBoundsException.class);
    }

    @Test
    void contains_메소드는_존재하는_요소를_전달하면_true를_반환한다() {
        assertThat(list.contains("a")).isTrue();
        assertThat(list.contains("b")).isTrue();
        assertThat(list.contains("c")).isTrue();
        assertThat(list.contains("d")).isTrue();
        assertThat(list.contains("e")).isTrue();
    }

    @Test
    void contains_메소드는_존재하지_않는_요소를_전달하면_false를_반환한다() {
        assertThat(list.contains("1")).isFalse();
        assertThat(list.contains("2")).isFalse();
        assertThat(list.contains("3")).isFalse();
        assertThat(list.contains("4")).isFalse();
        assertThat(list.contains("5")).isFalse();
    }

    @Test
    void indexOf_메소드는_존재하는_요소를_전달하면_그_요소의_위치를_반환한다() {
        assertThat(list.indexOf("a")).isSameAs(0);
        assertThat(list.indexOf("b")).isSameAs(1);
        assertThat(list.indexOf("c")).isSameAs(2);
        assertThat(list.indexOf("d")).isSameAs(3);
        assertThat(list.indexOf("e")).isSameAs(4);
    }

    @Test
    void indexOf_메소드는_존재하지_않는_요소를_전달하면_음수_1을_반환한다() {
        assertThat(list.indexOf("1")).isSameAs(-1);
        assertThat(list.indexOf("2")).isSameAs(-1);
        assertThat(list.indexOf("3")).isSameAs(-1);
        assertThat(list.indexOf("4")).isSameAs(-1);
        assertThat(list.indexOf("5")).isSameAs(-1);
    }

    @Test
    void size_테스트는_list의_크기를_반환한다() {
        assertThat(list.size()).isSameAs(5);
    }

    @Test
    void isEmpty_메소드는_list의_요소가_없다면_true를_반환한다() {
        SimpleList list = new SimpleArrayList();

        assertThat(list.isEmpty()).isTrue();
    }

    @Test
    void isEmpty_메소드는_list의_요소가_있다면_false를_반환한다() {
        assertThat(list.isEmpty()).isFalse();
    }

    @Test
    void remove_메소드는_존재하는_요소가_있다면_그를_삭제하고_true를_반환한다() {
        boolean actual = list.remove("a");

        assertThat(actual).isTrue();
        assertThat(list.get(0)).isEqualTo("b");
        assertThat(list.get(1)).isEqualTo("c");
        assertThat(list.get(2)).isEqualTo("d");
        assertThat(list.get(3)).isEqualTo("e");
    }

    @Test
    void remove_메소드는_존재하는_요소가_없다면_false를_반환한다() {
        boolean actual = list.remove("1");

        assertThat(actual).isFalse();
        assertThat(list.get(0)).isEqualTo("a");
        assertThat(list.get(1)).isEqualTo("b");
        assertThat(list.get(2)).isEqualTo("c");
        assertThat(list.get(3)).isEqualTo("d");
        assertThat(list.get(4)).isEqualTo("e");
    }

    @Test
    void remove_메소드는_유효한_위치를_전달하면_그_위치의_요소를_삭제하고_삭제한_요소를_반환한다() {
        String actual = list.remove(0);

        assertThat(actual).isEqualTo("a");
        assertThat(list.get(0)).isEqualTo("b");
        assertThat(list.get(1)).isEqualTo("c");
        assertThat(list.get(2)).isEqualTo("d");
        assertThat(list.get(3)).isEqualTo("e");
    }

    @ParameterizedTest
    @ValueSource(ints = {-1, 5})
    void remove_메소드는_유효하지_않은_위치를_전달하면_예외가_발생한다(int index) {
        assertThatThrownBy(() -> list.remove(index))
                .isInstanceOf(ArrayIndexOutOfBoundsException.class);
    }

    @Test
    void clear_메소드는_호출하면_모든_요소를_삭제한다() {
        list.clear();

        assertThat(list.size()).isSameAs(0);
        assertThatThrownBy(() -> list.get(0))
                .isInstanceOf(ArrayIndexOutOfBoundsException.class);
    }
}
