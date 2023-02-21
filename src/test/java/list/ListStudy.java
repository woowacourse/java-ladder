package list;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;

public class ListStudy {

    @Test
    public void arrayList() {
        SimpleArrayList values = new SimpleArrayList();
        values.add("first");
        values.add("second");

        assertThat(values.add("third")).isTrue(); // 세 번째 값을 추가한다.
        assertThatCode(() -> values.add(0, "zero")).doesNotThrowAnyException(); // 맨 앞에 0을 추가한다.
        assertThatCode(() -> values.add(100, "hundred")).isInstanceOf(RuntimeException.class); // 인덱스가 넘어가면 예외가 발생한다.
        assertThat(values.set(0, "0")).isEqualTo("0"); // 첫번째 원소가 "0"으로 바뀐다.
        assertThatCode(() -> values.set(100, "100")).isInstanceOf(RuntimeException.class); // 인덱스가 넘어가면 예외가 발생한다.
//        assertThat(values.size()).isEqualTo(3); // list의 크기를 구한다.
//        assertThat(values.get(0)).isEqualTo("first"); // 첫 번째 값을 찾는다.
//        assertThat(values.contains("first")).isTrue(); // "first" 값이 포함되어 있는지를 확인한다.
//        assertThat(values.remove(0)).isEqualTo("first"); // 첫 번째 값을 삭제한다.
//        assertThat(values.size()).isEqualTo(2); // 값이 삭제 됐는지 확인한다.

        // TODO values에 담긴 모든 값을 출력한다.
        values.printAll();
    }
}
