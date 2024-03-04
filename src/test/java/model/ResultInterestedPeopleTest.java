package model;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class ResultInterestedPeopleTest {
    private final List<String> participantsNames = List.of("엘라", "애쉬");

    @Test
    void 결과를_보고_싶은_사람이_참여한_사람이_아니면_예외가_발생한다() {
        assertThatThrownBy(() -> new ResultInterestedPeople(List.of("릴리"), participantsNames))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {"", " "})
    void 결과를_보고_싶은_사람이_빈값이면_예외가_발생한다(String name) {
        assertThatThrownBy(() -> new ResultInterestedPeople(List.of(name), participantsNames))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
