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

        assertThat(values.add("third")).isTrue();

        assertThat(values.size()).isEqualTo(3);
        assertThat(values.get(0)).isEqualTo("first");
        assertThat(values.contains("first")).isTrue();

        assertThat(values.remove(0)).isEqualTo("first");
        assertThat(values.remove("second")).isTrue();
        assertThat(values.remove("none")).isFalse();

        assertThat(values.size()).isEqualTo(1);

        SimpleList emptyValues = new SimpleArrayList();
        assertThat(emptyValues.isEmpty()).isTrue();

        System.out.println(values);
    }
}
