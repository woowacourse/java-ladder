package techcourse.jcf.mission;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class ListStudy {

    @Test
    public void arrayList() {
        SimpleList list = new SimpleArrayList();
        list.add("first");
        list.add("second");

        assertThat(list.add("third")).isTrue(); // 세 번째 값을 추가한다.
        assertThat(list.size()).isEqualTo(3); // list의 크기를 구한다.
        assertThat(list.get(0)).isEqualTo("first"); // 첫 번째 값을 찾는다.
        assertThat(list.contains("first")).isTrue(); // "first" 값이 포함되어 있는지를 확인한다.
        assertThat(list.remove(0)).isEqualTo("first"); // 첫 번째 값을 삭제한다.
        assertThat(list.size()).isEqualTo(2); // 값이 삭제 됐는지 확인한다.
        list.add(1, "hello");
        assertThat(list.size()).isEqualTo(3);
        list.set(0, "world");
        assertThat(list.get(0)).isEqualTo("world");
        assertThat(list.size()).isEqualTo(3);

         // values에 담긴 모든 값을 출력한다.
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }

        list.clear();
        assertThat(list.size()).isEqualTo(0);
        assertThat(list.isEmpty()).isTrue();
    }

    @Test
    public void linkedList() {
        SimpleList list = new SimpleLinkedList();
        list.add("first");
        list.add("second");

        assertThat(list.add("third")).isTrue(); // 세 번째 값을 추가한다.
        assertThat(list.size()).isEqualTo(3); // list의 크기를 구한다.
        assertThat(list.get(0)).isEqualTo("first"); // 첫 번째 값을 찾는다.
        assertThat(list.contains("first")).isTrue(); // "first" 값이 포함되어 있는지를 확인한다.
        assertThat(list.remove(0)).isEqualTo("first"); // 첫 번째 값을 삭제한다.
        assertThat(list.size()).isEqualTo(2); // 값이 삭제 됐는지 확인한다.
        list.add(1, "hello");
        assertThat(list.size()).isEqualTo(3);
        list.set(0, "world");
        assertThat(list.get(0)).isEqualTo("world");
        assertThat(list.size()).isEqualTo(3);
//
         // values에 담긴 모든 값을 출력한다.
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }

        list.clear();
        assertThat(list.size()).isEqualTo(0);
        assertThat(list.isEmpty()).isTrue();

        System.out.println("========");

        // values에 담긴 모든 값을 출력한다.
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }
}
