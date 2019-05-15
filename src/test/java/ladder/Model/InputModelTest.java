package ladder.Model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class InputModelTest {
    InputModel inputModel;

    @BeforeEach
    void setUp() {
        inputModel = new InputModel();
    }

    @Test
    void null_또는_빈문자인_경우() {
        assertThat(inputModel.getValidNames(null)).isEqualTo(null);
        assertThat(inputModel.getValidNames("")).isEqualTo(null);
    }

    @Test
    void 여섯자_이상인_경우() {
        assertThat(inputModel.getValidNames("abcdef")).isEqualTo(null);
    }

    @Test
    void 이름_중복() {
        assertThat(inputModel.getValidNames("ab,ab")).isEqualTo(null);
    }

    @Test
    void 쉼표가_연달아() {
        assertThat(inputModel.getValidNames(",,")).isEqualTo(null);
    }



}