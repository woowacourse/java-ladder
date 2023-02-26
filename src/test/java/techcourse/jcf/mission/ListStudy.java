package techcourse.jcf.mission;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ListStudy {

    @Test
    public void arrayList() {
        SimpleList values = new SimpleArrayList();

        values.add("first");
        values.add("second");

        assertThat(values.add("third")).isTrue();
        assertThat(values.size()).isEqualTo(3);
        assertThat(values.get(0)).isEqualTo("first");
        assertThat(values.contains("first")).isTrue();
        assertThat(values.remove(0)).isEqualTo("first");
        assertThat(values.size()).isEqualTo(2);

        // TODO values에 담긴 모든 값을 출력한다.
        System.out.println(values);

        assertThat(values.get(0)).isEqualTo("second");
        values.set(0, "first");
        assertThat(values.get(0)).isEqualTo("first");
        assertThat(values.indexOf("first")).isEqualTo(0);
        assertThat(values.indexOf("second")).isEqualTo(-1);
        assertThat(values.isEmpty()).isFalse();
        assertThat(values.size()).isEqualTo(2);
        values.clear();
        assertThat(values.size()).isEqualTo(0);
        values.add("first");
        values.add("second");
        assertThat(values.remove("fourth")).isFalse();
        assertThat(values.remove("second")).isTrue();
        assertThat(values.size()).isEqualTo(1);

        assertThat(values.get(0)).isEqualTo("first");
        values.add(0, "second");
        assertThat(values.get(0)).isEqualTo("second");
        System.out.println(values);
    }

}