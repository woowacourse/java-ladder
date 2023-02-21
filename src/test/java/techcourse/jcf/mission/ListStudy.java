package techcourse.jcf.mission;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

/**
 * @author 우가
 * @version 1.0.0
 * @Created by 우가 on 2023/02/21
 */
@SuppressWarnings("NonAsciiCharacters")
@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
@DisplayName("SimpleList 학습 테스트")
public class ListStudy {

    @Test
    public void arrayList() {
        ArrayList<String> values = new ArrayList<>();
        values.add("first");
        values.add("second");

        assertThat(values.add("third")).isTrue(); // 세 번째 값을 추가한다.
        assertThat(values.size()).isEqualTo(3); // list의 크기를 구한다.
        assertThat(values.get(0)).isEqualTo("first"); // 첫 번째 값을 찾는다.
        assertThat(values.contains("first")).isTrue(); // "first" 값이 포함되어 있는지를 확인한다.
        assertThat(values.remove(0)).isEqualTo("first"); // 첫 번째 값을 삭제한다.
        assertThat(values.size()).isEqualTo(2); // 값이 삭제 됐는지 확인한다.

        // TODO values에 담긴 모든 값을 출력한다.
        for (String value : values) {
            System.out.println("value = " + value);
        }
    }

    @Test
    void 문자열을_추가할_경우_true를_반환한다() {
        SimpleArrayList list = new SimpleArrayList();

        assertThat(list.add("test")).isTrue();
    }

    @Test
    void 인덱스를_지정해_문자열을_추가할수_있다() {
        SimpleArrayList list = new SimpleArrayList();

        assertDoesNotThrow(() -> list.add(10, "test"));
    }

    @Test
    void 초기값만_가지고_있을때_set호출시_null을_반환한다() {
        SimpleArrayList list = new SimpleArrayList();

        assertThat(list.set(10, "test")).isEqualTo(null);
    }

    @Test
    void set호출시_이전_인덱스의_값을_반환한다() {
        SimpleArrayList list = new SimpleArrayList();
        list.add("1");
        assertThat(list.set(0, "test")).isEqualTo("1");
    }

    @Test
    void get호출시_해당index가_없는경우_예외를_던진다() {
        SimpleArrayList list = new SimpleArrayList();
        list.add("1");

        assertThatThrownBy(() -> list.get(1))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("인덱스를 확인해주세요.");
    }

    @Test
    void get호출시_해당index의_값을_반환한다() {
        SimpleArrayList list = new SimpleArrayList();
        list.add("1");

        assertThat(list.get(0)).isEqualTo("1");
    }

    @ParameterizedTest
    @CsvSource({"0,false", "1,true"})
    void 값중에_해당값을_가지고_있으면true_않으면_false를_반환한다(final String actual, final boolean expected) {
        SimpleArrayList list = new SimpleArrayList();
        list.add("1");

        assertThat(list.contains(actual)).isEqualTo(expected);
    }

    @Test
    void 값중에_해당값을_조회할때_값이_있으면_앞에서_가까운_index를_반환한다() {
        SimpleArrayList list = new SimpleArrayList();
        list.add("1");
        list.add("1");
        list.add("2");
        list.add("1");
        list.add("2");

        assertThat(list.indexOf("2")).isEqualTo(2);
    }

    @Test
    void 값중에_해당값을_조회할때_값이_없으면_마이너스일을_반환한다() {
        SimpleArrayList list = new SimpleArrayList();
        list.add("1");
        list.add("1");
        list.add("2");
        list.add("1");
        list.add("2");

        assertThat(list.indexOf("3")).isEqualTo(-1);
    }

    @Test
    void 크기를_반환한다() {
        SimpleArrayList list = new SimpleArrayList();
        list.add("1");
        list.add("1");
        list.add("2");
        list.add("1");
        list.add("2");

        assertThat(list.size()).isEqualTo(5);
    }

    @Test
    void 비어있으면true_아니면false를_반환한다() {
        SimpleArrayList listA = new SimpleArrayList();
        listA.add("1");

        SimpleArrayList listB = new SimpleArrayList();

        assertThat(listA.isEmpty()).isFalse();
        assertThat(listB.isEmpty()).isTrue();
    }

