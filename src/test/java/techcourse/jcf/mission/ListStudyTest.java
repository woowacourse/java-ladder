package techcourse.jcf.mission;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ListStudyTest {
    @Test
    public void arrayList() {
        SimpleList values = new SimpleLinkedList();
        values.add("first");
        values.add("second");

        assertThat(values.add("three")).isTrue();
        assertThat(values.size()).isEqualTo(3);
        assertThat(values.get(0)).isEqualTo("first");
        assertThat(values.contains("first")).isTrue();
        assertThat(values.remove(0)).isEqualTo("first");
        assertThat(values.size()).isEqualTo(2);

        for (int i = 0; i < values.size(); i++) {
            System.out.println(values.get(i));
        }
    }
}
