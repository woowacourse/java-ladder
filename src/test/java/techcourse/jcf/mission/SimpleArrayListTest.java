package techcourse.jcf.mission;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class SimpleArrayListTest {

    @Test
    void ADD_메소드_실행시_SIZE_증가() {
        SimpleList simpleList = new SimpleArrayList();
        simpleList.add("건회");
        assertThat(simpleList.size()).isEqualTo(1);
    }

    @Test
    void GET_메소드_실행시_파라미터_INDEX_위치의_요소_반환() {
        SimpleList simpleList = new SimpleArrayList();
        simpleList.add("건회");
        assertThat(simpleList.get(0)).isEqualTo("건회");
    }

    @Test
    void ADD_메소드_실행시_중간에_값_추가() {
        SimpleList simpleList = new SimpleArrayList();
        simpleList.add("하마드");
        simpleList.add("오션");
        simpleList.add("동해");
        simpleList.add(1, "바론");
        assertThat(simpleList.get(1)).isEqualTo("바론");
    }

    @Test
    void SET_메소드_실행시_인덱스_값_변경() {
        SimpleList simpleList = new SimpleArrayList();
        simpleList.add("하마드");
        simpleList.set(0, "오션");
        assertThat(simpleList.get(0)).isEqualTo("오션");
    }

    @Test
    void CONTAINS_메소드_실행시_VALUES_포함되면_TRUE_반환() {
        SimpleList simpleList = new SimpleArrayList();
        simpleList.add("하마드");
        assertThat(simpleList.contains("하마드")).isTrue();
    }

    @Test
    void INDEXOF_메소드_실행시_VALUE값이_가장처음_위치한_INDEX반환() {
        SimpleList simpleList = new SimpleArrayList();
        simpleList.add("하마드");
        simpleList.add("오션");
        simpleList.add("두둠");
        simpleList.add("하마드");
        assertThat(simpleList.indexOf("하마드")).isEqualTo(0);
    }

    @Test
    void ISEMPTY가_TRUE면_SIZE가_0() {
        SimpleList simpleList = new SimpleArrayList();
        assertThat(simpleList.isEmpty()).isTrue();
    }

    @Test
    void REMOVE_실행시_VALUE값_제거() {
        SimpleList simpleList = new SimpleArrayList();
        simpleList.add("하마드");
        simpleList.add("오션");
        simpleList.add("두둠");
        simpleList.remove("오션");
        assertThat(simpleList.get(1)).isEqualTo("두둠");
    }

    @Test
    void REMOVE_실행시_인덱스값_제거() {
        SimpleList simpleList = new SimpleArrayList();
        simpleList.add("하마드");
        simpleList.add("오션");
        simpleList.add("두둠");
        simpleList.remove(1);
        assertThat(simpleList.get(1)).isEqualTo("두둠");
    }

    @Test
    void CLEAR_실행시_ISEMPTY_TRUE반환() {
        SimpleList simpleList = new SimpleArrayList();
        simpleList.add("하마드");
        simpleList.add("오션");
        simpleList.add("두둠");
        simpleList.clear();
        assertThat(simpleList.isEmpty()).isTrue();
    }
}
