package model;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;

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

    @Test
    void all를_입력하면_전체_참여자_리스트가_결과를_보고_싶은_사람_리스트가_된다() {
        ResultInterestedPeople resultInterestedPeople =
                new ResultInterestedPeople(List.of("all"), participantsNames);
        assertEquals(resultInterestedPeople.getResultInterestedName(), participantsNames);
    }

    @Test
    void 전체_참여자_리스트에서_결과를_보고_싶은_사람의_인덱스를_찾는다() {
        ResultInterestedPeople resultInterestedPeople =
                new ResultInterestedPeople(List.of("애쉬"), participantsNames);
        assertEquals(resultInterestedPeople.getPosition().get(0), 1);
    }
}
