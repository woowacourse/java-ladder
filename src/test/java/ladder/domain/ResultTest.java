package ladder.domain;

import org.junit.jupiter.api.Test;


import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class ResultTest {
    @Test
    void isEmpty() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Result(null,1);
        });
        assertThrows(IllegalArgumentException.class, () -> {
            new Result("",1);
        });
    }

    @Test
    void 띄어쓰기가_있는_이름() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Result("   ",1);
        });
        assertThrows(IllegalArgumentException.class, () -> {
            new Result("P O B I",1);
        });
    }

    @Test
    void 입력_다섯글자_초과() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Result("AAAAAA",1);
        });
    }

    @Test
    void 콤마로끝() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Result("pobi,brown,",2);
        });
    }

    @Test
    void 실행결과수_이름수_불일치() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Result("꽝,5000,5000,꽝",2);
        });
    }

    @Test
    void 출력() {
        Result result = new Result("꽝,5000",2);
        assertThat(result.toString()).isEqualTo("     꽝  5000");
    }
}
