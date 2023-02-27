package techcourse.jcf.mission;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.NoSuchElementException;
import org.junit.jupiter.api.Test;

public class ListStudy {
    @Test
    public void arrayList() {
        SimpleList values = new SimpleArrayList();
        values.add("first");
        values.add("second");

        assertThat(values.indexOf("second")).isEqualTo(1);
        assertThatThrownBy(() -> values.indexOf("none"))
                .isInstanceOf(NoSuchElementException.class);

        assertThat(values.add("third")).isTrue(); // 세 번째 값을 추가한다.

        assertThat(values.size()).isEqualTo(3); // list의 크기를 구한다.
        assertThat(values.get(0)).isEqualTo("first"); // 첫 번째 값을 찾는다.
        assertThat(values.contains("first")).isTrue(); // "first" 값이 포함되어 있는지를 확인한다.

        assertThat(values.remove(0)).isEqualTo("first"); // 첫 번째 값을 삭제한다.
        assertThat(values.remove("second")).isTrue();
        assertThat(values.remove("none")).isFalse();

        assertThat(values.size()).isEqualTo(1); // 값이 삭제 됐는지 확인한다

        SimpleList emptyValues = new SimpleArrayList();
        assertThat(emptyValues.isEmpty()).isTrue();

        System.out.println(values);
    }
}
