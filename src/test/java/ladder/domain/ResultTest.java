package ladder.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class ResultTest {
    @Test
    void isEmpty() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Result(null,new Person("pobi"));
        });
        assertThrows(IllegalArgumentException.class, () -> {
            new Result("",new Person("pobi"));
        });
    }

    @Test
    void 띄어쓰기가_있는_이름() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Result("   ",new Person("pobi"));
        });
        assertThrows(IllegalArgumentException.class, () -> {
            new Result("P O B I",new Person("pobi"));
        });
    }

    @Test
    void 입력_다섯글자_초과() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Result("AAAAAA",new Person("pobi"));
        });
    }

    @Test
    void 콤마로끝() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Result("5000,1000,",new Person("pobi,brown"));
        });
    }

    @Test
    void 실행결과수_이름수_불일치() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Result("꽝,5000,5000,꽝",new Person("pobi,brown"));
        });
    }

    @Test
    void 출력() {
        Result result = new Result("꽝,5000",new Person("pobi,brown"));
        assertThat(result.toString()).isEqualTo("     꽝  5000");
    }
}
