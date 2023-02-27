package techcourse.jcf.mission;

import org.junit.jupiter.api.Test;
import techcourse.jcf.mission.SimleList.SimpleArrayList;
import techcourse.jcf.mission.SimleList.SimpleList;

import java.util.ArrayList;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class ListStudy {
    @Test
    public void arrayList() {
        ArrayList<String> values = new ArrayList<>();
        values.add("first");
        values.add("second");

        assertThat(values.add("hello")).isTrue(); // 세 번째 값을 추가한다.
        assertThat(values.size()).isEqualTo(3); // list의 크기를 구한다.
        assertThat(values.get(0)).isEqualTo("first"); // 첫 번째 값을 찾는다.
        assertThat(values.contains("first")).isTrue(); // "first" 값이 포함되어 있는지를 확인한다.
        assertThat(values.remove(0)).isEqualTo("first"); // 첫 번째 값을 삭제한다.
        assertThat(values.size()).isEqualTo(2); // 값이 삭제 됐는지 확인한다.

        // TODO values에 담긴 모든 값을 출력한다.
        System.out.println(values);
    }

    @Test
    public void MyArrayListAddTest() {
        SimpleList mySimpleArrayList = new SimpleArrayList();
        mySimpleArrayList.add("first");
        mySimpleArrayList.add("second");

        assertThat(mySimpleArrayList.add("hello")).isTrue(); // 세 번째 값을 추가한다.
    }

    @Test
    public void MyArrayListGetTest() {
        SimpleList mySimpleArrayList = new SimpleArrayList();
        mySimpleArrayList.add("first");
        mySimpleArrayList.add("second");

        assertThat(mySimpleArrayList.get(0).equals("first")).isTrue();
        assertThat(mySimpleArrayList.get(1).equals("second")).isTrue();
    }
    @Test
    public void MyArrayListAddByIndexTest() {
        SimpleList mySimpleArrayList = new SimpleArrayList();

        mySimpleArrayList.add("first");
        mySimpleArrayList.add("second");
        mySimpleArrayList.add(1,"hello");

        assertThat(mySimpleArrayList.get(0).equals("first")).isTrue();
        assertThat(mySimpleArrayList.get(1).equals("hello")).isTrue();
        assertThat(mySimpleArrayList.get(2).equals("second")).isTrue();
    }

    @Test
    public void MyArrayListSetTest() {
        SimpleList mySimpleArrayList = new SimpleArrayList();

        mySimpleArrayList.add("first");
        mySimpleArrayList.add("second");

        assertThat(mySimpleArrayList.set(1,"hello").equals("hello")).isTrue();
        assertThat(mySimpleArrayList.get(0).equals("first")).isTrue();
        assertThat(mySimpleArrayList.get(1).equals("hello")).isTrue();
    }

    @Test
    public void MyArrayListContainsTest() {
        SimpleList mySimpleArrayList = new SimpleArrayList();

        mySimpleArrayList.add("first");
        mySimpleArrayList.add("second");

        assertThat(mySimpleArrayList.contains("first")).isTrue();
        assertThat(mySimpleArrayList.contains("second")).isTrue();
        assertThat(mySimpleArrayList.contains("hi")).isFalse();
    }

    @Test
    public void MyArrayListIndexOfTest() {
        SimpleList mySimpleArrayList = new SimpleArrayList();

        mySimpleArrayList.add("first");
        mySimpleArrayList.add("second");

        assertThat(mySimpleArrayList.indexOf("first")).isEqualTo(0);
        assertThat(mySimpleArrayList.indexOf("second")).isEqualTo(1);
        assertThat(mySimpleArrayList.indexOf("hi")).isEqualTo(-1);
    }

    @Test
    public void MyArrayListSizeTest() {
        SimpleList mySimpleArrayList = new SimpleArrayList();

        mySimpleArrayList.add("first");
        mySimpleArrayList.add("second");

        assertThat(mySimpleArrayList.size()).isEqualTo(2);
    }

    @Test
    public void MyArrayListsIsEmptyTest() {
        SimpleList mySimpleArrayList = new SimpleArrayList();

        assertThat(mySimpleArrayList.isEmpty()).isTrue();

        mySimpleArrayList.add("first");
        assertThat(mySimpleArrayList.isEmpty()).isFalse();
    }

    @Test
    public void MyArrayListsRemoveByIndexTest() {
        SimpleList mySimpleArrayList = new SimpleArrayList();
        mySimpleArrayList.add("first");
        mySimpleArrayList.add("second");

        assertThat(mySimpleArrayList.remove(0)).isEqualTo("first");
        assertThat(mySimpleArrayList.size()).isEqualTo(1);
    }

    @Test
    public void MyArrayListsRemoveByValueTest() {
        SimpleList mySimpleArrayList = new SimpleArrayList();
        mySimpleArrayList.add("first");
        mySimpleArrayList.add("second");
        assertThat(mySimpleArrayList.size()).isEqualTo(2);

        assertThat(mySimpleArrayList.remove("first")).isTrue();
        assertThat(mySimpleArrayList.size()).isEqualTo(1);
        assertThat(mySimpleArrayList.remove("none")).isFalse();
        assertThat(mySimpleArrayList.size()).isEqualTo(1);

    }

    @Test
    public void MyArrayListsClearTest() {
        SimpleList mySimpleArrayList = new SimpleArrayList();
        mySimpleArrayList.add("first");
        mySimpleArrayList.add("second");
        assertThat(mySimpleArrayList.size()).isEqualTo(2);

        mySimpleArrayList.clear();
        assertThat(mySimpleArrayList.size()).isEqualTo(0);

    }

}
