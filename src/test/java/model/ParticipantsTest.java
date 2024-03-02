package model;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import model.participant.Participants;
import org.junit.jupiter.api.Test;

public class ParticipantsTest {
    @Test
    void 참여자가_두명_미만이면_예외가_발생한다() {
        List<String> names = List.of("엘라");

        assertThatThrownBy(() -> new Participants(names)).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 중복된_참여자_이름이_있으면_예외가_발생한다() {
        List<String> names = List.of("릴리", "릴리");

        assertThatThrownBy(() -> new Participants(names)).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 결과를_보고싶은_참여자로_참여자_목록에_없는_이름을_입력하면_예외가_발생한다() {
        List<String> names = List.of("엘라", "릴리");
        Participants participants = new Participants(names);

        assertThatThrownBy(() -> participants.findByName("애쉬")).isInstanceOf(IllegalArgumentException.class);
    }
}
