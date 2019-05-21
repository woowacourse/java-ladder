package ladder.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

class PersonTest {
    @Test
    void isEmpty() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Person(null);
        });
        assertThrows(IllegalArgumentException.class, () -> {
            new Person("");
        });
    }

    @Test
    void 띄어쓰기가_있는_이름() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Person("   ");
        });
        assertThrows(IllegalArgumentException.class, () -> {
            new Person("P O B I");
        });
    }

    @Test
    void 입력_다섯글자_초과() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Person("AAAAAA");
        });
    }

    @Test
    void 중복이름_존재() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Person("Buddy,Buddy");
        });
    }

    @Test
    void 이름_all() {
        String name = "all";
        assertThrows(IllegalArgumentException.class, () -> {
            new Person(name);
        });
    }

    @Test
    void 콤마로끝() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Person("pobi,brown,");
        });
    }
}
