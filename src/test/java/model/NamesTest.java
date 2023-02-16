package model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import exception.WrongParticipantSizeException;
import java.util.List;
import java.util.stream.Collectors;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator.ReplaceUnderscores;
import org.junit.jupiter.api.Test;

@DisplayNameGeneration(ReplaceUnderscores.class)
class NamesTest {

    @Test
    void 생성자는_3_이상의_names를_전달하면_Names를_생성한다() {
        assertThatCode(() -> new Names(List.of(new Name("a"), new Name("b"))))
                .doesNotThrowAnyException();
    }

    @Test
    void 생성자는_2_이하의_names를_전달하면_예외가_발생한다() {
        assertThatThrownBy(() -> new Names(List.of(new Name("a"))))
                .isInstanceOf(WrongParticipantSizeException.class);
    }

    @Test
    void getNameOfIndex_메소드는_index를_전달하면_index의_이름을_반환한다() {
        List<String> inputNames = List.of("a", "b", "c");
        Names names = new Names(inputNames.stream().map(Name::new).collect(Collectors.toList()));
        int index = 0;

        assertThat(names.getNameOfIndex(index)).isEqualTo(inputNames.get(index));
    }

    @Test
    void getTotalParticipantSize_메소드는_호출하면_names의_크기를_반환한다() {
        List<String> inputNames = List.of("a", "b", "c");
        Names names = new Names(inputNames.stream().map(Name::new).collect(Collectors.toList()));

        assertThat(names.getTotalParticipantSize()).isSameAs(3);
    }
}