    @Test
    void 기댓값의_삭제에_성공하면_true_실패하면_false를_반환한다() {
        SimpleArrayList listA = new SimpleArrayList();
        listA.add("1");
        listA.add("1");
        listA.add("2");

        SimpleArrayList listB = new SimpleArrayList();
        listB.add("1");
        listB.add("2");
        listB.add("1");

        assertThat(listA.remove("2")).isTrue();
        assertThat(listA.size()).isEqualTo(2);
        assertThat(listA.remove("3")).isFalse();

        assertThat(listB.remove("2")).isTrue();
        assertThat(listB.size()).isEqualTo(2);
        assertThat(listB.remove("3")).isFalse();
    }

    @Test
    void 해당인덱스의_삭제에_성공하면_true_실패하면_false를_반환한다() {
        SimpleArrayList listA = new SimpleArrayList();
        listA.add("1");
        listA.add("1");
        listA.add("2");

        assertThat(listA.remove(2)).isEqualTo("2");
        assertThat(listA.size()).isEqualTo(2);
        assertThatThrownBy(() -> listA.remove(2))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("인덱스를 확인해주세요.");
    }

    @Test
    void 초기길이로_초기화된다() {
        SimpleArrayList listA = new SimpleArrayList();
        listA.add("1");
        listA.add("1");
        listA.add("2");

        listA.clear();

        assertThat(listA.size()).isEqualTo(1);
    }

    private class SimpleArrayList implements SimpleList {

        private String[] list;

        public SimpleArrayList() {
            this.list = new String[1];
        }

        @Override
        public boolean add(final String value) {
            if (Objects.isNull(list[list.length - 1])) {
                list[list.length - 1] = value;
                return true;
            }
            String[] newArray = new String[list.length + 1];
            System.arraycopy(list, 0, newArray, 0, list.length);
            list = newArray;
            newArray[newArray.length - 1] = value;
            return true;
        }

        @Override
        public void add(final int index, final String value) {
            if (list.length <= index) {
                list = new String[index + 1];
                list[index] = value;
                return;
            }
            list[index] = value;
        }

        @Override
        public String set(final int index, final String value) {
            if (list.length <= index) {
                list = new String[index + 1];
                list[index] = value;
                return null;
            }
            String temp = list[index];
            list[index] = value;
            return temp;
        }

        @Override
        public String get(final int index) {
            if (list.length <= index) {
                throw new IllegalArgumentException("인덱스를 확인해주세요.");
            }
            return list[index];
        }

        @Override
        public boolean contains(final String value) {
            for (String str : list) {
                if (str.equals(value)) {
                    return true;
                }
            }
            return false;
        }

        @Override
        public int indexOf(final String value) {
            for (int index = 0; index < list.length; index++) {
                if (list[index].equals(value)) {
                    return index;
                }
            }
            return -1;
        }

        @Override
        public int size() {
            return list.length;
        }

        @Override
        public boolean isEmpty() {
            for (String str : list) {
                if (Objects.nonNull(str)) {
                    return false;
                }
            }
            return true;
        }

        @Override
        public boolean remove(final String value) {
            for (int i = 0; i < list.length; i++) {
                if (list[i].equals(value)) {
                    list[i] = null;
                    if (i == list.length - 1) {
                        String[] newArray = new String[list.length - 1];
                        System.arraycopy(list, 0, newArray, 0, i);
                        list = newArray;
                        return true;
                    } else {
                        String[] newArray = new String[list.length - 1];
                        System.arraycopy(list, 0, newArray, 0, i);
                        System.arraycopy(list, i + 1, newArray, i, list.length - i - 1);
                        list = newArray;
                        return true;
                    }
                }
            }
            return false;
        }

        @Override
        public String remove(final int index) {
            if (list.length <= index) {
                throw new IllegalArgumentException("인덱스를 확인해주세요.");
            }
            String temp = list[index];
            list[index] = null;

            if (index == list.length - 1) {
                String[] newArray = new String[list.length - 1];
                System.arraycopy(list, 0, newArray, 0, index);
                list = newArray;
            } else {
                String[] newArray = new String[list.length - 1];
                System.arraycopy(list, 0, newArray, 0, index);
                System.arraycopy(list, index + 1, newArray, index, list.length - index - 1);
                list = newArray;
            }
            return temp;
        }

        @Override
        public void clear() {
            list = new String[1];
        }

        @Override
        public String toString() {
            return Arrays.toString(list);
        }
    }
}
