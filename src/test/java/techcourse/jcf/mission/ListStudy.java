package techcourse.jcf.mission;

import static org.assertj.core.api.Assertions.assertThat;

import minimission.SimpleArrayList;
import minimission.SimpleList;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class ListStudy {
    @Test
    public void arrayList() {
        ArrayList<String> values = new ArrayList<>();
        values.add("first");
        values.add("second");

        assertThat(values.add("third")).isTrue();
        assertThat(values.size()).isEqualTo(3);
        assertThat(values.get(0)).isEqualTo("first");
        assertThat(values.contains("first")).isTrue();
        assertThat(values.remove(0)).isEqualTo("first");
        assertThat(values.size()).isEqualTo(2);

        // TODO values에 담긴 모든 값을 출력한다.
        System.out.println("---values 요소 출력---");
        for (String element : values) {
            System.out.println(element);
        }
    }
}
