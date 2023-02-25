package techcourse.jcf.mission;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

class SimpleArrayListTest {
    @Test
    public void simpleArrayList() {
        SimpleArrayList values = new SimpleArrayList();

        assertThat(values.isEmpty()).isTrue(); // 처음엔 아무 값이 없다

        values.add("first");
        values.add("second");

        assertThat(values.add("four")).isTrue(); // 세 번째 값을 추가한다.

        values.add(2, "third"); // 세 번째 값을 추가한다.
        assertThatThrownBy(() -> values.add(null)).isExactlyInstanceOf(
            NullPointerException.class); // null 을 add 하면 널포인트 오류가 난다

        assertThat(values.set(3, "forth")).isEqualTo("four"); // 세 번째 값을 바꿔본다
        assertThat(values.size()).isEqualTo(4); // list의 크기를 구한다.
        assertThat(values.get(0)).isEqualTo("first"); // 첫 번째 값을 찾는다.
        assertThatThrownBy(() -> values.get(5)).isExactlyInstanceOf(
            IndexOutOfBoundsException.class); // 범위를 넘는 인덱스의 값을 get하면 bound오류가 난다.

        assertThat(values.indexOf("first")).isEqualTo(0); // first라는 값이 몇번째 인덱스인지 찾는다
        assertThat(values.indexOf("zero")).isEqualTo(-1); // 없는 값의 인덱스를 구하려 하면 -1이 나온다
        assertThat(values.contains("first")).isTrue(); // "first" 값이 포함되어 있는지를 확인한다.
        assertThat(values.contains("zero")).isFalse(); // "zero" 값이 없는지를 확인한다.

        assertThat(values.remove(0)).isEqualTo("first"); // 첫 번째 값을 삭제한다.
        assertThat(values.remove("second")).isTrue(); // 두 번째 값을 삭제한다.
        assertThat(values.size()).isEqualTo(2); // 값이 삭제 됐는지 확인한다.

        values.clear();
        assertThat(values.size()).isEqualTo(0); // clear 시 길이가 0인지 알아본다.
    }

}
