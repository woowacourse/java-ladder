package domain;

import static org.junit.jupiter.api.DynamicTest.dynamicTest;

import exception.DuplicateNameException;
import exception.InvalidParticipantsCountException;
import java.util.stream.Stream;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.TestFactory;

class ParticipantsTest {

    @DisplayName("참가자의 수가 요구사항에 충족할 경우")
    @TestFactory
    Stream<DynamicTest> participantsSuccess() {
        return Stream.of(
            dynamicTest("참가자의 수가 2명인 경우 (최소)", () -> {
                Participants participants = new Participants("split,jamie");
                Assertions.assertThat(participants.getCount()).isEqualTo(2);
            }),
            dynamicTest("참가자의 수가 10명인 경우 (최대)", () -> {
                Participants participants = new Participants("a,b,c,d,e,f,g,h,i,j");
                Assertions.assertThat(participants.getCount()).isEqualTo(10);
            })
        );
    }

    @DisplayName("참가자들이 요구사항에 맞지 않는 경우")
    @TestFactory
    Stream<DynamicTest> participantsFail() {
        return Stream.of(
            dynamicTest("참가자의 수가 1명인 경우", () -> Assertions.assertThatThrownBy(() -> new Participants("split"))
                .isExactlyInstanceOf(InvalidParticipantsCountException.class)),
            dynamicTest("참가자의 수가 11명인 경우",
                () -> Assertions.assertThatThrownBy(() -> new Participants("a,b,c,d,e,f,g,h,i,j,k"))
                    .isExactlyInstanceOf(InvalidParticipantsCountException.class)),
            dynamicTest("중복된 이름이의 참가자가 있는 경우",
                () -> Assertions.assertThatThrownBy(() -> new Participants("split,split"))
                    .isExactlyInstanceOf(DuplicateNameException.class))
        );
    }
}
