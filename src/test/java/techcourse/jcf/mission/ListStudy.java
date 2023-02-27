package techcourse.jcf.mission;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class ListStudy {
    @Test
    public void arrayList() {
        ArrayList<String> values = new ArrayList<>();
        values.add("first");
        values.add("second");

        Assertions.assertThat(values.add("third")).isTrue(); // 세 번째 값을 추가한다.
        Assertions.assertThat(values.size()).isEqualTo(3); // list의 크기를 구한다.
        Assertions.assertThat(values.get(0)).isEqualTo("first"); // 첫 번째 값을 찾는다.
        Assertions.assertThat(values.contains("first")).isTrue(); // "first" 값이 포함되어 있는지를 확인한다.
        Assertions.assertThat(values.remove(0)).isEqualTo("first"); // 첫 번째 값을 삭제한다.
        Assertions.assertThat(values.size()).isEqualTo(2); // 값이 삭제 됐는지 확인한다.

        System.out.println("values : " + values);
    }
}
