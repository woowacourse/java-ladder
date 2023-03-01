package techcourse.jcf.mission;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;

public class ListStudy {
    @Test
    public void arrayList() {
        ArrayList<String> values = new ArrayList<>();
        values.add("first");
        values.add("second");

        assertThat(values.add("three")).isTrue();
        assertThat(values.size()).isEqualTo(3);
        assertThat(values.get(0)).isEqualTo("first");
        assertThat(values.contains("first")).isTrue();
        assertThat(values.remove(0)).isEqualTo("first");
        assertThat(values.size()).isEqualTo(2);

        for (String s : values) {
            System.out.println(s);
        }
    }
}
